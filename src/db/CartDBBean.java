package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDBBean {
 private static CartDBBean cart=new CartDBBean();
 
 private CartDBBean() {
	 
	 
 }
 public static CartDBBean getInstance() {
	 return cart;
 }
 
 

	public static Connection getConnection(){
		
		Connection con=null;
		try {
			String jdbcUrl="jdbc:oracle:thin:@localhost:1521:orcl";
			String dbId="scott";
			String dbPass="tiger";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(jdbcUrl,dbId,dbPass);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public void close(Connection con, ResultSet rs,PreparedStatement pstmt) {
		if(rs!=null)
			try {
			rs.close();}catch(SQLException ex) {
				
			}
		if(pstmt!=null)
			try {
			pstmt.close();}catch(SQLException ex) {
				
			}
		if(con!=null)
			try {
			con.close();}catch(SQLException ex) {}
		
	}
	
public void addCart(CartDataBean cart) {
		
		String sql="";
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
	
	try {
		
		
			sql="insert into cart (userid,pronum) "
					+ "values(?,?)";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, cart.getUserid());
			pstmt.setString(2, cart.getPronum());
			
			
			
			pstmt.executeUpdate();
			
		
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con,rs,pstmt);
		}
	
	}


public int getCartCount (String pcode, String userid){
	String sql="select count(*) from cart where pronum like concat (?, '%') and userid=?";
	Connection con=getConnection();
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int x=0;
	
	try{ pstmt=con.prepareStatement(sql);
	pstmt.setString(1, pcode);
	pstmt.setString(2, userid);
	
	rs=pstmt.executeQuery();
	
	if(rs.next()) {
		x=rs.getInt(1);
	}
	}catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		close(con, rs, pstmt);
	}
	return x;
}

public List getCarts(int startRow, int endRow, String pcode, String userid) {
		
		
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List carts=null;
		String sql="";
		
		try {
			con=getConnection();
			sql="select * from (" + 
					"select rownum rum , b.* from (" + 
					"select a.* from cart a  where pronum like concat (?, '%') and userid=? ORDER BY rdate desc) b) " + 
					"where rum between ? and ?";
			
			
				pstmt=con.prepareStatement(sql);
				
				pstmt.setString(1, pcode);
				pstmt.setString(2, userid);
				pstmt.setInt(3, startRow);
				pstmt.setInt(4, endRow);
				
				rs=pstmt.executeQuery();
			
				if(rs.next()) {
					carts=new ArrayList();
					do {
						
						ShowCart cartrs=new ShowCart();
						
						if(pcode.equals("a")) {
						AuctionDBBean apro=AuctionDBBean.getInstance();
						AuctionDataBean product=apro.getProduct(Integer.parseInt(rs.getString("pronum").substring(1)), "content");
						
						cartrs.setRdate(rs.getDate("rdate"));
						cartrs.setState(product.getState());
						cartrs.setTitle(product.getTitle());
						cartrs.setImgs(product.getImgs());
						
						}else if(pcode.equals("g")) {
							GpurcDBBean gpro=GpurcDBBean.getInstance();
							GpurcDataBean product=gpro.getProduct(Integer.parseInt(rs.getString("pronum").substring(1)), "content");
						
							cartrs.setRdate(rs.getDate("rdate"));
							cartrs.setState(product.getState());
							cartrs.setTitle(product.getTitle());
							cartrs.setImgs(product.getImgs());
						
						}
						
						
					
					
						
					
					
						System.out.println(cartrs);
						
						carts.add(cartrs);
					
					}while(rs.next());
				}
			}catch(Exception ex) {
					ex.printStackTrace();
			}finally {close(con, rs, pstmt);}
		
		return carts;
		
	}


	
}
