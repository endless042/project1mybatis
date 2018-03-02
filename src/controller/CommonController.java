package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.msk.Action;

public class StaticController extends Action{
	public String menu(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
			
		
		
			 return  "/common/menu.jsp"; 
			} 
	
	public String footer(HttpServletRequest req,
			 HttpServletResponse res)  throws Throwable {
			
		
		
			 return  "/common/footer.jsp"; 
			} 
	
	
}
