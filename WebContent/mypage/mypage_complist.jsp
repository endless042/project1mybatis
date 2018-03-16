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
    	<td class="w3-center">결제한 상품이 없습니다.</td>
    	
    	</table>
    	</c:if>
<c:if test="${acount!=0}">
 <table class="w3-table w3-bordered w3-small">
 <tr class="w3-border-top"><td class="w3-center" width="50px;"  ><b>번호</b></td>
 <td class="w3-center"><b>사진</b></td>
 <td  class="w3-center"><b>상품명</b></td>
<td  class="w3-center"><b>결제가격</b></td>


<td class="w3-center"><b>결제일시</b></td>
<td class="w3-center"><b>배송방법</b></td></tr>


<c:forEach var="pay" items="${aList}">
<tr><td class="w3-center"><span style="width: 100%;">
<div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
${anumber }
<c:set var="anumber" value="${anumber-1 }"/>
</div></span></td>

<td class="w3-center" style="width: 100px;"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
<div class="w3-display-container">
<img src="<%= request.getContextPath() %>/fileSave/${pay.aproduct.imgs}" width="80px" height="100px"></div> </td>

<td style="width: 35%;" ><span style="width: 100%;">
<div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <a href="mypagePayView?num=${pay.num}&select=pay&pcode=a&apageNum=${apageNum}&gpageNum=${gpageNum}&pronum=${pay.aproduct.num}">
 ${pay.aproduct.title }</a>
</div></span></td>





<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p>
${pay.price }<p/>
 
</div></span></td>
<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p>
${pay.rdate}<p/>

</div></span></td>
<td class="w3-center">
<span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
<c:if test="${pay.deliv=='1' }">
픽업
</c:if>
<c:if test="${pay.deliv=='2' }">
택배
</c:if>
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
    	<td class="w3-center">결제한 상품이 없습니다.</td>
    	
    	</table>
    	</c:if>
<c:if test="${gcount!=0}">
 <table class="w3-table w3-bordered w3-small">
 <tr class="w3-border-top"><td class="w3-center" width="50px;"  ><b>번호</b></td>

 <td class="w3-center"><b>사진</b></td>
 <td  class="w3-center"><b>상품명</b></td>
<td class="w3-center"><b>진행상황</b></td>
<td class="w3-center"><b>결제가격</b></td>
<td class="w3-center"><b>결제일시</b></td>
<td class="w3-center"><b>배송방법</b></td></tr>


<c:forEach var="pay" items="${gList}">
<tr><td class="w3-center"><span style="width: 100%;">
<div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
${gnumber }
<c:set var="gnumber" value="${gnumber-1 }"/>
</div></span></td>


<td class="w3-center" style="width: 100px;"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
<div class="w3-display-container">
<img src="<%= request.getContextPath() %>/fileSave/${pay.gproduct.imgs}" width="80px" height="100px">

</td>
 
<td style="width: 30%;"><span style="width: 100%;">
<div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <a href="mypagePayView?num=${pay.num}&select=pay&pcode=g&apageNum=${apageNum}&gpageNum=${gpageNum}&pronum=${pay.gproduct.num}">
 ${pay.gproduct.title}
 </a>
</div></span></td>


<td class="w3-center"><span style="width: 100%;">
<div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
<span class="w3-tag w3-white w3-border">
<c:if test="${pay.gproduct.process =='1' }">
협상
</c:if>
<c:if test="${pay.gproduct.process =='2' }">
해외이동
</c:if>
<c:if test="${pay.gproduct.process =='3' }">
통관/검역
</c:if>
<c:if test="${pay.gproduct.process =='4' }">
국내이동
</c:if>
<c:if test="${pay.gproduct.process =='5' }">
순화중
</c:if>
<c:if test="${pay.gproduct.process =='6' }">
배송시작
</c:if>
</span><p/>
</div></span></td>

<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p>
 ${pay.price }<p/>

</div></span></td>
<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p>
 ${pay.rdate }<p/>

</div></span></td>

<td class="w3-center">
<span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
<c:if test="${pay.deliv=='1' }">
픽업
</c:if>
<c:if test="${pay.deliv=='2' }">
택배
</c:if>
</div></span></td></tr>
</c:forEach>



 </table>
 </c:if>
<!-- 하단 페이징  -->
    	<div class="w3-center w3-section w3-small">
    	
    	<c:if test="${gstartPage>gbottomLine}">
    		
    		 <a href="paylist?gpageNum=${gstartPage-gbottomLine}&apageNum=${apageNum}" class="w3-bar-item w3-button w3-hover-black">«</a>
    	
    		</c:if>
    	
    		<c:forEach var="i" begin="${gstartPage }" end="${gendPage }">
    		
    		<c:if test="${i!=gcurrentPage}">
    		  <a href="paylist?gpageNum=${i}&apageNum=${apageNum}"
    		 class="w3-bar-item w3-button w3-hover-black">${i}</a> 
    		 
    		 
    		 	</c:if>
    		
    		
    		<c:if test="${i==gcurrentPage}">
    		  <a href="paylist?gpageNum=${i}&apageNum=${apageNum}" 
    		  class="w3-bar-item w3-black w3-button">${i}</a> 
    		</c:if>
    		
    		</c:forEach>
    	
    	
    	<c:if test="${gendPage<gpageCount}">
    		
    		
    		 <a href="paylist?gpageNum=${ gstartPage+bottomLine}&apageNum=${apageNum}" class="w3-bar-item w3-button w3-hover-black">»</a>
    			</c:if>
    	
    		 
    		 
    	</div>
  
  
  
  
  
 </div>
  
 </div>

</div>



 
  <!-- End page content -->
 
 



