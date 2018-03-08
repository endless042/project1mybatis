package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDBBean {

	private static OrderDBBean order= new OrderDBBean();
	
	private OrderDBBean() {
		
	}
	public static OrderDBBean getInstance() {
		return order;
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
	


public OrderDataBean getOrder(int num) {
	
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql="";
	OrderDataBean order=null;
	
	try {
		con=DBcontrol.getConnection();
		
	
		
		sql="Select * from orderlist where num=?";
		
		pstmt=con.prepareStatement(sql);	
		
		pstmt.setInt(1, num);
		
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			order=new OrderDataBean();
			
			order.setAprice(rs.getString("aprice"));
			order.setCount(rs.getInt("count"));
			order.setNum(rs.getInt("num"));
			order.setPayState(rs.getString("paystate"));
			order.setPronum(rs.getString("pronum"));
			order.setRdate(rs.getTimestamp("rdate"));
			
			
			
			
	
			
		}
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		close(con, rs, pstmt);
	}
		
	return order;

}


public int updateOrder(OrderDataBean order) {
	
	String sql="";
	Connection con=DBcontrol.getConnection();
	PreparedStatement pstmt=null;
	
	int chk=0;
	try {

		sql="update orderlist set paystate=? where num=?";
		
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, order.getPayState());
		pstmt.setInt(2, order.getNum());
	
		
	
		chk=pstmt.executeUpdate(); 	
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, null, pstmt);
			
			
		}
		
	return chk;
}

	
public void addOrder(OrderDataBean order) {
		
		String sql="";
		Connection con=DBcontrol.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		int number=0;
	
	try {
		pstmt=con.prepareStatement("select oser.nextval from dual");
		rs=pstmt.executeQuery();
		if(rs.next()) number=rs.getInt(1);
		
		
			sql="insert into orderlist (userid,pronum,aprice,num,count) "
					+ "values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, order.getUserid());
			pstmt.setString(2, order.getPronum());
			pstmt.setString(3, order.getAprice());
			pstmt.setInt(4, number);
			pstmt.setInt(5, order.getCount());
			pstmt.executeUpdate();
			
		
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con,rs,pstmt);
		}
	
	}
	

