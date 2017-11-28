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

	function searchPWD() {
		f.action = "findpw.do";
		f.method = "get";
		f.submit();
	}
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
				class="btn btn-outline-secondary btn-lg btn-block">SEARCH PASSWORD</button>
			<form name="f" action="find.do" method="post">
				<table class="table table-striped table-hover table-bordered">
					<tbody class="tbody-dark">
					
						<tr align="center">
							<td>ID</td>
							<td><input type="text"  class="form-control" name="user_id" id="user_id"></td>
							</tr>
						<tr align="center">
							<td>전화번호</td>
							<td><input type="text"  class="form-control" name="user_phone" id="user_phone"></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<button type="button" onclick="searchPWD()" class="btn btn-secondary">찾기</button>
								<br>
							</td>
						</tr>
					</tbody>
				</table>
				<div>
				<div style="color: red">${msg }</div>
				<c:if test="${user_pwd != null}">
									<div style="color: red">회원님의 비밀번호는 <b>${user_pwd }</b> 입니다.</div>
				</c:if>
				
				</div>

	</form>
	</center>
	</div>
</body>
</html>