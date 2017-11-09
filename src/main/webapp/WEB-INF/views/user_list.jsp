<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 목록</title>
</head>
<body>
	<h2>회원 목록</h2>
	<input type="button" value="회원등록"
		onclick="location.href='write.do'">
	<table border="1" width="700px">
		<tr>
			<th>아이디</th>
			<th>닉네임</th>
			<th>휴대폰</th>
		</tr>
		<c:forEach var="row" items="${list}">
			<tr>
				<td>${row.user_id}</td>
				<td>${row.user_nick}</td>
				<td>${row.user_phone}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
