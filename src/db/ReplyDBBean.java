package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReplyDBBean {
	private static ReplyDBBean reply=new ReplyDBBean();
	
	private ReplyDBBean() {
		
		
	}
	
	public static ReplyDBBean getInstance() {
		return reply;
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
	
public void addReply(ReplyDataBean reply) {
		
		String sql="";
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
	
	try {

			sql="insert into reply (userid,rdate,pronum,content,password) "
					+ "values(?,sysdate,?,?,?)";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, reply.getUserid());
			pstmt.setString(2, reply.getPronum());
			pstmt.setString(3,reply.getContent());
			pstmt.setString(4, reply.getPassword());
		
		
			pstmt.executeUpdate();
			
		
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con,rs,pstmt);
		}
	
	}
	

public int getReplyCount (String pronum){
	String sql="select count(*) from reply where pronum=?";
	Connection con=getConnection();
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int x=0;
	
	try{ pstmt=con.prepareStatement(sql);
	pstmt.setString(1, pronum);
	
	
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


public List getReplys(int startRow, int endRow, String pronum) {
		
		
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List replys=null;
		String sql="";
		
		try {
			con=getConnection();
			sql="select * from (" + 
					"select rownum rum , b.* from (" + 
					"select a.* from reply a  where pronum=? ORDER BY rdate desc) b) " + 
					"where rum between ? and ?";
			
			
				pstmt=con.prepareStatement(sql);
				
				pstmt.setString(1, pronum);
				
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				
				rs=pstmt.executeQuery();
			
				if(rs.next()) {
					replys=new ArrayList();
					do {
						
						ReplyDataBean cartrs=new ReplyDataBean();
						
					
							ReplyDBBean rpro=ReplyDBBean.getInstance();
							ReplyDataBean reply=rpro.getReply(pronum);
						
							reply.setRdate(rs.getTimestamp("rdate"));
							reply.setUserid(rs.getString("userid"));
							reply.setContent(rs.getString("content"));
							reply.setPassword(rs.getString("password"));
							reply.setPronum(rs.getString("pronum"));
						
					
						
					
						System.out.println(reply);
						
						replys.add(reply);
					
					}while(rs.next());
				}
			}catch(Exception ex) {
					ex.printStackTrace();
			}finally {close(con, rs, pstmt);}
		
		return replys;
		
	}

public ReplyDataBean getReply(String pronum) {
	
	
	Connection con=getConnection();
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql="";
	ReplyDataBean reply=null;
	
	try {
		con=getConnection();
		
	
		sql="select * from reply where pronum=?";
		pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1, pronum);
		
		
		rs=pstmt.executeQuery();
		
		reply=new ReplyDataBean();
		if(rs.next()) {
				
			reply.setUserid(rs.getString("userid"));
			reply.setPassword(rs.getString("password"));
			reply.setPronum(pronum);
			reply.setRdate(rs.getTimestamp("rdate"));
			reply.setContent(rs.getString("content"));
			
	
		
		}	else {return null;}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		close(con, rs, pstmt);
	}
		
	return reply;

}

}

