package comment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import board.BoardDBBean;

public class CommentWrite {
	public String commentWriteService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
			String id=req.getSession().getAttribute("loginId").toString();
			String cocontent=req.getParameter("cocontent");
			int articlenum=Integer.parseInt(req.getParameter("articlenum"));
			HashMap<String,Object> result=null;
			
			try{
				BoardDBBean dbpro=BoardDBBean.getInstance();
				dbpro.insertComment(id, cocontent, articlenum);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		
			JSONObject jsonObj=new JSONObject(result);
			PrintWriter pw=res.getWriter();
			pw.println(jsonObj);
		
		return null;
		
	}
}
