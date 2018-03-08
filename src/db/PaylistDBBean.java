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

import db.AhistoryDBBean;
import db.AhistoryDataBean;
import db.AuctionDBBean;
import db.AuctionDataBean;
import db.GpurcDBBean;
import db.GpurcDataBean;
import db.OrderDataBean;
import db.PaylistDataBean;
import db.UserlistDataBean;

public class PaylistDBBean {

	private static PaylistDBBean pay= new PaylistDBBean();
	
	private PaylistDBBean() {
		
		
	};
	
	public static PaylistDBBean getInstance() {
		return pay;
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
	
	public void addPay(PaylistDataBean pay) {
		
		String sql="";
		Connection con=DBcontrol.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		int number=0;
	
	
	try {
		pstmt=con.prepareStatement("select payser.nextval from dual");
		rs=pstmt.executeQuery();
		if(rs.next()) number=rs.getInt(1);
	
		
	
		
			sql="insert into paylist"
					+ " (num,pronum,userid,price,name,addr,tel,deliv,count,point)"
					+ " values(?,?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setString(2, (pay.getPronum()));
			pstmt.setString(3, pay.getUserid());
			pstmt.setString(4, pay.getPrice());
			pstmt.setString(5, pay.getName());
			pstmt.setString(6, pay.getAddr());
			pstmt.setString(7, pay.getTel());
			pstmt.setString(8, pay.getDeliv());
			pstmt.setInt(9, pay.getCount());
			pstmt.setString(10, pay.getPoint());
			pstmt.executeUpdate();
			
		
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con,rs,pstmt);
		}
	
	}
	

public int getPayCountUser (String pcode, String userid){
	String sql="select count(*) from paylist where pronum like concat (?, '%') and userid=?";
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

public int getPayCountAdmin (String pcode){
	String sql="select count(*) from paylist where pronum like concat (?, '%')";
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


public List getPaylistUser(int startRow, int endRow, String pcode, String userid) {
		

Connection con=DBcontrol.getConnection();
PreparedStatement pstmt=null;
ResultSet rs=null;
List paylist=null;
String sql="";

try {
	con=DBcontrol.getConnection();
	sql="select * from (" + 
		"select rownum rum , b.* from (" + 
		"select a.* from paylist a  where pronum like concat (?, '%') and userid=? ORDER BY rdate desc) b) " + 
		"where rum between ? and ?";


	pstmt=con.prepareStatement(sql);
	
	pstmt.setString(1, pcode);
	pstmt.setString(2, userid);
	pstmt.setInt(3, startRow);
	pstmt.setInt(4, endRow);
	
	rs=pstmt.executeQuery();

if(rs.next()) {
	paylist=new ArrayList();
	do {
		
		PaylistDataBean pay=new PaylistDataBean();
	
	
	pay.setAddr(rs.getString("addr"));
	pay.setDeliv(rs.getString("deliv"));
	pay.setName(rs.getString("name"));
	pay.setNum(rs.getInt("num"));
	pay.setPrice(rs.getString("price"));
	pay.setPronum(rs.getString("pronum"));
	pay.setRdate(rs.getTimestamp("rdate"));
	pay.setTel(rs.getString("tel"));
	pay.setUserid(rs.getString("userid"));
	pay.setCount(rs.getInt("count"));
	
	if(pcode.equals("a")) {
		AuctionDBBean apro=AuctionDBBean.getInstance();
		AuctionDataBean atmp=apro.getProduct(Integer.parseInt(rs.getString("pronum").substring(1)), "");
		
		pay.setAproduct(atmp);
	}else if(pcode.equals("g")) {
		GpurcDBBean gpro=GpurcDBBean.getInstance();
		GpurcDataBean gtmp=gpro.getProduct(Integer.parseInt(rs.getString("pronum").substring(1)), "");
		pay.setGproduct(gtmp);	
	}
	
				
				paylist.add(pay);
			
			}while(rs.next());
		}
	}catch(Exception ex) {
			ex.printStackTrace();
	}finally {close(con, rs, pstmt);}

return paylist;

	}



public List getPaylistAdmin(int startRow, int endRow, String pcode) {
		

Connection con=DBcontrol.getConnection();
PreparedStatement pstmt=null;
ResultSet rs=null;
List paylist=null;
String sql="";

try {
	con=DBcontrol.getConnection();
	sql="select * from (" + 
		"select rownum rum , b.* from (" + 
		"select a.* from paylist a  where pronum like concat (?, '%')  ORDER BY rdate desc) b) " + 
		"where rum between ? and ?";


	pstmt=con.prepareStatement(sql);
	
	pstmt.setString(1, pcode);
	pstmt.setInt(2, startRow);
	pstmt.setInt(3, endRow);
	
	rs=pstmt.executeQuery();

if(rs.next()) {
	paylist=new ArrayList();
	do {
		
		PaylistDataBean pay=new PaylistDataBean();
	
	
	pay.setAddr(rs.getString("addr"));
	pay.setDeliv(rs.getString("deliv"));
	pay.setName(rs.getString("name"));
	pay.setNum(rs.getInt("num"));
	pay.setPrice(rs.getString("price"));
	pay.setPronum(rs.getString("pronum"));
	pay.setRdate(rs.getTimestamp("rdate"));
	pay.setTel(rs.getString("tel"));
	pay.setUserid(rs.getString("userid"));
	pay.setCount(rs.getInt("count"));
	
				
				paylist.add(pay);
			
			}while(rs.next());
		}
	}catch(Exception ex) {
			ex.printStackTrace();
	}finally {close(con, rs, pstmt);}

return paylist;

	}


public PaylistDataBean getPay(int num) {
	
	
	Connection con=DBcontrol.getConnection();
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql="";
	PaylistDataBean pay=null;
	
	try {
		con=DBcontrol.getConnection();
		
		
		
		sql="Select * from paylist where num=?";
		
		pstmt=con.prepareStatement(sql);	
		
		pstmt.setInt(1, num);
		
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			pay=new PaylistDataBean();
			
			pay.setAddr(rs.getString("addr"));
			pay.setCount(rs.getInt("count"));
			pay.setDeliv(rs.getString("deliv"));
			pay.setName(rs.getString("name"));
			pay.setNum(rs.getInt("num"));
			pay.setPrice(rs.getString("price"));
			pay.setPronum(rs.getString("pronum"));
			pay.setRdate(rs.getTimestamp("rdate"));
			pay.setTel(rs.getString("tel"));
			pay.setPoint(rs.getString("point"));
			
			if(rs.getString("pronum").substring(1).equals("a")) {
				AuctionDBBean apro=AuctionDBBean.getInstance();
				AuctionDataBean aproduct=apro.getProduct(Integer.parseInt(rs.getString("pronum").substring(1)), "");
			
				pay.setAproduct(aproduct);
			}
			if(rs.getString("pronum").substring(1).equals("g")) {
				GpurcDBBean gpro=GpurcDBBean.getInstance();
				GpurcDataBean gproduct=
						gpro.getProduct(Integer.parseInt(rs.getString("pronum").substring(1)), "");
			
				pay.setGproduct(gproduct);
			}

		}
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		close(con, rs, pstmt);
	}
		
	return pay;

}



	
}
