<!DOCTYPE html>
<%@page import="userlist.UserlistDataBean"%>
<%@page import="userlist.UserlistDBBean"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<html>
<title>Plant shop</title>
<meta charset="UTF-8">
 
 
 <c:if test="${loginId==null}">
 
		<script>
		alert("회원만 이용 가능합니다.");
		location.href='../user/login';
		</script>
	</c:if>

	
 <jsp:include page="mypageheader.jsp"></jsp:include>
<div class="w3-container w3-center"  width="100%"  >
  

 
      




<h5><b>문의</b></h5>

 <table class="w3-table w3-bordered w3-small">
 <tr class="w3-border-top"><td class="w3-center" width="50px;"  >번호</td><td class="w3-center">사진</td><td  class="w3-center">상품명</td>
<td class="w3-center">상태</td><td class="w3-center">찜한 날짜</td></tr>



<tr><td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
8
</div></span></td>

<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
<img src="../images/peperomia.PNG" width="100px"></div></span></td>
<td><span style="width: 100%;"><div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <a href="surveyview.jsp">요즘 텀블러에서 자주 보이는 이 식물</a>
</div></span></td>

<td class="w3-center"><span style="width: 100%;"><div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <span class="w3-tag w3-blue">진행</span>
</div></span></td><td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 2018-02-22
</div></span></td></tr>

<tr><td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
8
</div></span></td>

<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
<img src="../images/peperomia.PNG" width="100px"></div></span></td>
<td><span style="width: 100%;"><div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
  요즘 텀블러에서 자주 보이는 이 식물
</div></span></td>

<td class="w3-center"><span style="width: 100%;"><div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <span class="w3-tag w3-black">마감</span>
</div></span></td><td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 2018-02-22
</div></span></td></tr>



 </table>
 
 <!-- Pagination -->
  <div class="w3-center w3-padding-32 w3-small">
    <div class="w3-bar">
      <a href="#" class="w3-bar-item w3-button w3-hover-black">«</a>
      <a href="#" class="w3-bar-item w3-black w3-button">1</a>
      <a href="#" class="w3-bar-item w3-button w3-hover-black">2</a>
      <a href="#" class="w3-bar-item w3-button w3-hover-black">3</a>
      <a href="#" class="w3-bar-item w3-button w3-hover-black">4</a>
      <a href="#" class="w3-bar-item w3-button w3-hover-black">»</a>
    </div>
  </div>
  
  

<h5><b>후기</b></h5>


 <table class="w3-table w3-bordered w3-small">
 <tr class="w3-border-top"><td class="w3-center" width="50px;"  >번호</td><td class="w3-center">사진</td><td  class="w3-center">상품명</td>
<td class="w3-center">상태</td><td class="w3-center">찜한 날짜</td></tr>



<tr><td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
8
</div></span></td>

<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
<img src="../images/peperomia.PNG" width="100px"></div></span></td>
<td><span style="width: 100%;"><div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <a href="surveyview.jsp">요즘 텀블러에서 자주 보이는 이 식물</a>
</div></span></td>

<td class="w3-center"><span style="width: 100%;"><div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <span class="w3-tag w3-blue">진행</span>
</div></span></td><td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 2018-02-22
</div></span></td></tr>

<tr><td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
8
</div></span></td>

<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
<img src="../images/peperomia.PNG" width="100px"></div></span></td>
<td><span style="width: 100%;"><div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
  요즘 텀블러에서 자주 보이는 이 식물
</div></span></td>

<td class="w3-center"><span style="width: 100%;"><div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <span class="w3-tag w3-black">마감</span>
</div></span></td><td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 2018-02-22
</div></span></td></tr>



 </table>
 
 <!-- Pagination -->
  <div class="w3-center w3-padding-32 w3-small">
    <div class="w3-bar">
      <a href="#" class="w3-bar-item w3-button w3-hover-black">«</a>
      <a href="#" class="w3-bar-item w3-black w3-button">1</a>
      <a href="#" class="w3-bar-item w3-button w3-hover-black">2</a>
      <a href="#" class="w3-bar-item w3-button w3-hover-black">3</a>
      <a href="#" class="w3-bar-item w3-button w3-hover-black">4</a>
      <a href="#" class="w3-bar-item w3-button w3-hover-black">»</a>
    </div>
  </div>
 </div>
  
 </div>

</div>



 
  <!-- End page content -->
 
 



