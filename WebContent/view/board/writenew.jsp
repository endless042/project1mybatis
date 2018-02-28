<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
 <%   request.setCharacterEncoding("UTF-8"); %>
    
<form method="post" name="writeform" action="<%=request.getContextPath() %>/view/board/testPro.jsp" >

<input type="hidden" name="test" value="살려줘"> 
<input type="submit" value="확인" >
     
</form>


</body>
</html>