<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<style>
div.mypagestyle {
	width: 500px;
	margin: auto;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>회원정보 상세 페이지</title>
<script>
	$(document).ready(function() {
		$("#btnUpdate").click(function() {
			document.mypage.action = "update.do";
			document.mypage.submit();
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
	<div class="mypagestyle">
		<center>
			<button type="button"
				class="btn btn-secondary btn-lg btn-block">MYPAGE</button>
			<form name="mypage" method="post" action="update.do">
				<table class="table table-striped table-hover table-bordered">
					<tr>
						<td>아이디</td>
						<!-- id는 수정이 불가능하도록 readonly속성 추가 -->
						<td><input name="user_id" class="form-control" value="${user.user_id}"
							readonly="readonly"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" class="form-control" name="user_pwd"
							value="${user.user_pwd}"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input name="user_nick" class="form-control" value="${user.user_nick}"></td>
					</tr>
					<!-- 누락된 부분 -->
					<tr>
						<td>휴대폰</td>
						<td><input name="user_phone" class="form-control" value="${user.user_phone}"></td>
					</tr>

					<tr>
						<td colspan="2" align="center"><input type="button" class="btn btn-primary"
							value="수정" id="btnUpdate"> <input type="button" class="btn btn-secondary"
							value="삭제" id="btnDelete"></td>
					</tr>
				</table>
			</form>
</body>
</html>