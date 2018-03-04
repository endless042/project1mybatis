<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<html>
<title>Plant shop</title>
<meta charset="UTF-8">
 
 
 
<div class="w3-container w3-padding-64"  width="100%"  >
  

 <div class="w3-card-4  w3-center  w3-padding-24"  style="max-width:900px; padding:20px;" >
      

<form class="w3-container w3-section" method="post" action="joinPro" style="padding-left:50px;">
  <h4>회원 가입</h4>
  
 
   <table class="w3-white w3-small w3-margin-top" style="width: 80%;" >
  <!--  <tr><td colspan="2"><span class="w3-small w3-left"> <b><font color="red">&nbsp;&nbsp;&nbsp;*</font></b> 표시가 된 항목은 필수 입력입니다. </span></td></tr> -->
   <tr><td valign="top">
  <label><b>이름<font color="red">&nbsp;&nbsp;&nbsp;*</font></b></label><p/></td>
  <td align="left">
  <input class="w3-input w3-hover-light-grey" type="text" name="name" value="${param.name }" >
  <c:if test="${errors.name }"><label class="w3-red">이름을 입력하세요.</label></c:if>
 
 
 
<p/>
</td></tr>
<tr ><td valign="top">  <label><b>아이디<font color="red">&nbsp;&nbsp;&nbsp;*</font></b></label></td><td align="left">
<input class="w3-input w3-hover-light-grey " type="text" name="id" value="${param.id }">
 <c:if test="${errors.id }"><label class="w3-red">아이디를 입력하세요.</label></c:if>
  <c:if test="${errors.duplicateId }"><label class="w3-red">이미 사용중인 아이디입니다.</label></c:if>
<p/>
</td></tr>
<tr ><td valign="top">  <label><b>비밀번호<font color="red">&nbsp;&nbsp;&nbsp;*</font></b></label></td><td align="left">
<input class="w3-input w3-hover-light-grey" type="password" name="pwd"   >
<c:if test="${errors.pwd }"><label class="w3-red">암호를 입력하세요.</label></c:if>
<p/></td></tr>
<tr ><td valign="top">  <label><b>비밀번호확인<font color="red">&nbsp;&nbsp;&nbsp;*</font></b></label></td><td align="left"><input class="w3-input w3-hover-light-grey" type="password" name="confirmPwd"   >
<c:if test="${errors.confirmPwd }"><label class="w3-red">확인을 입력하세요.</label></c:if>
<c:if test="${errors.notMatch }"><label class="w3-red">암호와 확인이 일치하지 않습니다.</label></c:if>

<p/></td></tr>
 
 <tr ><td valign="top"><label><b>생일<font color="red">&nbsp;&nbsp;&nbsp;*</font></b> </label></td><td align="left"><input type="date"  class="w3-input w3-hover-light-grey" name="bdate" value="${param.bdate }" >
 <c:if test="${errors.bdate}"><label class="w3-red">생일을 입력하세요.</label></c:if>
 
 <p/></td></tr>

<tr ><td valign="top">  <label><b>이메일<font color="red">&nbsp;&nbsp;&nbsp;*</font></b></label></td>
<td align="left"> <input type="email" class="w3-input w3-hover-light-grey" name="email" value="${param.email }" >
<c:if test="${errors.email}"><label class="w3-red">이메일을 입력하세요.</label></c:if>
<p/></td></tr>

 <tr ><td valign="top"> <label><b>주소</b></label></td>
 <td><input type="text"  class="w3-input w3-hover-light-grey" name="addr" value="${param.addr }" ><p/></td></tr>
 <tr ><td valign="top"><label><b>전화번호</b></label></td>
 <td><input type="text" onKeyDown = "javascript:onlyNumberInput(event)" style='IME-MODE: disabled' class="w3-input w3-hover-light-grey" name="tel" placeholder="숫자만 입력" value="${param.tel}"><p/></td></tr>


  </table>

 <hr>

   <div class="w3-row-padding">
  <div class="w3-bar">
   <button class="w3-button w3-black w3-margin-right w3-small" onclick="history.go(-1)">뒤로</button>
	
	 <input type="reset" class="w3-button w3-black w3-margin-right w3-small" value="재작성">
   <input type="submit" class="w3-button w3-black w3-margin-right w3-small" value="확인"> <br><br>
  </div>
  </div>
  
 
</form>

</div>
</div>





 
  <!-- End page content -->
 
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
 function onlyNumberInput( Ev )
 
 {
     if (window.event) // IE코드
         var code = window.event.keyCode;
     else // 타브라우저
         var code = Ev.which;
  
     if ((code > 34 && code < 41) || (code > 47 && code < 58) || (code > 95 && code < 106) || code == 8 || code == 9 || code == 13 || code == 46)
     {
         window.event.returnValue = true;
         return;
     }
  
     if (window.event)
         window.event.returnValue = false;
     else
         Ev.preventDefault();}    

</script>
 



