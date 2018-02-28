<%@page import="board.BoardDataBean"%>
<%@page import="board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <% request.setCharacterEncoding("utf-8"); %>
     <%
    String boardid=request.getParameter("boardid");
    if(boardid==null){
    	boardid="1";
    }
 
	int num=Integer.parseInt(request.getParameter("num"));
	String pageNum=request.getParameter("pageNum");
	if(pageNum==null||pageNum==""){
		pageNum="1";}
	
	
	try{
		BoardDBBean dbPro=BoardDBBean.getInstance();
		BoardDataBean article=dbPro.getArticle(num,boardid,"update");

		%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"></head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}


</style>
</head>
<body>

<div class="w3-container" style="padding-bottom: 64px;">

<center><h4 class="w3-wide w3-center">글 수정</h4>
<br>
<form method="post" name="writeform" action="<%=request.getContextPath() %>/view/board/updatePro.jsp" >
<input type="hidden" name="boardid" value="<%=boardid%>">
<input type="hidden" name="num" value="<%=num%>">
<input type="hidden" name="pageNum" value="<%=pageNum%>">



<table class="w3-table w3-bordered  w3-bordered w3-small"  style="width:90%;" >
   
   <tr>
      <td  width="70" class=" w3-center "  ><label><b>이 름</b></label></td>
    <td  width="330">
       <input type="text"  class="w3-input w3-border-0 w3-hover-light-grey" style="width:300px;" size="10" maxlength="12" name="writer" value="<%=article.getWriter()%>"></td>
  </tr>
  <tr>
    <td  width="70" class=" w3-center "    ><label><b>제 목</b></label>
    </td>
    <td width="330">
 
 
       <input type="text" size="40" maxlength="50" name="subject"  class="w3-input w3-border-0 w3-hover-light-grey" value="<%=article.getSubject()%>">
	
   
   </td>
  </tr>
  <tr>
    <td  width="70" class=" w3-center " ><label><b>Email</b></label></td>
    <td  width="330">
       <input type="text" size="40" maxlength="30" name="email" class="w3-input w3-border-0 w3-hover-light-grey" value="<%=article.getEmail()%>"></td>
  </tr>
  <tr>
   <td  width="70" class=" w3-center " ><label><b>내 용</b></label></td>
    <td  width="330" >
     <textarea name="content" rows="13"  cols="40" class="w3-input w3-border-0 w3-hover-light-grey"><%=article.getContent() %></textarea> </td>
  </tr>
  <tr>
   <td  width="70" class=" w3-center " ><label><b>비밀번호</b></label></td>
    <td  width="330" >
     <input type="password" size="8" maxlength="12" name="passwd" style="width:300px;"  class="w3-input w3-border-0 w3-hover-light-grey" > 
	 </td>
  </tr>
<tr>      
 <td colspan=2  class="w3-center"> 
  <input type="submit" class="w3-button w3-hover-black" value="글수정" >  
  <input type="reset" class="w3-button w3-hover-black" value="다시작성">
  <input type="button" class="w3-button w3-hover-black" value="목록보기" OnClick="window.location='list.jsp'">
</td></tr></table>    
     
</form>  </center></div>  
<%}catch(Exception e){} %>

 
  <!-- End page content -->
 