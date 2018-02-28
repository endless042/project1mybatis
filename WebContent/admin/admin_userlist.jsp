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
    
   <span class="w3-small"> <p>(전체 회원수:<%=count %>)</p></span><%
    if(count==0){
    		
    	
    	%>
    	<table class="w3-table w3-border w3-hoverable w3-center w3-small" width="90%">
    	<tr class="w3-light-grey">
    	<td class="w3-center">회원이 없습니다.</td>
    	
    	</table><% }else{ %>
    	<table class="w3-table w3-bordered w3-hoverable w3-small" width="90%">
    	<tr class="w3-light-grey">
    	<td class="w3-center" width="10%"><b>회원번호</b></td>
    	<td class="w3-center" width="10%"><b>레벨</b></td>
    	<td class="w3-center" width="15%"><b>아이디</b></td>
    	<td class="w3-center" width="15%"><b>이름</b></td>
    	<td class="w3-center" width="20%"><b>가입일</b></td>
    	<td class="w3-center" width="10%"><b>적립금</b></td>
    	<td class="w3-center" width="20%"><b>관리</b></td>
    
    
    <% for (int i=0;i<userList.size();i++){
    			UserlistDataBean user=(UserlistDataBean)userList.get(i);%>
    			<tr >
    			<td class="w3-center" ><%=user.getNum()%></td>
    			<td class="w3-center" ><%=user.getUlevel() %></td>
    			<td class="w3-center" ><%=user.getId()%></td>
    			<td class="w3-center" ><%=user.getName()%></td>
    			<td class="w3-center" ><%=user.getCdate()%></td>
    			<td class="w3-center"><%=user.getPoint() %></td>
    			<td class="w3-center" >
    			
    			
    			<form method="post" action="admin_userModify.jsp" style="display: inline-block;">
    			<input type="hidden" name="pageNum" value="<%= pageNum%>">
    			<input type="hidden" name="id" value="<%= user.getId()%>">
    			<input type="hidden" name="pwd" value="<%=user.getPwd() %>">
    			<input type="hidden" name="select" value="auserlist">
    			<button class="w3-button w3-padding-small w3-black tablink w3-hover-green w3-small w3-padding-small" 
    			type="submit" onclick="openAdminPage(event,'userModify')"  >수정</button></form>
    			
    			
    			<form method="post" action="deleteUserPro.jsp" style="display: inline-block;"><button class="w3-padding-small w3-hover-red
    			 w3-button w3-small w3-black w3-padding-small" type="submit"  >탈퇴</button>
    			 <input type="hidden" name="pageNum" value="<%= pageNum%>">
    			<input type="hidden" name="id" value="<%= user.getId()%>">
    			<input type="hidden" name="pwd" value="<%=user.getPwd() %>"></form></td>

    		</tr>
    		<%} %>
    </table>
    
    <!-- 하단 페이징    -->
    <div class="w3-section">
    <% int bottomLine=5;
    	
    	if(count>0){
    		int pageCount=count/pageSize+(count%pageSize==0?0:1);
    		int startPage=1+(currentPage-1)/bottomLine*bottomLine;
    		int endPage=startPage+bottomLine-1;
    	
    		if(endPage>pageCount)endPage=pageCount;
    	
    		if(startPage>bottomLine){%>
    		<a href="admin_userlist.jsp?pageNum=<%=startPage-bottomLine %>&select=auserlist" class="w3-bar-item w3-button w3-hover-black">«</a>
    		<%} %>
    	
    		<%
    		for(int i=startPage;i<=endPage;i++){
    		 
    		if(i!=currentPage) { %>
    		<a href="admin_userlist.jsp?pageNum=<%=i %>&select=auserlist" class="w3-bar-item w3-button w3-hover-black"><%=i %></a>
    		<%}
    		else  {%>
    		<a href="admin_userlist.jsp?pageNum=<%=i %>&select=auserlist" class="w3-bar-item w3-black w3-button"><%=i %></a>
    		
    		
    		<%}
    	
    		if(endPage<pageCount){
    		%>
    		<a href="admin_userlist.jsp?pageNum=<%=startPage+bottomLine %>&select=auserlist" class="w3-bar-item w3-button w3-hover-black">»</a>
    			<%} }	
    		} 
    		%>
    		</div>
    		<%
    	}
    	%>