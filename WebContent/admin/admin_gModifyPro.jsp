
<%@page import="db.AuctionDBBean"%>
<%@page import="db.UserlistDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${chk==1 }">

	<script>
		alert("정보 수정 완료");
		</script>
	<meta http-equiv="Refresh" content="0;url=admin_gproductModify?num=${num }&select=agpurchase">
	</c:if>
	<c:if test="${chk!=1 }">

		<script>
		alert("정보 수정 오류");
		history.go(-1);		//바로 전 화면으로 이동(updateForm.jsp)
		</script>
	
</c:if>



</body>
</html>