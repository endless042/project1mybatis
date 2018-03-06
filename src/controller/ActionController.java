package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.msk.Action;

import db.AhistoryDBBean;
import db.AhistoryDataBean;
import db.AuctionDBBean;
import db.AuctionDataBean;
import db.CartDBBean;
import db.CartDataBean;
import db.GpurcDBBean;
import db.GpurcDataBean;
import db.OrderDBBean;
import db.OrderDataBean;
import db.UserlistDBBean;
import db.UserlistDataBean;

public class ActionController extends Action{
	
	public String main(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
		  
			req.setAttribute("title", "메인");
			 return  "/view/main.jsp"; 
			} 
	
	public String auction(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		req.setAttribute("title", "경매");
		
		
		

	    String state=req.getParameter("state");
	    if(state==null||state==""){
	    	state="2";}
	    
	     int pageSize=6;
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	    String pageNum=req.getParameter("pageNum");
	    if(pageNum==null||pageNum==""){
	    	pageNum="1";}
	    
	    int currentPage=Integer.parseInt(pageNum);
	    int startRow=(currentPage -1 )*pageSize+1;
	    int endRow=currentPage*pageSize;
	    int count=0;
	    int number=0;
	    List productList=null;
	    
	   AuctionDBBean apro=AuctionDBBean.getInstance();
	    count=apro.getAproductCount();
	    
	    if(count>0){
	    	productList=apro.getProducts(startRow,endRow);}
	    
	    number=count-(currentPage-1)*pageSize;
	    
	    int bottomLine=5;
    	
    	
    		int pageCount=count/pageSize+(count%pageSize==0?0:1);
    		int startPage=1+(currentPage-1)/bottomLine*bottomLine;
    		int endPage=startPage+bottomLine-1;
    	
    		if(endPage>pageCount)endPage=pageCount;
    	
    		
    	
    		req.setAttribute("state", state); 	//나중에쓸거
    		req.setAttribute("count", count);
    		req.setAttribute("productList", productList);
    		req.setAttribute("startPage", startPage);
    		req.setAttribute("bottomLine", bottomLine);
    		req.setAttribute("currentPage", currentPage);
    		req.setAttribute("endPage", endPage);
    		req.setAttribute("pageCount", pageCount);
    		req.setAttribute("number", number);
	   
    	
	
		return "/view/auction.jsp";
			} 
	
	public String acontent(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
		req.setAttribute("title", "경매");
		
		String part=req.getParameter("part");
	    String state=req.getParameter("state");
	    if(state==null||state==""){
	    	state="2";}
		
	 
		int num=Integer.parseInt(req.getParameter("num"));
		String pageNum=req.getParameter("pageNum");
		
		if(pageNum==null||pageNum==""){
			pageNum="1";}
		
		
		
		try{
			AuctionDBBean aPro=AuctionDBBean.getInstance();
			AuctionDataBean aproduct=aPro.getProduct(num, "content");
			
			
			System.out.println(aproduct);
		
			Date date = new Date();

			SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

			System.out.println(simple.format(date));
			String curtime=simple.format(date);

			
			int timeCount=aPro.getRemainTime(aproduct, curtime);
			int startRemain=aPro.getStartRemain(aproduct, curtime);
			
			String olddate=aproduct.getSdate();
			String formatSdate=olddate.substring(0, 4)+"년 "+olddate.substring(4,6)+"월 "+olddate.substring(6,8)+"일 "+olddate.substring(8,10)+"시";
			olddate=aproduct.getEdate();
			String formatEdate=olddate.substring(0, 4)+"년 "+olddate.substring(4,6)+"월 "+olddate.substring(6,8)+"일 "+olddate.substring(8,10)+"시";
			
			req.setAttribute("num", num);
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("part", part);
			req.setAttribute("aproduct", aproduct);
			req.setAttribute("timeCount", timeCount);
			req.setAttribute("formatSdate", formatSdate);
			req.setAttribute("formatEdate", formatEdate);
			
			
			int rsecond=timeCount%60;
			int rminutes=timeCount/60%60;
			int rhour=timeCount/3600%24;
			int rday=timeCount/24/60/60;
			
			
			
			req.setAttribute("rsecond", rsecond);
			req.setAttribute("rminutes", rminutes);
			req.setAttribute("rhour", rhour);
			req.setAttribute("rday", rday);
			req.setAttribute("startRemain", startRemain);
			
			AhistoryDBBean hpro=AhistoryDBBean.getInstance();
			List historylist=hpro.getHistoryList(0, 3, num);
			int historycount=hpro.getHistoryCount(num);
			req.setAttribute("historylist", historylist);
			req.setAttribute("historycount", historycount);
		
		}catch(Exception e){e.printStackTrace();}  
		
		
		
		return "/view/aproductview.jsp?select=auction";
	}
	
