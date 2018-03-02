<%@page import="db.UserlistDataBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="db.UserlistDBBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:include page="adminheader.jsp"></jsp:include>
     <% int pageSize=10;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    String pageNum=request.getParameter("pageNum");
    if(pageNum==null||pageNum==""){
    	pageNum="1";}
    
    int currentPage=Integer.parseInt(pageNum);
    int startRow=(currentPage -1 )*pageSize+1;
    int endRow=currentPage*pageSize;
    int count=0;
    int number=0;
    List userList=null;
    UserlistDBBean userPro=UserlistDBBean.getInstance();
   count=userPro.getUserCount("1")+userPro.getUserCount("2");
    if(count>0){
    	userList=userPro.getUsers(startRow,endRow);}
    number=count-(currentPage-1)*pageSize;
    
   
    %>
  
  <form class="w3-container w3-section" action="userModifyPro.jsp" style="padding-left:50px;">
  <h4>경매 상품 등록</h4>
  
   <table class="w3-white w3-small" style="width: 80%;">
<tr ><td>  <label><b>상품이름</b></label></td><td><input class="w3-input w3-hover-light-grey" type="text" name="name" ><p/></td></tr>
 <tr ><td><label><b>원산지</b> </label></td><td><input type="text"  class="w3-input w3-hover-light-grey" name="bdate"><p/></td></tr>
 <tr ><td> <label><b>식물분류</b></label></td><td><input type="text"  class="w3-input w3-hover-light-grey" name="addr" ><p/></td></tr>
 <tr height="50px"><td><label><b>식물크기</b></label>
</td>
<td align="left">&nbsp;&nbsp;&nbsp;<select required="required" style="max-width: 150px;" class="w3-select w3-hover-light-grey w3-border w3-small" name="ulevel">
    <option value="0" selected disabled="disabled">선택</option>
          <option value="1">소(10cm 이하)</option>
    <option value="2">중(10cm~20cm)</option>
    <option value="3">대(20cm~40cm)</option>
    <option value="4">특대(40cm 이상)</option>
  </select></td></tr>
<tr ><td>  <label><b>경매시작일시</b></label></td><td><input type="datetime-local"  class="w3-input w3-hover-light-grey" name="email" ><p/></td></tr>
<tr ><td>  <label><b>경매종료일시</b></label></td><td><input type="datetime-local"  class="w3-input w3-hover-light-grey" name="email" ><p/></td></tr>
<tr ><td>  <label><b>시작가</b></label></td><td><input type="text"  class="w3-input w3-hover-light-grey" name="email" ><p/></td></tr>

<tr height="50px"><td><label><b>배송방법</b></label>
</td>
<td align="left">&nbsp;&nbsp;&nbsp;<select required="required" style="max-width: 150px;" class="w3-select w3-border w3-hover-light-grey w3-small" name="ulevel">
    <option value="0" selected disabled="disabled">선택</option>
    <option value="1">픽업만 가능</option>
    <option value="2">택배만 가능</option>
    <option value="3">픽업 or 택배</option>
    
  </select></td></tr>

<tr height="50px"><td><label><b>진행단계</b></label>
</td>
<td align="left">&nbsp;&nbsp;&nbsp;<select required="required" style="max-width: 150px;" class="w3-select w3-hover-light-grey w3-border w3-small" name="ulevel">
    <option value="0" selected disabled="disabled">선택</option>
    <option value="1">진행 예정</option>
    <option value="2">진행 중</option>
    <option value="3">완료</option>
  </select></td></tr>
  <tr><td>
  <label><b>제목</b></label></td><td><input class="w3-input w3-hover-light-grey" type="text" name="name" ><p/></td></tr>
  <tr>
  <td><label><b>상품설명</b></label></td>
  <td><textarea class="w3-input w3-border w3-hover-light-grey" style="width: 100%;" rows="10" placeholder="상품 설명을 입력하세요."></textarea> </td>
 
  </tr>
  <tr>
  <td><label><b>사진첨부1</b></label></td>
  <td><input class="w3-input w3-hover-light-grey" type="file" name="image1"></td>
  </tr>
  <tr>
  <td><label><b>사진첨부2</b></label></td>
  <td><input class="w3-input w3-hover-light-grey" type="file" name="image2"></td>
  </tr>
  <tr>
  <td><label><b>사진첨부3</b></label></td>
  <td><input class="w3-input w3-hover-light-grey" type="file" name="image3"></td>
  </tr>
  <tr>
  <td><label><b>사진첨부4</b></label></td>
  <td><input class="w3-input w3-hover-light-grey" type="file" name="image4"></td>
  </tr>
  <tr>
  <td><label><b>사진첨부5</b></label></td>
  <td><input class="w3-input w3-hover-light-grey" type="file" name="image5"></td>
  </tr>
  <tr>
  <td><label><b>사진첨부6</b></label></td>
  <td><input class="w3-input w3-hover-light-grey" type="file" name="image6"></td>
  </tr>
  
  </table>

 <hr>

   <div class="w3-row-padding">
  <div class="w3-bar">
   <input class="w3-button w3-black w3-margin-right w3-small" type="button" onclick="window.location='admin_userlist.jsp?pageNum=<%=pageNum %>&select=auserlist'" value="뒤로">
	<input type="hidden" name="id" >
	<input type="hidden" name="pwd" >
	<input type="hidden" name="pageNum" >
   <input type="submit" class="w3-button w3-black w3-margin-right w3-small" value="확인"> <br><br></p>
  </div>
  </div>
  
 
</form>
</div></div>
