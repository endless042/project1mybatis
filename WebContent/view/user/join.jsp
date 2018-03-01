<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<title>Plant shop</title>
<meta charset="UTF-8">
<style>
.w3-input {
    display: inline-block;
    width: auto;
} 
</style>

 
  
<div class="w3-container" >
  <form class="w3-container w3-small"  action="joinPro.jsp">

 
  <p>  <b><font color="red">&nbsp;&nbsp;&nbsp;*</font></b> 표시가 된 항목은 필수 입력입니다.</p>

 <p> <label ><b>NAME OR NICKNAME<font color="red">*</font></b></label><br>
  <input class="w3-input w3-border" name="name" type="text" placeholder="이름 또는 별명" required="required"></p>



<label ><b>ID <font color="red">*</font></b></label><br>

      <input class="w3-input w3-border" name="id" type="text" placeholder="아이디"  required="required">

    <input class="w3-button w3-black w3-margin-left" type="button" value="중복확인">

  
   
 <p> <label ><b>PASSWORD <font color="red">*</font></b></label><br>
  <input class="w3-input w3-border" name="pwd" type="password" placeholder="비밀번호" required="required"></p>
  
  
 <p> <label ><b>RETYPE  <font color="red">*</font></b></label><br>
  <input class="w3-input w3-border" name="pwdck" type="password" placeholder="비밀번호 다시 입력" required="required"></p>

 

  <p> <label ><b>BIRTHDATE <font color="red">*</font></b></label><br>
  <input class="w3-input w3-border" style="width: 300px;" name="bdate" type="date"   required="required"></p>
 
<!--  이메일 입력  -->
 
  <label ><b>EMAIL</b></label><br>
  
  <input  class="w3-input w3-border" name="email1" id="first_email" type="text" placeholder="이메일" > @
<input  class="w3-input w3-border" name="email2" type="text"  id="last_email" placeholder="이메일" >&nbsp;
  <select  class="w3-select w3-border"  style="max-width: 200px;" id="email_select">
     <option value="" selected>선택</option>
   <option value="naver.com">naver.com</option>
   <option value="nate.com">nate.com</option>
   <option value="daum.net">daum.net</option>
   <option value="gmail.com">gmail.com</option>
   <option value="hotmail.com">hotmail.com</option>
   <option value="empas.com">empas.com</option>
   <option value="yahoo.co.kr">yahoo.co.kr</option>
   <option value="dreamwiz.com">dreamwiz.com</option>
 
 
   <option value="1">직접입력</option>
  </select> 
  
 <!--  이메일 입력  -->

  <p>
  <label ><b>TEL</b></label><br>
   <select style="max-width: 100px;" class="w3-select w3-border w3-small" name="tel1">
    <option value="미입력" selected>선택</option>
    <option value="010">010</option>
    <option value="011">011</option>
    <option value="070">070</option>
    <option value="080">080</option>
     <option value="02">02</option>
  </select>
    -
    <input style="max-width: 100px;" class="w3-input w3-border  " name="tel2" type="text" placeholder="전화번호" > -
    <input style="max-width: 100px;" class="w3-input w3-border  " name="tel3" type="text" placeholder="전화번호" >
 
  
   <p> <label ><b>ADDRESS</b></label><br>
  <input class="w3-input w3-border" name="addr" type="text" placeholder="주소" style="width:400px;"></p>


  
  

 <hr>
 
   <div class="w3-row-padding w3-center ">
  <div class="w3-bar">
   <button class="w3-button w3-black w3-margin-right" onclick="history.go(-1)">뒤로</button>
    <input type="reset" class="w3-button w3-black w3-margin-right" value="재작성">
   <input type="submit" class="w3-button w3-black w3-margin-right" value="확인"><br><br></p>
  </div>
  </div>
  
 
</form>
</div>
  
  





 
  <!-- End page content -->
 
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
 $(function(){
  $('#email_select').change(function(){
   if($('#email_select').val() == "1"){
    $("#last_email").val(""); //값 초기화
    $("#last_email").prop("readonly",false); //활성화
   } else if($('#email_select').val() == ""){
    $("#last_email").val(""); //값 초기화
    $("#last_email").prop("readonly",true); //textBox 비활성화
   } else {
    $("#last_email").val($('#email_select').val()); //선택값 입력
    $("#last_email").prop("readonly",true); //비활성화
   }
  });
 });
 

</script>
 



