package auction;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import util.MybatisConnector;

public class AuctionDBBean extends MybatisConnector{
	private final String namespace = "auction";
	private static AuctionDBBean instance = new AuctionDBBean();
	private AuctionDBBean() {}
	
	public static AuctionDBBean getInstance() {
		return instance;
	}
	
	SqlSession sqlSession;
	
	
	
	public void addAproduct(AuctionDataBean aproduct) {
		sqlSession=sqlSession();
		
		
	
		int number=sqlSession.selectOne(namespace+".getNextNumber");
		
		aproduct.setNum(number);
		aproduct.setEprice(aproduct.getSprice());
		
		System.out.println(aproduct);
		sqlSession.insert(namespace+".addAproduct",aproduct);
		
		sqlSession.commit();
		sqlSession.close();

	
	}
	

public int getAproductCount (String stateSelect){
	sqlSession=sqlSession();
	Map map=new HashMap();
	
	map.put("stateSelect", stateSelect);
	
	int x=0;
	if(stateSelect.equals("all")||stateSelect.equals("top")) {
		x=sqlSession.selectOne(namespace+".getAproductCountAll");}
	else {
		x=sqlSession.selectOne(namespace+".getAproductCount",map);
	
	}

	sqlSession.close();
	return x;
}


public int getRemainTime (AuctionDataBean aproduct, String curtime){
	sqlSession=sqlSession();
	
	Map map=new HashMap();
	map.put("edate", aproduct.getEdate());
	map.put("curtime", curtime);
	
	int x=0;
	
	x=sqlSession.selectOne(namespace+".getRemainTime",map);
	
	sqlSession.close();
	
	if(x>0) {
	return x;
	}else {
		return 0;
	}
}


public int getStartRemain (AuctionDataBean aproduct, String curtime){
	sqlSession=sqlSession();
	
	Map map=new HashMap();
	map.put("sdate", aproduct.getSdate());
	map.put("curtime", curtime);
	
	int x=0;
	
	x=sqlSession.selectOne(namespace+".getStartRemain",map);
	sqlSession.close();
	if(x>0) {
	return 1;		
	}else {
		return 0;	
	}
}


public void stateManage(List<AuctionDataBean> products) {
	AuctionDBBean apro=AuctionDBBean.getInstance();	
	AuctionDataBean product=new AuctionDataBean();
	Date date = new Date();

	SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

	
	String curtime=simple.format(date);
	int timeCount;
	int startRemain;
	for(int i=0;i<products.size();i++) {
		
		product=(AuctionDataBean)products.get(i);
		timeCount=apro.getRemainTime(product, curtime);
		startRemain=apro.getStartRemain(product, curtime);	
		if(startRemain==1) {
			product.setState("1");
		}else if(timeCount==0) {
			product.setState("3");
		}else if(timeCount>0) {
			product.setState("2");
		}
		
		apro.updateAproduct(product);
		
			
		}
	
		
	}

public List getProducts(int startRow, int endRow, String stateSelect) {
		sqlSession=sqlSession();
		Map map=new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("stateSelect", stateSelect);
		
		List li=null;

			if(stateSelect.equals("all")) {
			li=sqlSession.selectList(namespace+".getProductsAll",map);
			}else if(stateSelect.equals("top")) {
				li=sqlSession.selectList(namespace+".getProductsTop",map);
				
			}else  {
				li= sqlSession.selectList(namespace+".getProducts",map);
			}
			sqlSession.close();
		return li;
		
	}


public List getTopProducts(int startRow, int endRow) {
		
	sqlSession=sqlSession();
	Map map=new HashMap();
	map.put("startRow", startRow);
	map.put("endRow", endRow);
	
	
	List li=null;
	li=sqlSession.selectList(namespace+".getProductsTop",map);
	sqlSession.close();
		return li;
		
	}

public AuctionDataBean getProduct(int num,  String chk) {
	
	sqlSession=sqlSession();
	
	Map map=new HashMap();
	map.put("num", num);

		if(chk.equals("content")) {
		 sqlSession.update(namespace+".updateReadcount",map);
		sqlSession.commit();}

		AuctionDataBean aproduct=sqlSession.selectOne(namespace+".getProduct",map);
		sqlSession.close();
	return aproduct;

}


public int updateAproduct(AuctionDataBean aproduct) {
	
	sqlSession=sqlSession();
	
	
	int chk=0;
	
	
	
	if(Integer.parseInt(aproduct.getSprice())>Integer.parseInt(aproduct.getEprice())) {
		chk=sqlSession.update(namespace+".updateAproduct1",aproduct);
	}else {
	
	chk=sqlSession.update(namespace+".updateAproduct",aproduct);
	}
		
	sqlSession.commit();
	sqlSession.close();
		
	return chk;
}
	
	
}
