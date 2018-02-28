<%@page import="db.UserlistDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 <% request.setCharacterEncoding("utf-8"); %>
     <%
    String id=request.getParameter("id");
    String pwd=request.getParameter("pwd");
	
    String pageNum=request.getParameter("pageNum");
    if(pageNum==null||pageNum==""){
    	pageNum="1";}
	UserlistDBBean userPro=UserlistDBBean.getInstance();
	int check=userPro.deleteUser(id,pwd);
	if(check==1){
		%>
		<script>
alert("성공적으로 탈퇴되었습니다.");


</script>
<meta http-equiv="Refresh" content="0;url=admin_userlist.jsp?pageNum=<%=pageNum%>&select=auserlist">


		<% }else{ %>
		<script>
alert("탈퇴 오류");
history.go(-1);		//바로 전 화면으로 이동(updateForm.jsp)
</script><%} %>
		
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>

</body>
</html>