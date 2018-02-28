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


<jsp:include page="/menu.jsp"/>
 

<div class="w3-container w3-padding-64"  width="100%"  >
  

 <div class="w3-card-4 w3-center w3-padding-24"  style="max-width:900px; padding:20px;" >
      
 
  
  
    <div class="w3-bar w3-border w3-small" style="max-width:900px; width:90%;">
    <button style="width:25%" class="w3-bar-item w3-button tablink <%=(select!=null&&select.equals("myinfo"))?"w3-green":"" %>  " onclick="location.href='mypage.jsp?select=myinfo';">내 정보</button>
    <button style="width:25%" class="w3-bar-item w3-button tablink w3-hide-small <%=(select!=null&&select.equals("order"))?"w3-green":"" %> " onclick="location.href='mypage.jsp?select=order';">주문정보</button>
    <button style="width:25%" class="w3-bar-item w3-button tablink w3-hide-small <%=(select!=null&&select.equals("cart"))?"w3-green":"" %> " onclick="location.href='mypage.jsp?select=cart';">장바구니</button>
         <button style="width:25%" class="w3-bar-item w3-button tablink w3-hide-small <%=(select!=null&&select.equals("articles"))?"w3-green":"" %> " onclick="location.href='mypage.jsp?select=articles';">내가 쓴 글</button>
        <a href="javascript:void(0)" class="w3-bar-item w3-button w3-right w3-hide-large w3-hide-medium" onclick="myFunction()">&#9776;</a>
  </div>
  <div id="demo" class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium">
  <a href="#"  onclick="location.href='admin_auction.jsp?select=aauction';" class="w3-bar-item w3-button">주문정보</a>
  <a href="#" onclick="location.href='admin_gpurchase.jsp?select=agpurchase';" class="w3-bar-item w3-button">장바구니</a>
  <a href="#" onclick="location.href='admin_board.jsp?select=aboard';" class="w3-bar-item w3-button">내가 쓴 글</a>
</div>


