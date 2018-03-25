package cart;

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

public class CartDBBean extends MybatisConnector{
 private static CartDBBean cart=new CartDBBean();
	private final String namespace = "cart";
	private static CartDBBean instance = new CartDBBean();
	private CartDBBean() {}
	public static CartDBBean getInstance() {
		return instance;
	}
	
	SqlSession sqlSession;
	
	
public void addCart(CartDataBean cart) {
		sqlSession=sqlSession();
		
		sqlSession.insert(namespace+".addCart",cart);
		sqlSession.commit();
		sqlSession.close();

	}


public int getCartCount (String pcode, String userid){
	sqlSession=sqlSession();
	Map map=new HashMap();
	map.put("pcode", pcode);
	map.put("userid", userid);
	
	int x=0;
	x=sqlSession.selectOne(namespace+".getCartCount",map);

	return x;
}

public List getCarts(int startRow, int endRow, String pcode, String userid) {
		sqlSession=sqlSession();
		Map map=new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("pcode", pcode);
		map.put("userid", userid);
		
		List li=null;
		li=sqlSession.selectList(namespace+".getCarts",map);
		List carts=null;
	Iterator it=li.iterator();
	
	
if(it.hasNext()) {
	carts=new ArrayList();
	
	do {
		CartDataBean cit=(CartDataBean)it.next();
		
		ShowCart cartrs=new ShowCart();
		
		if(pcode.equals("a")) {
		AuctionDBBean apro=AuctionDBBean.getInstance();
		AuctionDataBean product=apro.getProduct(Integer.parseInt(cit.getPronum().substring(1)), "");
		
		cartrs.setRdate(cit.getRdate());
		cartrs.setState(product.getState());
		cartrs.setTitle(product.getTitle());
		cartrs.setImgs(product.getImgs());
		cartrs.setAproduct(product);
		
		}else if(pcode.equals("g")) {
			GpurcDBBean gpro=GpurcDBBean.getInstance();
			GpurcDataBean product=gpro.getProduct(Integer.parseInt(cit.getPronum().substring(1)), "");
		
			cartrs.setRdate(cit.getRdate());
			cartrs.setState(product.getState());
			cartrs.setTitle(product.getTitle());
			cartrs.setImgs(product.getImgs());
			cartrs.setGproduct(product);
		}
		
			
				
				carts.add(cartrs);
			
			}while(it.hasNext());
	
		
		
	}

return carts;
	
}}
