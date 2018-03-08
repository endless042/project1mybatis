package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AhistoryDBBean {
	private static AhistoryDBBean ahistory=new AhistoryDBBean();
	
	private AhistoryDBBean() {
		
		
	}
	
	public static AhistoryDBBean getInstance() {
		return ahistory;
	}
	
	Connection con=getConnection();

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
	
	
public void addHistory(AhistoryDataBean ahistory) {
		
		String sql="";
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		
	
	try {
		
	
			sql="insert into ahistory (num,userid,price,adate) "
					+ "values(?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1, ahistory.getNum());
			pstmt.setString(2, ahistory.getUserid());
			pstmt.setString(3,ahistory.getPrice());
		
			
			
			
			pstmt.executeUpdate();
			
		
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con,rs,pstmt);
		}
	
	}



public List getHistoryList(int startRow, int endRow, int num) {
		
		
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List historyList=null;
		String sql="";
		
		try {
			con=getConnection();
			sql="select * from (" + 
					"select rownum rum , b.* from (" + 
					"select a.* from ahistory a where num=? ORDER BY adate DESC) b)" + 
					"where rum between ? and ? ";
			
			
				pstmt=con.prepareStatement(sql);
				
				pstmt.setInt(1, num);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				
				rs=pstmt.executeQuery();
			
				if(rs.next()) {
					historyList=new ArrayList();
					do {
						
						AhistoryDataBean ahistory=new AhistoryDataBean();
						
						ahistory.setAdate(rs.getTimestamp("adate"));
						ahistory.setNum(rs.getInt("num"));
						ahistory.setPrice(rs.getString("price"));
						ahistory.setUserid(rs.getString("userid"));
						
					
						
						historyList.add(ahistory);
					
					}while(rs.next());
				}
			}catch(Exception ex) {
					ex.printStackTrace();
			}finally {close(con, rs, pstmt);}
		
		return historyList;
		
	}


public AhistoryDataBean getHistory(String userid,  String chk) {
	
	
	Connection con=getConnection();
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql="";
	AhistoryDataBean ahistory=null;
	
	try {
		con=getConnection();
		
		
		sql="Select * from ahistory where userid=? order by adate desc";
		
		pstmt=con.prepareStatement(sql);	//pstmt에 sql문을 새로 수정해서 넣어야 함. 
		
		pstmt.setString(1, userid);
		
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			ahistory=new AhistoryDataBean();
			ahistory.setAdate(rs.getTimestamp("adate"));
			ahistory.setNum(rs.getInt("num"));
			ahistory.setPrice(rs.getString("price"));
			ahistory.setUserid(userid);
			
		}
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		close(con, rs, pstmt);
	}
		
	return ahistory;

}


public int getHistoryCount (int num){
	String sql="select count(*) from ahistory  where num=? ";
	Connection con=getConnection();
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int x=0;
	
	try{ pstmt=con.prepareStatement(sql);
	pstmt.setInt(1, num);
	
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
	
}