	public String gcontent_reply(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
		req.setAttribute("title", "경매");
		
	
		
		
		
		return "/view/gproductview.jsp?select=gpurchase&part=reply";
	}
	
	public String auctionSubmit(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
		req.setAttribute("title", "경매");
		
		int num=Integer.parseInt(req.getParameter("num"));
		String pageNum=req.getParameter("pageNum");
		
		if(pageNum==null||pageNum==""){
			pageNum="1";}
		String price=req.getParameter("price");
		AhistoryDBBean hpro=AhistoryDBBean.getInstance();
		AhistoryDataBean ahistory=new AhistoryDataBean();
		
		ahistory.setNum(num);
		ahistory.setPrice(price);
		ahistory.setUserid((String)req.getSession().getAttribute("loginId"));
		
	
		
		hpro.addHistory(ahistory);
		
		System.out.println(ahistory);
		
		AuctionDBBean apro=AuctionDBBean.getInstance();
		AuctionDataBean aproduct=apro.getProduct(num, "");
		
		aproduct.setEprice(price);
		aproduct.setCount(aproduct.getCount()+1);
		
		apro.updateAproduct(aproduct);
		
		OrderDBBean opro=OrderDBBean.getInstance();
		OrderDataBean order=new OrderDataBean();
		
		order.setAprice(price);
		order.setAproduct(aproduct);
		order.setPronum("a"+num);
		order.setUserid((String)req.getSession().getAttribute("loginId"));
		
		opro.addOrder(order);
		
		return "/page/acontent";
	}
	
	public String gpurcSubmit(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
		req.setAttribute("title", "공동구매");
		
		int num=Integer.parseInt(req.getParameter("num"));
		String pageNum=req.getParameter("pageNum");
		
		if(pageNum==null||pageNum==""){
			pageNum="1";}
		
		String quantity=req.getParameter("quantity");
		int selectquantity=Integer.parseInt(quantity);
	 System.out.println(quantity);
	 
	 try {
		OrderDBBean opro=OrderDBBean.getInstance();
		OrderDataBean order=new OrderDataBean();
		
		GpurcDBBean gpro=GpurcDBBean.getInstance();
		GpurcDataBean gproduct=gpro.getProduct(num, "");
		
		int gcount=gproduct.getCount();
		System.out.println(gcount);
		
		gproduct.setCount(gcount+selectquantity); //
		
		System.out.println("gproduct 카운트"+gproduct.getCount());
		
		gpro.updateGproduct(gproduct);
	
		System.out.println(gproduct);
		
		order.setGproduct(gproduct);
		order.setPronum("g"+num);
		order.setUserid((String)req.getSession().getAttribute("loginId"));
		order.setCount(selectquantity);
		
		
		opro.addOrder(order);
	 }catch(Exception e) {e.printStackTrace();}
		return "/page/gcontent";
	}
	
	
	public String gpurchase(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		req.setAttribute("title", "공동구매");
		
		   String state=req.getParameter("state");
		    if(state==null||state==""){
		    	state="2";}
		    
		     int pageSize=6;
		    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		    String pageNum=req.getParameter("pageNum");
		    if(pageNum==null||pageNum==""){
		    	pageNum="1";}
		    
		    int currentPage=Integer.parseInt(pageNum);
		    int startRow=(currentPage -1 )*pageSize+1;
		    int endRow=currentPage*pageSize;
		    int count=0;
		    int number=0;
		   
		    List productList=null;
		  GpurcDBBean gpro=GpurcDBBean.getInstance();
		    count=gpro.getGproductCount();
		    
		    if(count>0){
		    	productList=gpro.getProducts(startRow,endRow);}
		    
		    GpurcDataBean tmp=null;
		    for(int i=0;i<productList.size();i++) {
		    	tmp=(GpurcDataBean) productList.get(i);
		    	Date date = new Date();
				SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");
				String curtime=simple.format(date);
				int timeCount=gpro.getRemainTime(tmp, curtime);
				int rday=timeCount/24/60/60;
		    	
				tmp.setEdate(rday+"");
		    	
		    }
		    
		    number=count-(currentPage-1)*pageSize;
		    
		    int bottomLine=5;
	    	
	    	
	    		int pageCount=count/pageSize+(count%pageSize==0?0:1);
	    		int startPage=1+(currentPage-1)/bottomLine*bottomLine;
	    		int endPage=startPage+bottomLine-1;
	    	
	    		if(endPage>pageCount)endPage=pageCount;
	    	
	    		
	    		req.setAttribute("state", state); 	//나중에쓸거
	    		req.setAttribute("count", count);
	    		req.setAttribute("productList", productList);
	    		req.setAttribute("startPage", startPage);
	    		req.setAttribute("bottomLine", bottomLine);
	    		req.setAttribute("currentPage", currentPage);
	    		req.setAttribute("endPage", endPage);
	    		req.setAttribute("pageCount", pageCount);
	    		req.setAttribute("number", number);
		   
	    		return "/view/gpurchase.jsp?select=gpurchase";
			} 
	
