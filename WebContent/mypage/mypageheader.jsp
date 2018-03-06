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


<jsp:include page="../common/menu.jsp"/>
 

<div class="w3-container w3-padding-64"  width="100%"  >
  

 <div class="w3-card-4 w3-center w3-padding-24 w3-section"  style="padding:50px;" >
      

  
    <div class="w3-bar w3-border w3-small w3-section" style="max-width:900px; width:90%;">
    <button style="width:25%" class="w3-bar-item w3-button tablink <%=(select!=null&&select.equals("myinfo"))?"w3-green":"" %>  " onclick="location.href='mypage?select=myinfo';">내 정보</button>
    <button style="width:25%" class="w3-bar-item w3-button tablink w3-hide-small <%=(select!=null&&select.equals("order"))?"w3-green":"" %> " onclick="location.href='orderlist?select=order';">주문정보</button>

    <button style="width:25%" class="w3-bar-item w3-button tablink w3-hide-small <%=(select!=null&&select.equals("cart"))?"w3-green":"" %> " onclick="location.href='cartlist?select=cart';">찜목록</button>
         <button style="width:25%" class="w3-bar-item w3-button tablink w3-hide-small <%=(select!=null&&select.equals("articles"))?"w3-green":"" %> " onclick="location.href='myarticle';">내가 쓴 글</button>
        <a href="javascript:void(0)" class="w3-bar-item w3-button w3-right w3-hide-large w3-hide-medium" onclick="myFunction()">&#9776;</a>
  </div>
  
  
  
  
  <div id="demo" class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium">
  <a href="#"  onclick="location.href='orderlist?select=order';" class="w3-bar-item w3-button">주문정보</a>
  <a href="#" onclick="location.href='cartlist?select=cart';" class="w3-bar-item w3-button">장바구니</a>
  <a href="#" onclick="location.href='myarticle';" class="w3-bar-item w3-button">내가 쓴 글</a>
</div>


