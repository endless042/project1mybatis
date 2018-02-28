package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.msk.Action;

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
	
	public String notice(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		req.setAttribute("title", "공지");
		return "/view/board/list.jsp";
			} 
	
	public String survey(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		req.setAttribute("title", "수입제안");
		return "/view/survey.jsp";
			} 
	
	
	
}
