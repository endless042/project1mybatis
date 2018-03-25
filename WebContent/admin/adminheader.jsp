<!DOCTYPE html>
<%@page import="userlist.UserlistDataBean"%>
<%@page import="userlist.UserlistDBBean"%>
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

<jsp:include page="../common/menu.jsp"/>
 

<div class="w3-container w3-padding-64"  width="100%"  >
  

 <div class="w3-card-4 w3-center w3-padding-24 w3-section"  style="padding:50px;" >
      
 
 
  <div class="w3-container w3-bar w3-show-inline-block w3-center w3-border w3-clear w3-small" style="width: 90%; padding:0;">
  
  <div class="w3-dropdown-hover w3-center" >
    <button class="w3-button <%=(select!=null&&select.equals("auserlist"))?"w3-green":"w3-white" %> w3-center " onclick="location.href='userlist?select=auserlist';">회원목록</button>
    <!-- <div class="w3-dropdown-content w3-bar-block w3-border" >
      <a href="#" class="w3-bar-item w3-button">Link 1</a>
      <a href="#" class="w3-bar-item w3-button">Link 2</a>
      <a href="#" class="w3-bar-item w3-button">Link 3</a>
    </div> -->
  </div>
 
   <div class="w3-dropdown-hover ">
    <button class="w3-button  <%=(select!=null&&select.equals("aauction"))?"w3-green":"w3-white" %> " onclick="location.href='alist?select=aauction';">경매</button>
    <div class="w3-dropdown-content w3-bar-block w3-border">
     
      <a href="alist?select=aauction" class="w3-bar-item w3-button">경매 상품 관리</a>
       <a href="auction?select=aauction" class="w3-bar-item w3-button">경매 상품 등록</a>
     <a href="plist?select=aauction&pcode=a" class="w3-bar-item w3-button">경매 결제 내역</a>
    </div>
  </div>
   <div class="w3-dropdown-hover ">
    <button class="w3-button  <%=(select!=null&&select.equals("agpurchase"))?"w3-green":"w3-white" %> "  onclick="location.href='glist?select=agpurchase';">공동구매</button>
    <div class="w3-dropdown-content w3-bar-block w3-border">
    <a href="glist?select=agpurchase" class="w3-bar-item w3-button">공동구매 상품 관리</a>
      <a href="gpurchase?select=agpurchase" class="w3-bar-item w3-button">공동구매 상품 등록</a>
       <a href="plist?select=agpurchase&pcode=g" class="w3-bar-item w3-button">공동구매 결제 내역</a>
    </div>
  </div>
   <div class="w3-dropdown-hover ">
    <button class="w3-button <%=(select!=null&&select.equals("aarticles"))?"w3-green":"w3-white" %>">후기/문의</button>
    <div class="w3-dropdown-content w3-bar-block w3-border">
      <a href="#" class="w3-bar-item w3-button">후기글 답변하기</a>
      <a href="#" class="w3-bar-item w3-button">문의글 답변하기</a>
      
    </div>
  </div>
  
</div>
  
  
<!--   기존버튼   -->   
  
  <%-- 
    <div class="w3-bar w3-border w3-small w3-section" style="max-width:900px; width:90%;">
    <button  class="w3-bar-item w3-button tablink <%=(select!=null&&select.equals("auserlist"))?"w3-green":"" %>  " onclick="location.href='userlist?select=auserlist';">회원목록</button>
    <button  class="w3-bar-item w3-button tablink w3-hide-small <%=(select!=null&&select.equals("aauction"))?"w3-green":"" %> " onclick="location.href='auction?select=aauction';">경매등록</button>
     <button  class="w3-bar-item w3-button tablink w3-hide-small <%=(select!=null&&select.equals("aprolist"))?"w3-green":"" %> " onclick="location.href='alist?select=aprolist';">경매관리</button>
    
    <button  class="w3-bar-item w3-button tablink w3-hide-small <%=(select!=null&&select.equals("agpurchase"))?"w3-green":"" %> " onclick="location.href='gpurchase?select=agpurchase';">공동구매등록</button>
    <button  class="w3-bar-item w3-button tablink w3-hide-small <%=(select!=null&&select.equals("gprolist"))?"w3-green":"" %> " onclick="location.href='glist?select=gprolist';">공동구매관리</button>
           <button  class="w3-bar-item w3-button tablink w3-hide-small <%=(select!=null&&select.equals("olist"))?"w3-green":"" %> " onclick="location.href='olist?select=olist';">회원참여내역</button>
        <button  class="w3-bar-item w3-button tablink w3-hide-small <%=(select!=null&&select.equals("plista"))?"w3-green":"" %> " onclick="location.href='plist?select=plista&pcode=a';">결제된경매</button>
                <button  class="w3-bar-item w3-button tablink w3-hide-small <%=(select!=null&&select.equals("plistg"))?"w3-green":"" %> " onclick="location.href='plist?select=plistg&pcode=g';">결제된공동구매</button>
        
         <button  class="w3-bar-item w3-button tablink w3-hide-small <%=(select!=null&&select.equals("aboard"))?"w3-green":"" %> " onclick="location.href='board?select=aboard';">게시판</button>
        <a href="javascript:void(0)" class="w3-bar-item w3-button w3-right w3-hide-large w3-hide-medium" onclick="myFunction()">&#9776;</a>
  </div>
  <div id="demo" class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium">
  <a href="#"  onclick="location.href='admin_auction.jsp?select=aauction';" class="w3-bar-item w3-button">경매</a>
  <a href="#" onclick="location.href='admin_gpurchase.jsp?select=agpurchase';" class="w3-bar-item w3-button">공동구매</a>
  <a href="#" onclick="location.href='admin_board.jsp?select=aboard';" class="w3-bar-item w3-button">게시판</a>
</div>

 --%>
