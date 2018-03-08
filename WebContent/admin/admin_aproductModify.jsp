<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
 <jsp:include page="adminheader.jsp"></jsp:include>

  
  <form class="w3-container w3-section"  method="post" enctype="multipart/form-data" action="modifyAproductPro?num=${aproduct.num }" style="padding-left:50px;">
  <h4>경매 상품 수정</h4>
  
   <table class="w3-white w3-small" style="width: 80%;">
<tr ><td>  <label><b>상품이름</b></label></td>
<td><input class="w3-input w3-hover-light-grey" type="text" required="required" name="name" value="${aproduct.name }"><p/></td></tr>
 <tr ><td><label><b>원산지</b> </label></td>
 <td><input type="text"  class="w3-input w3-hover-light-grey" required="required" name="origin" value="${aproduct.origin }"><p/></td></tr>
 <tr ><td> <label><b>식물분류</b></label></td>
 <td><input type="text"  class="w3-input w3-hover-light-grey" required="required" name="category" value="${aproduct.category }" ><p/></td></tr>
 <tr ><td> <label><b>식물크기</b></label></td>
 <td align="left">약 <input type="number" style="display: inline-block; width: 150px;" min="0" class="w3-input w3-hover-light-grey" required="required" name="height" value="${aproduct.height }">cm<p/></td></tr>
<tr ><td>  <label><b>경매시작일시</b></label></td>
<td align="left">
<input type="date" value="${formatSdate }" required="required" style="display: inline-block; 
width: 150px;" class="w3-input w3-hover-light-grey  w3-margin-right" name="sdate" >
<input type="number" style="display: inline-block; width: 150px;" 
required="required" placeholder="(0~23) 시간 선택" min="0" max="23" 
class="w3-input w3-border  w3-hover-light-grey  " name="sdatetime" value="${formatStime}"> 시부터<p/></td></tr>
<tr ><td>  <label><b>경매종료일시</b></label></td>
<td align="left">
<input type="date" required="required"  value="${formatEdate }" style="display: inline-block; width: 150px;" 
class="w3-input w3-hover-light-grey  w3-margin-right" name="edate" >
<input type="number" style="display: inline-block; width: 150px;" required="required" placeholder="(0~23) 시간 선택" min="0" max="23" class="w3-input w3-border w3-hover-light-grey " value="${formatEtime}" name="edatetime" > 시까지<p/></td></tr>
<tr ><td>  <label><b>시작가</b></label></td><td>
<input type="number"  required="required" class="w3-input w3-hover-light-grey" name="sprice" value="${aproduct.sprice }"><p/></td></tr>

<tr height="50px"><td><label><b>배송방법</b></label>
</td>
<td align="left"><select required="required" style="max-width: 150px; display: inline-block;"
class="w3-select w3-border w3-hover-light-grey w3-small" name="deliv" >
    <option value="${aproduct.deliv}" selected >
    <c:if test="${aproduct.deliv=='1' }">
  픽업
  </c:if>
  <c:if test="${aproduct.deliv=='2' }">
  택배
  </c:if>
  <c:if test="${aproduct.deliv=='3' }">
  픽업 or 택배
  </c:if></option>
    <option value="1">픽업만 가능</option>
    <option value="2">택배만 가능</option>
    <option value="3">픽업 or 택배</option>
    
  </select>
 
  </td></tr>

  <tr><td>
  <label><b>제목</b></label></td><td><input required="required" 
  class="w3-input w3-hover-light-grey" type="text" name="title" value="${aproduct.title}" ><p/></td></tr>
  <tr>
  <td><label><b>상품설명</b></label></td>
  <td><textarea name="content" required="required" class="w3-input w3-border w3-hover-light-grey" 
  style="width: 100%;" rows="10" placeholder="상품 설명을 입력하세요." >${aproduct.content }</textarea> </td>
 
  </tr>
  <tr>
  <td><label><b>사진첨부</b></label></td>
  <td><input class="w3-input w3-hover-light-grey" type="file" name="uploadfile" value="${aproduct.imgs }">
  
    <input type="hidden" name="num" value="${aproduct.num }">
 
  
  
  </td>
  </tr>
	<tr><td><b>기존 사진</b></td>
	<td align="left">
   <img src="<%= request.getContextPath() %>/fileSave/${aproduct.imgs}" 
   style="width:200px;"><p/>
   <input type="hidden" name="uploadfile" value="${aproduct.imgs }">
   <input type="hidden" name="imgsize" value="${aproduct.imgsize }">
    
  </td>
	</tr>
  
  </table>

 <hr>

   <div class="w3-row-padding">
  <div class="w3-bar">
   <input class="w3-button w3-black w3-margin-right w3-small" type="button" 
   onclick="window.location='alist?pageNum=${pageNum}&select=auserlist'" value="뒤로">
	
   <input type="submit" class="w3-button w3-black w3-margin-right w3-small" value="확인"> <br><br></p>
  </div>
  </div>
  
 
</form>
</div></div>
