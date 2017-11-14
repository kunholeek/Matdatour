<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- jstl 코어 태그 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<center>
	<h1>맛있는거 다 튀어 나와</h1>
</center>
<hr>
<c:choose>
	<c:when test="${sessionScope.user_id == null}">
		<a href="../user/write.do">회원가입</a>
		<a href="../user/login.do">로그인</a>
	</c:when>
	<c:otherwise>
		<a href="../user/home.do">HOME</a>
		<c:if test="${sessionScope.user_id == 'admin'}">
			<a href="../user/list.do">회원 목록</a>
		</c:if>
			<span>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">맛집<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="../board/list.do?board_group=한식">한식</a></li>
						<li><a href="../board/list.do?board_group=일식">일식</a></li>
						<li><a href="../board/list.do?board_group=중식">중식</a></li>
						<li><a href="../board/list.do?board_group=양식">양식</a></li>
						<li><a href="../board/list.do?board_group=기타">기타</a></li>
					</ul></li>
			</span>
		<span> ${sessionScope.user_nick}님이 로그인중입니다. <a
			href="../user/logout.do">로그아웃</a>
		</span>

	</c:otherwise>
</c:choose>

<hr>
