<!DOCTYPE html>
<%@page import="userlist.UserlistDataBean"%>
<%@page import="userlist.UserlistDBBean"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<html>
<title>Plant shop</title>
<meta charset="UTF-8">
 
 
 <c:if test="${loginId==null}">
 
		<script>
		alert("회원만 이용 가능합니다.");
		location.href='../user/login';
		</script>
	</c:if>

	
 <jsp:include page="mypageheader.jsp"></jsp:include>
<div class="w3-container "  width="100%"  >
  

 
      

<form class="w3-container w3-section" method="post" action="../user/userModifyPro" style="padding-left:50px;">
  <h4>회원 정보</h4>
 
   <table class="w3-white w3-small" style="width: 80%;" >
  
  
<tr ><td>  <label><b>아이디</b></label></td><td align="left">&nbsp;&nbsp;&nbsp;${user.id}<p/>
</td></tr>
 <tr><td>
  <label><b>이름</b></label></td><td><input class="w3-input w3-hover-light-grey" type="text" name="name" value="${user.name}"><p/></td></tr>

 <tr ><td><label><b>생일</b> </label></td><td><input type="date"  class="w3-input w3-hover-light-grey" name="bdate" value="${user.bdate}"><p/></td></tr>
 <tr ><td> <label><b>주소</b></label></td><td><input type="text"  class="w3-input w3-hover-light-grey" name="addr" value="${user.addr}"><p/></td></tr>
 <tr ><td><label><b>전화번호</b></label></td><td><input type="text"  class="w3-input w3-hover-light-grey" name="tel" value="${user.tel}"><p/></td></tr>
<tr ><td>  <label><b>이메일</b></label></td><td><input type="text"  class="w3-input w3-hover-light-grey" name="email" value="${user.email}"><p/></td></tr>
<tr  height="50px"><td><label><b>가입일</b></label>
</td><td align="left">&nbsp;&nbsp;&nbsp;${user.cdate}<p/></td></tr>
<tr><td><label><b>적립금</b></label></td><td align="left">&nbsp;&nbsp;&nbsp;${user.point}<p/></td></tr>
<tr><td><label><b>비밀번호</b></label></td><td align="left">
<input type="password" placeholder="정보를 수정하려면 비밀번호를 입력하세요." class="w3-input w3-hover-light-grey" name="pwd" required="required"><p/></td></tr>

  </table>

 <hr>

   <div class="w3-row-padding">
  <div class="w3-bar">
   <button class="w3-button w3-black w3-margin-right w3-small" type="button" onclick="location.href='<%=request.getContextPath()%>/view/main.jsp'">메인으로</button>
	<input type="hidden" name="id" value="${user.id}">
	<input type="hidden" name="point" value="${user.point}">
	<input type="hidden" name="ulevel" value="${user.ulevel}">

   <input type="submit" class="w3-button w3-black w3-margin-right w3-small" value="수정"> <br><br></p>
  </div>
  </div>
  
 
</form>








 
  <!-- End page content -->
 
 



