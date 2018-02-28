<%@page import="guestbook.service.GetMessageListService"%>
<%@page import="guestbook.service.MessageListView"%>
<%@page import="guestbook.model.Message"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String pageNumberStr = request.getParameter("page");

	int pageNumber = 1;
	if (pageNumberStr != null) {
		pageNumber = Integer.parseInt(pageNumberStr);
	}
	GetMessageListService messageListService = GetMessageListService.getInstance();
	MessageListView viewData = messageListService.getMessageList(pageNumber);
%>

<c:set var="viewData" value="<%=viewData%>" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록 메시지 목록</title>
</head>
<body>
	<div class="w3-container  w3-margin-bottom w3-small"  >


		<c:if test="${!viewData.isEmpty() }">

			<div>
				
<ul class="w3-ul ">
					<c:forEach var="message" items="${viewData.messageList }">
					
					  
    <li class="w3-bar">
      <span onclick="this.parentElement.style.display='none'" class="w3-bar-item w3-button w3-white   w3-right">&times;</span>
     <span class="w3-small w3-opacity w3-right">2018-02-27 PM 07:30</span>
      <div class="w3-bar-item">
         <span class="w3-tag w3-white w3-medium w3-margin-bottom">${message.id }</span><span  class="w3-tag w3-medium w3-margin-bottom "><b>${message.guestName }</b></span><br>
        <span class="w3-margin-left">${message.message }</span>
      </div>
    </li>

  <%-- 
					
					<ul class="w3-ul"></ul>
					
					<div class="w3-container w3-card w3-white  w3-margin"><br>
         
        <span class="w3-right w3-opacity">2018-02-27</span>
       <b>${message.guestName }</b>
        <hr >
        <p>${message.message }</p>
        <button type="button" class="w3-button w3-green w3-margin-bottom w3-padding-small">Like</button> 
        <button type="button" class="w3-button  w3-green w3-margin-bottom w3-padding-small">Comment</button> 
        <button class="w3-button w3-black w3-margin-bottom w3-padding-small" type="submit" onclick="location.href='confirmDeletion.jsp?messageId=${message.id }'">삭제</button>
      </div>  
					 --%>
					
					
					
				
				</c:forEach>
 </ul>

			</div>
	<div class="w3-section  w3-center">
			
				<c:forEach var="pageNum" begin="1" end="${viewData.pageTotalCount }">
					<span class="w3-center"><a href="<%=request.getContextPath() %>/reply/list.jsp?page=${pageNum }" class="w3-bar-item w3-button w3-hover-black">${pageNum}</a></span>
					
				</c:forEach>
			
</div>
		</c:if>

		<div class="w3-container w3-padding-16 w3-card w3-center">
			<form action="<%=request.getContextPath() %>/reply/writeMessage.jsp" method="post">
				<div class="w3-row-padding" style="margin: 0 -16px 8px -16px">
					<div class="w3-half">
						<input class="w3-input w3-border" type="text" placeholder="이름"
							required name="guestName">
					</div>
					<div class="w3-half">
						<input class="w3-input w3-border" type="password"
							placeholder="비밀번호" required name="password">
					</div>
				</div>
				<textarea class="w3-input  w3-border "  placeholder="내용"
					required name="message"></textarea>
					<input type="hidden" name="cururi" value="<%= request.getRequestURI()%>">
				<button class="w3-button w3-black w3-section w3-right w3-padding-small" type="submit">전송</button>
			</form>
		</div>

	</div>
</body>
</html>