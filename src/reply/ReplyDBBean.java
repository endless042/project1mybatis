package reply;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import util.MybatisConnector;

public class ReplyDBBean extends MybatisConnector{
	private final String namespace = "reply";
	private static ReplyDBBean instance = new ReplyDBBean();
	private ReplyDBBean() {}
	public static ReplyDBBean getInstance() {
		return instance;
	}
	
	SqlSession sqlSession;
	
	
	public int selectCount(String pronum) throws SQLException {
		
		sqlSession=sqlSession();
		Map map=new HashMap();
		map.put("pronum", pronum);
		int num=0;
		num=sqlSession.selectOne(namespace+".selectCount",map);
		
		sqlSession.close();
		return num;
	}

	public ReplyDataBean select(int num) throws SQLException {
		sqlSession=sqlSession();
		Map map=new HashMap();
		map.put("num", num);
		
		ReplyDataBean reply=null;
		reply=sqlSession.selectOne(namespace+".select",map);
		sqlSession.close();
		return reply;
	}
	
	public List<ReplyDataBean> selectList(int firstRow, int endRow, String pronum) throws SQLException{
		sqlSession=sqlSession();
		Map map=new HashMap();
		map.put("firstRow", firstRow);
		map.put("endRow", endRow);
		map.put("pronum", pronum);
		
		List li=null;
		li=sqlSession.selectList(namespace+".selectList",map);
		
			return li;
	}
	
	
	
	public int insert(ReplyDataBean message) throws SQLException{
		sqlSession=sqlSession();
		int max=0;
		max=sqlSession.selectOne(namespace+".getNumber");
		message.setNum(max+1);
		int x=0;
		x=sqlSession.insert(namespace+".insert",message);
		
		sqlSession.commit();
		sqlSession.close();
		return x;
	}
	
	public int delete(int num) throws SQLException{
		sqlSession=sqlSession();
		Map map=new HashMap();
		map.put("num", num);
		int x=0;
		x=sqlSession.delete(namespace+".delete",map);
		sqlSession.commit();
		sqlSession.close();
		
		return x;
	}

}
