<!DOCTYPE html>
<%@page import="db.UserlistDataBean"%>
<%@page import="db.UserlistDBBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String pageNum=request.getParameter("pageNum");
     if(pageNum==null||pageNum==""){
    	pageNum="1";}
     String levelCk=(String)session.getAttribute("levelCk");
     if(levelCk==null){
    	 levelCk="1";
    	 }
     String select=request.getParameter("select");
     
 	String id=request.getParameter("id");
     String pwd=request.getParameter("pwd");
     UserlistDBBean userPro=UserlistDBBean.getInstance();
		UserlistDataBean user=userPro.getUser(id,pwd);
		
		
    	%>
<html>
<title>Plant shop</title>
<meta charset="UTF-8">
<% 

String modify="";
if(!levelCk.equals("0")){%>
<script>
alert("접근 권한이 없습니다.");
history.go(-1);		
</script>

<%} %>

<jsp:include page="/menu.jsp"/>
 

<div class="w3-container w3-padding-64"  width="100%"  >
  

 <div class="w3-card-4 w3-center w3-padding-24"  style="max-width:900px; padding:20px;" >
      
 
  
  
    <div class="w3-bar w3-border w3-small" style="max-width:900px; width:90%;">
    <button style="width:25%" class="w3-bar-item w3-button tablink <%=(select!=null&&select.equals("auserlist"))?"w3-green":"" %>  " onclick="location.href='admin_userlist.jsp?select=auserlist';">회원목록</button>
    <button style="width:25%" class="w3-bar-item w3-button tablink w3-hide-small <%=(select!=null&&select.equals("aauction"))?"w3-green":"" %> " onclick="location.href='admin_auction.jsp?select=aauction';">경매</button>
    <button style="width:25%" class="w3-bar-item w3-button tablink w3-hide-small <%=(select!=null&&select.equals("agpurchase"))?"w3-green":"" %> " onclick="location.href='admin_gpurchase.jsp?select=agpurchase';">공동구매</button>
         <button style="width:25%" class="w3-bar-item w3-button tablink w3-hide-small <%=(select!=null&&select.equals("aboard"))?"w3-green":"" %> " onclick="location.href='admin_board.jsp?select=aboard';">게시판</button>
        <a href="javascript:void(0)" class="w3-bar-item w3-button w3-right w3-hide-large w3-hide-medium" onclick="myFunction()">&#9776;</a>
  </div>
  <div id="demo" class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium">
  <a href="#"  onclick="location.href='admin_auction.jsp?select=aauction';" class="w3-bar-item w3-button">경매</a>
  <a href="#" onclick="location.href='admin_gpurchase.jsp?select=agpurchase';" class="w3-bar-item w3-button">공동구매</a>
  <a href="#" onclick="location.href='admin_board.jsp?select=aboard';" class="w3-bar-item w3-button">게시판</a>
</div>


