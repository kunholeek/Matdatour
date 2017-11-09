<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
	<center>
		<H1>로그인</H1>
		<form name="login" action="home.jsp" method="post">
			<table border="1" width="400px">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="user_id" id="user_id"></td>
				</tr>

				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="user_pwd" id="user_pwd"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="button" id="btnLogin">로그인</button> <c:if
							test="${msg == 'failure'}">
							<div style="color: red">아이디 또는 비밀번호가 일치하지 않습니다.</div>
						</c:if> <c:if test="${msg == 'logout'}">
							<div style="color: red">로그아웃되었습니다.</div>
						</c:if>
					</td>
				</tr>

			</table>

		</form>
	</center>
</body>
</html>