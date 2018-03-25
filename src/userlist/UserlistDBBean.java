package userlist;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import util.MybatisConnector;


public class UserlistDBBean extends MybatisConnector{
	private final String namespace = "userlist";
	private static UserlistDBBean instance = new UserlistDBBean();
	private UserlistDBBean() {}
	public static UserlistDBBean getInstance() {
		return instance;
	}
	
	SqlSession sqlSession;
		
		public void addUser(UserlistDataBean user) {
		sqlSession=sqlSession();
			int number=0;
			Date bd=null;
			number=sqlSession.selectOne(namespace+".getNextNumber");
			user.setNum(number);
		
			sqlSession.insert(namespace+".addUser",user);
			sqlSession.commit();
			sqlSession.close();
		}
		
	public UserlistDataBean getUser(String id, String pwd) {
			sqlSession=sqlSession();
			Map map=new HashMap();
			map.put("id", id);
			map.put("pwd",pwd);
			
			
			UserlistDataBean user=null;
			user=sqlSession.selectOne(namespace+".getUser",map);
			
			sqlSession.close();
			
			return user;
		
		}
	public UserlistDataBean getUser(String id) {
		
		sqlSession=sqlSession();
		Map map=new HashMap();
		map.put("id", id);
		
		
		UserlistDataBean user=null;
		user=sqlSession.selectOne(namespace+".getUser",map);
		
		sqlSession.close();
		
		return user;
			
	
	
	}
	
	public int loginCheck(String id,String pwd) {
		
		sqlSession=sqlSession();
		Map map=new HashMap();
		map.put("id", id);
		map.put("pwd", pwd);

		int ck=-1;

		UserlistDataBean user=null;
		user=sqlSession.selectOne(namespace+".getUser",map);
		
		if(user!=null) {ck=0;}
		
		sqlSession.close();
		return ck;

		
	}
		
	
public List getUsers(int startRow, int endRow) {
	sqlSession=sqlSession();
	Map map=new HashMap();
	map.put("startRow", startRow);
	map.put("endRow", endRow);
		
		List users=null;
	
		users=sqlSession.selectList(namespace+".getUsers",map);
		
	sqlSession.close();
		return users;
		
	}

public int getUserCount (String ulevel){
	sqlSession=sqlSession();
	Map map=new HashMap();
	map.put("ulevel", ulevel);
	int x=0;
	x=sqlSession.selectOne(namespace+".getUserCount",map);
	sqlSession.close();
	return x;
}


public int deleteUser(String id, String pwd) throws Exception {
	sqlSession=sqlSession();
	Map map=new HashMap();
	map.put("id", id);
	map.put("pwd", pwd);
	
	int x=-1;
	x=sqlSession.delete(namespace+".deleteUser",map);
	sqlSession.commit();
	sqlSession.close();
	return x;
	
	
}

public int updateUser(UserlistDataBean user) {
	sqlSession=sqlSession();

	int chk=0;
	chk=sqlSession.update(namespace+".updateUser",user);
	
		
	return chk;
}

}