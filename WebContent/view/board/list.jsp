<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>게시판</title>
<style type="text/css">
a {
text-decoration: none;
}

.w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}

</style>
</head>
<body>
 

 
 
    
    <p class="w3-left" style="padding-left:30px;">
    </p>
    
    <div class="w3-container w3-padding-64">
 
 	
    	<p class="w3-right w3-padding-right-large">
    	<c:if test="${boardid=='1'}">
    	
    		<c:if test="${userLevel=='0'}">
    	<a href="writeForm?boardid=${boardid }"><button class="w3-button w3-green w3-small">글쓰기</button></a>
    		</c:if>
    	
    	</c:if>
    	<c:if test="${boardid!='1' }">
    	<a href="writeForm?boardid=${boardid }"><button class="w3-button w3-green w3-small">글쓰기</button></a>
    	</c:if>
    	
    	</p>
    	
    	
    	<c:if test="${count==0}">
    	
    	<table class="w3-table w3-border w3-hoverable w3-center w3-small " width="90%">
    	<tr class="w3-light-grey">
    	<td class="w3-center">저장된 글이 없습니다.</td>
    	
    	</table>
    	</c:if>
    	
    	<c:if test="${count!=0}">
    	
    	<span class="w3-small">(전체글:${count})<p/></span>
    	<table class="w3-table  w3-border-top w3-border-bottom w3-small" width="80%">
    	<tr class="  w3-border-bottom">
    	<td class="w3-center" width="50"><b>번호</b></td>
    	<td class="w3-center" width="250"><b>제목</b></td>
    	<td class="w3-center" width="100"><b>작성자</b></td>
    	<td class="w3-center" width="150"><b>작성일</b></td>
    	<td class="w3-center" width="50"><b>조회</b></td>
    	
    	
    	
    	  <c:forEach var="article" items="${articleList}">
 
    			<tr height="30" >
    		
    			<td class="w3-center" width="50">${number}</td>
    			<c:set var="number" value="${number-1}"/>
    			
    			<td width="250">
    			
    			<c:if test="${article.re_level>0}">
    			
    			
    			<img src="../../images/level.gif" width="${15*article.re_level}" height="16">
    			&#8600;
    			
    			</c:if>
    			
    			<c:if test="${article.re_level==0}">
    		<img src="../../images/level.gif" width="0" height="16">
    				
    				</c:if>
    				
    				 <a href="content?num=${article.num}&pageNum=${currentPage}&boardid=${boardid}">
    				${article.subject}</a> </td>
    				<td class="w3-center" width="100"><span class="w3-tag">${article.writer}</span></td>
    				<td class="w3-center" width="150">
    				${article.reg_date}</td>
    				
    				<td class="w3-center" width="50">${article.readcount }</td>
    				
    				
 
    		</tr>
    		</c:forEach>
    	
    	
    	</table>
    	
    	
    	
    	</c:if>
    	
    	
    	<!-- 하단 페이징  -->
    	<div class="w3-center w3-section w3-small">
    	
    	<c:if test="${startPage>bottomLine}">
    		
    		 <a href="list?pageNum=${startPage-bottomLine}" class="w3-bar-item w3-button w3-hover-black">«</a>
    	
    		</c:if>
    	
    		<c:forEach var="i" begin="${startPage }" end="${endPage }">
    		
    		<c:if test="${i!=currentPage}">
    		  <a href="list?pageNum=${i}"
    		 class="w3-bar-item w3-button w3-hover-black">${i}</a> 
    		 
    		 
    		 	</c:if>
    		
    		
    		<c:if test="${i==currentPage}">
    		  <a href="list?pageNum=${i}" 
    		  class="w3-bar-item w3-black w3-button">${i}</a> 
    		</c:if>
    		
    		</c:forEach>
    	
    	
    	<c:if test="${endPage<pageCount}">
    		
    		
    		 <a href="list?pageNum=${ startPage+bottomLine}" class="w3-bar-item w3-button w3-hover-black">»</a>
    			</c:if>
    	
    		 
    		 
    	</div>
    	</div>
    	 
  <!-- End page content -->
 