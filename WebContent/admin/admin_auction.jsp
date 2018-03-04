<%@page import="db.UserlistDataBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="db.UserlistDBBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:include page="adminheader.jsp"></jsp:include>

  
  <form class="w3-container w3-section" action="addAproductPro" style="padding-left:50px;">
  <h4>경매 상품 등록</h4>
  
   <table class="w3-white w3-small" style="width: 80%;">
<tr ><td>  <label><b>상품이름</b></label></td>
<td><input class="w3-input w3-hover-light-grey" type="text" required="required" name="name" ><p/></td></tr>
 <tr ><td><label><b>원산지</b> </label></td>
 <td><input type="text"  class="w3-input w3-hover-light-grey" required="required" name="origin"><p/></td></tr>
 <tr ><td> <label><b>식물분류</b></label></td>
 <td><input type="text"  class="w3-input w3-hover-light-grey" required="required" name="category" ><p/></td></tr>
 <tr ><td> <label><b>식물크기</b></label></td>
 <td align="left">약 <input type="number" style="display: inline-block; width: 150px;" min="0" class="w3-input w3-hover-light-grey" required="required" name="height" >cm<p/></td></tr>
<tr ><td>  <label><b>경매시작일시</b></label></td><td align="left"><input type="date" required="required" style="display: inline-block; width: 150px;" class="w3-input w3-hover-light-grey  w3-margin-right" name="sdate" >
<input type="number" style="display: inline-block; width: 150px;" required="required" placeholder="(0~23) 시간 선택" min="0" max="23" class="w3-input w3-border  w3-hover-light-grey  " name="sdatetime" > 시부터<p/></td></tr>
<tr ><td>  <label><b>경매종료일시</b></label></td><td align="left"><input type="date" required="required" style="display: inline-block; width: 150px;" class="w3-input w3-hover-light-grey  w3-margin-right" name="edate" >
<input type="number" style="display: inline-block; width: 150px;" required="required" placeholder="(0~23) 시간 선택" min="0" max="23" class="w3-input w3-border w3-hover-light-grey " name="edatetime" > 시까지<p/></td></tr>
<tr ><td>  <label><b>시작가</b></label></td><td><input type="text"  required="required" class="w3-input w3-hover-light-grey" name="sprice" ><p/></td></tr>

<tr height="50px"><td><label><b>배송방법</b></label>
</td>
<td align="left">&nbsp;&nbsp;&nbsp;<select required="required" style="max-width: 150px;" class="w3-select w3-border w3-hover-light-grey w3-small" name="deliv">
    <option value="0" selected disabled="disabled">선택</option>
    <option value="1">픽업만 가능</option>
    <option value="2">택배만 가능</option>
    <option value="3">픽업 or 택배</option>
    
  </select></td></tr>

<tr height="50px"><td><label><b>진행단계</b></label>
</td>
<td align="left">&nbsp;&nbsp;&nbsp;<select required="required" style="max-width: 150px;" class="w3-select w3-hover-light-grey w3-border w3-small" name="state">
    <option value="0" selected disabled="disabled">선택</option>
    <option value="1">진행 예정</option>
    <option value="2">진행 중</option>
    <option value="3">완료</option>
  </select></td></tr>
  <tr><td>
  <label><b>제목</b></label></td><td><input required="required" class="w3-input w3-hover-light-grey" type="text" name="title" ><p/></td></tr>
  <tr>
  <td><label><b>상품설명</b></label></td>
  <td><textarea name="content" required="required" class="w3-input w3-border w3-hover-light-grey" style="width: 100%;" rows="10" placeholder="상품 설명을 입력하세요."></textarea> </td>
 
  </tr>
  <tr>
  <td><label><b>사진첨부1</b></label></td>
  <td><input class="w3-input w3-hover-light-grey" type="file" name="imgs"></td>
  </tr>
  <tr>
  <td><label><b>사진첨부2</b></label></td>
  <td><input class="w3-input w3-hover-light-grey" type="file" name="imgs"></td>
  </tr>
  <tr>
  <td><label><b>사진첨부3</b></label></td>
  <td><input class="w3-input w3-hover-light-grey" type="file" name="imgs"></td>
  </tr>
  <tr>
  <td><label><b>사진첨부4</b></label></td>
  <td><input class="w3-input w3-hover-light-grey" type="file" name="imgs"></td>
  </tr>
  <tr>
  <td><label><b>사진첨부5</b></label></td>
  <td><input class="w3-input w3-hover-light-grey" type="file" name="imgs"></td>
  </tr>
  <tr>
  <td><label><b>사진첨부6</b></label></td>
  <td><input class="w3-input w3-hover-light-grey" type="file" name="imgs"></td>
  </tr>
  
  </table>

 <hr>

   <div class="w3-row-padding">
  <div class="w3-bar">
   <input class="w3-button w3-black w3-margin-right w3-small" type="button" value="뒤로">
	
   <input type="submit" class="w3-button w3-black w3-margin-right w3-small" value="확인"> <br><br></p>
  </div>
  </div>
  
 
</form>
</div></div>
