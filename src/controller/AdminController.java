package controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.msk.Action;

import db.UserlistDBBean;

public class AdminController extends Action{
	public String userlist(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
			req.setAttribute("title", "관리자페이지");
			
	 int pageSize=10;
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	    String pageNum=req.getParameter("pageNum");
	    if(pageNum==null||pageNum==""){
	    	pageNum="1";}
	    
	    int currentPage=Integer.parseInt(pageNum);
	    int startRow=(currentPage -1 )*pageSize+1;
	    int endRow=currentPage*pageSize;
	    int count=0;
	    int number=0;
	    List userList=null;
	    UserlistDBBean userPro=UserlistDBBean.getInstance();
	   count=userPro.getUserCount("1")+userPro.getUserCount("2");
	   int bottomLine=5;
	    if(count>0){
	    	userList=userPro.getUsers(startRow,endRow);
	    number=count-(currentPage-1)*pageSize;
	    
	   

    		int pageCount=count/pageSize+(count%pageSize==0?0:1);
    		int startPage=1+(currentPage-1)/bottomLine*bottomLine;
    		int endPage=startPage+bottomLine-1;
    	
    		if(endPage>pageCount)endPage=pageCount;
    		
    		 
    	    req.setAttribute("count", count);
    	    req.setAttribute("userList", userList);
    	    req.setAttribute("pageNum", pageNum);
    	    req.setAttribute("bottomLine", bottomLine);
    	    req.setAttribute("startPage", startPage);
    	    req.setAttribute("currentPage", currentPage);
    	    req.setAttribute("pageCount", pageCount);
    	    req.setAttribute("endPage", endPage);

	    }
	   

			 return  "/admin/admin_userlist.jsp"; 
			} 
	
	public String gpurchase(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
			req.setAttribute("title", "관리자페이지");
			 return  "/admin/admin_gpurchase.jsp"; 
			} 
	
	public String auction(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
			req.setAttribute("title", "관리자페이지");
			 return  "/admin/admin_auction.jsp"; 
			} 
	
	public String admin_userModify(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
			req.setAttribute("title", "관리자페이지");
			 return  "/admin/admin_userModify.jsp"; 
			} 
	
	public String deleteUserPro(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
			req.setAttribute("title", "관리자페이지");
			 return  "/admin/deleteUserPro.jsp"; 
			} 
	
	public String userModifyPro(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
			req.setAttribute("title", "관리자페이지");
			 return  "/admin/userModifyPro.jsp"; 
			} 
	
	public String board(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
			req.setAttribute("title", "관리자페이지");
			 return  "/admin/admin_board.jsp"; 
			} 
	
	
	
	
}
