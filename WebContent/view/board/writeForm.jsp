<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%   request.setCharacterEncoding("UTF-8"); %>
   
     <%
     
     int num=0,ref=0,re_step=0, re_level=0;
    String boardid=request.getParameter("boardid");
    
     
     if(request.getParameter("num")!=null){
    	num=Integer.parseInt(request.getParameter("num"));
     	ref=Integer.parseInt(request.getParameter("ref"));
    	re_level=Integer.parseInt(request.getParameter("re_level"));
     	re_step=Integer.parseInt(request.getParameter("re_step"));
     }
    if(boardid==null){
    	boardid="1";
    }
    
    
    %>

  <style>
.w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}


</style>


<center><div class="w3-container" style="padding-bottom: 64px;">

 <h4 class="w3-wide w3-center">글쓰기</h4>
<br>
<form method="post" name="writeform" action="<%=request.getContextPath() %>/view/board/writePro.jsp" >
<input type="hidden" name="boardid" value="<%=boardid%>">
<input type="hidden" name="num" value="<%=num%>">
<input type="hidden" name="ref" value="<%=ref%>">
<input type="hidden" name="re_level" value="<%=re_level%>">
<input type="hidden" name="re_step" value="<%=re_step%>">





<table class="w3-table w3-bordered  w3-bordered w3-small"  style="width:90%;" >
   
   <tr>
    <td  width="70" class=" w3-center "  ><label><b>이 름</b></label></td>
    <td  width="330">
       <% if(loginId==null){
       %> <input type="text" required="required" class="w3-input w3-border-0 w3-hover-light-grey" style="width:300px;" size="10" maxlength="12" name="writer"><%}else{
       
       %><%=loginId %> <input type="hidden"  name="writer" value="<%=loginId%>"><%} %>
      
  </tr>
  <tr>
    <td  width="70" class=" w3-center "    ><label><b>제 목</b></label>
    </td>
    <td width="330">
 
 	<%if(request.getParameter("num")==null){%>
 	
       <input type="text" size="40" maxlength="50" name="subject"  required="required" class="w3-input w3-border-0 w3-hover-light-grey">
       <%}else{ %>
       <input type="text" size="40" maxlength="50" name="subject" value="[답글]" required="required" class="w3-input w3-border-0 w3-hover-light-grey">
       <%} %>
	
   
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
    <td  width="70" class=" w3-center " ><label><b>비밀번호</b></label></td>
    <td  width="330" >
     <input type="password" size="8" maxlength="12" name="passwd"  style="width:300px;" required="required" class="w3-input w3-border-0 w3-hover-light-grey"> 
	 </td>
  </tr>
<tr>      
 <td colspan=2  class="w3-center"> 
  <input type="submit" class="w3-button w3-hover-black" value="글쓰기" >  
  <input type="reset" class="w3-button w3-hover-black" value="다시작성">
  <input type="button" class="w3-button w3-hover-black" value="목록보기" OnClick="window.location='list.jsp'">
</td></tr></table>    
     
</form>   </div> </center>


 
  <!-- End page content -->
 