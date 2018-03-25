<%@page import="userlist.UserlistDataBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="userlist.UserlistDBBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
 <jsp:include page="adminheader.jsp"></jsp:include>
   
      <span class="w3-small"> <p>(전체 주문수:${count})</p></span>
   
 
  <c:if test="${count==0}">
    	<table class="w3-table w3-border w3-hoverable w3-center w3-small" width="90%">
    	<tr class="w3-light-grey">
    	<td class="w3-center">회원 참여가 없습니다.</td>
    	
    	</table>
    	</c:if>
    	
    	
    	 <c:if test="${count!=0}">
    	
    	<table class="w3-table w3-bordered w3-hoverable w3-small" width="90%">
    	<tr class="w3-light-grey">
    	<td class="w3-center" width="10%"><b>상품번호</b></td>
    	<td class="w3-center" width="10%"><b>회원아이디</b></td>
    	<td class="w3-center" width="15%"><b>결제가격</b></td>

    	<td class="w3-center" ><b>주문일</b></td>
    	<td class="w3-center" width="10%"><b>주문수량</b></td>
    	<td class="w3-center" width="20%"><b>관리</b></td>
    
    <c:forEach var="order" items="${oList}">
   
    			<tr >
    			<td class="w3-center" >${order.pronum}</td>
    			<td class="w3-center" >${order.userid}</td>
    			<td class="w3-center" >${order.aproduct.eprice}</td>
    			<td class="w3-center" >${order.rdate}</td>
    			<td class="w3-center" >${order.count}</td>
    			
    			<td class="w3-center" >
    			
    			
    			<form method="post" action="admin_userModify" style="display: inline-block;">
    			<%-- <input type="hidden" name="pageNum" value="${pageNum}">
    			<input type="hidden" name="id" value="${user.id}">
    			<input type="hidden" name="pwd" value="${user.pwd}"> --%>
    			<input type="hidden" name="select" value="auserlist">
    			<button class="w3-button w3-padding-small w3-black tablink w3-hover-green w3-small w3-padding-small" 
    			type="submit" onclick="openAdminPage(event,'userModify')"  >수정</button></form>
    			
    			
    			<form method="post" action="deleteUserPro" style="display: inline-block;"><button class="w3-padding-small w3-hover-red
    			 w3-button w3-small w3-black w3-padding-small" type="submit"  >삭제</button>
    			 <%-- <input type="hidden" name="pageNum" value="${pageNum}">
    			<input type="hidden" name="id" value="${user.id}">
    			<input type="hidden" name="pwd" value="${user.pwd}"> --%></form></td>

    		</tr>
    		</c:forEach>
    </table>
    
    <!-- 하단 페이징    -->
    <div class="w3-section">
    
    	<c:if test="${count>0}">
   
    	
    	<c:if test="${startPage>bottomLine}">
    		
    		<a href="olist?pageNum=${startPage-bottomLine}&select=olist" class="w3-bar-item w3-button w3-hover-black">«</a>
    		</c:if>
    		
    		<c:forEach var="i" begin="${startPage }" end="${endPage}">
    		<c:if test="${i!=currentPage }">
    		
    		<a href="olist?pageNum=${i}&select=olist" class="w3-bar-item w3-button w3-hover-black">${i}</a>
    		</c:if>
    		<c:if test="${i==currentPage }">
    		
    		
    		<a href="olist?pageNum=${i}&select=olist" class="w3-bar-item w3-black w3-button">${i}</a>
    		
    		
    		</c:if>
    		
    		<c:if test="${endPage<pageCount}">
    	
    		<a href="olist?pageNum=${startPage+bottomLine}&select=olist" class="w3-bar-item w3-button w3-hover-black">»</a>
    			
    			</c:if>
    		
    		
    		</c:forEach>
    		
    			</c:if>
    		</div>
    		
    	
    	</c:if>
    		
    	