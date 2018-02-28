package comment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import board.BoardDBBean;

public class CommentRead {
	public String commentReadService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		int commPageSize=Integer.parseInt(req.getParameter("commPageSize"));
		int articlenum=Integer.parseInt(req.getParameter("articlenum"));
		ArrayList<CommentData> comments=null;
		
		try {
			BoardDBBean dbpro=BoardDBBean.getInstance();
			comments=dbpro.getComments(articlenum, commPageSize);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JSONArray jsonArr=new JSONArray(comments);
		PrintWriter pw=res.getWriter();
		pw.println(jsonArr);
		
		return null;
	}
}
