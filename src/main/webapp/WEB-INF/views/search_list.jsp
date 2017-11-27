<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
div.boardliststyle {
	width: 1024px;
	margin: auto;
}

.horizonAlign {
	width: 100%;
}

.horizonAlign div {
	display: inline-block;
	margin: 5px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>게시글 목록</title>
<script>
	$(document).ready(function() {
		$("#btnWrite").click(function() {
			// 페이지 주소 변경(이동)
			location.href = "write.do";
		});
	});
</script>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<br>
	<br>
	<br>
	<br>
	<div class="boardliststyle">
		<center>
			<button type="button" class="btn btn-secondary">BOARD LIST</button>
		</center>
		<div style="text-align: right;">
			<button type="button" class="btn btn-outline-danger" id="btnWrite">글쓰기</button>
		</div>
		<hr>
		<br>
		<form action="list.do" method="get">
			<div class="horizonAlign" width="25%" hieght="25%">
		<c:set var="num" value="0"></c:set>
		<c:forEach var="row" items="${map.slist}">
			<div>
				<a
					href="view.do?board_num=${row.board_num}&user_nick=${row.user_nick}">
					<img width="320px" height="240px"
					src="${pageContext.request.contextPath}/upload/${row.m_image}"
					class="rounded" width="70%" height="70%">
				</a><br> <b>${row.user_nick} </b><a
					href="view.do?board_num=${row.board_num}&user_nick=${row.user_nick}">${row.title}</a><br>
				<fmt:formatDate value="${row.board_date}" pattern="yyyy-MM-dd" />
				<br>

			</div>
			<c:set var="num" value="${ num+1}"></c:set>
			<c:if test="${num%5==0}">
			</c:if>
		</c:forEach>
	</div>
		</form>

	</div>
</body>
</html>