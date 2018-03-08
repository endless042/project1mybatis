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

public class GpurcDBBean {
private static GpurcDBBean gpurchase=new GpurcDBBean();
	
	private GpurcDBBean() {
		
	}
	
	public static GpurcDBBean getInstance() {
		
		return gpurchase;
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
	
	public void addGproduct(GpurcDataBean gproduct) {
		
		String sql="";
		Connection con=DBcontrol.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		int number=0;
		Date bd=null;
	
	try {
		pstmt=con.prepareStatement("select pSer.nextval from dual");
		rs=pstmt.executeQuery();
		if(rs.next()) number=rs.getInt(1);
	
		
	
		
			sql="insert into gproduct (num,state,origin,title,name,"
					+ "category,height,sdate,edate,price,goal,deliv,content,process,imgs,rdate,imgsize) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?)";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1, number);
			pstmt.setString(2, gproduct.getState());
			pstmt.setString(3,gproduct.getOrigin());
			pstmt.setString(4, gproduct.getTitle());
			pstmt.setString(5, gproduct.getName());
			pstmt.setString(6, gproduct.getCategory());
			pstmt.setString(7,gproduct.getHeight());
			pstmt.setString(8, gproduct.getSdate());
			pstmt.setString(9, gproduct.getEdate());
			pstmt.setString(10, gproduct.getPrice());
			pstmt.setInt(11, gproduct.getGoal());
			pstmt.setString(12, gproduct.getDeliv());
			pstmt.setString(13, gproduct.getContent());
			pstmt.setString(14, gproduct.getProcess());
			pstmt.setString(15, gproduct.getImgs());
			pstmt.setInt(16, gproduct.getImgsize());
			
			pstmt.executeUpdate();
			
		
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con,rs,pstmt);
		}
	
	}
	

