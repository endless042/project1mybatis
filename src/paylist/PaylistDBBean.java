package paylist;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import auction.AuctionDBBean;
import auction.AuctionDataBean;
import gpurc.GpurcDBBean;
import gpurc.GpurcDataBean;
import util.MybatisConnector;

public class PaylistDBBean extends MybatisConnector{
	private final String namespace = "paylist";
	private static PaylistDBBean instance = new PaylistDBBean();
	private PaylistDBBean() {}
	public static PaylistDBBean getInstance() {
		return instance;
	}
	
	SqlSession sqlSession;
	
	public void addPay(PaylistDataBean pay) {
		sqlSession =sqlSession();
		
		
		int number=0;
		number=sqlSession.selectOne(namespace+".getNextNumber");
	
	pay.setNum(number);
	sqlSession.insert(namespace+".addPay",pay);
		sqlSession.commit();
		
		sqlSession.close();
	}
	

public int getPayCountUser (String pcode, String userid){
	sqlSession=sqlSession();
	Map map=new HashMap();
	map.put("pcode", pcode);
	map.put("userid", userid);
	
	int x=0;
	x=sqlSession.selectOne(namespace+".getPayCountUser",map);
	sqlSession.close();
	return x;
}

public int getPayCountAdmin (String pcode){
	sqlSession=sqlSession();
	Map map=new HashMap();
	map.put("pcode", pcode);
	int x=0;
	x=sqlSession.selectOne(namespace+".getPayCountAdmin",map);
	sqlSession.close();
	return x;
}

public List getPaylistUser(int startRow, int endRow, String pcode, String userid) {
	sqlSession=sqlSession();
	Map map=new HashMap();
	map.put("startRow", startRow);
	map.put("endRow", endRow);
	map.put("pcode", pcode);
	map.put("userid", userid);
	
List li=null;
List paylist=null;
li=sqlSession.selectList(namespace+".getPaylistUser",map);

Iterator it=li.iterator();

if(it.hasNext()) {
	paylist=new ArrayList();
	do {
		
		PaylistDataBean pay=(PaylistDataBean)it.next();
	
	
	if(pcode.equals("a")) {
		AuctionDBBean apro=AuctionDBBean.getInstance();
		AuctionDataBean atmp=apro.getProduct(Integer.parseInt(pay.getPronum().substring(1)), "");
		
		pay.setAproduct(atmp);
	}else if(pcode.equals("g")) {
		GpurcDBBean gpro=GpurcDBBean.getInstance();
		GpurcDataBean gtmp=gpro.getProduct(Integer.parseInt(pay.getPronum().substring(1)), "");
		pay.setGproduct(gtmp);	
	}
	
				
				paylist.add(pay);
			
			}while(it.hasNext());
		}
	sqlSession.close();
return paylist;

	}



public List getPaylistAdmin(int startRow, int endRow, String pcode) {
	sqlSession=sqlSession();
	Map map=new HashMap();
	map.put("startRow", startRow);
	map.put("endRow", endRow);
	map.put("pcode", pcode);

	
List li=null;
List paylist=null;
li=sqlSession.selectList(namespace+".getPaylistAdmin",map);

Iterator it=li.iterator();
if(it.hasNext()) {
	paylist=new ArrayList();
	do {
		
		PaylistDataBean pay=(PaylistDataBean)it.next();

		if(pcode.equals("a")) {
			AuctionDBBean apro=AuctionDBBean.getInstance();
			AuctionDataBean atmp=apro.getProduct(Integer.parseInt(pay.getPronum().substring(1)), "");
			
			pay.setAproduct(atmp);
		}else if(pcode.equals("g")) {
			GpurcDBBean gpro=GpurcDBBean.getInstance();
			GpurcDataBean gtmp=gpro.getProduct(Integer.parseInt(pay.getPronum().substring(1)), "");
			pay.setGproduct(gtmp);	
		}
		
					
					paylist.add(pay);
				
				}while(it.hasNext());
			}
		sqlSession.close();
	return paylist;
	}


public PaylistDataBean getPay(int num) {
	sqlSession=sqlSession();
	Map map=new HashMap();
	map.put("num", num);
	
	PaylistDataBean pay=sqlSession.selectOne(namespace+".getPay",map);
	

			if(pay.getPronum().substring(1).equals("a")) {
				AuctionDBBean apro=AuctionDBBean.getInstance();
				AuctionDataBean aproduct=apro.getProduct(Integer.parseInt(pay.getPronum().substring(1)), "");
			
				pay.setAproduct(aproduct);
			}
			if(pay.getPronum().substring(1).equals("g")) {
				GpurcDBBean gpro=GpurcDBBean.getInstance();
				GpurcDataBean gproduct=
						gpro.getProduct(Integer.parseInt(pay.getPronum().substring(1)), "");
			
				pay.setGproduct(gproduct);
			}

	return pay;

}

public int deletePay(int num) throws Exception {
	sqlSession=sqlSession();
	int x=-1;
	Map map=new HashMap();
	map.put("num", num);
	x=sqlSession.delete(namespace+".deletePay",map);
	
	return x;
	
	
}


	
}
