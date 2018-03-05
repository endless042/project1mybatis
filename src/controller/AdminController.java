package controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
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
			
			
		     
		     String realFolder = ""; // 웹 어플리케이션상의 절대 경로
				String encType = "utf-8"; // 엔코딩 타입
				int maxSize = 5 * 1024 * 1024; // 최대 업로드될 파일크기 5MB
				ServletContext context = req.getServletContext();
				realFolder = context.getRealPath("fileSave");
				MultipartRequest multi = null;
				multi = new MultipartRequest(req, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
				Enumeration files = multi.getFileNames();
			
				String filename = "";
				File file = null;
				int filelength=0;
				/*파일이 여러개면 while*/ 
				if(files.hasMoreElements()) {
					String name=(String)files.nextElement();
					filename=multi.getFilesystemName(name)+" ";		/* DefaultFileRenamePolicy가 적용된 이름	*/
					String original=multi.getOriginalFileName(name);   /* 파일의 원래 이름을 알 수 있음 */
					String type=multi.getContentType(name);			 	/* 파일의 타입을 알 수 있음 */	
					file=multi.getFile(name);
					
				}
			
			
			AuctionDBBean apro=AuctionDBBean.getInstance();
			AuctionDataBean aproduct=new AuctionDataBean();
			
			String sdatetime=multi.getParameter("sdatetime");
			if(sdatetime.length()<2) {
				sdatetime="0"+sdatetime;
			}
			String edatetime=multi.getParameter("edatetime");
			if(edatetime.length()<2) {
				edatetime="0"+edatetime;
			}
			
			
			String sdatestr=multi.getParameter("sdate").replace("-", "")+sdatetime+"0000";
			String edatestr=multi.getParameter("edate").replace("-", "")+edatetime+"0000";
			
			
			aproduct.setName(multi.getParameter("name"));
			aproduct.setOrigin(multi.getParameter("origin"));
			aproduct.setCategory(multi.getParameter("category"));
			aproduct.setHeight(multi.getParameter("height"));
			aproduct.setSdate(sdatestr);
			aproduct.setEdate(edatestr);
			aproduct.setSprice(multi.getParameter("sprice"));
			aproduct.setDeliv(multi.getParameter("deliv"));
			aproduct.setState(multi.getParameter("state"));
			aproduct.setTitle(multi.getParameter("title"));
			aproduct.setContent(multi.getParameter("content"));
			
			  if(file!=null) {
				  aproduct.setImgs(filename);
				  aproduct.setImgsize((int)file.length());
			     }else {
			    	 aproduct.setImgs(" ");
			    	 aproduct.setImgsize(0);
			     }
			
			/*if(multi.getParameter("imgs")!=null) {
				
				String[] allimg=req.getParameterValues("imgs");
				String allpath="";
				for(int i=0;i<allimg.length;i++) {
					allpath+=allimg[i]+",";
				}
				
				aproduct.setImgs(allpath);
			}*/
			
			apro.addAproduct(aproduct);
			
			System.out.println(aproduct);
			
			return  "/admin/admin_addComp.jsp?select=aauction"; 
			} 
	
	public String addGproductPro(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
			req.setAttribute("title", "관리자페이지");
			
			 
		     String realFolder = ""; // 웹 어플리케이션상의 절대 경로
				String encType = "utf-8"; // 엔코딩 타입
				int maxSize = 5 * 1024 * 1024; // 최대 업로드될 파일크기 5MB
				ServletContext context = req.getServletContext();
				realFolder = context.getRealPath("fileSave");
				MultipartRequest multi = null;
				multi = new MultipartRequest(req, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
				Enumeration files = multi.getFileNames();
			
				String filename = "";
				File file = null;
				int filelength=0;
				/*파일이 여러개면 while*/ 
				if(files.hasMoreElements()) {
					String name=(String)files.nextElement();
					filename=multi.getFilesystemName(name)+" ";		/* DefaultFileRenamePolicy가 적용된 이름	*/
					String original=multi.getOriginalFileName(name);   /* 파일의 원래 이름을 알 수 있음 */
					String type=multi.getContentType(name);			 	/* 파일의 타입을 알 수 있음 */	
					file=multi.getFile(name);
					
				}
			
			GpurcDBBean gpro=GpurcDBBean.getInstance();
			GpurcDataBean gproduct=new GpurcDataBean();
			
			String sdatestr=multi.getParameter("sdate")+"-"+multi.getParameter("sdatetime");
			String edatestr=multi.getParameter("edate")+"-"+multi.getParameter("edatetime");
			
		
			gproduct.setName(multi.getParameter("name"));
			gproduct.setOrigin(multi.getParameter("origin"));
			gproduct.setCategory(multi.getParameter("category"));
			gproduct.setHeight(multi.getParameter("height"));
			gproduct.setSdate(sdatestr);
			gproduct.setEdate(edatestr);
			gproduct.setPrice(multi.getParameter("price"));
			gproduct.setDeliv(multi.getParameter("deliv"));
			gproduct.setState(multi.getParameter("state"));
			gproduct.setTitle(multi.getParameter("title"));
			gproduct.setContent(multi.getParameter("content"));
			gproduct.setGoal(Integer.parseInt(multi.getParameter("goal")));
			gproduct.setProcess(multi.getParameter("process"));
			

			  if(file!=null) {
				  gproduct.setImgs(filename);
				  gproduct.setImgsize((int)file.length());
			     }else {
			    	 gproduct.setImgs(" ");
			    	 gproduct.setImgsize(0);
			     }
			
		/*	if(req.getParameter("imgs")!=null) {
				
				String[] allimg=req.getParameterValues("imgs");
				String allpath="";
				for(int i=0;i<allimg.length;i++) {
					allpath+=allimg[i]+",";
				}
				
				gproduct.setImgs(allpath);
			}*/
			
			gpro.addGproduct(gproduct);
			
			
			System.out.println(gproduct);
			req.setAttribute("curr", req.getRequestURI());
			
			return  "/admin/admin_addComp.jsp?select=agpurchase"; 
			} 
	
	
	
}