public int getOrderCount (String pcode, String userid){
	String sql="select count(*) from orderlist where pronum like concat (?, '%') and userid=?";
	Connection con=DBcontrol.getConnection();
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


public int getTotalOrderCount (String pcode){
	String sql="select count(*) from orderlist where pronum like concat (?, '%')";
	Connection con=DBcontrol.getConnection();
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int x=0;
	
	try{ pstmt=con.prepareStatement(sql);
	pstmt.setString(1, pcode);
	
	
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

public int getPayOrderCount (String pcode){
	String sql="select count(*) from orderlist where pronum like concat (?, '%') and paystate is not null";
	Connection con=DBcontrol.getConnection();
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int x=0;
	
	try{ pstmt=con.prepareStatement(sql);
	pstmt.setString(1, pcode);
	
	
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


public List getOrders(int startRow, int endRow, String pcode, String userid) {
		
		
	Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List orders=null;
		String sql="";
		
		try {
			con=DBcontrol.getConnection();
			sql="select * from (" + 
					"select rownum rum , b.* from (" + 
					"select a.* from orderlist a  where pronum like concat (?, '%') and userid=? ORDER BY rdate desc) b) " + 
					"where rum between ? and ?";
			
			
				pstmt=con.prepareStatement(sql);
				
				pstmt.setString(1, pcode);
				pstmt.setString(2, userid);
				pstmt.setInt(3, startRow);
				pstmt.setInt(4, endRow);
				
				rs=pstmt.executeQuery();
			
				if(rs.next()) {
					orders=new ArrayList();
					do {
						
						OrderDataBean order=new OrderDataBean();
						
						if(pcode.equals("a")) {
						AuctionDBBean apro=AuctionDBBean.getInstance();
						AuctionDataBean product=apro.getProduct(Integer.parseInt(rs.getString("pronum").substring(1)), "");
						AhistoryDBBean hpro=AhistoryDBBean.getInstance();
						AhistoryDataBean ahistory=hpro.getHistory(userid, "");						
						
						order.setAprice(ahistory.getPrice()); 
						
						order.setAproduct(product);
						order.setNum(rs.getInt("num"));
						order.setPronum(rs.getString("pronum"));
						order.setRdate(rs.getTimestamp("rdate"));
						order.setUserid(userid);
						order.setAprice(rs.getString("aprice"));
						order.setPayState(rs.getString("paystate"));
						
						Date date = new Date();

						SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

						System.out.println(simple.format(date));
						String curtime=simple.format(date);
						
						order.setRemainTime(apro.getRemainTime(product, curtime));
						order.setStartRemain(apro.getStartRemain(product, curtime));
						
						
						}else if(pcode.equals("g")) {
							GpurcDBBean gpro=GpurcDBBean.getInstance();
							GpurcDataBean product=gpro.getProduct(Integer.parseInt(rs.getString("pronum").substring(1)), "");
						
							order.setGproduct(product);
							order.setNum(rs.getInt("num"));
							order.setPronum(rs.getString("pronum"));
							order.setRdate(rs.getTimestamp("rdate"));
							order.setUserid(userid);
							order.setCount(rs.getInt("count"));
							order.setPayState(rs.getString("paystate"));
							
							Date date = new Date();

							SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

							System.out.println(simple.format(date));
							String curtime=simple.format(date);
							
							order.setRemainTime(gpro.getRemainTime(product, curtime));
							order.setStartRemain(gpro.getStartRemain(product, curtime));
							
						}
						
						
					
		
						
						orders.add(order);
					
					}while(rs.next());
				}
			}catch(Exception ex) {
					ex.printStackTrace();
			}finally {close(con, rs, pstmt);}
		
		return orders;
		
	}


public List getOrdersAdmin(int startRow, int endRow, String pcode) {
		
		
	Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List orders=null;
		String sql="";
		
		try {
			con=DBcontrol.getConnection();
			sql="select * from (" + 
					"select rownum rum , b.* from (" + 
					"select a.* from orderlist a  where pronum like concat (?, '%') ORDER BY rdate desc) b) " + 
					"where rum between ? and ?";
			
			
				pstmt=con.prepareStatement(sql);
				
				pstmt.setString(1, pcode);
			
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				
				rs=pstmt.executeQuery();
			
				if(rs.next()) {
					orders=new ArrayList();
					do {
						
						OrderDataBean order=new OrderDataBean();
						
						if(pcode.equals("a")) {
						AuctionDBBean apro=AuctionDBBean.getInstance();
						AuctionDataBean product=apro.getProduct(Integer.parseInt(rs.getString("pronum").substring(1)), "");
						AhistoryDBBean hpro=AhistoryDBBean.getInstance();
								
						
						
						order.setAproduct(product);
						order.setNum(rs.getInt("num"));
						order.setPronum(rs.getString("pronum"));
						order.setRdate(rs.getTimestamp("rdate"));
						order.setUserid(rs.getString("userid"));
						order.setAprice(rs.getString("aprice"));
						order.setCount(1);
						Date date = new Date();

						SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

						System.out.println(simple.format(date));
						String curtime=simple.format(date);
						
						order.setRemainTime(apro.getRemainTime(product, curtime));
						order.setStartRemain(apro.getStartRemain(product, curtime));
						
						
						}else if(pcode.equals("g")) {
							GpurcDBBean gpro=GpurcDBBean.getInstance();
							GpurcDataBean product=gpro.getProduct(Integer.parseInt(rs.getString("pronum").substring(1)), "content");
						
							order.setGproduct(product);
							order.setNum(rs.getInt("num"));
							order.setPronum(rs.getString("pronum"));
							order.setRdate(rs.getTimestamp("rdate"));
							order.setUserid(rs.getString("userid"));
							order.setCount(rs.getInt("count"));
							
							
							Date date = new Date();

							SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

							System.out.println(simple.format(date));
							String curtime=simple.format(date);
							
							order.setRemainTime(gpro.getRemainTime(product, curtime));
							order.setStartRemain(gpro.getStartRemain(product, curtime));
							
						}
						
						
					
		
						
						orders.add(order);
					
					}while(rs.next());
				}
			}catch(Exception ex) {
					ex.printStackTrace();
			}finally {close(con, rs, pstmt);}
		
		return orders;
		
	}


public List getPayOrders(int startRow, int endRow, String pcode) {
		
		
	Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List orders=null;
		String sql="";
		
		try {
			con=DBcontrol.getConnection();
			sql="select * from (" + 
					"select rownum rum , b.* from (" + 
					"select a.* from orderlist a  where pronum like concat (?, '%') and paystate is not null ORDER BY rdate desc) b) " + 
					"where rum between ? and ?";
			
			
				pstmt=con.prepareStatement(sql);
				
				pstmt.setString(1, pcode);
			
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				
				rs=pstmt.executeQuery();
			
				if(rs.next()) {
					orders=new ArrayList();
					do {
						
						OrderDataBean order=new OrderDataBean();
						
						if(pcode.equals("a")) {
						AuctionDBBean apro=AuctionDBBean.getInstance();
						AuctionDataBean product=apro.getProduct(Integer.parseInt(rs.getString("pronum").substring(1)), "");
						AhistoryDBBean hpro=AhistoryDBBean.getInstance();
								
						
						
						order.setAproduct(product);
						order.setNum(rs.getInt("num"));
						order.setPronum(rs.getString("pronum"));
						order.setRdate(rs.getTimestamp("rdate"));
						order.setUserid(rs.getString("userid"));
						order.setAprice(rs.getString("aprice"));
						
						Date date = new Date();

						SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

						System.out.println(simple.format(date));
						String curtime=simple.format(date);
						
						order.setRemainTime(apro.getRemainTime(product, curtime));
						order.setStartRemain(apro.getStartRemain(product, curtime));
						
						
						}else if(pcode.equals("g")) {
							GpurcDBBean gpro=GpurcDBBean.getInstance();
							GpurcDataBean product=gpro.getProduct(Integer.parseInt(rs.getString("pronum").substring(1)), "content");
						
							order.setGproduct(product);
							order.setNum(rs.getInt("num"));
							order.setPronum(rs.getString("pronum"));
							order.setRdate(rs.getTimestamp("rdate"));
							order.setUserid(rs.getString("userid"));
							order.setCount(rs.getInt("count"));
							
							
							Date date = new Date();

							SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

							System.out.println(simple.format(date));
							String curtime=simple.format(date);
							
							order.setRemainTime(gpro.getRemainTime(product, curtime));
							order.setStartRemain(gpro.getStartRemain(product, curtime));
							
						}
						
						
					
		
						
						orders.add(order);
					
					}while(rs.next());
				}
			}catch(Exception ex) {
					ex.printStackTrace();
			}finally {close(con, rs, pstmt);}
		
		return orders;
		
	}
	
}
