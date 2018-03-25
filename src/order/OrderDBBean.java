package order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import ahistory.AhistoryDBBean;
import ahistory.AhistoryDataBean;
import auction.AuctionDBBean;
import auction.AuctionDataBean;
import gpurc.GpurcDBBean;
import gpurc.GpurcDataBean;
import util.MybatisConnector;

public class OrderDBBean extends MybatisConnector {

	private final String namespace = "order";
	private static OrderDBBean instance = new OrderDBBean();

	private OrderDBBean() {
	}

	public static OrderDBBean getInstance() {
		return instance;
	}

	SqlSession sqlSession;

	public OrderDataBean getOrder(int num) {
		sqlSession = sqlSession();
		Map map = new HashMap();
		map.put("num", num);
		OrderDataBean order = null;
		order = sqlSession.selectOne(namespace + ".getOrder", map);
		sqlSession.close();

		return order;

	}

	public int updateOrder(OrderDataBean order) {
		sqlSession = sqlSession();
		int chk = 0;
		chk = sqlSession.update(namespace + ".updateOrder", order);
		sqlSession.commit();
		sqlSession.close();

		return chk;
	}

	public void addOrder(OrderDataBean order) {
		sqlSession = sqlSession();

		int number = 0;
		number = sqlSession.selectOne(namespace + ".getNextNumber");

		order.setNum(number);
		order.setAprice("");
		sqlSession.insert(namespace + ".addOrder", order);
		sqlSession.commit();
		sqlSession.close();

	}

	public int getOrderCount(String pcode, String userid) {
		sqlSession = sqlSession();
		Map map = new HashMap();
		map.put("pcode", pcode);
		map.put("userid", userid);
		int x = 0;

		x = sqlSession.selectOne(namespace + ".getOrderCount", map);

		return x;
	}

	public int getTotalOrderCount(String pcode) {
		sqlSession = sqlSession();
		Map map = new HashMap();
		map.put("pcode", pcode);
		int x = 0;

		x = sqlSession.selectOne(namespace + ".getTotalOrderCount", map);

		return x;
	}

	public int getPayOrderCount(String pcode) {
		sqlSession = sqlSession();
		Map map = new HashMap();
		map.put("pcode", pcode);

		int x = 0;
		x = sqlSession.selectOne(namespace + ".getPayOrderCount", map);

		return x;
	}

	public List getSelectOrders(int startRow, int endRow, String pcode, String userid) {
		sqlSession = sqlSession();
		Map map = new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("pcode", pcode);
		map.put("userid", userid);
		
		
		List li = null;
		List orders = null;
		li = sqlSession.selectList(namespace + ".getSelectOrders",map);

		Iterator it = li.iterator();

		if (it.hasNext()) {

			orders = new ArrayList();
			do {

				OrderDataBean odb = (OrderDataBean) it.next();

				if (pcode.equals("a")) {

					AuctionDBBean apro = AuctionDBBean.getInstance();
					AuctionDataBean product = apro.getProduct(Integer.parseInt(odb.getPronum().substring(1)), "");
					AhistoryDBBean hpro = AhistoryDBBean.getInstance();
					AhistoryDataBean ahistory = hpro.getHistory(userid, product.getNum()+"");

					odb.setAprice(ahistory.getPrice());
					odb.setAproduct(product);
					odb.setUserid(userid);

					Date date = new Date();

					SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

					System.out.println(simple.format(date));
					String curtime = simple.format(date);

					odb.setRemainTime(apro.getRemainTime(product, curtime));
					odb.setStartRemain(apro.getStartRemain(product, curtime));

				} else if (pcode.equals("g")) {

					GpurcDBBean gpro = GpurcDBBean.getInstance();
					GpurcDataBean product = gpro.getProduct(Integer.parseInt(odb.getPronum().substring(1)), "");

					odb.setGproduct(product);
					odb.setUserid(userid);

					Date date = new Date();

					SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

					System.out.println(simple.format(date));
					String curtime = simple.format(date);

					odb.setRemainTime(gpro.getRemainTime(product, curtime));
					odb.setStartRemain(gpro.getStartRemain(product, curtime));

				}

				orders.add(odb);

			} while (it.hasNext());
		}
		sqlSession.close();
		return orders;

	}

