package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.msk.Action;

import db.UserlistDBBean;
import db.UserlistDataBean;

public class UserController extends Action{
	public String join(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
			req.setAttribute("title", "회원가입");
			
			
			
			
			
			 return  "/view/user/join2.jsp"; 
			} 
	
	public String joinPro(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
			req.setAttribute("title", "회원가입");
			
			UserlistDBBean userPro=UserlistDBBean.getInstance();
			UserlistDataBean user=new UserlistDataBean();
			
			String tel="";
			String addr="";
			if(req.getParameter("tel")==null||req.getParameter("tel")=="") {
			tel="미입력";
			}else {
				tel=req.getParameter("tel");
			}
			if(req.getParameter("addr")==null||req.getParameter("addr")=="") {
			addr="미입력";
			
			}else {
				addr=req.getParameter("addr");
			}
			
			user.setTel(tel);
			user.setAddr(addr);
			user.setEmail(req.getParameter("email"));
			user.setBdate(req.getParameter("bdate"));
			user.setName(req.getParameter("name"));
			user.setId(req.getParameter("id"));
			user.setPwd(req.getParameter("pwd"));
				
			
			System.out.println(user); 
			userPro.addUser(user);
			
			
			res.sendRedirect("joinComp");
			
			
			
			 return  null; 
			} 
	

	public String joinComp(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
		
		req.setAttribute("title", "회원가입 완료");
		return "/view/user/joinComp.jsp";
	}
	public String login(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
			 
		req.setAttribute("title", "로그인");
		return  "/view/user/login.jsp"; 
			} 
	
	public String loginPro(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable { 
			 
		req.setAttribute("title", "로그인");
		
		 String tryid=req.getParameter("tryid");
		 String trypwd=req.getParameter("trypwd");
		

		UserlistDBBean userPro= UserlistDBBean.getInstance(); 
		
		System.out.println(tryid+" "+trypwd);
		
		int ck=userPro.loginCheck(tryid, trypwd);
		UserlistDataBean user=null;
		
	
		
		user=userPro.getUser(tryid, trypwd);
		
		req.setAttribute("ck", ck);
		
		
		if(ck!=-1) {
			
			System.out.println("Login : "+user); 
			req.getSession().setAttribute("loginId", tryid);
			req.getSession().setAttribute("levelCk", user.getUlevel());
			req.getSession().setAttribute("userName", user.getName());
			req.getSession().setAttribute("userLevel", user.getUlevel());
			
			
		}
		
		return "/view/user/loginPro.jsp";
		
			} 
	
	public String logoutPro(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
		
		req.getSession().invalidate();
		
	
		return "/view/user/logoutPro.jsp";
	}
	
	public String userModifyPro(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
		

		return "/view/user/userModifyPro.jsp";
	}
	
	
}