	public String gcontent(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
		req.setAttribute("title", "공동구매");
		
		String part=req.getParameter("part");
	    String state=req.getParameter("state");
	    if(state==null||state==""){
	    	state="2";}
		
	 
		int num=Integer.parseInt(req.getParameter("num"));
		String pageNum=req.getParameter("pageNum");
		
		if(pageNum==null||pageNum==""){
			pageNum="1";}
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		try{
			GpurcDBBean gPro=GpurcDBBean.getInstance();
			GpurcDataBean gproduct=gPro.getProduct(num, "content");
			
			
			System.out.println(gproduct);
		
			Date date = new Date();

			SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

			
			String curtime=simple.format(date);

			
			int timeCount=gPro.getRemainTime(gproduct, curtime);

			String olddate=gproduct.getSdate();
			String formatSdate=olddate.substring(0, 4)+"년 "+olddate.substring(4,6)+"월 "+olddate.substring(6,8)+"일 "+olddate.substring(8,10)+"시";
			olddate=gproduct.getEdate();
			String formatEdate=olddate.substring(0, 4)+"년 "+olddate.substring(4,6)+"월 "+olddate.substring(6,8)+"일 "+olddate.substring(8,10)+"시";
			
			req.setAttribute("num", num);
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("part", part);
			
			req.setAttribute("gproduct", gproduct);
			req.setAttribute("timeCount", timeCount);
			req.setAttribute("formatSdate", formatSdate);
			req.setAttribute("formatEdate", formatEdate);
			
			int rsecond=timeCount%60;
			int rminutes=timeCount/60%60;
			int rhour=timeCount/3600%24;
			int rday=timeCount/24/60/60;
			
			
			req.setAttribute("rsecond", rsecond);
			req.setAttribute("rminutes", rminutes);
			req.setAttribute("rhour", rhour);
			req.setAttribute("rday", rday);
			
			
			 }catch(Exception e){e.printStackTrace();}  
		
		
		
		return "/view/gproductview.jsp?select=gpurchase";
	}
	

	
	public String survey(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		req.setAttribute("title", "수입제안");
		return "/view/survey.jsp";
			} 

	public String contact(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
			req.setAttribute("title", "ABOUT US");
			 return  "/view/contact.jsp"; 
			} 
	
	
	
	
	public String mypage(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		req.setAttribute("title", "마이페이지");	
		
		 try{
				UserlistDBBean userPro=UserlistDBBean.getInstance();
				UserlistDataBean user=userPro.getUser((String)req.getSession().getAttribute("loginId")); 
				
				req.setAttribute("user", user);
			
		 }catch(Exception e){}
		
		
		return  "/mypage/mypage.jsp?select=myinfo"; 
			} 
	

	
	public String myarticle(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		req.setAttribute("title", "마이페이지");	
		
		 try{
				UserlistDBBean userPro=UserlistDBBean.getInstance();
				UserlistDataBean user=userPro.getUser((String)req.getSession().getAttribute("loginId")); 
				
				req.setAttribute("user", user);
			
		 }catch(Exception e){}
		
		
		return  "/mypage/mypage_article.jsp?select=articles"; 
			} 
	
