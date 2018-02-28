<!DOCTYPE html>
<%@page import="db.UserlistDataBean"%>
<%@page import="db.UserlistDBBean"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<title>Plant shop</title>
<meta charset="UTF-8">
  <jsp:include page="mypageheader.jsp"></jsp:include>
 
  <%
  try{
		UserlistDBBean userPro=UserlistDBBean.getInstance();
		UserlistDataBean user=userPro.getUser((String)session.getAttribute("loginId")); %>
		

<div class="w3-container "  width="100%"  >
  

 
      

<form class="w3-container w3-section" method="post" action="<%=request.getContextPath() %>/view/userModifyPro.jsp" style="padding-left:50px;">
  <h4>회원 정보</h4>
 
   <table class="w3-white w3-small" style="width: 80%;" >
  
  
<tr ><td>  <label><b>아이디</b></label></td><td align="left">&nbsp;&nbsp;&nbsp;<%=user.getId()%><p/>
</td></tr>
 <tr><td>
  <label><b>이름</b></label></td><td><input class="w3-input" type="text" name="name" value="<%=user.getName()%>"><p/></td></tr>

 <tr ><td><label><b>생일</b> </label></td><td><input type="date"  class="w3-input" name="bdate" value="<%=user.getBdate()%>"><p/></td></tr>
 <tr ><td> <label><b>주소</b></label></td><td><input type="text"  class="w3-input" name="addr" value="<%=user.getAddr() %>"><p/></td></tr>
 <tr ><td><label><b>전화번호</b></label></td><td><input type="text"  class="w3-input" name="tel" value="<%=user.getTel() %>"><p/></td></tr>
<tr ><td>  <label><b>이메일</b></label></td><td><input type="text"  class="w3-input" name="email" value="<%=user.getEmail() %>"><p/></td></tr>
<tr  height="50px"><td><label><b>가입일</b></label>
</td><td align="left">&nbsp;&nbsp;&nbsp;<%=user.getCdate() %><p/></td></tr>
<tr><td><label><b>적립금</b></label></td><td align="left">&nbsp;&nbsp;&nbsp;<%=user.getPoint() %><p/></td></tr>
<tr><td><label><b>비밀번호</b></label></td><td align="left">
<input type="password"  class="w3-input" name="pwd" required="required"><p/></td></tr>

  </table>

 <hr>

   <div class="w3-row-padding">
  <div class="w3-bar">
   <button class="w3-button w3-black w3-margin-right w3-small" type="button" onclick="location.href='<%=request.getContextPath()%>/view/main.jsp'">메인으로</button>
	<input type="hidden" name="id" value="<%=user.getId()%>">
	<input type="hidden" name="point" value="<%=user.getPoint()%>">
	<input type="hidden" name="ulevel" value="<%=user.getUlevel() %>">

   <input type="submit" class="w3-button w3-black w3-margin-right w3-small" value="수정"> <br><br></p>
  </div>
  </div>
  
 
</form>








 
  <!-- End page content -->
 
 

<%}catch(Exception e){}%>

