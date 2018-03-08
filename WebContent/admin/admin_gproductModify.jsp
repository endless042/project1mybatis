<%@page import="db.UserlistDataBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="db.UserlistDBBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
 <jsp:include page="adminheader.jsp"></jsp:include>

  
  <form class="w3-container w3-section"  method="post" enctype="multipart/form-data" action="modifyGproductPro?num=${gproduct.num }" style="padding-left:50px;">
  <h4>공동구매 상품 수정</h4>
  
   <table class="w3-white w3-small" style="width: 80%;">
<tr ><td>  <label><b>상품이름</b></label></td>
<td><input class="w3-input w3-hover-light-grey" type="text" required="required" name="name" value="${gproduct.name }"><p/></td></tr>
 <tr ><td><label><b>원산지</b> </label></td>
 <td><input type="text"  class="w3-input w3-hover-light-grey" required="required" name="origin" value="${gproduct.origin }"><p/></td></tr>
 <tr ><td> <label><b>식물분류</b></label></td>
 <td><input type="text"  class="w3-input w3-hover-light-grey" required="required" name="category" value="${gproduct.category }"><p/></td></tr>
 <tr ><td> <label><b>식물크기</b></label></td>
 <td align="left">약 <input type="number" style="display: inline-block; width: 150px;" min="0" class="w3-input w3-hover-light-grey" required="required" name="height" value="${gproduct.height }">cm<p/></td></tr>
<tr ><td>  <label><b>공구시작일시</b></label></td>
<td align="left">
<input type="date" required="required" 
style="display: inline-block; width: 150px;" 
class="w3-input w3-hover-light-grey  w3-margin-right" name="sdate" value="${formatSdate}">
<input type="number" style="display: inline-block; width: 150px;" required="required" placeholder="(0~23) 시간 선택" min="0" max="23" class="w3-input w3-border  w3-hover-light-grey  " name="sdatetime" value="${formatStime }"> 시부터<p/></td></tr>
<tr ><td>  <label><b>공구종료일시</b></label></td><td align="left">
<input type="date" required="required" style="display: inline-block; width: 150px;" class="w3-input w3-hover-light-grey  w3-margin-right" name="edate" value="${formatEdate }">
<input type="number" style="display: inline-block; width: 150px;" required="required" placeholder="(0~23) 시간 선택" min="0" max="23" class="w3-input w3-border w3-hover-light-grey " name="edatetime" value="${formatEtime }"> 시까지<p/></td></tr>
<tr ><td>  <label><b>공구가격</b></label></td>
<td><input type="number" required="required" class="w3-input w3-hover-light-grey" name="price" value="${gproduct.price }"><p/></td></tr>
<tr ><td><label><b>목표수량</b> </label></td>
<td><input type="number" required="required" class="w3-input w3-hover-light-grey" name="goal" value="${gproduct.goal }"><p/></td></tr>
<tr height="50px"><td><label><b>배송방법</b></label>
</td>
<td align="left"><select required="required" style="max-width: 150px; display: inline-block;" class="w3-select w3-border w3-hover-light-grey w3-small" name="deliv">
<option value="${gproduct.deliv}" selected >
<c:if test="${gproduct.deliv=='1' }">
  픽업
  </c:if>
  <c:if test="${gproduct.deliv=='2' }">
  택배
  </c:if>
  <c:if test="${gproduct.deliv=='3' }">
  픽업 or 택배
  </c:if></option>
    <option value="1">픽업만 가능</option>
    <option value="2">택배만 가능</option>
    <option value="3">픽업 or 택배</option>
    
  </select>
  
  </td></tr>
<!-- 
<tr height="50px"><td><label><b>진행단계</b></label>
</td>
<td align="left">&nbsp;&nbsp;&nbsp;
<select required="required" style="max-width: 150px;" 
class="w3-select w3-hover-light-grey w3-border w3-small" name="state">
    <option value="0" selected disabled="disabled">선택</option>
    <option value="1">진행 예정</option>
    <option value="2">진행 중</option>
    <option value="3">완료</option>
  </select></td></tr> -->
  <tr height="50px"><td><label><b>수입상황</b></label>
</td>
<td align="left">
<select required="required" style="max-width: 150px; display: inline-block;" 
class="w3-select w3-hover-light-grey w3-border w3-small" name="process">
    <option value="${gproduct.process}" selected >
     <c:if test="${gproduct.process=='1' }">
  협상
  </c:if>
  <c:if test="${gproduct.process=='2' }">
  해외이동
  </c:if>
  <c:if test="${gproduct.process=='3' }">
  통관/검역
  </c:if>
    <c:if test="${gproduct.process=='4' }">
  국내이동
  </c:if>
  <c:if test="${gproduct.process=='5' }">
  순화 중
  </c:if>
    </option>
    <option value="1">협상</option>
    <option value="2">해외이동</option>
    <option value="3">통관/검역</option>
    <option value="4">국내이동</option>
    <option value="5">순화 중</option>
    <option value="5">배송시작</option>
  </select></td></tr>
  
  <tr><td>
  <label><b>제목</b></label></td>
  <td><input class="w3-input w3-hover-light-grey" required="required" type="text" name="title" value="${gproduct.title}"><p/></td></tr>
  <tr>
  <td><label><b>상품설명</b></label></td>
  <td><textarea name="content" class="w3-input w3-border w3-hover-light-grey" 
  style="width: 100%;" rows="10" required="required" placeholder="상품 설명을 입력하세요.">
  ${gproduct.content}</textarea> </td>
 
  </tr>
  <tr>
  <td><label><b>사진첨부</b></label></td>
  <td><input class="w3-input w3-hover-light-grey" type="file" name="uploadfile"></td>
  </tr>
  <tr><td><b>기존 사진</b></td>
	<td align="left">
   <img src="<%= request.getContextPath() %>/fileSave/${gproduct.imgs}" 
   style="width:200px;"><p/></td>
	</tr>
  
  </table>

 <hr>

   <div class="w3-row-padding">
  <div class="w3-bar">
   <input class="w3-button w3-black w3-margin-right w3-small" type="button"  value="뒤로">
	 <input type="hidden" name="uploadfile" value="${gproduct.imgs }">
    <input type="hidden" name="num" value="${gproduct.num }">
 
  <input type="hidden" name="imgsize" value="${gproduct.imgsize }">
    
  
   <input type="submit" class="w3-button w3-black w3-margin-right w3-small" value="확인"> <br><br></p>
  </div>
  </div>
  
 
</form>
</div></div>
