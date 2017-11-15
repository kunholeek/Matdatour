<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
div.loginstyle {
	width: 500px;
	margin: auto; 
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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


<title>맛다퉈 - 로그인</title>
<script>
	$(document).ready(function() {
		$("#btnLogin").click(function() {
			// 태크.val() : 태그에 입력된 값
			// 태크.val("값") : 태그의 값을 변경 
			var user_id = $("#user_id").val();
			var user_pwd = $("#user_pwd").val();
			if (user_id == "") {
				alert("아이디를 입력하세요.");
				$("#user_id").focus(); // 입력포커스 이동
				return; // 함수 종료
			}
			if (user_pwd == "") {
				alert("아이디를 입력하세요.");
				$("#user_pwd").focus();
				return;
			}
			// 폼 내부의 데이터를 전송할 주소
			document.login.action = "loginCheck.do"
			// 제출
			document.login.submit();
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
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="loginstyle">
		<center>
			<button type="button"
				class="btn btn-outline-secondary btn-lg btn-block">LOGIN</button>
			<form name="login" action="home.jsp" method="post">
				<table class="table table-striped table-hover table-bordered">
					<tbody class="tbody-dark">
						<tr align="center">
							<td>아이디</td>
							<td><input type="text"  class="form-control" name="user_id" id="user_id"></td>
						</tr>

						<tr align="center">
							<td>비밀번호</td>
							<td><input type="password"  class="form-control" name="user_pwd" id="user_pwd"></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<button type="button" id="btnLogin" class="btn btn-secondary">로그인</button>
								<c:if test="${msg == 'failure'}">
									<div style="color: red">아이디 또는 비밀번호가 일치하지 않습니다.</div>
								</c:if> <c:if test="${msg == 'logout'}">
									<div style="color: red">로그아웃되었습니다.</div>
								</c:if>
							</td>
						</tr>
					</tbody>
				</table>
	</div>

	</form>
	</center>
</body>
</html>