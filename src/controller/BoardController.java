package controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.msk.Action;

import board.BoardDBBean;
import board.BoardDataBean;
import db.UserlistDBBean;
import db.UserlistDataBean;

public class BoardController extends Action {

	public String list(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		
		
		    String boardid=req.getParameter("boardid");
		    if(boardid==null) boardid="1";
		    
		    if(boardid.equals("1")) {
		    req.setAttribute("title", "소식");
		    }else if(boardid.equals("2")) {
		    	req.setAttribute("title", "문의");
		    }else if(boardid.equals("3")){
		    	req.setAttribute("title", "후기");
		    }else if(boardid.equals("4")){
		    	req.setAttribute("title", "커뮤니티");
		    }else {
		    	req.setAttribute("title", "");
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
		    List articleList=null;
		    BoardDBBean dpPro=BoardDBBean.getInstance();
		    count=dpPro.getArticleCount(boardid);
		    if(count>0){
		    	articleList=dpPro.getArticles(startRow,endRow,boardid);}
		    
		    number=count-(currentPage-1)*pageSize;
		    
		    int bottomLine=5;
	    	
	    	
	    		int pageCount=count/pageSize+(count%pageSize==0?0:1);
	    		int startPage=1+(currentPage-1)/bottomLine*bottomLine;
	    		int endPage=startPage+bottomLine-1;
	    	
	    		if(endPage>pageCount)endPage=pageCount;
	    	
	    		
	    		req.setAttribute("boardid", boardid);
	    		req.setAttribute("count", count);
	    		req.setAttribute("articleList", articleList);
	    		req.setAttribute("startPage", startPage);
	    		req.setAttribute("bottomLine", bottomLine);
	    		req.setAttribute("currentPage", currentPage);
	    		req.setAttribute("endPage", endPage);
	    		req.setAttribute("pageCount", pageCount);
	    		req.setAttribute("number", number);
	    		req.setAttribute("userLevel", req.getSession().getAttribute("userLevel") );
		
		
		return "/view/board/list.jsp?bdck=on";
			
	    	} 
	
	public String deleteForm(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		
		  
		String boardid=req.getParameter("boardid");
		    if(boardid==null){
		    	boardid="1";
		    }
		    
		    if(boardid.equals("1")) {
			    req.setAttribute("title", "소식");
			    }else if(boardid.equals("2")) {
			    	req.setAttribute("title", "문의");
			    }else {
			    	req.setAttribute("title", "");
			    }
		  
		    int num=Integer.parseInt(req.getParameter("num"));
		    String pageNum=req.getParameter("pageNum");
		    
		    req.setAttribute("num", num);
    		req.setAttribute("pageNum", pageNum);
    		req.setAttribute("boardid", boardid);
		
		return "/view/board/deleteForm.jsp?select=notice&bdck=on";
			} 
	
	public String deletePro(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		
		
		
	    String boardid=req.getParameter("boardid");
	    if(boardid==null){
	    	boardid="1";
	    }
	    
	    if(boardid.equals("1")) {
		    req.setAttribute("title", "소식");
		    }else if(boardid.equals("2")) {
		    	req.setAttribute("title", "문의");
		    }else {
		    	req.setAttribute("title", "");
		    }
	    
	    
	    String pageNum=req.getParameter("pageNum");
	    if(pageNum==null||pageNum==""){
			pageNum="1";}
		
	    int num=Integer.parseInt(req.getParameter("num"));
		String passwd=req.getParameter("passwd");
		
		BoardDBBean dbPro=BoardDBBean.getInstance();
		int check=dbPro.deleteArticle(num,passwd,boardid);
		
			req.setAttribute("boardid", boardid);
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("check", check);
			
	
		return "/view/board/deletePro.jsp?select=notice&bdck=on";
			} 
	
	public String content(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		
		
		String boardid=req.getParameter("boardid");
		if(boardid==null) boardid="1";
		
		 if(boardid.equals("1")) {
			    req.setAttribute("title", "소식");
			    }else if(boardid.equals("2")) {
			    	req.setAttribute("title", "문의");
			    }else {
			    	req.setAttribute("title", "");
			    }
	 
		int num=Integer.parseInt(req.getParameter("num"));
		String pageNum=req.getParameter("pageNum");
		
		if(pageNum==null||pageNum==""){
			pageNum="1";}
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		try{
			BoardDBBean dbPro=BoardDBBean.getInstance();
			BoardDataBean article=dbPro.getArticle(num,boardid,"content");
			int ref=article.getRef();
			int re_step=article.getRe_step();
			int re_level=article.getRe_level();
			
			
		
		
			req.setAttribute("boardid", boardid);
			req.setAttribute("num", num);
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("ref", ref);
			req.setAttribute("re_step", re_step);
			req.setAttribute("re_level", re_level);
			req.setAttribute("article", article);
			
			
			 }catch(Exception e){e.printStackTrace();}  
		
		
		
		return "/view/board/content.jsp?select=notice&bdck=on";
			} 
	
	public String updateForm(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		
		
		 
		    String boardid=req.getParameter("boardid");
		    if(boardid==null){
		    	boardid="1";
		    }
		    
		    if(boardid.equals("1")) {
			    req.setAttribute("title", "소식");
			    }else if(boardid.equals("2")) {
			    	req.setAttribute("title", "문의");
			    }else {
			    	req.setAttribute("title", "");
			    }
		 
			int num=Integer.parseInt(req.getParameter("num"));
			String pageNum=req.getParameter("pageNum");
			if(pageNum==null||pageNum==""){
				pageNum="1";}
			
			
			try{
				BoardDBBean dbPro=BoardDBBean.getInstance();
				BoardDataBean article=dbPro.getArticle(num,boardid,"update");

				
				req.setAttribute("boardid", boardid);
				req.setAttribute("num", num);
				req.setAttribute("pageNum", pageNum);
				req.setAttribute("article", article);
				
				
				
		
				}catch(Exception e){} 
		
		return "/view/board/updateForm.jsp?select=notice&bdck=on";
			} 
	
	public String updatePro(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		
		
		 int num=Integer.parseInt(req.getParameter("num"));
	     
	     String boardid=req.getParameter("boardid");
	     if(boardid==null) boardid="1";
	     
	     if(boardid.equals("1")) {
			    req.setAttribute("title", "소식");
			    }else if(boardid.equals("2")) {
			    	req.setAttribute("title", "문의");
			    }else {
			    	req.setAttribute("title", "");
			    }
	     
	     String pageNum=req.getParameter("pageNum");
	     if(pageNum==null||pageNum==""){pageNum="1";}
	     
		
	     req.setAttribute("boardid", boardid);
	 	req.setAttribute("pageNum", pageNum);
	 	
	 	BoardDataBean article=new BoardDataBean();
	 	article.setBoardid(boardid);
	 	article.setNum(num);
	 	article.setWriter(req.getParameter("writer"));
	 	article.setSubject(req.getParameter("subject"));
	 	article.setEmail(req.getParameter("email"));
	 	article.setContent(req.getParameter("content"));
	 	article.setPasswd(req.getParameter("passwd"));
	 	 req.setAttribute("article", article);
	 	System.out.println(article);
	     
	 	BoardDBBean dbPro = BoardDBBean.getInstance(); 

		int chk=dbPro.updateArticle(article);
		
		 req.setAttribute("chk", chk);
		
		return "/view/board/updatePro.jsp?select=notice&bdck=on";
			} 
	
	public String writeForm(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		
		
		   req.setAttribute("userName", req.getSession().getAttribute("userName"));

	     int num=0,ref=0, re_step=0, re_level=0;
	    String boardid=req.getParameter("boardid");
	    
	     
	     if(req.getParameter("num")!=null){
	    	num=Integer.parseInt(req.getParameter("num"));
	     	ref=Integer.parseInt(req.getParameter("ref"));
	    	re_level=Integer.parseInt(req.getParameter("re_level"));
	     	re_step=Integer.parseInt(req.getParameter("re_step"));
	     }
	    if(boardid==null||boardid.equals("")){
	    	boardid="1";
	    }
	    
	    
	    
	    if(boardid.equals("1")) {
		    req.setAttribute("title", "소식");
		    }else if(boardid.equals("2")) {
		    	req.setAttribute("title", "문의");
		    }else {
		    	req.setAttribute("title", "");
		    }
	    
	    req.setAttribute("boardid", boardid);
	    req.setAttribute("num", num);
	 	req.setAttribute("ref", ref);
	 	 req.setAttribute("re_step", re_step);
		 req.setAttribute("re_level", re_level);
		  req.setAttribute("pageNum", 1);
	 	
		
		return "/view/board/writeForm.jsp?select=notice&bdck=on";
			} 
	
	public String writePro(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
		req.setAttribute("title", "소식");
		

	
		UserlistDBBean userpro=UserlistDBBean.getInstance();
		UserlistDataBean user=userpro.getUser(req.getParameter("writer"));
		
		String passwd="";
		if(req.getParameter("passwd")==null) {
			 passwd=user.getPwd();
			 }else{
				 passwd=req.getParameter("passwd");
			 }
		
		   String boardid=req.getParameter("boardid");
		     if(boardid==null) boardid="1";
		     
		     if(boardid.equals("1")) {
				    req.setAttribute("title", "소식");
				    }else if(boardid.equals("2")) {
				    	req.setAttribute("title", "문의");
				    }else {
				    	req.setAttribute("title", "");
				    }
		     
		     String pageNum=req.getParameter("pageNum");
		     if(pageNum==null||pageNum==""){pageNum="1";}
  
		     
		     BoardDataBean article=new BoardDataBean();
		     
		     if(req.getParameter("num")!=null&& !req.getParameter("num").equals("")) {
		    	 
		    	  article.setNum(Integer.parseInt(req.getParameter("num")));
		 	     article.setRef(Integer.parseInt(req.getParameter("ref")));
		 	     article.setRe_step(Integer.parseInt(req.getParameter("re_step")));
		 	     article.setRe_level(Integer.parseInt(req.getParameter("re_level")));
		     }
		     
			 	article.setBoardid(boardid);
			 	article.setWriter(req.getParameter("writer"));
			 	article.setSubject(req.getParameter("subject"));
			 	article.setEmail(req.getParameter("email"));
			 	article.setContent(req.getParameter("content"));
			 	article.setPasswd(passwd);
			 	 
			 	 
			 	
			 	
			 	BoardDBBean dbPro = BoardDBBean.getInstance(); 
			 	article.setIp(req.getRemoteAddr());
			 	dbPro.insertArticle(article);
			 	System.out.println(article);
			 	
			 	req.setAttribute("article", article);
		     
		     req.setAttribute("boardid", boardid);
			 	req.setAttribute("pageNum", pageNum);
			 	
		
		res.sendRedirect("list?pageNum="+pageNum+"&boardid="+boardid);
		
		return null;
			} 
	
	
	
	
}