	public List getOrdersAdmin(int startRow, int endRow, String pcode) {
		sqlSession = sqlSession();
		Map map = new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("pcode", pcode);

		List li = null;
		List orders = null;
		li = sqlSession.selectList(namespace + ".getOrdersAdmin");

		Iterator it = li.iterator();

		if (it.hasNext()) {

			orders = new ArrayList();

			do {

				OrderDataBean odb = (OrderDataBean) it;

				if (pcode.equals("a")) {

					AuctionDBBean apro = AuctionDBBean.getInstance();
					AuctionDataBean product = apro.getProduct(Integer.parseInt(odb.getPronum().substring(1)), "");
					AhistoryDBBean hpro = AhistoryDBBean.getInstance();
					AhistoryDataBean ahistory = hpro.getHistory(odb.getUserid(), "");

					odb.setAprice(ahistory.getPrice());
					odb.setAproduct(product);

					Date date = new Date();

					SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

					System.out.println(simple.format(date));
					String curtime = simple.format(date);

					odb.setRemainTime(apro.getRemainTime(product, curtime));
					odb.setStartRemain(apro.getStartRemain(product, curtime));

				} else if (pcode.equals("g")) {

					GpurcDBBean gpro = GpurcDBBean.getInstance();
					GpurcDataBean product = gpro.getProduct(Integer.parseInt(odb.getPronum().substring(1)), "");

					odb.setGproduct(product);

					Date date = new Date();

					SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

					System.out.println(simple.format(date));
					String curtime = simple.format(date);

					odb.setRemainTime(gpro.getRemainTime(product, curtime));
					odb.setStartRemain(gpro.getStartRemain(product, curtime));

				}

				orders.add(odb);

			} while (it.hasNext());
		}
		sqlSession.close();
		return orders;

	}

	public List getPayOrders(int startRow, int endRow, String pcode) {
		sqlSession = sqlSession();
		Map map = new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("pcode", pcode);

		List li = null;
		List orders = null;
		li = sqlSession.selectList(namespace + ".getPayOrders");

		Iterator it = li.iterator();

		if (it.hasNext()) {

			orders = new ArrayList();

			do {

				OrderDataBean odb = (OrderDataBean) it;

				if (pcode.equals("a")) {

					AuctionDBBean apro = AuctionDBBean.getInstance();
					AuctionDataBean product = apro.getProduct(Integer.parseInt(odb.getPronum().substring(1)), "");
					AhistoryDBBean hpro = AhistoryDBBean.getInstance();
					AhistoryDataBean ahistory = hpro.getHistory(odb.getUserid(), "");

					odb.setAprice(ahistory.getPrice());
					odb.setAproduct(product);

					Date date = new Date();

					SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

					System.out.println(simple.format(date));
					String curtime = simple.format(date);

					odb.setRemainTime(apro.getRemainTime(product, curtime));
					odb.setStartRemain(apro.getStartRemain(product, curtime));

				} else if (pcode.equals("g")) {

					GpurcDBBean gpro = GpurcDBBean.getInstance();
					GpurcDataBean product = gpro.getProduct(Integer.parseInt(odb.getPronum().substring(1)), "");

					odb.setGproduct(product);

					Date date = new Date();

					SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

					System.out.println(simple.format(date));
					String curtime = simple.format(date);

					odb.setRemainTime(gpro.getRemainTime(product, curtime));
					odb.setStartRemain(gpro.getStartRemain(product, curtime));

				}

				orders.add(odb);

			} while (it.hasNext());
		}
		sqlSession.close();
		return orders;

	}

}