public int getRemainTime (GpurcDataBean gproduct, String curtime){
	String sql="select (to_date(?,'yyyymmddhh24miss') - " + 
			"to_date(?,'yyyymmddhh24miss'))*24*60*60 from dual";
	Connection con=DBcontrol.getConnection();
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int x=0;
	
	try{ pstmt=con.prepareStatement(sql);
	pstmt.setString(1, gproduct.getEdate());
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
	if(x>0) {
		return x;
		}else {
			return 0;
		}
}

public int getStartRemain (GpurcDataBean gproduct, String curtime){
	String sql="select (to_date(?,'yyyymmddhh24miss') - " + 
			"to_date(?,'yyyymmddhh24miss'))*24*60*60 from dual";
	Connection con=DBcontrol.getConnection();
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int x=0;
	
	try{ pstmt=con.prepareStatement(sql);
	pstmt.setString(1, gproduct.getSdate());
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
	
	if(x>0) {
	return 1;		//아직 시작 안 함
	}else {
		return 0;	//시작 됨
	}
}


public void stateManage(List<GpurcDataBean> products) {
	GpurcDBBean apro=GpurcDBBean.getInstance();	
	GpurcDataBean product=new GpurcDataBean();
	Date date = new Date();

	SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

	
	String curtime=simple.format(date);
	int timeCount;
	int startRemain;
	for(int i=0;i<products.size();i++) {
		
		product=(GpurcDataBean)products.get(i);
		timeCount=apro.getRemainTime(product, curtime);
		startRemain=apro.getStartRemain(product, curtime);	
		if(startRemain==1) {
			product.setState("1");
		}else if(timeCount==0) {
			product.setState("3");
		}else if(timeCount>0) {
			product.setState("2");
		}
		
		apro.updateGproduct(product);
		
			
		}
	
		
	}
	
public int getGproductCount (String stateSelect){
	String sql="";
	
	if(stateSelect.equals("all")||stateSelect.equals("top")) {
	sql="select count(*) from gproduct";}
	else if(stateSelect.equals("1")) {
		sql="select count(*) from gproduct where state='1'";
	}else if(stateSelect.equals("2")) {
		sql="select count(*) from gproduct where state='2'";
	}else if(stateSelect.equals("3")) {
		sql="select count(*) from gproduct where state='3'";
	}
	
	Connection con=DBcontrol.getConnection();
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


public List getProducts(int startRow, int endRow, String stateSelect) {
		
		
		Connection con=DBcontrol.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List productList=null;
		String sql="";
		
		try {
			con=DBcontrol.getConnection();
			
			if(stateSelect.equals("all")) {
			sql="select * from (" + 
					"select rownum rum , b.* from (" + 
					"select a.* from gproduct a  ORDER BY rdate DESC) b)" + 
					"where rum between ? and ? ORDER BY  num desc";
			}else if(stateSelect.equals("top")) {
				sql="select * from (" + 
						"select rownum rum , b.* from (" + 
						"select a.* from gproduct a  ) b)" + 
						"where rum between ? and ? ORDER BY  readcount desc";
				
			}else if(stateSelect.equals("1")) {
				sql="select * from (" + 
						"select rownum rum , b.* from (" + 
						"select a.* from gproduct a where state='1' ORDER BY rdate DESC) b)" + 
						"where rum between ? and ? ORDER BY  num desc";
			}else if(stateSelect.equals("2")) {
				sql="select * from (" + 
						"select rownum rum , b.* from (" + 
						"select a.* from gproduct a where state='2' ORDER BY rdate DESC) b)" + 
						"where rum between ? and ? ORDER BY  num desc";
			}else if(stateSelect.equals("3")) {
				sql="select * from (" + 
						"select rownum rum , b.* from (" + 
						"select a.* from gproduct a where state='3' ORDER BY rdate DESC) b)" + 
						"where rum between ? and ? ORDER BY  num desc";
			}
			
				
			
			
				pstmt=con.prepareStatement(sql);
				
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
				rs=pstmt.executeQuery();
			
				if(rs.next()) {
					productList=new ArrayList();
					do {
						
						GpurcDataBean gproduct=new GpurcDataBean();
						
						gproduct.setNum(rs.getInt("num"));
						gproduct.setState(rs.getString("state"));
						gproduct.setOrigin(rs.getString("origin"));
						gproduct.setTitle(rs.getString("title"));
						gproduct.setName(rs.getString("name"));
						gproduct.setCategory(rs.getString("category"));
						gproduct.setHeight(rs.getString("height"));
						gproduct.setSdate(rs.getString("sdate"));
						gproduct.setEdate(rs.getString("edate"));
						gproduct.setProcess(rs.getString("process"));
						gproduct.setPrice(rs.getString("price"));
						gproduct.setRe(rs.getInt("re"));
						gproduct.setRdate(rs.getDate("rdate"));
						gproduct.setDeliv(rs.getString("deliv"));
						gproduct.setImgs(rs.getString("imgs"));
						gproduct.setContent(rs.getString("content"));
						gproduct.setGoal(rs.getInt("goal"));
						gproduct.setCount(rs.getInt("count"));
						
						
						productList.add(gproduct);
					
					}while(rs.next());
				}
				
				GpurcDBBean gpro=GpurcDBBean.getInstance();
				if(productList!=null) {gpro.stateManage(productList);}
			}catch(Exception ex) {
					ex.printStackTrace();
			}finally {close(con, rs, pstmt);}
		
		return productList;
		
	}


public List getTopProducts(int startRow, int endRow) {
		
		
	Connection con=DBcontrol.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List productList=null;
		String sql="";
		
		try {
			con=DBcontrol.getConnection();
			sql="select * from (" + 
					"select rownum rum , b.* from (" + 
					"select a.* from gproduct a  ) b)" + 
					"where rum between ? and ? ORDER BY  readcount desc";
			
			
				pstmt=con.prepareStatement(sql);
				
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
				rs=pstmt.executeQuery();
			
				if(rs.next()) {
					productList=new ArrayList();
					do {
						
						GpurcDataBean gproduct=new GpurcDataBean();
						
						gproduct.setNum(rs.getInt("num"));
						gproduct.setState(rs.getString("state"));
						gproduct.setOrigin(rs.getString("origin"));
						gproduct.setTitle(rs.getString("title"));
						gproduct.setName(rs.getString("name"));
						gproduct.setCategory(rs.getString("category"));
						gproduct.setHeight(rs.getString("height"));
						gproduct.setSdate(rs.getString("sdate"));
						gproduct.setEdate(rs.getString("edate"));
						gproduct.setProcess(rs.getString("process"));
						gproduct.setPrice(rs.getString("price"));
						gproduct.setRe(rs.getInt("re"));
						gproduct.setRdate(rs.getDate("rdate"));
						gproduct.setDeliv(rs.getString("deliv"));
						gproduct.setImgs(rs.getString("imgs"));
						gproduct.setContent(rs.getString("content"));
						gproduct.setGoal(rs.getInt("goal"));
						gproduct.setCount(rs.getInt("count"));
						
						
						productList.add(gproduct);
					
					}while(rs.next());
				}
				
				GpurcDBBean gpro=GpurcDBBean.getInstance();
				gpro.stateManage(productList);
			}catch(Exception ex) {
					ex.printStackTrace();
			}finally {close(con, rs, pstmt);}
		
		return productList;
		
	}

public GpurcDataBean getProduct(int num,  String chk) {
	
	
	Connection con=DBcontrol.getConnection();
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql="";
	GpurcDataBean gproduct=null;
	
	try {
		con=DBcontrol.getConnection();
		
		if(chk.equals("content")) {
		sql="Update gproduct set readcount=readcount+1 where num=?";
		//조회수 1 증가
		
		pstmt=con.prepareStatement(sql);
		
		pstmt.setInt(1, num);
		
		
		pstmt.executeUpdate();
		}
		
		sql="Select * from gproduct where num=?";
		
		pstmt=con.prepareStatement(sql);	//pstmt에 sql문을 새로 수정해서 넣어야 함. 
		
		pstmt.setInt(1, num);
		
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			gproduct=new GpurcDataBean();
			
			gproduct.setNum(rs.getInt("num"));
			gproduct.setState(rs.getString("state"));
			gproduct.setOrigin(rs.getString("origin"));
			gproduct.setTitle(rs.getString("title"));
			gproduct.setName(rs.getString("name"));
			gproduct.setCategory(rs.getString("category"));
			gproduct.setHeight(rs.getString("height"));
			gproduct.setSdate(rs.getString("sdate"));
			gproduct.setEdate(rs.getString("edate"));
			gproduct.setPrice(rs.getString("price"));
			gproduct.setProcess(rs.getString("process"));
			gproduct.setRdate(rs.getTimestamp("rdate"));
			gproduct.setDeliv(rs.getString("deliv"));
			gproduct.setRe(rs.getInt("re"));
			gproduct.setImgs(rs.getString("imgs"));
			gproduct.setContent(rs.getString("content"));
			gproduct.setCount(rs.getInt("count"));
			gproduct.setGoal(rs.getInt("goal"));
			
			
	
			
		}
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		close(con, rs, pstmt);
	}
		
	return gproduct;

}


public int updateGproduct(GpurcDataBean gproduct) {
	
	String sql="";
	Connection con=DBcontrol.getConnection();
	PreparedStatement pstmt=null;
	
	int chk=0;
	try {

		sql="update gproduct set "
				+ "count=?, state=?, process=?, origin=?, title=?, name=?, category=?,"
				+ "height=?, sdate=?, edate=?, price=?,"
				+ " goal=?, deliv=?, imgs=?, content=?, imgsize=? where num=?";
		
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, gproduct.getCount());
		pstmt.setString(2, gproduct.getState());
		pstmt.setString(3, gproduct.getProcess());
		pstmt.setString(4, gproduct.getOrigin());
		pstmt.setString(5, gproduct.getTitle());
		pstmt.setString(6, gproduct.getName());
		pstmt.setString(7, gproduct.getCategory());
		pstmt.setString(8, gproduct.getHeight());
		pstmt.setString(9, gproduct.getSdate());
		pstmt.setString(10, gproduct.getEdate());
		pstmt.setString(11, gproduct.getPrice());
		pstmt.setInt(12, gproduct.getGoal());
		pstmt.setString(13, gproduct.getDeliv());
		pstmt.setString(14, gproduct.getImgs());
		pstmt.setString(15, gproduct.getContent());
		pstmt.setInt(16, gproduct.getImgsize());
		
		
		
		pstmt.setInt(17, gproduct.getNum());
		
		
		
		chk=pstmt.executeUpdate(); 	
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, null, pstmt);
			
			
		}
		
	return chk;
}

}