	public String addCart(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		req.setAttribute("title", "마이페이지");	
		
		String userid=(String)req.getSession().getAttribute("loginId");
		String pronum=req.getParameter("num");
		int pnum=Integer.parseInt(pronum);
		String pcode=req.getParameter("pcode");
		
		
		AuctionDBBean apro=AuctionDBBean.getInstance();
		GpurcDBBean gpro=GpurcDBBean.getInstance();
	
		
		CartDataBean cart=new CartDataBean();
		
		cart.setUserid(userid);
		cart.setPronum(pcode+pronum);
		
		if(pcode.equals("g")) {
		cart.setGproduct(gpro.getProduct(pnum, ""));}
		else if(pcode.equals("a")) {
			cart.setAproduct(apro.getProduct(pnum, ""));
		}
		
		CartDBBean cpro=CartDBBean.getInstance();
		
		
		cpro.addCart(cart);
		
		System.out.println(cart);
		
		
		return  "/page/cartlist"; 
			} 
	
	public String cartlist(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		
			req.setAttribute("title", "마이페이지");
		
		     int pageSize=4;
		  
		    String apageNum=req.getParameter("apageNum");
		    if(apageNum==null||apageNum==""){
		    	apageNum="1";}
		    String gpageNum=req.getParameter("gpageNum");
		    if(gpageNum==null||gpageNum==""){
		    	gpageNum="1";}
		    
		    String userid=(String)req.getSession().getAttribute("loginId");
		    
		    int acurrentPage=Integer.parseInt(apageNum);
		    int gcurrentPage=Integer.parseInt(gpageNum);
		    int astartRow=(acurrentPage -1 )*pageSize+1;
		    int aendRow=acurrentPage*pageSize;
		    int gstartRow=(gcurrentPage -1 )*pageSize+1;
		    int gendRow=gcurrentPage*pageSize;
		    
		    int acount=0;
		    int gcount=0;
		    
		    int anumber=0;
		    int gnumber=0;
		    
		    List aList=null;
		    List gList=null;
		    
		    CartDBBean cPro=CartDBBean.getInstance();
		    acount=cPro.getCartCount("a",userid);
		    
		   // System.out.println("acount:"+acount);
		    
		    gcount=cPro.getCartCount("g",userid);
		    
		    int bottomLine=5;
		    try {
		    if(acount>0){
		    	aList=cPro.getCarts(astartRow,aendRow,"a", userid);}
		    
		    anumber=acount-(acurrentPage-1)*pageSize;

	    		int apageCount=acount/pageSize+(acount%pageSize==0?0:1);
	    		int astartPage=1+(acurrentPage-1)/bottomLine*bottomLine;
	    		int aendPage=astartPage+bottomLine-1;
	    	
	    		if(aendPage>apageCount)aendPage=apageCount;
	    		
	    		
	    		
	    		if(gcount>0){
			    	gList=cPro.getCarts(gstartRow,gendRow,"g", userid);}
			    
			    gnumber=gcount-(gcurrentPage-1)*pageSize;

		    		int gpageCount=gcount/pageSize+(gcount%pageSize==0?0:1);
		    		int gstartPage=1+(gcurrentPage-1)/bottomLine*bottomLine;
		    		int gendPage=gstartPage+bottomLine-1;
		    	
		    		if(gendPage>gpageCount)gendPage=gpageCount;
	    	
		  
	    	
	    		req.setAttribute("acount", acount);
	    		req.setAttribute("gcount", gcount);
	    		
	    		req.setAttribute("aList", aList);
	    		req.setAttribute("gList", gList);
	    		
	    		req.setAttribute("astartPage", astartPage);
	    		req.setAttribute("bottomLine", bottomLine);
	    		req.setAttribute("acurrentPage", acurrentPage);
	    		req.setAttribute("aendPage", aendPage);
	    		req.setAttribute("apageCount", apageCount);
	    		req.setAttribute("anumber", anumber);
	    		req.setAttribute("apageNum", apageNum);
	    		req.setAttribute("gpageNum", gpageNum);
	    		
	    		req.setAttribute("gstartPage", gstartPage);
	    		req.setAttribute("userid", userid);
	    		req.setAttribute("gcurrentPage", gcurrentPage);
	    		req.setAttribute("gendPage", gendPage);
	    		req.setAttribute("gpageCount", gpageCount);
	    		req.setAttribute("gnumber", gnumber);
		   
		    }catch(Exception e) {
		    	e.printStackTrace();
		    }
		
		return "/mypage/mypage_cart.jsp?select=cart";
			
	    	} 
	
