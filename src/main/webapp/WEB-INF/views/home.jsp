<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>

<html>
<head>
<title>Home</title>
<%-- <%@ include file="include/header.jsp" %> --%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>



</head>
<body>
	<%@ include file="menu.jsp"%>

	<c:if test="${msg == 'success'}">
		<h2>${sessionScope.user_nick}(${sessionScope.user_id})님환영합니다.</h2>
	</c:if>
	<%-- <%=request.getSession().getAttribute("user_nick")%> --%>
</body>
</html>