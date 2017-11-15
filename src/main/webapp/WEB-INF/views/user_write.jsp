<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
div.userwritestyle {
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

<title>Insert title here</title>
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
	<div class="userwritestyle">
		<center>
			<button type="button"
				class="btn btn-outline-secondary btn-lg btn-block">SIGN UP</button>
			<form name="signup" method="post" action="insert.do">
				<table class="table table-striped table-hover table-bordered">
					<tralign="center">
					<td>아이디</td>
					<td><input type="text" class="form-control" name="user_id"></td>
					</tr>
					<tralign="center">
					<td>비밀번호</td>
					<td><input type="password" class="form-control"
						name="user_pwd"></td>
					</tr>
					<tralign="center">
					<td>닉네임</td>
					<td><input type="text" class="form-control" name="user_nick"></td>
					</tr>
					<tralign="center">
					<td>휴대폰</td>
					<td><input type="text" class="form-control" name="user_phone"></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><button type="submit"
								class="btn btn-outline-secondary
							value="확인">
								Submit
								<button type="reset" class="btn btn-outline-secondary value="취소">Cancel</td>
					</tr>
				</table>
			</form>
		</center>
</body>
</html>