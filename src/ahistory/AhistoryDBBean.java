package ahistory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import util.MybatisConnector;

public class AhistoryDBBean extends MybatisConnector {
	private final String namespace = "ahistorymap";
	private static AhistoryDBBean instance = new AhistoryDBBean();

	private AhistoryDBBean() {
	}

	public static AhistoryDBBean getInstance() {
		return instance;
	}

	SqlSession sqlSession;

	public void addHistory(AhistoryDataBean ahistory) {

		sqlSession = sqlSession();

		sqlSession.insert(namespace + ".addHistory", ahistory);
		sqlSession.commit();
		sqlSession.close();
	}

	public List getHistoryList(int startRow, int endRow, int num) {

		sqlSession = sqlSession();

		Map map = new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("num", num);

		List li = null;

		int count = 0;
		count = sqlSession.selectOne(namespace + ".getHistoryCount", map);

		if (count != 0) {
			li = sqlSession.selectList(namespace + ".getHistoryList", map);
		}
		sqlSession.close();
		return li;

	}

	public AhistoryDataBean getHistory(String userid, String num) {

		sqlSession = sqlSession();
		Map map = new HashMap();
		map.put("userid", userid);
		map.put("num", num);
		List li = null;
		li = sqlSession.selectList(namespace + ".getHistory", map);
		AhistoryDataBean ahistory = (AhistoryDataBean) li.get(0);
		sqlSession.close();

		return ahistory;

	}

	public int getHistoryCount(int num) {

		sqlSession = sqlSession();
		Map map = new HashMap();
		map.put("num", num);

		int x = 0;
		x = sqlSession.selectOne(namespace + ".getHistoryCount", map);

		sqlSession.close();
		return x;

	}

}