	public String orderlist(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		
			req.setAttribute("title", "마이페이지");
		
		     int pageSize=4;
		  
		    String apageNum=req.getParameter("apageNum");
		    if(apageNum==null||apageNum==""){
		    	apageNum="1";}
		    String gpageNum=req.getParameter("gpageNum");
		    if(gpageNum==null||gpageNum==""){
		    	gpageNum="1";}
		    
		    String userid=(String)req.getSession().getAttribute("loginId");
		    
		    int acurrentPage=Integer.parseInt(apageNum);
		    int gcurrentPage=Integer.parseInt(gpageNum);
		    int astartRow=(acurrentPage -1 )*pageSize+1;
		    int aendRow=acurrentPage*pageSize;
		    int gstartRow=(gcurrentPage -1 )*pageSize+1;
		    int gendRow=gcurrentPage*pageSize;
		    
		    int acount=0;
		    int gcount=0;
		    
		    int anumber=0;
		    int gnumber=0;
		    
		    List aList=null;
		    List gList=null;
		    
		    OrderDBBean oPro=OrderDBBean.getInstance();
		    acount=oPro.getOrderCount("a",userid);
		    
		   // System.out.println("acount:"+acount);
		    
		    gcount=oPro.getOrderCount("g",userid);
		    
		    int bottomLine=5;
		    try {
		    if(acount>0){
		    	aList=oPro.getOrders(astartRow,aendRow,"a", userid);}
		    
		    anumber=acount-(acurrentPage-1)*pageSize;

	    		int apageCount=acount/pageSize+(acount%pageSize==0?0:1);
	    		int astartPage=1+(acurrentPage-1)/bottomLine*bottomLine;
	    		int aendPage=astartPage+bottomLine-1;
	    	
	    		if(aendPage>apageCount)aendPage=apageCount;
	    		
	    		
	    		
	    		if(gcount>0){
			    	gList=oPro.getOrders(gstartRow,gendRow,"g", userid);}
			    
			    gnumber=gcount-(gcurrentPage-1)*pageSize;

		    		int gpageCount=gcount/pageSize+(gcount%pageSize==0?0:1);
		    		int gstartPage=1+(gcurrentPage-1)/bottomLine*bottomLine;
		    		int gendPage=gstartPage+bottomLine-1;
		    	
		    		if(gendPage>gpageCount)gendPage=gpageCount;
	    	
		  
	    	
	    		req.setAttribute("acount", acount);
	    		req.setAttribute("gcount", gcount);
	    		
	    		req.setAttribute("aList", aList);
	    		req.setAttribute("gList", gList);
	    		
	    		req.setAttribute("astartPage", astartPage);
	    		req.setAttribute("bottomLine", bottomLine);
	    		req.setAttribute("acurrentPage", acurrentPage);
	    		req.setAttribute("aendPage", aendPage);
	    		req.setAttribute("apageCount", apageCount);
	    		req.setAttribute("anumber", anumber);
	    		req.setAttribute("apageNum", apageNum);
	    		req.setAttribute("gpageNum", gpageNum);
	    		
	    		req.setAttribute("gstartPage", gstartPage);
	    		req.setAttribute("userid", userid);
	    		req.setAttribute("gcurrentPage", gcurrentPage);
	    		req.setAttribute("gendPage", gendPage);
	    		req.setAttribute("gpageCount", gpageCount);
	    		req.setAttribute("gnumber", gnumber);
		   
		    }catch(Exception e) {
		    	e.printStackTrace();
		    }
		
		return "/mypage/mypage_order.jsp?select=order";
			
	    	} 
	
	public String payPage(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		req.setAttribute("title", "결제");
		
		return  "/mypage/mypage_pay.jsp?select=order"; 
			} 
	
}
