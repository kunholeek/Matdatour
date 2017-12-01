<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table style="width: 700px">
		<c:forEach var="row" items="${replyList}">
			<tr>
				<td>${row.user_nick}
				<td><fmt:formatDate value="${row.regdate}" pattern="yyyy-MM-dd" />
				<td>${row.c_comment}</td>
				<td><button>X</button></td>
			</tr>



		</c:forEach>
	</table>
</body>
</html>