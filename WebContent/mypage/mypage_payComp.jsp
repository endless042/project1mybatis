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
  

 
  <h4>주문 완료</h4>
  
  주문이 완료되었습니다.
  <br>
  <br>
  <button class="w3-button" onclick="location.href='${cur}'">확인</button>
  
  </div></div>





 
  <!-- End page content -->
 
 



