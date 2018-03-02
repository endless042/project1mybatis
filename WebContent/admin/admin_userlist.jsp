<%@page import="db.UserlistDataBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="db.UserlistDBBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
 <jsp:include page="adminheader.jsp"></jsp:include>
    
      <span class="w3-small"> <p>(전체 회원수:${count})</p></span>
   
 
  <c:if test="${count==0}">
    	<table class="w3-table w3-border w3-hoverable w3-center w3-small" width="90%">
    	<tr class="w3-light-grey">
    	<td class="w3-center">회원이 없습니다.</td>
    	
    	</table>
    	</c:if>
    	
    	
    	 <c:if test="${count!=0}">
    	
    	<table class="w3-table w3-bordered w3-hoverable w3-small" width="90%">
    	<tr class="w3-light-grey">
    	<td class="w3-center" width="10%"><b>회원번호</b></td>
    	<td class="w3-center" width="10%"><b>레벨</b></td>
    	<td class="w3-center" width="15%"><b>아이디</b></td>
    	<td class="w3-center" width="15%"><b>이름</b></td>
    	<td class="w3-center" width="20%"><b>가입일</b></td>
    	<td class="w3-center" width="10%"><b>적립금</b></td>
    	<td class="w3-center" width="20%"><b>관리</b></td>
    
    <c:forEach var="user" items="${userList}">
   
    			<tr >
    			<td class="w3-center" >${user.num}</td>
    			<td class="w3-center" >${user.ulevel}</td>
    			<td class="w3-center" >${user.id}</td>
    			<td class="w3-center" >${user.name}</td>
    			<td class="w3-center" >${user.cdate}</td>
    			<td class="w3-center">${user.point}</td>
    			<td class="w3-center" >
    			
    			
    			<form method="post" action="admin_userModify" style="display: inline-block;">
    			<input type="hidden" name="pageNum" value="${pageNum}">
    			<input type="hidden" name="id" value="${user.id}">
    			<input type="hidden" name="pwd" value="${user.pwd}">
    			<input type="hidden" name="select" value="auserlist">
    			<button class="w3-button w3-padding-small w3-black tablink w3-hover-green w3-small w3-padding-small" 
    			type="submit" onclick="openAdminPage(event,'userModify')"  >수정</button></form>
    			
    			
    			<form method="post" action="deleteUserPro" style="display: inline-block;"><button class="w3-padding-small w3-hover-red
    			 w3-button w3-small w3-black w3-padding-small" type="submit"  >탈퇴</button>
    			 <input type="hidden" name="pageNum" value="${pageNum}">
    			<input type="hidden" name="id" value="${user.id}">
    			<input type="hidden" name="pwd" value="${user.pwd}"></form></td>

    		</tr>
    		</c:forEach>
    </table>
    
    <!-- 하단 페이징    -->
    <div class="w3-section">
    
    	<c:if test="${count>0}">
   
    	
    	<c:if test="${startPage>bottomLine}">
    		
    		<a href="userlist?pageNum=${startPage-bottomLine}&select=auserlist" class="w3-bar-item w3-button w3-hover-black">«</a>
    		</c:if>
    		
    		<c:forEach var="i" begin="${startPage }" end="${endPage}">
    		<c:if test="${i!=currentPage }">
    		
    		<a href="userlist?pageNum=${i}&select=auserlist" class="w3-bar-item w3-button w3-hover-black">${i}</a>
    		</c:if>
    		<c:if test="${i==currentPage }">
    		
    		
    		<a href="userlist?pageNum=${i}&select=auserlist" class="w3-bar-item w3-black w3-button">${i}</a>
    		
    		
    		</c:if>
    		
    		<c:if test="${endPage<pageCount}">
    	
    		<a href="userlist?pageNum=${startPage+bottomLine}&select=auserlist" class="w3-bar-item w3-button w3-hover-black">»</a>
    			
    			</c:if>
    		
    		
    		</c:forEach>
    		
    			</c:if>
    		</div>
    		
    	
    	</c:if>
    		
    	