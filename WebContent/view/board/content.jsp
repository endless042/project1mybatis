<%@page import="board.BoardDataBean"%>
<%@page import="board.BoardDBBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <style>
.w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}
pre {
font-family: "Montserrat", sans-serif;
}

</style>
</head>

<body> <center>

<div class="container w3-responsive w3-padding-64 ">
<div  style="padding-bottom: 64px;">
 
<table class="w3-table w3-bordered w3-small " style="width: 90%;">
<tr ><td colspan="4"><h5><b>${article.subject}</b></h5></td></tr>
<tr height="30">
<td width="25%" align="center"><b>글번호</b></td>
<td width="25%" align="center">${article.num}</td>
<td width="25%" align="center"><b>조회수</b></td>
<td width="25%" align="center">${article.readcount}</td>
</tr>

<tr height="30">
<td width="25%" align="center"><b>작성자</b></td>
<td width="25%" align="center"><span class="w3-tag ">${article.writer}</span></td>
<td width="25%" align="center"><b>작성일</b></td>
<td width="25%" align="center" >${article.reg_date}</td>
</tr>


<tr height="30">
<td width="100%" align="left" colspan="4" style="padding: 50px;"><pre>${article.content}</pre></td></tr>

<tr height="30">
<td colspan="4" class="w3-center">
<c:if test="${loginId==article.writer || loginId=='admin'}">

<input type="button" class="w3-button w3-black " value="수정" onclick="document.location.href='updateForm?num=${article.num}&pageNum=${pageNum}&boardid=${boardid}'">
&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" class="w3-button w3-black " value="삭제" onclick="document.location.href='deleteForm?num=${article.num}&pageNum=${pageNum}&boardid=${boardid}'">
&nbsp;&nbsp;&nbsp;&nbsp;</c:if>
<input type="button" class="w3-button w3-black " value="답글" onclick="document.location.href='writeForm?num=${num}&ref=${ref}&re_step=${re_step}&re_level=${re_level}&pageNum=${pageNum}&boardid=${boardid}'">
&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" class="w3-button w3-black " value="목록" onclick="document.location.href='list?pageNum=${pageNum}&boardid=${boardid}'">
</td></tr><tr><td colspan="4"><b>댓글</b></td></tr>
<tr><td colspan="4">
 <%-- <jsp:include page="../../reply/list.jsp"></jsp:include> --%></td></tr>
</table>


</center>
 
