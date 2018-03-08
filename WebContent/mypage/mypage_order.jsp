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
    	<td class="w3-center">입찰한 상품이 없습니다.</td>
    	
    	</table>
    	</c:if>
    	<c:if test="${acount!=0}">
 <table class="w3-table w3-bordered w3-small">
 <tr class="w3-border-top">
 <td class="w3-center" width="50px;"  ><b>번호</b></td>
 <td class="w3-center"><b>사진</b></td>
 <td  class="w3-center"><b>상품명</b></td>
<td class="w3-center"><b>경매기간</b></td>
<td class="w3-center"><b>입찰 정보</b></td>
<td class="w3-center"><b>결과</b></td></tr>
<c:forEach var="order" items="${aList}">

<tr><td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
${anumber }
<c:set var="anumber" value="${anumber-1 }"/>
</div></span></td>


<td class="w3-center" style="width: 100px;"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
<div class="w3-display-container"><img src="<%= request.getContextPath() %>/fileSave/${order.aproduct.imgs}" width="80px" height="100px">
<c:if test="${order.aproduct.state=='1'}">
<span class="w3-tag w3-display-topleft">예정</span>
</c:if>
<c:if test="${order.aproduct.state=='2'}">
<span class="w3-tag w3-green w3-display-topleft">진행</span>
</c:if>
<c:if test="${order.aproduct.state=='3'}">
<span class="w3-tag w3-display-topleft">마감</span>
</c:if></span></div></div></span></td>


<td width="35%"><span style="width: 100%;"><div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p><a href="acontent?num=${order.aproduct.num}&part=content">${order.aproduct.title }</a><p/>
</div></span></td>


<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p>
${order.aproduct.sdate }<p/>
${order.aproduct.edate }<br>

</div></span></td>
<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p><b>입찰가</b><br>
 ${order.aprice }<p/>
 <b>현재가</b> <br>${order.aproduct.eprice}
</div></span></td>

<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p>
 
 
 <c:if test="${(order.remainTime==0) && (order.aprice==order.aproduct.eprice)}">
 <span class="w3-tag w3-blue">낙찰</span><p/>
  <c:if test="${order.payState!='1' }">
  <form method="post" action="mypagePay">
  <button type="submit"
   class="w3-button w3-padding-small w3-small w3-black">결제하기</button>
  <input type="hidden" name="num" value="${order.aproduct.num}">
  <input type="hidden" name="apageNum" value="${apageNum }">
  <input type="hidden" name="ordernum" value="${order.num}">
  <input type="hidden" name="pcode" value="a">
  </form> </c:if>
    <c:if test="${order.payState=='1' }">
 
  <button 
   class="w3-button w3-padding-small w3-small w3-green">결제완료</button>
 </c:if>
  
  
 </c:if>
 
 
 <c:if test="${(order.remainTime==0) && (order.aprice!=order.aproduct.eprice)}">
 <span class="w3-tag w3-white w3-border">종료</span><p/>
 </c:if>
 
 
  <c:if test="${order.remainTime!=0}">
 <span class="w3-tag w3-white w3-border">진행중</span><p/>
 </c:if>

</div></span></td>


</tr>
</c:forEach>
 </table>
  </c:if>
<!-- 하단 페이징  -->
    	<div class="w3-center w3-section w3-small">
    	
    	<c:if test="${astartPage>abottomLine}">
    		 <a href="orderlist?apageNum=${astartPage-abottomLine}&gpageNum=${gpageNum}" class="w3-bar-item w3-button w3-hover-black">«</a>
    		</c:if>
    	
    		<c:forEach var="i" begin="${astartPage }" end="${aendPage }">
    		<c:if test="${i!=acurrentPage}">
    		  <a href="orderlist?apageNum=${i}&gpageNum=${gpageNum}"
    		 class="w3-bar-item w3-button w3-hover-black">${i}</a> 
    		 	</c:if>

    		<c:if test="${i==acurrentPage}">
    		  <a href="orderlist?apageNum=${i}&gpageNum=${gpageNum}" 
    		  class="w3-bar-item w3-black w3-button">${i}</a> 
    		</c:if>
    		</c:forEach>
    	
    	
    	<c:if test="${aendPage<apageCount}">
    		 <a href="orderlist?apageNum=${ astartPage+bottomLine}&gpageNum=${gpageNum}" class="w3-bar-item w3-button w3-hover-black">»</a>
</c:if>
  </div>
  
  

<h5><b>공동구매</b></h5>

 <c:if test="${gcount==0}">
    	
    	<table class="w3-table w3-border w3-hoverable w3-center w3-small " width="90%">
    	<tr class="w3-light-grey">
    	<td class="w3-center">참여한 상품이 없습니다.</td>
    	
    	</table>
    	</c:if>
