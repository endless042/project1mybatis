package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.BoardDataBean;

public class AuctionDBBean {
	private static AuctionDBBean auction=new AuctionDBBean();
	
	private AuctionDBBean() {
		
	}
	
	public static AuctionDBBean getInstance() {
		
		return auction;
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
	
	public void addAproduct(AuctionDataBean aproduct) {
		
		String sql="";
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		int number=0;
		Date bd=null;
	
	try {
		pstmt=con.prepareStatement("select aSer.nextval from dual");
		rs=pstmt.executeQuery();
		if(rs.next()) number=rs.getInt(1);
	
		
	
		
			sql="insert into aproduct (num,state,origin,title,name,"
					+ "category,height,sdate,edate,sprice,eprice,deliv,content,imgs,rdate,imgsize) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?)";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1, number);
			pstmt.setString(2, aproduct.getState());
			pstmt.setString(3,aproduct.getOrigin());
			pstmt.setString(4, aproduct.getTitle());
			pstmt.setString(5, aproduct.getName());
			pstmt.setString(6, aproduct.getCategory());
			pstmt.setString(7,aproduct.getHeight());
			pstmt.setString(8, aproduct.getSdate());
			pstmt.setString(9, aproduct.getEdate());
			pstmt.setString(10, aproduct.getSprice());
			pstmt.setString(11, aproduct.getSprice());
			pstmt.setString(12, aproduct.getDeliv());
			pstmt.setString(13, aproduct.getContent());
			pstmt.setString(14, aproduct.getImgs());
			pstmt.setInt(15, aproduct.getImgsize());
			
			
			
			pstmt.executeUpdate();
			
		
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con,rs,pstmt);
		}
	
	}
	

public int getAproductCount (){
	String sql="select count(*) from aproduct";
	Connection con=getConnection();
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int x=0;
	
	try{ pstmt=con.prepareStatement(sql);
	
	
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


public int getRemainTime (AuctionDataBean aproduct, String curtime){
	String sql="select abs((to_date(?,'yyyymmddhh24miss') - " + 
			"to_date(?,'yyyymmddhh24miss')))*24*60*60 from dual";
	Connection con=getConnection();
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int x=0;
	
	try{ pstmt=con.prepareStatement(sql);
	pstmt.setString(1, aproduct.getEdate());
	pstmt.setString(2,curtime);
	
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


public List getProducts(int startRow, int endRow) {
		
		
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List productList=null;
		String sql="";
		
		try {
			con=getConnection();
			sql="select * from (" + 
					"select rownum rum , b.* from (" + 
					"select a.* from aproduct a  ORDER BY rdate DESC) b)" + 
					"where rum between ? and ? ORDER BY  num desc";
			
			
				pstmt=con.prepareStatement(sql);
				
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
				rs=pstmt.executeQuery();
			
				if(rs.next()) {
					productList=new ArrayList();
					do {
						
						AuctionDataBean aproduct=new AuctionDataBean();
						
						aproduct.setNum(rs.getInt("num"));
						aproduct.setState(rs.getString("state"));
						aproduct.setOrigin(rs.getString("origin"));
						aproduct.setTitle(rs.getString("title"));
						aproduct.setName(rs.getString("name"));
						aproduct.setCategory(rs.getString("category"));
						aproduct.setHeight(rs.getString("height"));
						aproduct.setSdate(rs.getString("sdate"));
						aproduct.setEdate(rs.getString("edate"));
						aproduct.setSprice(rs.getString("sprice"));
						aproduct.setEprice(rs.getString("eprice"));
						aproduct.setRe(rs.getInt("re"));
						aproduct.setRdate(rs.getDate("rdate"));
						aproduct.setDeliv(rs.getString("deliv"));
						aproduct.setImgs(rs.getString("imgs"));
						aproduct.setContent(rs.getString("content"));
						
						
						productList.add(aproduct);
					
					}while(rs.next());
				}
			}catch(Exception ex) {
					ex.printStackTrace();
			}finally {close(con, rs, pstmt);}
		
		return productList;
		
	}

public AuctionDataBean getProduct(int num,  String chk) {
	
	
	Connection con=getConnection();
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql="";
	AuctionDataBean aproduct=null;
	
	try {
		con=getConnection();
		
		if(chk.equals("content")) {
		sql="Update aproduct set readcount=readcount+1 where num=?";
		//조회수 1 증가
		
		pstmt=con.prepareStatement(sql);
		
		pstmt.setInt(1, num);
		
		
		pstmt.executeUpdate();
		}
		
		sql="Select * from aproduct where num=?";
		
		pstmt=con.prepareStatement(sql);	//pstmt에 sql문을 새로 수정해서 넣어야 함. 
		
		pstmt.setInt(1, num);
		
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			aproduct=new AuctionDataBean();
			
			aproduct.setNum(rs.getInt("num"));
			aproduct.setState(rs.getString("state"));
			aproduct.setOrigin(rs.getString("origin"));
			aproduct.setTitle(rs.getString("title"));
			aproduct.setName(rs.getString("name"));
			aproduct.setCategory(rs.getString("category"));
			aproduct.setHeight(rs.getString("height"));
			aproduct.setSdate(rs.getString("sdate"));
			aproduct.setEdate(rs.getString("edate"));
			aproduct.setSprice(rs.getString("sprice"));
			aproduct.setEprice(rs.getString("eprice"));
			aproduct.setRdate(rs.getTimestamp("rdate"));
			aproduct.setDeliv(rs.getString("deliv"));
			aproduct.setRe(rs.getInt("re"));
			aproduct.setImgs(rs.getString("imgs"));
			aproduct.setContent(rs.getString("content"));
			aproduct.setCount(rs.getInt("count"));
			
			
	
			
		}
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		close(con, rs, pstmt);
	}
		
	return aproduct;

}


	
	
}
