<!DOCTYPE html>
<%@page import="db.UserlistDataBean"%>
<%@page import="db.UserlistDBBean"%>
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
<div class="w3-container w3-center"  width="100%"  >
  


<h5><b>경매</b></h5>
 <c:if test="${acount==0}">
    	
    	<table class="w3-table w3-border w3-hoverable w3-center w3-small " width="90%">
    	<tr class="w3-light-grey">
    	<td class="w3-center">담긴 상품이 없습니다.</td>
    	
    	</table>
    	</c:if>
<c:if test="${acount!=0}">
 <table class="w3-table w3-bordered w3-small">
 <tr class="w3-border-top"><td class="w3-center" width="50px;"  >번호</td><td class="w3-center">사진</td><td  class="w3-center">상품명</td>
<td class="w3-center">상태</td><td class="w3-center">찜한 날짜</td></tr>


<c:forEach var="cart" items="${aList}">
<tr><td class="w3-center"><span style="width: 100%;">
<div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
${anumber }
<c:set var="anumber" value="${anumber-1 }"/>
</div></span></td>

<td class="w3-center" style="width: 110px;"><span style="width: 100%;">
<div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
<img src="../images/peperomia.PNG" width="100px"></div></span></td>
<td><span style="width: 100%;">
<div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <a href="surveyview.jsp">${cart.title }</a>
</div></span></td>

<td class="w3-center"><span style="width: 100%;">
<div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <span class="w3-tag w3-blue">${cart.state }</span>
</div></span></td><td class="w3-center">
<span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
${cart.rdate }
</div></span></td></tr>
</c:forEach>



 </table>
 </c:if>
<!-- 하단 페이징  -->
    	<div class="w3-center w3-section w3-small">
    	
    	<c:if test="${astartPage>abottomLine}">
    		 <a href="cartlist?apageNum=${astartPage-abottomLine}&gpageNum=${gpageNum}" class="w3-bar-item w3-button w3-hover-black">«</a>
    		</c:if>
    	
    		<c:forEach var="i" begin="${astartPage }" end="${aendPage }">
    		<c:if test="${i!=acurrentPage}">
    		  <a href="cartlist?apageNum=${i}&gpageNum=${gpageNum}"
    		 class="w3-bar-item w3-button w3-hover-black">${i}</a> 
    		 	</c:if>

    		<c:if test="${i==acurrentPage}">
    		  <a href="cartlist?apageNum=${i}&gpageNum=${gpageNum}" 
    		  class="w3-bar-item w3-black w3-button">${i}</a> 
    		</c:if>
    		</c:forEach>
    	
    	
    	<c:if test="${aendPage<apageCount}">
    		 <a href="cartlist?apageNum=${ astartPage+bottomLine}&gpageNum=${gpageNum}" class="w3-bar-item w3-button w3-hover-black">»</a>
</c:if>
    	
    		 
    		 
    	</div>
  
  

<h5><b>공동구매</b></h5>


 <c:if test="${gcount==0}">
    	
    	<table class="w3-table w3-border w3-hoverable w3-center w3-small " width="90%">
    	<tr class="w3-light-grey">
    	<td class="w3-center">담긴 상품이 없습니다.</td>
    	
    	</table>
    	</c:if>
<c:if test="${gcount!=0}">
 <table class="w3-table w3-bordered w3-small">
 <tr class="w3-border-top"><td class="w3-center" width="50px;"  >번호</td><td class="w3-center">사진</td><td  class="w3-center">상품명</td>
<td class="w3-center">상태</td><td class="w3-center">찜한 날짜</td></tr>


<c:forEach var="cart" items="${gList}">
<tr><td class="w3-center"><span style="width: 100%;">
<div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
${gnumber }
<c:set var="gnumber" value="${gnumber-1 }"/>
</div></span></td>

<td class="w3-center"  style="width: 110px;"><span style="width: 100%;">
<div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
<img src="../images/peperomia.PNG" width="100px"></div></span></td>
<td><span style="width: 100%;">
<div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <a href="surveyview.jsp">${cart.title}</a>
</div></span></td>

<td class="w3-center"><span style="width: 100%;">
<div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <span class="w3-tag w3-blue">${cart.state }</span>
</div></span></td><td class="w3-center">
<span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
${cart.rdate}
</div></span></td></tr>
</c:forEach>



 </table>
 </c:if>
<!-- 하단 페이징  -->
    	<div class="w3-center w3-section w3-small">
    	
    	<c:if test="${gstartPage>gbottomLine}">
    		
    		 <a href="cartlist?gpageNum=${gstartPage-gbottomLine}&apageNum=${apageNum}" class="w3-bar-item w3-button w3-hover-black">«</a>
    	
    		</c:if>
    	
    		<c:forEach var="i" begin="${gstartPage }" end="${gendPage }">
    		
    		<c:if test="${i!=gcurrentPage}">
    		  <a href="cartlist?gpageNum=${i}&apageNum=${apageNum}"
    		 class="w3-bar-item w3-button w3-hover-black">${i}</a> 
    		 
    		 
    		 	</c:if>
    		
    		
    		<c:if test="${i==gcurrentPage}">
    		  <a href="cartlist?gpageNum=${i}&apageNum=${apageNum}" 
    		  class="w3-bar-item w3-black w3-button">${i}</a> 
    		</c:if>
    		
    		</c:forEach>
    	
    	
    	<c:if test="${gendPage<gpageCount}">
    		
    		
    		 <a href="cartlist?gpageNum=${ gstartPage+bottomLine}&apageNum=${apageNum}" class="w3-bar-item w3-button w3-hover-black">»</a>
    			</c:if>
    	
    		 
    		 
    	</div>
  
  
  
  
  
 </div>
  
 </div>

</div>



 
  <!-- End page content -->
 
 



