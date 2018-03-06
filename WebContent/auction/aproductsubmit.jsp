<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<html>
<head><link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script language="JavaScript" type="text/JavaScript">


function linkToOpener(URL){
if (window.opener && !window.opener.closed)
window.opener.location = URL;
window.close();
}

</script>
<%
String num=request.getParameter("num");

String pageNum=request.getParameter("pageNum");

%>
</head>
<body>
 
 <header class="w3-container w3-black"> 
        <h5>입찰가를 입력하세요</h5>
      </header><br><div class="w3-padding-32 w3-center w3-margin-left w3-margin-right">
      
      <form action="javascript:linkToOpener('<%=request.getContextPath()%>/page/auctionSubmit?num=<%=num%>&pageNum=<%=pageNum %>&select=auction&part=content');" method="post">
<input class="w3-input w3-border w3-margin-top" type="number"  placeholder="가격 입력" name="price">
<br>
<input type="hidden" name="num" value="<%=num%>">
<input type="hidden" name="pageNum" value="<%=pageNum%>">

<button class="w3-button w3-black" type="submit" >보내기</button>
</form>
</div>
</body>
</html>
 
