<!DOCTYPE html>
<%@page import="db.UserlistDataBean"%>
<%@page import="db.UserlistDBBean"%>
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
  

 
  
<h5><b>경매</b></h5>

 <table class="w3-table w3-bordered w3-small">
 <tr class="w3-border-top">
 <td class="w3-center" width="50px;"  ><b>번호</b></td>
 <td class="w3-center"><b>사진</b></td>
 <td  class="w3-center"><b>상품명</b></td>
<td class="w3-center"><b>경매기간</b></td>
<td class="w3-center"><b>입찰 정보</b></td>
<td class="w3-center"><b>결과</b></td></tr>


<tr><td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
8
</div></span></td>

<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
<div class="w3-display-container"><img src="../images/peperomia.PNG" width="100px"> <span class="w3-tag w3-display-topleft">마감</span></div></div></span></td>
<td><span style="width: 100%;"><div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p><a href="surveyview.jsp">요즘 텀블러에서 자주 보이는 이 식물</a><p/>
</div></span></td>


<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p>
 18/02/22 08:00<p/>
 18/02/25 08:00
</div></span></td>
<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p><b>입찰가</b><br>
 35,000원<p/>
 <b>현재가</b> <br>35,000원
</div></span></td>

<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p><span class="w3-tag w3-blue">낙찰</span><p/>
 <span class="w3-tag w3-green">결제하기</span>
</div></span></td>


</tr>
<tr><td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
8
</div></span></td>

<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
<div class="w3-display-container"><img src="../images/peperomia.PNG" width="100px"> <span class="w3-tag w3-green w3-display-topleft">진행
</span></div></div></span></td>
<td><span style="width: 100%;"><div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p><a href="surveyview.jsp">요즘 텀블러에서 자주 보이는 이 식물</a><p/>
</div></span></td>

<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p>
 18/02/22 08:00<p/>
 18/02/25 08:00
</div></span></td>
<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p><b>입찰가</b><br>
 35,000원<p/>
 <b>현재가</b> <br>35,000원
</div></span></td>

<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 -

</div></span></td>


</tr>

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
  
  

<h5><b>공동구매</b></h5>


 <table class="w3-table w3-bordered w3-small">
 <tr class="w3-border-top">
 <td class="w3-center" width="50px;"  ><b>번호</b></td>
 <td class="w3-center"><b>사진</b></td>
 <td  class="w3-center"><b>상품명</b></td>
<td class="w3-center"><b>진행기간</b></td>
<td class="w3-center"><b>참여 수량</b></td>
<td class="w3-center"><b>가격</b></td>
<td class="w3-center"><b>결과</b></td></tr>



<tr><td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
8
</div></span></td>

<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
<div class="w3-display-container"><img src="../images/peperomia.PNG" width="100px"> <span class="w3-tag w3-display-topleft">마감</span></div></div></span></td>
<td><span style="width: 100%;"><div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p><a href="surveyview.jsp">요즘 텀블러에서 자주 보이는 이 식물</a><p/>
</div></span></td>


<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p>
 18/02/22 08:00<p/>
 18/02/25 08:00
</div></span></td>
<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 4
</div></span></td>
<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
120,000원
</div></span></td>

<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p><span class="w3-tag w3-blue">달성</span><p/>
 <span class="w3-tag w3-green">결제하기</span>
</div></span></td>


</tr>
<tr><td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
8
</div></span></td>

<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
<div class="w3-display-container"><img src="../images/peperomia.PNG" width="100px"> <span class="w3-tag w3-display-topleft">마감</span></div></div></span></td>
<td><span style="width: 100%;"><div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p><a href="surveyview.jsp">요즘 텀블러에서 자주 보이는 이 식물</a><p/>
</div></span></td>


<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p>
 18/02/22 08:00<p/>
 18/02/25 08:00
</div></span></td>
<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 4
</div></span></td>
<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
120,000원
</div></span></td>

<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p><span class="w3-tag w3-red">미달</span><p/>
 
</div></span></td>


</tr>

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
 
 



