<%@page import="reply.WriteMessageService"%>
<%@ page contentType="text/html; charset=utf-8" %>

<jsp:useBean id="message" class="db.MessageDataBean">
	<jsp:setProperty name="message" property="*" />
</jsp:useBean>
<%
String pageNum=request.getParameter("pageNum");
String num=request.getParameter("num");
String pronum=request.getParameter("pronum");
	WriteMessageService writeService = WriteMessageService.getInstance();
	writeService.write(message);
	
%>
<html>
<head>
	<title>방명록 메시지 남김</title>
</head>
<body>
방명록에 메시지를 남겼습니다.
<br/>
<a href="list.jsp">[목록 보기]</a>
<%
request.setAttribute("pageNum", pageNum);
request.setAttribute("num",num);
request.setAttribute("pronum", pronum);

if(pronum.substring(0, 1).equals("g")){
	response.sendRedirect(request.getContextPath()+"/page/gcontent?part=reply&pageNum="+pageNum+"&num="+num+"&pronum="+pronum); 
}
if(pronum.substring(0, 1).equals("a")){
	response.sendRedirect(request.getContextPath()+"/page/acontent?part=reply&pageNum="+pageNum+"&num="+num+"&pronum="+pronum); 
}

%>

</body>
</html>