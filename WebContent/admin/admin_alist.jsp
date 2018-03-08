<%@page import="db.UserlistDataBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="db.UserlistDBBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
 <jsp:include page="adminheader.jsp"></jsp:include>
    <h4>경매 상품 관리</h4>
      <span class="w3-small"> <p>(전체 상품수:${count})</p></span>
   
 
  <c:if test="${count==0}">
    	<table class="w3-table w3-border w3-hoverable w3-center w3-small" width="90%">
    	<tr class="w3-light-grey">
    	<td class="w3-center">상품이 없습니다.</td>
    	
    	</table>
    	</c:if>
    	
    	
    	 <c:if test="${count!=0}">
    	
    	<table class="w3-table w3-bordered w3-hoverable w3-small" width="90%">
    	<tr class="w3-light-grey">
    	<td class="w3-center" width="10%"><b>상품번호</b></td>
    	<td class="w3-center" width="10%"><b>이름</b></td>
    	<td class="w3-center" width="15%"><b>원산지</b></td>
    	<td class="w3-center" width="15%"><b>시작일</b></td>
    	<td class="w3-center" width="20%"><b>종료일</b></td>
    	<td class="w3-center" width="10%"><b>현재가</b></td>
    	<td class="w3-center" width="20%"><b>관리</b></td>
    
    <c:forEach var="product" items="${aList}">
   
    			<tr >
    			<td class="w3-center" >${product.num}</td>
    			<td class="w3-center" >${product.name}</td>
    			<td class="w3-center" >${product.origin}</td>
    			<td class="w3-center" >${product.sdate}</td>
    			<td class="w3-center" >${product.edate}</td>
    			<td class="w3-center">${product.eprice}</td>
    			<td class="w3-center" >
    			
    			
    			<form method="post" action="admin_aproductModify" style="display: inline-block;">
    			<input type="hidden" name="pageNum" value="${pageNum}">
    			<input type="hidden" name="num" value="${product.num}">
    			
    			<input type="hidden" name="select" value="auserlist">
    			<button class="w3-button w3-padding-small w3-black tablink w3-hover-green w3-small w3-padding-small" 
    			type="submit" onclick="openAdminPage(event,'userModify')"  >수정</button></form>
    			
    			
    			<form method="post" action="deleteUserPro" style="display: inline-block;"><button class="w3-padding-small w3-hover-red
    			 w3-button w3-small w3-black w3-padding-small" type="submit"  >삭제</button>
    			<input type="hidden" name="pageNum" value="${pageNum}">
    			<input type="hidden" name="num" value="${product.num}">
    			</form></td>

    		</tr>
    		</c:forEach>
    </table>
    
    <!-- 하단 페이징    -->
    <div class="w3-section">
    
    	<c:if test="${count>0}">
   
    	
    	<c:if test="${startPage>bottomLine}">
    		
    		<a href="alist?pageNum=${startPage-bottomLine}&select=aprolist" class="w3-bar-item w3-button w3-hover-black">«</a>
    		</c:if>
    		
    		<c:forEach var="i" begin="${startPage }" end="${endPage}">
    		<c:if test="${i!=currentPage }">
    		
    		<a href="alist?pageNum=${i}&select=aprolist" class="w3-bar-item w3-button w3-hover-black">${i}</a>
    		</c:if>
    		<c:if test="${i==currentPage }">
    		
    		
    		<a href="alist?pageNum=${i}&select=aprolist" class="w3-bar-item w3-black w3-button">${i}</a>
    		
    		
    		</c:if>
    		
    		<c:if test="${endPage<pageCount}">
    	
    		<a href="alist?pageNum=${startPage+bottomLine}&select=aprolist" class="w3-bar-item w3-button w3-hover-black">»</a>
    			
    			</c:if>
    		
    		
    		</c:forEach>
    		
    			</c:if>
    		</div>
    		
    	
    	</c:if>
    		
    	