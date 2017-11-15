<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- jstl 코어 태그 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootswatch/minty/bootstrap.min.css">
<link rel="stylesheet"
	href="https://bootswatch.com/4/minty/bootstrap.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>

<script>
	$(document).ready(function() {
		$("#btnLogout").click(function() {
			// 페이지 주소 변경(이동)
			location.href = "../user/logout.do";
		});
	});
	$(document).ready(function() {
		$("#menuLogin").click(function() {
			// 페이지 주소 변경(이동)
			location.href = "../user/login.do";
		});
	});
</script>


<nav class="navbar navbar-expand-lg navbar-dark bg-primary">

	<a class="navbar-brand" href="../user/home.do">Matdatour</a>

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarColor01" aria-controls="navbarColor01"
		aria-expanded="false" aria-label="Toggle navigation" style="">
		<span class="navbar-toggler-icon"></span>
	</button>




	<div class="collapse navbar-collapse" id="navbarColor01">
		<ul class="nav nav-pills">
			<li class="nav-item"><a class="nav-link active"
				href="../user/home.do">Home <span class="sr-only">(current)</span></a></li>
			<c:choose>
				<c:when test="${sessionScope.user_id == null}">
					<li class="nav-item"><a class="nav-link active"
						href="../user/write.do">Sign up <span class="sr-only">(current)</span></a>
					</li>
				</c:when>

				<c:otherwise>
					<c:if test="${sessionScope.user_id == 'admin'}">
						<li class="nav-item"><a class="nav-link active"
							href="../user/list.do">User List <span class="sr-only">(current)</span></a>
						</li>
					</c:if>


					<li class="nav-item dropdown "><a class="nav-link dropdown"
						data-toggle="dropdown" href="#" role="button"><font
							color="white">Review</font></a>
						<div class="dropdown-menu" x-placement="bottom-start"
							style="position: absolute; transform: translate3d(0px, 40px, 0px); top: 0px; left: 0px; will-change: transform;">
							<a class="dropdown-item" href="../board/list.do?board_group=한식">한
								식</a> <a class="dropdown-item"
								href="../board/list.do?board_group=일식">일 식</a> <a
								class="dropdown-item" href="../board/list.do?board_group=중식">중
								식</a> <a class="dropdown-item"
								href="../board/list.do?board_group=양식">양 식</a> <a
								class="dropdown-item" href="../board/list.do?board_group=기타">기
								타</a>
						</div></li>


					<li class="nav-item"><a class="nav-link active"
						href="../user/home.do">Recipe <span class="sr-only">(current)</span></a>
					</li>


					<li class="nav-item"><a class="nav-link active"
						href="../user/home.do">Tip <span class="sr-only">(current)</span></a>
					</li>

				</c:otherwise>
			</c:choose>
		</ul>
	</div>

	<span> <c:choose>
			<c:when test="${sessionScope.user_id == null}">
				<button type="button" class="btn btn-secondary" id="menuLogin">Login</button>
			</c:when>

			<c:otherwise>

				<font color="white"> ${sessionScope.user_nick}님이 로그인중입니다.</font>
				<button type="button" class="btn btn-secondary" id="btnLogout">Logout</button>

			</c:otherwise>

		</c:choose>
	</span>

</nav>
