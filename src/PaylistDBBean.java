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
	
	public void addPay(PaylistDataBean pay) {
		
		String sql="";
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		int number=0;
	
	
	try {
		pstmt=con.prepareStatement("select payser.nextval from dual");
		rs=pstmt.executeQuery();
		if(rs.next()) number=rs.getInt(1);
	
		
	
		
			sql="insert into paylist"
					+ " (num,pronum,userid,price,name,addr,tel,deliv)"
					+ " values(?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setString(2, (pay.getPronum()));
			pstmt.setString(3, pay.getUserid());
			pstmt.setString(4, pay.getPrice());
			pstmt.setString(5, pay.getName());
			pstmt.setString(6, pay.getAddr());
			pstmt.setString(7, pay.getTel());
			pstmt.setString(8, pay.getDeliv());
			
			pstmt.executeUpdate();
			
		
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con,rs,pstmt);
		}
	
	}
	

public int getPayCountUser (String pcode, String userid){
	String sql="select count(*) from paylist where pronum like concat (?, '%') and userid=?";
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

public int getPayCountAdmin (String pcode){
	String sql="select count(*) from paylist where pronum like concat (?, '%')";
	Connection con=getConnection();
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
		

Connection con=getConnection();
PreparedStatement pstmt=null;
ResultSet rs=null;
List paylist=null;
String sql="";

try {
	con=getConnection();
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
	
	
				
				paylist.add(pay);
			
			}while(rs.next());
		}
	}catch(Exception ex) {
			ex.printStackTrace();
	}finally {close(con, rs, pstmt);}

return paylist;

	}



public List getPaylistAdmin(int startRow, int endRow, String pcode) {
		

Connection con=getConnection();
PreparedStatement pstmt=null;
ResultSet rs=null;
List paylist=null;
String sql="";

try {
	con=getConnection();
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
	
	
				
				paylist.add(pay);
			
			}while(rs.next());
		}
	}catch(Exception ex) {
			ex.printStackTrace();
	}finally {close(con, rs, pstmt);}

return paylist;

	}



	
}
