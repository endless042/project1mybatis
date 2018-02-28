<%@page import="com.sun.org.apache.xml.internal.security.encryption.DocumentSerializer"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="db.UserlistDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <% request.setCharacterEncoding("utf-8"); %>
   
     
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
 $(function(){
  $('#email_select').change(function(){
   if($('#email_select').val() == "1"){
    $("#last_email").val(""); //값 초기화
    $("#last_email").prop("readonly",false); //활성화
   } else if($('#email_select').val() == ""){
    $("#last_email").val(""); //값 초기화
    $("#last_email").prop("readonly",true); //textBox 비활성화
   } else {
    $("#last_email").val($('#email_select').val()); //선택값 입력
    $("#last_email").prop("readonly",true); //비활성화
   }
  });
 });
 

</script>
<jsp:useBean id="user" class="db.UserlistDataBean">
<jsp:setProperty name="user" property="*"/>
</jsp:useBean>

<% 

String tel=request.getParameter("tel1")+request.getParameter("tel2")+request.getParameter("tel3");
String email=request.getParameter("email1")+"@"+request.getParameter("email2");


user.setTel(tel);
if(email.equals("")||email.equals("@")||email==null){
	email="미입력";
}

user.setEmail(email);

UserlistDBBean userPro= UserlistDBBean.getInstance(); 


	
	if(user.getTel()==null){
		 user.setTel("미입력");		
	}
	if(user.getEmail()==null){
		 user.setEmail("미입력");		
	}
 
	
	if(user.getAddr()==null){
	user.setAddr("미입력");}
	
	
	System.out.println(user); 
	
	userPro.addUser(user);%>
	

<%response.sendRedirect("joinComp.jsp"); %>
</body>

</html>

