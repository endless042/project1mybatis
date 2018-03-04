<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<title>Plant shop</title>
<meta charset="UTF-8">

 
 <style>
 .w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}
 pre {
font-family: "Montserrat", sans-serif;
}
 
 </style>
 <!-- Section -->
  <div class="w3-container w3-content w3-padding" style="max-width:850px" id="contact">

<div class="w3-cell-row w3-margin-bottom" >

<div class="w3-bar w3-white "><span class="w3-tag w3-medium w3-black w3-margin-top w3-margin-right">${gproduct.re }차</span>
<span class="w3-tag w3-xxlarge w3-white w3-margin-top w3-margin-right"><h4>${gproduct.title }</h4></span><hr></div>
 <!-- 사진쪽 div  -->
  <div class="w3-container w3-half w3-cell w3-padding">
  <div class="w3-display-container w3-text-white">
    <img src="<%=request.getContextPath() %>/images/alocasia.PNG" alt="Lights" style="width:100%">
   <span class="w3-tag w3-display-topleft">
     <c:if test="${gproduct.state=='1'}">
    예정
    </c:if>
       <c:if test="${gproduct.state=='2'}">
    진행
    </c:if>
       <c:if test="${gproduct.state=='3'}">
    마감
    </c:if></span>

  </div></div>

<!-- 상세정보쪽 div -->
  <div class="w3-container w3-half w3-cell w3-cell-bottom w3-small " >
    <table ><tr><td class="w3-border-bottom">
    
    <p><b>품명 : </b>${gproduct.name }<br>
    
    	<b>원산지 : </b>${gproduct.origin }<br>
    	<b>분류 : </b>${gproduct.category }<br>
    	<b>크기 : </b>약 ${gproduct.height } cm<br>
   </td></tr><tr><td class="w3-border-bottom">
    <p><b>배송방법 : </b>
    <c:if test="${gproduct.deliv=='1'}">
    픽업만 가능
    </c:if>
       <c:if test="${gproduct.deliv=='2'}">
    픽업만 가능
    </c:if>
       <c:if test="${gproduct.deliv=='3'}">
    택배 or 픽업
    </c:if></p>
    
   </td><tr>
   <tr><td class="w3-border-bottom"> 
   
      <p><b>진행기간 : </b>${gproduct.sdate } ~ ${gproduct.edate }</p>
 </td><tr><tr><td class="w3-border-bottom">
    <p><label><b>진행상황</b></label><br>
    
    <div class="w3-light-grey w3-tiny" >
  <div class="w3-container w3-red w3-center w3-margin-bottom" style="width:50%">${gproduct.count/gproduct.goal}%</div>
</div> <center>목표 수량 ${gproduct.goal }개 중 현재  ${gproduct.count }개 달성</center><br>
</td></tr><tr><td class="w3-border-bottom" >

<p>

<select class="w3-select w3-border w3-margin-right" required="required" style="width: 100px;" name="quantity">
	<option  selected="selected" >수량 선택</option>
	<option onselect="">1</option>
    <option>2</option>
    <option>3</option>
    <option>4</option>
    <option>5</option>
    </select><span class="w3-tag w3-large w3-white " style="min-width: 200px;">총 가격 : 0 원</span>
</p>

</td>
</tr>
<tr><td>

<div class="w3-bar w3-white w3-section  ">
<button style="width: 33%;" class="w3-button w3-bar-item w3-green  w3-right  w3-border-top w3-border-left w3-border-bottom" >입찰하기</button>
<button  style="width: 33%;" class="w3-button w3-bar-item  w3-white   w3-right w3-border-top w3-border-left w3-border-bottom " onclick="location.href='addCart?num=${gproduct.num}&pcode=g'">찜하기</button>
<button  style="width: 33%;"  class="w3-button w3-bar-item w3-white   w3-border-top w3-border-left w3-border-bottom w3-right "  >공유</button>

 
   
</div>
</td></tr>
</table>

</div>



  
  </div>
<hr>

<div class="w3-bar w3-border w3-small" >
  <a href="gcontent?part=content&pageNum=${pageNum }&num=${num}" style="width:25%" class="w3-bar-item w3-button <%=request.getParameter("part").equals("content")?"w3-green":"" %> w3-border-right">정보</a>
  <a href="gcontent?part=qna&pageNum=${pageNum }&num=${num}" style="width:25%" class="w3-bar-item w3-button w3-hide-small  w3-border-right <%=request.getParameter("part").equals("qna")?"w3-green":"" %> ">문의</a>
  <a href="gcontent?part=review&pageNum=${pageNum }&num=${num}" style="width:25%" class="w3-bar-item w3-button w3-hide-small  w3-border-right  <%=request.getParameter("part").equals("review")?"w3-green":"" %> ">후기</a>
  <a href="gcontent?part=reply&pageNum=${pageNum }&num=${num}" style="width:25%" class="w3-bar-item w3-button w3-hide-small  <%=request.getParameter("part").equals("reply")?"w3-green":"" %> ">댓글</a>
  <a href="javascript:void(0)" class="w3-bar-item w3-button w3-right w3-hide-large w3-hide-medium" onclick="myFunction()">&#9776;</a>
</div>

<div id="demo" class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium">
  <a href="gcontent?part=qna&pageNum=${pageNum }&num=${num}" class="w3-bar-item w3-button">문의</a>
  <a href="gcontent?part=review&pageNum=${pageNum }&num=${num}" class="w3-bar-item w3-button">후기</a>
  <a href="gcontent?part=reply&pageNum=${pageNum }&num=${num}" class="w3-bar-item w3-button">댓글</a>
</div>

<c:if test="${part=='content'}">
  <div class="w3-container w3-section  " id="content">
  
  <pre><p>${gproduct.content }</p></pre>
 
  </div>
    </c:if>
 
<c:if test="${part=='qna'}">
  <div class="w3-container w3-section  " id="qna">
  <jsp:include page="/list.jsp"></jsp:include>
  </div>
  </c:if>
 
  <c:if test="${part=='review'}">
   <div class="w3-container w3-section  " id="review">
  <jsp:include page="/list.jsp"></jsp:include>
  </div>
    </c:if>
 
 <c:if test="${part=='reply'}"> 
   <div class="w3-container w3-section  " id="reply">
  <jsp:include page="/reply/list.jsp"></jsp:include>
  </div>
    </c:if>
 



  

</div>


 


 
  <!-- End page content -->
 

<script>
function myFunction() {
    var x = document.getElementById("demo");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else { 
        x.className = x.className.replace(" w3-show", "");
    }
}
</script>

 
