package controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import db.OrderDBBean;
import db.PaylistDBBean;
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
	public String alist(HttpServletRequest req,
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
	    List aList=null;
	    AuctionDBBean aPro=AuctionDBBean.getInstance();
	    
	   count=aPro.getAproductCount("all");
	   
	   int bottomLine=5;
	    if(count>0){
	    	aList=aPro.getProducts(startRow, endRow, "all");
	    number=count-(currentPage-1)*pageSize;
	    
	   

   		int pageCount=count/pageSize+(count%pageSize==0?0:1);
   		int startPage=1+(currentPage-1)/bottomLine*bottomLine;
   		int endPage=startPage+bottomLine-1;
   	
   		if(endPage>pageCount)endPage=pageCount;
   		
   		 
   	    req.setAttribute("count", count);
   	    req.setAttribute("aList", aList);
   	    req.setAttribute("pageNum", pageNum);
   	    req.setAttribute("bottomLine", bottomLine);
   	    req.setAttribute("startPage", startPage);
   	    req.setAttribute("currentPage", currentPage);
   	    req.setAttribute("pageCount", pageCount);
   	    req.setAttribute("endPage", endPage);

	    }
	   

			 return  "/admin/admin_alist.jsp"; 
			} 
	
	public String glist(HttpServletRequest req,
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
	    List gList=null;
	    GpurcDBBean gPro=GpurcDBBean.getInstance();
	    
	   count=gPro.getGproductCount("all");
	   
	   int bottomLine=5;
	    if(count>0){
	    	gList=gPro.getProducts(startRow, endRow,"all");
	    number=count-(currentPage-1)*pageSize;
	    
	   

  		int pageCount=count/pageSize+(count%pageSize==0?0:1);
  		int startPage=1+(currentPage-1)/bottomLine*bottomLine;
  		int endPage=startPage+bottomLine-1;
  	
  		if(endPage>pageCount)endPage=pageCount;
  		
  		 
  	    req.setAttribute("count", count);
  	    req.setAttribute("gList", gList);
  	    req.setAttribute("pageNum", pageNum);
  	    req.setAttribute("bottomLine", bottomLine);
  	    req.setAttribute("startPage", startPage);
  	    req.setAttribute("currentPage", currentPage);
  	    req.setAttribute("pageCount", pageCount);
  	    req.setAttribute("endPage", endPage);

	    }
	   

			 return  "/admin/admin_glist.jsp"; 
			} 
	
	public String olist(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
			req.setAttribute("title", "관리자페이지");
			
			
			String pcode=req.getParameter("pcode");
			if(pcode==null||pcode==""){
				pcode="a";}
			
		
			
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
	    List oList=null;
	    OrderDBBean oPro=OrderDBBean.getInstance();
	    
	   count=oPro.getTotalOrderCount(pcode);
	   
	   int bottomLine=5;
	    if(count>0){
	    	oList=oPro.getOrdersAdmin(startRow, endRow, pcode);
	    number=count-(currentPage-1)*pageSize;
	    
	   

 		int pageCount=count/pageSize+(count%pageSize==0?0:1);
 		int startPage=1+(currentPage-1)/bottomLine*bottomLine;
 		int endPage=startPage+bottomLine-1;
 	
 		if(endPage>pageCount)endPage=pageCount;
 		
 		 
 	    req.setAttribute("count", count);
 	    req.setAttribute("oList", oList);
 	    req.setAttribute("pageNum", pageNum);
 	    req.setAttribute("bottomLine", bottomLine);
 	    req.setAttribute("startPage", startPage);
 	    req.setAttribute("currentPage", currentPage);
 	    req.setAttribute("pageCount", pageCount);
 	    req.setAttribute("endPage", endPage);

	    }
	   

			 return  "/admin/admin_orderlist.jsp?pcode="+pcode; 
			} 
	
	public String plist(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
			req.setAttribute("title", "관리자페이지");
			String pcode=req.getParameter("pcode");
			if(pcode==null||pcode==""){
				pcode="a";}
			if(pcode.equals("a")) {
				req.setAttribute("pageTitle", "경매 결제 내역");
			}else if(pcode.equals("g")) {
				req.setAttribute("pageTitle", "공동구매 결제 내역");
			}
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
	    List pList=null;
	    PaylistDBBean paypro=PaylistDBBean.getInstance();
	    
	   count=paypro.getPayCountAdmin(pcode);
	   System.out.println("==============="+count);
	   int bottomLine=5;
	    if(count>0){
	    	pList=paypro.getPaylistAdmin(startRow, endRow, pcode);
	    number=count-(currentPage-1)*pageSize;
	    
	   

		int pageCount=count/pageSize+(count%pageSize==0?0:1);
		int startPage=1+(currentPage-1)/bottomLine*bottomLine;
		int endPage=startPage+bottomLine-1;
	
		if(endPage>pageCount)endPage=pageCount;
		
		 
	    req.setAttribute("count", count);
	    req.setAttribute("pList", pList);
	    req.setAttribute("pageNum", pageNum);
	    req.setAttribute("bottomLine", bottomLine);
	    req.setAttribute("startPage", startPage);
	    req.setAttribute("currentPage", currentPage);
	    req.setAttribute("pageCount", pageCount);
	    req.setAttribute("endPage", endPage);

	    }
	   

			 return  "/admin/admin_pay.jsp?pcode="+pcode; 
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
	public String admin_aproductModify(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
			req.setAttribute("title", "관리자페이지");
			String pageNum=req.getParameter("pageNum");
			int num=Integer.parseInt(req.getParameter("num"));
			AuctionDBBean apro=AuctionDBBean.getInstance();
			
			AuctionDataBean aproduct=apro.getProduct(num, "");
			
			String olddate=aproduct.getSdate();
			
			String formatSdate="";
			String formatEdate="";
			String formatStime;
			String formatEtime;
			
			formatSdate=olddate.substring(0, 4)+"-"+olddate.substring(4,6)+"-"+olddate.substring(6,8);
			formatStime=olddate.substring(8,10);
			
		
			olddate=aproduct.getEdate();
			formatEdate=olddate.substring(0, 4)+"-"+olddate.substring(4,6)+"-"+olddate.substring(6,8);
			formatEtime=olddate.substring(8,10);
			
		
			
			req.setAttribute("formatSdate", formatSdate);
			req.setAttribute("formatStime", formatStime);
			req.setAttribute("formatEdate", formatEdate);
			req.setAttribute("formatEtime", formatEtime);
			
			req.setAttribute("aproduct", aproduct);
			req.setAttribute("pageNum", pageNum);
			
			 return  "/admin/admin_aproductModify.jsp?select=aauction"; 
			} 
	
	public String admin_gproductModify(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
			req.setAttribute("title", "관리자페이지");
			String pageNum=req.getParameter("pageNum");
			int num=Integer.parseInt(req.getParameter("num"));
			GpurcDBBean gpro=GpurcDBBean.getInstance();
			
			GpurcDataBean gproduct=gpro.getProduct(num, "");
			
			
			String olddate=gproduct.getSdate();
			
			String formatSdate="";
			String formatEdate="";
			String formatStime;
			String formatEtime;
			
			formatSdate=olddate.substring(0, 4)+"-"+olddate.substring(4,6)+"-"+olddate.substring(6,8);
			formatStime=olddate.substring(8,10);
			
		
			olddate=gproduct.getEdate();
			formatEdate=olddate.substring(0, 4)+"-"+olddate.substring(4,6)+"-"+olddate.substring(6,8);
			formatEtime=olddate.substring(8,10);
			
		
			
			req.setAttribute("formatSdate", formatSdate);
			req.setAttribute("formatStime", formatStime);
			req.setAttribute("formatEdate", formatEdate);
			req.setAttribute("formatEtime", formatEtime);
			
			
			
			
			req.setAttribute("gproduct", gproduct);
			req.setAttribute("pageNum", pageNum);
			
			 return  "/admin/admin_gproductModify.jsp?select=agpurchase"; 
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
			
			aproduct.setSdate(sdatestr);
			aproduct.setEdate(edatestr);
			
			Date date = new Date();

			SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

			System.out.println(simple.format(date));
			String curtime=simple.format(date);

			
			int timeCount=apro.getRemainTime(aproduct, curtime);
			int startRemain=apro.getStartRemain(aproduct, curtime);	//1이면 아직시작안함
			
		
			if(startRemain==1) {
				aproduct.setState("1");
			}else if(timeCount==0) {
				aproduct.setState("3");
			}else if(timeCount>0) {
				aproduct.setState("2");
			}
			
			
			
			aproduct.setName(multi.getParameter("name"));
			aproduct.setOrigin(multi.getParameter("origin"));
			aproduct.setCategory(multi.getParameter("category"));
			aproduct.setHeight(multi.getParameter("height"));
			
			aproduct.setSprice(multi.getParameter("sprice"));
			aproduct.setDeliv(multi.getParameter("deliv"));
			
			aproduct.setTitle(multi.getParameter("title"));
			aproduct.setContent(multi.getParameter("content"));
			
			  if(file!=null) {
				  aproduct.setImgs(filename);
				  aproduct.setImgsize((int)file.length());
			     }else {
			    	 aproduct.setImgs(" ");
			    	 aproduct.setImgsize(0);
			     }
			
			
			
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
			
			GpurcDBBean gpro=GpurcDBBean.getInstance();
			GpurcDataBean gproduct=new GpurcDataBean();
			
			gproduct.setSdate(sdatestr);
			gproduct.setEdate(edatestr);
			
		
			
		
			Date date = new Date();

			SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

			System.out.println(simple.format(date));
			String curtime=simple.format(date);

			
			int timeCount=gpro.getRemainTime(gproduct, curtime);
			int startRemain=gpro.getStartRemain(gproduct, curtime);
			
			if(startRemain==1) {
				gproduct.setState("1");
			}else if(timeCount==0) {
				gproduct.setState("3");
			}else if(timeCount>0) {
				gproduct.setState("2");
			}
			
			gproduct.setName(multi.getParameter("name"));
			gproduct.setOrigin(multi.getParameter("origin"));
			gproduct.setCategory(multi.getParameter("category"));
			gproduct.setHeight(multi.getParameter("height"));
			gproduct.setPrice(multi.getParameter("price"));
			gproduct.setDeliv(multi.getParameter("deliv"));
			
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
			
	
			gpro.addGproduct(gproduct);
			
			
			System.out.println(gproduct);
			req.setAttribute("curr", req.getRequestURI());
			
			return  "/admin/admin_addComp.jsp?select=agpurchase"; 
			} 
	public String modifyAproductPro(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		req.setAttribute("title", "관리자페이지");
		
		String pronum=req.getParameter("num");
		System.out.println(pronum+"===========");
		int num=Integer.parseInt(pronum);
		
				


	     try {
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
		AuctionDataBean aproduct=apro.getProduct(num, "");
		
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
		
		aproduct.setSdate(sdatestr);
		aproduct.setEdate(edatestr);
		
		Date date = new Date();

		SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

		System.out.println(simple.format(date));
		String curtime=simple.format(date);

		
		int timeCount=apro.getRemainTime(aproduct, curtime);
		int startRemain=apro.getStartRemain(aproduct, curtime);	//1이면 아직시작안함
		
		
		if(startRemain==1) {
			aproduct.setState("1");
		}else if(timeCount==0) {
			aproduct.setState("3");
		}else if(timeCount>0) {
			aproduct.setState("2");
		}
		
		
		
		aproduct.setName(multi.getParameter("name"));
		aproduct.setOrigin(multi.getParameter("origin"));
		aproduct.setCategory(multi.getParameter("category"));
		aproduct.setHeight(multi.getParameter("height"));
		aproduct.setSprice(multi.getParameter("sprice"));
		aproduct.setDeliv(multi.getParameter("deliv"));
	
		aproduct.setTitle(multi.getParameter("title"));
		aproduct.setContent(multi.getParameter("content"));
		
		  if(file!=null) {
			  aproduct.setImgs(filename);
			  aproduct.setImgsize((int)file.length());
		    
		     }
		
		
		
		int chk=apro.updateAproduct(aproduct);
		
		System.out.println(aproduct);
		
			
		req.setAttribute("num", num);
		req.setAttribute("chk", chk);
		}catch(Exception e){e.printStackTrace();}
		
		return  "/admin/admin_aModifyPro.jsp"; 
			} 
	
	
	public String modifyGproductPro(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		req.setAttribute("title", "관리자페이지");
		
		String pronum=req.getParameter("num");
		
		int num=Integer.parseInt(pronum);
		try {
		 
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
		
		GpurcDBBean gpro=GpurcDBBean.getInstance();
		GpurcDataBean gproduct=gpro.getProduct(num, "");
		
		gproduct.setSdate(sdatestr);
		gproduct.setEdate(edatestr);
		
	
		
	
		Date date = new Date();

		SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

		System.out.println(simple.format(date));
		String curtime=simple.format(date);

		
		int timeCount=gpro.getRemainTime(gproduct, curtime);
		int startRemain=gpro.getStartRemain(gproduct, curtime);
		
		if(startRemain==1) {
			gproduct.setState("1");
		}else if(timeCount==0) {
			gproduct.setState("3");
		}else if(timeCount>0) {
			gproduct.setState("2");
		}
		
		gproduct.setName(multi.getParameter("name"));
		gproduct.setOrigin(multi.getParameter("origin"));
		gproduct.setCategory(multi.getParameter("category"));
		gproduct.setHeight(multi.getParameter("height"));
		gproduct.setPrice(multi.getParameter("price"));
		gproduct.setDeliv(multi.getParameter("deliv"));
		
		gproduct.setTitle(multi.getParameter("title"));
		gproduct.setContent(multi.getParameter("content"));
		gproduct.setGoal(Integer.parseInt(multi.getParameter("goal")));
		gproduct.setProcess(multi.getParameter("process"));
		

		  if(file!=null) {
			  gproduct.setImgs(filename);
			  gproduct.setImgsize((int)file.length());
		    
		     }
		

		System.out.println(gproduct);
		
		
		
		int chk=gpro.updateGproduct(gproduct);
		
		req.setAttribute("num", num);
		req.setAttribute("chk", chk);
		}catch(Exception e){e.printStackTrace();}
		
		return  "/admin/admin_gModifyPro.jsp"; 
			} 
	
	
}
