
<%@page import="db.UserlistDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <% request.setCharacterEncoding("utf-8"); %>
     
   
     <jsp:useBean id="user" class="db.UserlistDataBean">
<jsp:setProperty name="user" property="*"/>
</jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



<%
 	
	


	try{
		UserlistDBBean userPro = UserlistDBBean.getInstance(); 
		int chk=userPro.updateUser(user);
		
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	String pageNum=request.getParameter("pageNum");
	if(pageNum==null||pageNum.equals("")){
		pageNum="1";
	}

%>

<%
	System.out.println(chk);
	if(chk==1){
	
	 System.out.println("userModify "+user); %>
	<script>
		alert("정보 수정 완료");
		</script>
	<meta http-equiv="Refresh" content="0;url=admin_userModify.jsp?id=<%=id%>&pwd=<%=pwd%>&pageNum=<%=pageNum%>&select=auserlist">
	
	<%}else{ %>
		<script>
		alert("정보 수정 오류");
		history.go(-1);		//바로 전 화면으로 이동(updateForm.jsp)
		</script>
	<%} 
	}catch(Exception e){e.printStackTrace();}%>




</body>
</html>