<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<title>Plant shop</title>
<meta charset="UTF-8">
 
 
 
<div class="w3-container w3-padding-64"  width="100%"  >
  

 <div class="w3-card-4  w3-center  w3-padding-24"  style="max-width:900px; padding:20px;" >
      

<form class="w3-container w3-section" action="joinPro2.jsp" style="padding-left:50px;">
  <h4>회원 가입</h4>
 
   <table class="w3-white w3-small" style="width: 80%;" >
  <!--  <tr><td colspan="2"><span class="w3-small w3-left"> <b><font color="red">&nbsp;&nbsp;&nbsp;*</font></b> 표시가 된 항목은 필수 입력입니다. </span></td></tr> -->
   <tr><td >
  <label><b>이름<font color="red">&nbsp;&nbsp;&nbsp;*</font></b></label></td><td td align="left">
  <input class="w3-input w3-hover-light-grey" type="text" name="name" required="required" >
  <label>이름을 입력해주세요.</label>
</td></tr>
<tr ><td>  <label><b>아이디<font color="red">&nbsp;&nbsp;&nbsp;*</font></b></label></td><td align="left">
<input class="w3-input w3-hover-light-grey " type="text" name="id"  required="required"  >
<label>중복된 아이디입니다.</label>
</td></tr>
<tr ><td>  <label><b>비밀번호<font color="red">&nbsp;&nbsp;&nbsp;*</font></b></label></td><td align="left">
<input class="w3-input w3-hover-light-grey" type="password" name="pwd"  required="required"  >
<label>중복된 아이디입니다.</label><p/></td></tr>
<tr ><td>  <label><b>비밀번호확인<font color="red">&nbsp;&nbsp;&nbsp;*</font></b></label></td><td align="left"><input class="w3-input w3-hover-light-grey" type="password" name="pwdck"   required="required" ><p/></td></tr>
 <tr ><td><label><b>생일<font color="red">&nbsp;&nbsp;&nbsp;*</font></b> </label></td><td><input type="date"  class="w3-input w3-hover-light-grey" name="bdate"  required="required" ><p/></td></tr>
 <tr ><td> <label><b>주소</b></label></td><td><input type="text"  class="w3-input w3-hover-light-grey" name="addr"  ><p/></td></tr>
 <tr ><td><label><b>전화번호</b></label></td><td><input type="text" onKeyDown = "javascript:onlyNumberInput(event)" style='IME-MODE: disabled' class="w3-input w3-hover-light-grey" name="tel" placeholder="숫자만 입력"><p/></td></tr>
<tr ><td>  <label><b>이메일</b></label></td><td> <input type="email"  class="w3-input w3-hover-light-grey" name="email"  ><p/></td></tr>


  </table>

 <hr>
 <%String pageNum=request.getParameter("pageNum"); 
 if(pageNum==null||pageNum.equals("")){
 pageNum="1";}%>
   <div class="w3-row-padding">
  <div class="w3-bar">
   <button class="w3-button w3-black w3-margin-right w3-small" onclick="history.go(-1)">뒤로</button>
	<input type="hidden" name="id"  >
	<input type="hidden" name="pwd"  >
	<input type="hidden" name="pageNum"  >
	 <input type="reset" class="w3-button w3-black w3-margin-right w3-small" value="재작성">
   <input type="submit" class="w3-button w3-black w3-margin-right w3-small" value="확인"> <br><br></p>
  </div>
  </div>
  
 
</form>

</div>
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
 



