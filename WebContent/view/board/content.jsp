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
 <style>
.w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}


</style>
</head>
<%
	String boardid=request.getParameter("boardid");
	if(boardid==null) boardid="1";

%>
<% 
	int num=Integer.parseInt(request.getParameter("num"));
	String pageNum=request.getParameter("pageNum");
	if(pageNum==null||pageNum==""){
		pageNum="1";}
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	try{
		BoardDBBean dbPro=BoardDBBean.getInstance();
		BoardDataBean article=dbPro.getArticle(num,boardid,"content");
		int ref=article.getRef();
		int re_step=article.getRe_step();
		int re_level=article.getRe_level();
		
		%>
	

<body> <center>

<div class="container w3-responsive w3-padding-64 ">
<div  style="padding-bottom: 64px;">
 
<table class="w3-table w3-bordered w3-small " style="width: 90%; "  >
<tr ><td colspan="4"><h5><b><%= article.getSubject()%></b></h5></td></tr>
<tr height="30">
<td width="25%" align="center"><b>글번호</b></td>
<td width="25%" align="center"><%=article.getNum() %></td>
<td width="25%" align="center"><b>조회수</b></td>
<td width="25%" align="center"><%= article.getReadcount()%></td>
</tr>

<tr height="30">
<td width="25%" align="center"><b>작성자</b></td>
<td width="25%" align="center"><%=article.getWriter() %></td>
<td width="25%" align="center"><b>작성일</b></td>
<td width="25%" align="center" ><%= sdf.format(article.getReg_date())%></td>
</tr>


<tr height="30">
<td width="100%" align="left" colspan="4" style="padding: 50px;"><pre><%= article.getContent() %></pre></td></tr>

<tr height="30">
<td colspan="4" class="w3-center">
<input type="button" class="w3-button w3-black " value="수정" onclick="document.location.href='updateForm.jsp?num=<%=article.getNum()%>&pageNum=<%=pageNum%>'">
&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" class="w3-button w3-black " value="삭제" onclick="document.location.href='deleteForm.jsp?num=<%=article.getNum()%>&pageNum=<%=pageNum%>'">
&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" class="w3-button w3-black " value="답글" onclick="document.location.href='writeForm.jsp?num=<%=num%>&ref=<%=ref%>&re_step=<%=re_step%>&re_level=<%=re_level%>&pageNum=<%=pageNum%>'">
&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" class="w3-button w3-black " value="목록" onclick="document.location.href='list.jsp?pageNum=<%=pageNum%>'">
</td></tr><tr><td colspan="4"><b>댓글</b></td></tr>
<tr><td colspan="4">
 <%-- <jsp:include page="../../reply/list.jsp"></jsp:include> --%></td></tr>
</table>

 <!-- comment  -->
 
 <div   role="group" aria-label="..." style="width: 100%">
 <textarea class="form-control" rows="3" id= commentContent" placeholder="댓글을 입력하세요."
 style="width: 100%"></textarea>
 <div  role="group" aria-label="...">
 	<c:if test="${id==null }">
 		<input type="button" class="w3-button" value="댓글 쓰기" disabled="disabled">
 		
 		</c:if>
 		<c:if test="${id!=null }">
 		<input type="button" class="w3-button" value="댓글 쓰기" id="commentWrite">
 		</c:if>
 		<input type="button" class="w3-button" value="댓글 읽기(${article.commentCount})"
 		onclick="getComment(1,event)" id="commentRead">
 		
 		
 </div>
 
 
 </div>
 
 <div role="group" aria-label="..." style="margin-top: 10px; width:100%;" >
 <div id="showComment" style="text-align: center;"></div>
 
 </div>




</div>
 </div>

<script>
	jQuery(document).ready(function(){
		if(${id==null}){
			alert("게시판을 이용하시려면 로그인하셔야 합니다.");
			location.href="<%=request.getContextPath()%>/view/login.jsp";
		}
	});
	
	$.ajaxSetup({
		type:"POST",
		async:true,
		dataType:"json",
		error:function(xhr){
			console.log("error html="+xhr.statusText);
		}
	});
	
	$(function(){
		$("#commentWrite").on("click",function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/"
			})
		})
		
	}

</script>

</center>
 
<% }catch(Exception e){} %>