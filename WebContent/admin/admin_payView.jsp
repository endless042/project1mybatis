<%@page import="userlist.UserlistDataBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="userlist.UserlistDBBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
 <jsp:include page="adminheader.jsp"></jsp:include>
   <div class="w3-container w3-center"   >
 <h4>결제 정보</h4><br><br>
 <table align="center" class="w3-table w3-bordered w3-small"  style="width: 80%;">
 <tr class="w3-border-top">
 
 <td class="w3-center" style="width: 15%;"><b>사진</b></td>
 <td  class="w3-center" style="width: 55%;"><b>상품명</b></td>
<td  class="w3-center" style="width: 15%;"><b>수량</b></td>
<td class="w3-center" style="width: 15%;"><b>가격</b></td></tr>

<tr>


<td class="w3-center" style="width: 100px;">
<span style="width: 100%;">
<div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
<div class="w3-display-container">


<img src="<%= request.getContextPath() %>/fileSave/${product.imgs}" width="80px" height="100px">

</div></div></span></td>


<td ><span style="width: 100%;"><div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p><a href="surveyview.jsp">
 ${product.title }</a><p/>
</div></span></td>
<td  align="right"><span style="width: 100%;"><div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p><a href="surveyview.jsp">${pay.count}</a><p/>
 
</div></span></td>

<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 ${pay.price}
</div></span></td>


</tr>

 </table>
 <br><br>
      </div>

<form  class="w3-container w3-section" method="post" action="payCancelPro?ordernum=${pay.ordernum }" style="padding-left:50px;">
 
 
   <table class="w3-white w3-small w3-margin-left" style="width: 80%;" >
   

   
   <tr ><td > <label><b>배송방법</b><p/></label></td>
 <td align="left">
 <c:if test="${pay.deliv=='1'}">
 픽업
 </c:if>
 <c:if test="${pay.deliv=='2'}">
 택배
 </c:if>

  <p/></td>
 
   
 </tr>
 <tr><td><b>주소</b><p/></td><td align="left">${pay.addr }<p/></td>
 </tr>

 <tr><td>
  <label><b>이름</b><p/></label></td>
  <td align="left">${pay.name }<p/></td></tr>

 
 
 <tr ><td><label><b>전화번호</b><p/></label></td>
 <td align="left">${pay.tel }<p/></td></tr>
 <tr ><td><label><b>결제가격</b><p/></label></td>
 <td align="left">
 ${pay.price }</td></tr>

<tr><td><label><b>비밀번호</b><p/></label></td>

<td align="left">
<input type="password" placeholder="주문을 취소하려면 비밀번호를 입력하세요." class="w3-input w3-twothird w3-hover-light-grey" name="pwd" required="required"><p/></td></tr>

  </table>

 <hr>

   <div class="w3-row-padding">
  <div class="w3-bar">
   <button class="w3-button w3-black w3-margin-right w3-small" type="button" onclick="location.href='orderlist'">뒤로</button>
	

   <input type="submit" class="w3-button w3-black w3-margin-right w3-small" value="주문취소"> <br><br></p>
  </div>
  </div>
  <input type="hidden" name="pronum" value="${product.num }">
  <input type="hidden" name="pcode" value="${pcode }">
 <input type="hidden" name="ordernum" value="${ordernum }">
 <input type="hidden" name="count" value="${count }">
 <input type="hidden" name="num" value="${pay.num}">
</form>
 







 
  <!-- End page content -->
 
 

   