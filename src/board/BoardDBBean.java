package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import ahistory.AhistoryDBBean;
import util.MybatisConnector;



public class BoardDBBean extends MybatisConnector{
	private final String namespace = "board";
	private static BoardDBBean instance = new BoardDBBean();
	private BoardDBBean() {}
	public static BoardDBBean getInstance() {
		return instance;
	}
	
	SqlSession sqlSession;
	
	public void insertArticle(BoardDataBean article) {
		sqlSession=sqlSession();

		int number=0;
		number=sqlSession.selectOne(namespace+".getNextNumber");
		
		
		int num=article.getNum();
		int ref=article.getRef();
		int re_step=article.getRe_step();
		int re_level=article.getRe_level();
		
		
		if(num!=0) {
			sqlSession.update(namespace+".updateRe_step",article);
			sqlSession.commit();
			
			re_step=re_step+1;
			re_level=re_level+1;
		}else { 
			ref=number;
			re_step=0;
			re_level=0;
			
		}
		
		article.setNum(number);
		article.setRef(ref);
		article.setRe_step(re_step);
		article.setRe_level(re_level);
		
		sqlSession.insert(namespace+".insertArticle",article);
		sqlSession.commit();
		
		sqlSession.close();
		
	}
	public int getArticleCount (String boardid){
		sqlSession=sqlSession();
		Map map=new HashMap();
		map.put("boardid",boardid);
		
		int x=0;
		x=sqlSession.selectOne(namespace+".getArticleCount",map);
		
		sqlSession.close();
		return x;
	}
	
	
	public List getArticles(int startRow, int endRow, String boardid) {
		sqlSession=sqlSession();
		Map map=new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("boardid", boardid);
		List li=null;
		li=sqlSession.selectList(namespace+".getArticles",map);
		
			sqlSession.close();
		
		return li;
		
	}
												
public BoardDataBean getArticle(int num, String boardid, String chk) {
	sqlSession =sqlSession();
	Map map=new HashMap();
	map.put("num", num);
	map.put("boardid", boardid);
	map.put("chk", chk);
	
	BoardDataBean article=null;

		if(chk.equals("content")) {
	sqlSession.update(namespace+".updateReadcount",map);
	sqlSession.commit();
		}
		
		article=sqlSession.selectOne(namespace+".getArticle",map);

		sqlSession.close();
		
	return article;

}

public int updateArticle(BoardDataBean article) {
	sqlSession =sqlSession();

	int chk=0;
	chk=sqlSession.update(namespace+".updateArticle",article);
	
	sqlSession.close();
	return chk;
}


public int deleteArticle(int num, String passwd, String boardid) throws Exception {
	sqlSession = sqlSession();
	Map map=new HashMap();
	map.put("num", num);
	map.put("passwd", passwd);
	map.put("boardid", boardid);
	int x=-1;
	x=sqlSession.delete(namespace+".deleteArticle",map);
	sqlSession.commit();
	sqlSession.delete(namespace+".deleteReArticle",map);
	sqlSession.commit();
		
		return x;
		
		
	}
	
	
	
	
	
}



	

