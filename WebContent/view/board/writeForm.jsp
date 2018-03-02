<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
  

  <style>
.w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}


</style>


<center><div class="w3-container" style="padding-bottom: 64px;">

 <h4 class="w3-wide w3-center">글쓰기</h4>
<br>
<form method="post" name="writeform" action="writePro" >
<input type="hidden" name="boardid" value="${boardid}">
<input type="hidden" name="num" value="${num}">
<input type="hidden" name="ref" value="${ref}">
<input type="hidden" name="re_level" value="${re_level}">
<input type="hidden" name="re_step" value="${re_step}">





<table class="w3-table w3-bordered  w3-bordered w3-small"  style="width:90%;" >
   
   <tr>
    <td  width="70" class=" w3-center "  ><label><b>이 름</b></label></td>
    <td  width="330">
    
    <c:if test="${loginId==null }">
        <input type="text" required="required" class="w3-input w3-border-0 w3-hover-light-grey" style="width:300px;" size="10" maxlength="12" name="writer">
       
       </c:if>
       <c:if test="${loginId!=null}">
       ${loginId}<input type="hidden"  name="writer" value="${loginId}">
       </c:if>
      
  </tr>
  <tr>
    <td  width="70" class=" w3-center "    ><label><b>제 목</b></label>
    </td>
    <td width="330">
 	<c:if test="${num==0}">
 	
 	
       <input type="text" size="40" maxlength="50" name="subject"  required="required" class="w3-input w3-border-0 w3-hover-light-grey">
       </c:if>
       
       <c:if test="${num!=0}">
       <input type="text" size="40" maxlength="50" name="subject" value="[답글] " required="required" class="w3-input w3-border-0 w3-hover-light-grey">
      </c:if>
	
   
   </td>
  </tr>
  <tr>
    <td  width="70" class=" w3-center " ><label><b>Email</b></label></td>
    <td  width="330">
       <input type="text" size="40" maxlength="30" name="email" class="w3-input w3-border-0 w3-hover-light-grey" ></td>
  </tr>
  <tr>
    <td  width="70" class=" w3-center " ><label><b>내 용</b></label></td>
    <td  width="330" >
     <textarea name="content" rows="13" cols="40" class="w3-input w3-border-0 w3-hover-light-grey" required="required"></textarea> </td>
  </tr>
  <tr>
   <c:if test="${loginId==null }">
    <td  width="70" class=" w3-center " ><label><b>비밀번호</b></label></td>
    
    
    <td  width="330" >
     <input type="password" size="8" maxlength="12" name="passwd"  style="width:300px;" required="required" class="w3-input w3-border-0 w3-hover-light-grey"> 
	 </td>
	 </c:if>
	  
  </tr>
<tr>      
 <td colspan=2  class="w3-center"> 
 <input type="hidden"  name="boardid" value="${boardid}">
  <input type="submit" class="w3-button w3-hover-black" value="글쓰기" >  
  <input type="reset" class="w3-button w3-hover-black" value="다시작성">
  <input type="button" class="w3-button w3-hover-black" value="목록보기" OnClick="window.location='list'">
</td></tr></table>    
     
</form>   </div> </center>


 
  <!-- End page content -->
 