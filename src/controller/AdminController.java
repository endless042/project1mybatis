package controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.msk.Action;

import db.AuctionDBBean;
import db.AuctionDataBean;
import db.GpurcDBBean;
import db.GpurcDataBean;
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
	
	public String addAproductPro(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
			req.setAttribute("title", "관리자페이지");
			
			AuctionDBBean apro=AuctionDBBean.getInstance();
			AuctionDataBean aproduct=new AuctionDataBean();
			
			String sdatestr=req.getParameter("sdate")+"-"+req.getParameter("sdatetime");
			String edatestr=req.getParameter("edate")+"-"+req.getParameter("edatetime");
			
			aproduct.setName(req.getParameter("name"));
			aproduct.setOrigin(req.getParameter("origin"));
			aproduct.setCategory(req.getParameter("category"));
			aproduct.setHeight(req.getParameter("height"));
			aproduct.setSdate(sdatestr);
			aproduct.setEdate(edatestr);
			aproduct.setSprice(req.getParameter("sprice"));
			aproduct.setDeliv(req.getParameter("deliv"));
			aproduct.setState(req.getParameter("state"));
			aproduct.setTitle(req.getParameter("title"));
			aproduct.setContent(req.getParameter("content"));
			
			if(req.getParameter("imgs")!=null) {
				
				String[] allimg=req.getParameterValues("imgs");
				String allpath="";
				for(int i=0;i<allimg.length;i++) {
					allpath+=allimg[i]+",";
				}
				
				aproduct.setImgs(allpath);
			}
			
			apro.addAproduct(aproduct);
			
			System.out.println(aproduct);
			
			return  "/admin/admin_addComp.jsp"; 
			} 
	
	public String addGproductPro(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
			req.setAttribute("title", "관리자페이지");
			
			GpurcDBBean gpro=GpurcDBBean.getInstance();
			GpurcDataBean gproduct=new GpurcDataBean();
			
			String sdatestr=req.getParameter("sdate")+"-"+req.getParameter("sdatetime");
			String edatestr=req.getParameter("edate")+"-"+req.getParameter("edatetime");
			
		
			gproduct.setName(req.getParameter("name"));
			gproduct.setOrigin(req.getParameter("origin"));
			gproduct.setCategory(req.getParameter("category"));
			gproduct.setHeight(req.getParameter("height"));
			gproduct.setSdate(sdatestr);
			gproduct.setEdate(edatestr);
			gproduct.setPrice(req.getParameter("price"));
			gproduct.setDeliv(req.getParameter("deliv"));
			gproduct.setState(req.getParameter("state"));
			gproduct.setTitle(req.getParameter("title"));
			gproduct.setContent(req.getParameter("content"));
			gproduct.setGoal(Integer.parseInt(req.getParameter("goal")));
			gproduct.setProcess(req.getParameter("process"));
			
			if(req.getParameter("imgs")!=null) {
				
				String[] allimg=req.getParameterValues("imgs");
				String allpath="";
				for(int i=0;i<allimg.length;i++) {
					allpath+=allimg[i]+",";
				}
				
				gproduct.setImgs(allpath);
			}
			
			gpro.addGproduct(gproduct);
			
			System.out.println(gproduct);
			
			return  "/admin/admin_addComp.jsp"; 
			} 
	
	
	
}
