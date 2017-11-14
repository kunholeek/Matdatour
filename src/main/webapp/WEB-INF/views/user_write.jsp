<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jsp"%>
	<h2>회원등록폼</h2>
	<form name="signup" method="post" action="insert.do">
		<table border="1" width="400px">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="user_id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="user_pwd"></td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td><input type="text" name="user_nick"></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="user_phone"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="확인">
					<input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>