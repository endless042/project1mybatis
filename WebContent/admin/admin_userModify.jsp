<%@page import="db.UserlistDataBean"%>
<%@page import="db.UserlistDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:include page="adminheader.jsp"></jsp:include>
    <%
  
 
	String id=request.getParameter("id");
    String pwd=request.getParameter("pwd");
     
	
	try{
		UserlistDBBean userPro=UserlistDBBean.getInstance();
		UserlistDataBean user=userPro.getUser(id,pwd);
		
		%>
    

  <form class="w3-container w3-section" action="userModifyPro.jsp" style="padding-left:50px;">
  <h4>회원 정보 수정</h4>
  
   <table class="w3-white w3-small" style="width: 80%;" ><tr><td>
  <label><b>이름</b></label></td><td><input class="w3-input" type="text" name="name" value="<%=user.getName()%>"><p/></td></tr>
<tr ><td>  <label><b>아이디</b></label></td><td align="left">&nbsp;&nbsp;&nbsp;<%=user.getId()%><p/></td></tr>
 <tr ><td><label><b>생일</b> </label></td><td><input type="date"  class="w3-input" name="bdate" value="<%=user.getBdate()%>"><p/></td></tr>
 <tr ><td> <label><b>주소</b></label></td><td><input type="text"  class="w3-input" name="addr" value="<%=user.getAddr() %>"><p/></td></tr>
 <tr ><td><label><b>전화번호</b></label></td><td><input type="text"  class="w3-input" name="tel" value="<%=user.getTel() %>"><p/></td></tr>
<tr ><td>  <label><b>이메일</b></label></td><td><input type="text"  class="w3-input" name="email" value="<%=user.getEmail() %>"><p/></td></tr>
<tr  height="50px"><td><label><b>가입일</b></label>
</td><td align="left">&nbsp;&nbsp;&nbsp;<%=user.getCdate() %></td></tr>
<tr><td><label><b>적립금</b></label></td><td><input type="text"  class="w3-input" name="point" value="<%=user.getPoint() %>"><p/></td></tr>
<tr height="50px"><td><label><b>회원레벨</b></label>
</td><td align="left">&nbsp;&nbsp;&nbsp;<select style="max-width: 100px;" class="w3-select w3-border w3-small" name="ulevel">
    <option value="<%=user.getUlevel() %>" selected>선택</option>
    <option value="1">1(기본)</option>
    <option value="2">2(패널티)</option>
    <option value="3">3(열람금지)</option>
  </select>&nbsp;&nbsp;&nbsp;현재레벨 : <%=user.getUlevel() %> </td></tr>
  </table>

 <hr>
 <%String pageNum=request.getParameter("pageNum"); 
 if(pageNum==null||pageNum.equals("")){
 pageNum="1";}%>
   <div class="w3-row-padding">
  <div class="w3-bar">
   <input class="w3-button w3-black w3-margin-right w3-small" type="button" onclick="window.location='admin_userlist.jsp?pageNum=<%=pageNum %>&select=auserlist'" value="뒤로">
	<input type="hidden" name="id" value="<%=user.getId()%>">
	<input type="hidden" name="pwd" value="<%=user.getPwd()%>">
	<input type="hidden" name="pageNum" value="<%=pageNum %>">
   <input type="submit" class="w3-button w3-black w3-margin-right w3-small" value="확인"> <br><br></p>
  </div>
  </div>
  
 
</form>
</div></div>

<%}catch(Exception e){}%>


