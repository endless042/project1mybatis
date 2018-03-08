<%@page import="reply.MessageListView"%>
<%@page import="reply.GetMessageListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String pageNumberStr = request.getParameter("page");
	String pronum=request.getParameter("pronum");
	String pcode=pronum.substring(0, 1);
	
	System.out.println(pronum);
	int pageNumber = 1;
	if (pageNumberStr != null) {
		pageNumber = Integer.parseInt(pageNumberStr);
	}
	request.setAttribute("pcode", pcode);
	request.setAttribute("pronum", pronum);
	request.setAttribute("pageNumber",pageNumber);
	GetMessageListService messageListService = GetMessageListService.getInstance();
	MessageListView viewData = messageListService.getMessageList(pageNumber, pronum);
%>

<c:set var="viewData" value="<%=viewData%>" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록 메시지 목록</title>
<style type>
.w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}

</style>
</head>
<body>
	<div class="w3-container  w3-margin-bottom w3-small"  >
<c:if test="${viewData.isEmpty() }">

<table class="w3-table w3-border w3-hoverable w3-center w3-small w3-margin-top w3-margin-bottom" width="90%">
    	<tr class="w3-light-grey">
    	<td class="w3-center">등록된 의견이 없습니다.</td>
    	
    	</table>
</c:if>

		<c:if test="${!viewData.isEmpty() }">

			<div>
				
<ul class="w3-ul ">
					<c:forEach var="message" items="${viewData.messageList }">
					
					  
    <li class="w3-bar">
      <span onclick="this.parentElement.style.display='none'" class="w3-bar-item w3-button w3-white   w3-right">&times;</span>
     <span class="w3-small w3-opacity w3-right">${message.rdate }</span>
      <div class="w3-bar-item">
         <%-- <span class="w3-tag w3-white w3-medium w3-margin-bottom">${message.num}</span> --%><span  class="w3-tag w3-medium w3-margin-bottom "><b>${message.userid }</b></span><br>
        <span class="w3-margin-left">${message.content }</span>
      </div>
    </li>

 
					
					
				
				</c:forEach>
 </ul>

			</div>
	<div class="w3-section  w3-center">
			
				<c:forEach var="page" begin="1" end="${viewData.pageTotalCount }">
					<span class="w3-center"><a href="<%=request.getContextPath() %>/page/${pcode }content?part=reply&pageNum=${ pageNum}&num=${num}&pronum=${ pronum}&page=${page}" class="w3-bar-item w3-button w3-hover-black">${page}</a></span>
					
				</c:forEach>
			
</div>
		</c:if>

		<div class="w3-container w3-padding-16 w3-card w3-center">
			<form action="<%=request.getContextPath() %>/reply/writeMessage.jsp" method="post">
				<div class="w3-row-padding" style="margin: 0 -16px 8px -16px">
					<div class="w3-half">
						<input class="w3-input w3-border" type="text" placeholder="이름"
							required name="userid">
					</div>
					<div class="w3-half">
						<input class="w3-input w3-border" type="password"
							placeholder="비밀번호" required name="password">
					</div>
				</div>
				<textarea class="w3-input  w3-border "  placeholder="내용"
					required name="content"></textarea>
					<input type="hidden" name="cururi" value="<%= request.getRequestURI()%>">
					<input type="hidden" name="pageNum" value="${pageNum }">
					<input type="hidden" name="num" value="${num }">
					
					<input type="hidden" name="pronum" value="<%=pronum%>">
					
				<button class="w3-button w3-black w3-section w3-right w3-padding-small" type="submit">전송</button>
			</form>
		</div>

	</div>
</body>
</html>