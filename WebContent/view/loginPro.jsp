<%@page import="db.UserlistDataBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="db.UserlistDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <% request.setCharacterEncoding("utf-8"); 
 
 String tryid=request.getParameter("tryid");
 String trypwd=request.getParameter("trypwd");
 %>

     
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<% 


UserlistDBBean userPro= UserlistDBBean.getInstance(); 

System.out.println(tryid+" "+trypwd);
int ck=userPro.loginCheck(tryid, trypwd);
UserlistDataBean user=null;
System.out.println(ck);
	if(ck==-1){
		%><script>
alert("로그인에 실패하였습니다.");
history.go(-1);		//바로 전 화면으로 이동(updateForm.jsp)
</script><%
	}else{
		user=userPro.getUser(tryid, trypwd);
		
				System.out.println("Login : "+user); 
				session.setAttribute("loginId", tryid);
				session.setAttribute("levelCk", user.getUlevel());
				session.setAttribute("userName", user.getName());
				%><meta http-equiv="Refresh" content="0;url=main.jsp"> 
				
				<%};
	%>
	


</body>
</html>