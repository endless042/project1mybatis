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
 <h4>주문 정보</h4><br><br>
 <table align="center" class="w3-table w3-bordered w3-small"  style="width: 80%;">
 <tr class="w3-border-top">
 
 <td class="w3-center" style="width: 15%;"><b>사진</b></td>
 <td  class="w3-center" style="width: 55%;"><b>상품명</b></td>
<td  class="w3-center" style="width: 15%;"><b>수량</b></td>
<td class="w3-center" style="width: 15%;"><b>가격</b></td></tr>

<tr>

 <c:if test="${pcode=='a' }">
 <c:set var="price1" value="${product.eprice }"/>
 </c:if>
 <c:if test="${pcode=='g' }">
 <c:set var="price1" value="${product.price*count }"/>
 </c:if>

<td class="w3-center" style="width: 100px;"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
<div class="w3-display-container"><img src="<%= request.getContextPath() %>/fileSave/${product.imgs}" width="80px" height="100px">

</div></div></span></td>


<td ><span style="width: 100%;"><div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p><a href="surveyview.jsp">${product.title }</a><p/>
</div></span></td>
<td  align="right"><span style="width: 100%;"><div class="  w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 <p><a href="surveyview.jsp">${count}</a><p/>
</div></span></td>

<td class="w3-center"><span style="width: 100%;"><div class=" w3-cell w3-cell-middle" style="height: 100px; width: 100%;">
 ${price1}
</div></span></td>


</tr>

 </table>
 <br><br>
      </div>

<form  class="w3-container w3-section" method="post" action="payPro" style="padding-left:50px;">
 
 
   <table class="w3-white w3-small w3-margin-left" style="width: 80%;" >
   

 
   <c:if test="${product.deliv=='2'}">
   
   <tr ><td > <label><b>배송방법</b><p/></label></td>
 <td align="left">&nbsp;&nbsp;&nbsp;택배 <p/></td>
 
 </c:if>
 
 <c:if test="${product.deliv=='1'}">
  <tr ><td > <label><b>배송방법</b><p/></label></td>
 <td align="left">&nbsp;&nbsp;&nbsp;직접 픽업 <p/>
  <input type="hidden" name="deliv" value="1"></td>

 </c:if>
 
 <c:if test="${product.deliv=='3'}">
  <tr ><td > <label><b>배송방법</b><p/></label></td>
  <td align="left">
<select id="delevselect" onchange="delivSel();"  class="w3-select w3-border " required="required" style="width: 120px; display: inline-block;" name="quantity">
	<option  selected="selected" disabled="disabled" >배송 방법 선택</option>
	<option value="1">픽업</option>
    <option value="2">택배</option>
   
    </select>
   
 <p/></td></tr>
 <tr><td><b>주소</b><p/></td><td align="left"><div id="userselect">먼저 배송방법을 선택해주세요.</div></td>
 </tr>
 </c:if> 
 
 
 
 
 <tr><td>
  <label><b>이름</b><p/></label></td><td><input class="w3-input w3-hover-light-grey" type="text" name="name" value="${user.name}"><p/></td></tr>

 <c:if test="${product.deliv=='2'}">
  
 <tr ><td> <label><b>주소</b><p/></label></td>
 <td><input type="text"  class="w3-input w3-hover-light-grey" name="addr" value="${user.addr}"><p/></td></tr>
 <input type="hidden" name="deliv" value="2">
 </c:if>
 
 
 <tr ><td><label><b>전화번호</b><p/></label></td>
 <td><input type="text"  class="w3-input w3-hover-light-grey" name="tel" value="${user.tel}"><p/></td></tr>
 <tr ><td><label><b>가격</b><p/></label></td>
 <td align="left">
 
 
 
  <c:if test="${product.deliv=='2'}">
 <b>&nbsp;&nbsp;&nbsp;${price1+3000 } 원</b> (${price1} 원 + 배송비 3000원)<p/>
 <input type="hidden" name="price" value="${price1+3000 }">
 
 </c:if>
 <c:if test="${product.deliv=='1' }">
 <b>&nbsp;&nbsp;&nbsp;${price1} 원</b> <p/>
  <input type="hidden" name="price" value="${price1}">
 </c:if>
 <c:if test="${product.deliv=='3' }">
 <span id="totalprice">&nbsp;&nbsp;&nbsp;<b>${price1} 원</b><p/></span>
 </c:if> </td></tr>
 

 
 </td></tr>
 
<tr><td><label><b>적립금 사용</b><p/></label></td>
<td align="left"><input type="number" placeholder="사용할 적립금 입력" max="${user.point }" style="display: inline-block;" class="w3-input w3-half w3-hover-light-grey" name="point"> (보유 포인트 : ${user.point })<p/></td></tr>


<tr><td><label><b>비밀번호</b><p/></label></td>

<td align="left">
<input type="password" placeholder="결제를 완료하려면 비밀번호를 입력하세요." class="w3-input w3-twothird w3-hover-light-grey" name="pwd" required="required"><p/></td></tr>

  </table>

 <hr>

   <div class="w3-row-padding">
  <div class="w3-bar">
   <button class="w3-button w3-black w3-margin-right w3-small" type="button" onclick="location.href='orderlist'">취소</button>
	

   <input type="submit" class="w3-button w3-black w3-margin-right w3-small" value="결제"> <br><br></p>
  </div>
  </div>
  <input type="hidden" name="pronum" value="${product.num }">
  <input type="hidden" name="pcode" value="${pcode }">
 <input type="hidden" name="ordernum" value="${ordernum }">
</form>
 <script>
function delivSel(){
	var x=document.getElementById("delevselect").value;
	
	if(x=='1'){
		document.getElementById("userselect").innerHTML='직접 픽업 오시면 됩니다.<input type="hidden" name="deliv" value="1">';
		document.getElementById("totalprice").innerHTML='&nbsp;&nbsp;&nbsp;<b>${price1} 원</b><p/>'+'<input type="hidden" name="price" value="${price1}">';
	}
	else if(x=='2'){
		document.getElementById("userselect").innerHTML='<input type="text" placeholder="주소 입력" class="w3-input" name="addr" value="${user.addr}">'
		+'<input type="hidden" name="price" value="${price1+3000}">'+'<input type="hidden" name="deliv" value="1">';
		document.getElementById("totalprice").innerHTML='<b>&nbsp;&nbsp;&nbsp;${price1}  원</b> (${price1} 원 + 배송비 3000원)<p/>';
		
	}
	
	
	
	
};

</script>







 
  <!-- End page content -->
 
 



