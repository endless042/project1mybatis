package gpurc;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import util.MybatisConnector;



public class GpurcDBBean extends MybatisConnector{
private static GpurcDBBean gpurchase=new GpurcDBBean();
private final String namespace = "gpurc";
private static GpurcDBBean instance = new GpurcDBBean();
private GpurcDBBean() {}
public static GpurcDBBean getInstance() {
	return instance;
}

SqlSession sqlSession;

	public void addGproduct(GpurcDataBean gproduct) {
		sqlSession = sqlSession();
		
		int number=0;
		number=sqlSession.selectOne(namespace+".getNextNumber");
		
		gproduct.setNum(number);
		sqlSession.insert(namespace+".addGproduct",gproduct);
		sqlSession.commit();
	
	sqlSession.close();
	
	}
	
	public int getRemainTime (GpurcDataBean gproduct, String curtime){
		sqlSession=sqlSession();
		
		Map map=new HashMap();
		map.put("edate", gproduct.getEdate());
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


	public int getStartRemain (GpurcDataBean gproduct, String curtime){
		sqlSession=sqlSession();
		
		Map map=new HashMap();
		map.put("sdate", gproduct.getSdate());
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
	

public void stateManage(List<GpurcDataBean> products) {
	GpurcDBBean gpro=GpurcDBBean.getInstance();	
	GpurcDataBean product=new GpurcDataBean();
	Date date = new Date();

	SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

	
	String curtime=simple.format(date);
	int timeCount;
	int startRemain;
	for(int i=0;i<products.size();i++) {
		
		product=(GpurcDataBean)products.get(i);
		timeCount=gpro.getRemainTime(product, curtime);
		startRemain=gpro.getStartRemain(product, curtime);	
		if(startRemain==1) {
			product.setState("1");
		}else if(timeCount==0) {
			product.setState("3");
		}else if(timeCount>0) {
			product.setState("2");
		}
		
		gpro.updateGproduct(product);
		
			
		}
	
		
	}

public int getGproductCount (String stateSelect){
	sqlSession=sqlSession();
	Map map=new HashMap();
	
	map.put("stateSelect", stateSelect);
	
	int x=0;
	if(stateSelect.equals("all")||stateSelect.equals("top")) {
		x=sqlSession.selectOne(namespace+".getGgproductCountAll");}
	else {
		x=sqlSession.selectOne(namespace+".getGgproductCount",map);
	
	}

	sqlSession.close();
	return x;
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

public GpurcDataBean getProduct(int num,  String chk) {
	
	sqlSession=sqlSession();
	
	Map map=new HashMap();
	map.put("num", num);

		if(chk.equals("content")) {
		 sqlSession.update(namespace+".updateReadcount",map);
		sqlSession.commit();}

		GpurcDataBean gproduct=sqlSession.selectOne(namespace+".getProduct",map);
		sqlSession.close();
	return gproduct;

}


public int updateGproduct(GpurcDataBean gproduct) {
	
	sqlSession = sqlSession();
	int chk=0;
	
	chk=sqlSession.update(namespace+".updateGproduct",gproduct);
	sqlSession.commit();
	
	sqlSession.close();
		
	return chk;
}

}
