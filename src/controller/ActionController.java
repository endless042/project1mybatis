package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.msk.Action;

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
		return "/view/auction.jsp";
			} 
	
	public String gpurchase(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		req.setAttribute("title", "공동구매");
		return "/view/gpurchase.jsp";
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
	public String aproductview(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		req.setAttribute("title", "경매");	 
		return  "/view/aproductview.jsp"; 
			} 
	
	public String gproductview(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		req.setAttribute("title", "공동구매");	
		return  "/view/gproductview.jsp"; 
			} 
	
	
	public String cart(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		req.setAttribute("title", "마이페이지");	
		
		 try{
				UserlistDBBean userPro=UserlistDBBean.getInstance();
				UserlistDataBean user=userPro.getUser((String)req.getSession().getAttribute("loginId")); 
				
				req.setAttribute("user", user);
			
		 }catch(Exception e){}
		
		
		return  "/mypage/mypage_cart.jsp?select=cart"; 
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
	
	public String order(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		req.setAttribute("title", "마이페이지");	
		
		 try{
				UserlistDBBean userPro=UserlistDBBean.getInstance();
				UserlistDataBean user=userPro.getUser((String)req.getSession().getAttribute("loginId")); 
				
				req.setAttribute("user", user);
			
		 }catch(Exception e){}
		
		
		return  "/mypage/mypage_order.jsp?select=order"; 
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
	
}
