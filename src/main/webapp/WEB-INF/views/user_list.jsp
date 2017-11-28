<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 목록</title>
<style>
div.boardliststyle {
	width: 1024px;
	margin: auto;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
function delAlert(){
	var user_id = $("#user_id").val();
	alert(user_id);
}
</script>
</head>
<body>
<%@ include file="menu.jsp"%>
<br><br>
<br><br>
	<form id="ulist" name="f" action="" method="post">
	<div class="boardliststyle">
	<button type="button" class="btn btn-secondary">회원 목록</button>
	<input type="button" class="btn btn-outline-danger" value="회원등록"
		onclick="location.href='write.do'">
	<br>
	<br>
	
	<table class="table table-striped table-hover table-bordered">
	<thead class="thead-dark">
		<tr class="table-secondary">
			<th>아이디</th>
			<th>닉네임</th>
			<th>휴대폰</th>
	<!-- 		<th>비고</th>
	 -->
		</tr>
		</thead>
		<tbody>
		<c:forEach var="row" items="${list}">
			<tr>
				<td width="300px"><a href="delete.do?user_id=${row.user_id}">${row.user_id}<input type="hidden" name="user_id" id="user_id" value="${row.user_id}"></a></td>
				
				<td width="300px">${row.user_nick}</td>
				<td width="300px">${row.user_phone}</td>
				<!-- <td width="100px"><button  onclick="delAlert()" id ="btnDel">DEL</button></td> -->
			</tr>
			
		</c:forEach>
		</tbody>
	</table>

	</div>
	</form>
</body>
</html>
