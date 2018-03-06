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
<div class="w3-container w3-center"   >
 <table align="center" class="w3-table w3-bordered w3-small"  style="width: 80%;">
 <tr class="w3-border-top">
 
 <td class="w3-center"><b>사진</b></td>
 <td  class="w3-center"><b>상품명</b></td>


<td class="w3-center"><b>가격</b></td></tr>
<c:forEach var="order" items="${aList}">

<tr>


<td class="w3-center" style="width: 100px;"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
<div class="w3-display-container"><img src="<%= request.getContextPath() %>/fileSave/${order.aproduct.imgs}" width="80px" height="100px">
<c:if test="${order.aproduct.state=='1'}">
<span class="w3-tag w3-display-topleft">예정</span>
</c:if>
<c:if test="${order.aproduct.state=='2'}">
<span class="w3-tag w3-green w3-display-topleft">진행</span>
</c:if>
<c:if test="${order.aproduct.state=='3'}">
<span class="w3-tag w3-display-topleft">마감</span>
</c:if></span></div></div></span></td>


<td width="35%"><span style="width: 100%;"><div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p><a href="surveyview.jsp">${order.aproduct.title }</a><p/>
</div></span></td>


<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p><b>입찰가</b><br>
 ${order.aprice }<p/>
 <b>현재가</b> <br>${order.aproduct.eprice}
</div></span></td>


</tr>
</c:forEach>
 </table>
      </div>

<form class="w3-container w3-section" method="post" action="../user/userModifyPro" style="padding-left:50px;">
  <h4>주문 정보</h4>
 
   <table class="w3-white w3-small" style="width: 80%;" >
  

 <tr><td>
  <label><b>이름</b></label></td><td><input class="w3-input w3-hover-light-grey" type="text" name="name" value="${user.name}"><p/></td></tr>

 
 <tr ><td> <label><b>주소</b></label></td><td><input type="text"  class="w3-input w3-hover-light-grey" name="addr" value="${user.addr}"><p/></td></tr>
 <tr ><td><label><b>전화번호</b></label></td><td><input type="text"  class="w3-input w3-hover-light-grey" name="tel" value="${user.tel}"><p/></td></tr>
<tr><td><label><b>적립금 사용</b></label></td><td align="left">&nbsp;&nbsp;&nbsp;${user.point}<p/></td></tr>
<tr><td><label><b>비밀번호</b></label></td><td align="left">
<input type="password" placeholder="결제를 완료하려면 비밀번호를 입력하세요." class="w3-input w3-hover-light-grey" name="pwd" required="required"><p/></td></tr>

  </table>

 <hr>

   <div class="w3-row-padding">
  <div class="w3-bar">
   <button class="w3-button w3-black w3-margin-right w3-small" type="button" onclick="location.href='<%=request.getContextPath()%>/view/main.jsp'">취소</button>
	<input type="hidden" name="id" value="${user.id}">
	<input type="hidden" name="point" value="${user.point}">
	<input type="hidden" name="ulevel" value="${user.ulevel}">

   <input type="submit" class="w3-button w3-black w3-margin-right w3-small" value="결제"> <br><br></p>
  </div>
  </div>
  
 
</form>








 
  <!-- End page content -->
 
 