<c:if test="${gcount!=0}">
 <table class="w3-table w3-bordered w3-small">
 <tr class="w3-border-top">
 <td class="w3-center" width="50px;"  ><b>번호</b></td>
 <td class="w3-center"><b>사진</b></td>
 <td  class="w3-center"><b>상품명</b></td>
<td class="w3-center"><b>진행기간</b></td>
<td class="w3-center"><b>참여 수량</b></td>
<td class="w3-center"><b>총 금액</b></td>
<td class="w3-center"><b>결과</b></td></tr>


<c:forEach var="order" items="${gList}">
<tr><td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
${gnumber }
<c:set var="gnumber" value="${gnumber-1 }"/>
</div></span></td>

<td class="w3-center" style="width: 100px;"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
<div class="w3-display-container"><img src="<%= request.getContextPath() %>/fileSave/${order.gproduct.imgs}" width="80px" height="100px">
<c:if test="${order.gproduct.state=='1'}">
<span class="w3-tag w3-display-topleft">예정</span>
</c:if>
<c:if test="${order.gproduct.state=='2'}">
<span class="w3-tag w3-green w3-display-topleft">진행</span>
</c:if>
<c:if test="${order.gproduct.state=='3'}">
<span class="w3-tag w3-display-topleft">마감</span>
</c:if></div></div></span></td>

<td width="35%"><span style="width: 100%;"><div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p><a href="gcontent?num=${order.gproduct.num}&part=content">${order.gproduct.title }</a><p/>
</div></span></td>


<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p>
 ${order.gproduct.sdate}<p/>
 ${order.gproduct.edate}
</div></span></td>
<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 ${order.count}
</div></span></td>
<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
${order.gproduct.price*order.count}
</div></span></td>

<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
<p><c:if test="${order.gproduct.goal<=order.gproduct.count}">
 <span class="w3-tag w3-blue">달성</span><p/>
  <%-- 	<c:if test="${(order.remainTime==0) && (order.startRemain==0) }"> --%>
  <form method="post" action="mypagePay">
  <button type="submit"
   class="w3-button w3-padding-small w3-small w3-black">결제하기</button>
  <input type="hidden" name="num" value="${order.gproduct.num}">
  <input type="hidden" name="apageNum" value="${gpageNum }">
  <input type="hidden" name="ordernum" value="${order.num}">
  <input type="hidden" name="count" value="${order.count}">
  <input type="hidden" name="pcode" value="g">
  </form> <%-- </c:if> --%>
 </c:if>
 <c:if test="${(order.remainTime==0) && (order.gproduct.goal>order.gproduct.count)}">
 <span class="w3-tag w3-red">미달</span><p/>
 (${order.gproduct.count }/${order.gproduct.goal })
 </c:if>
  <c:if test="${(order.remainTime!=0)&&(order.gproduct.goal>order.gproduct.count)}">
  <span class="w3-tag w3-white w3-border">모집중</span><p/>
  (${order.gproduct.count }/${order.gproduct.goal })
 </c:if>
</div></span></td>


</tr>
</c:forEach>
 </table>
  </c:if>

<!-- 하단 페이징  -->
    	<div class="w3-center w3-section w3-small">
    	
    	<c:if test="${gstartPage>gbottomLine}">
    		
    		 <a href="orderlist?gpageNum=${gstartPage-gbottomLine}&apageNum=${apageNum}" class="w3-bar-item w3-button w3-hover-black">«</a>
    	
    		</c:if>
    	
    		<c:forEach var="i" begin="${gstartPage }" end="${gendPage }">
    		
    		<c:if test="${i!=gcurrentPage}">
    		  <a href="orderlist?gpageNum=${i}&apageNum=${apageNum}"
    		 class="w3-bar-item w3-button w3-hover-black">${i}</a> 
    		 
    		 
    		 	</c:if>
    		
    		
    		<c:if test="${i==gcurrentPage}">
    		  <a href="orderlist?gpageNum=${i}&apageNum=${apageNum}" 
    		  class="w3-bar-item w3-black w3-button">${i}</a> 
    		</c:if>
    		
    		</c:forEach>
    	
    	
    	<c:if test="${gendPage<gpageCount}">
    		
    		
    		 <a href="orderlist?gpageNum=${ gstartPage+bottomLine}&apageNum=${apageNum}" class="w3-bar-item w3-button w3-hover-black">»</a>
    			</c:if>
    	
    		 
    		 
    	</div>
 </div>
  </div>
 </div>


 
  <!-- End page content -->
 
 



