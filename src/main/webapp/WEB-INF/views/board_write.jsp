<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>게시글 작성</title>
<script>
	$(document).ready(function() {
		$("#btnSave").click(function() {
			var title = $("#title").val();
			var m_content = $("#m_content").val();
			var user_nick = $("#user_nick").val();
			var board_group = $("#board_group").val();

			// 폼에 입력한 데이터를 서버로 전송
			document.writing.submit();
		});
	});
</script>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<h2>게시글 작성</h2>
	<form name="writing" method="post" action="insert.do">

		<div>
			<select name="board_group" id="board_group">
				<option value="1">한식</option>
				<option value="2">일식</option>
				<option value="3">중식</option>
				<option value="4">서양식</option>
				<option value="5">기타</option>
			</select>
		</div>
		<div>
			제목 <input name="title" id="title" size="80" placeholder="제목을 입력해주세요">
		</div>
		<div>
			내용
			<textarea name="m_content" id="m_content" rows="8" cols="80"
				placeholder="내용을 입력해주세요"></textarea>
		</div>
		<div>
			닉네임 <input name="user_nick" id="user_nick"
				value="<%=request.getSession().getAttribute("user_nick")%>">
				<!--  -->
			닉네임 <input name="user_num" id="user_num"
				value="<%=request.getSession().getAttribute("user_num")%>">
					<!--  -->
		</div>
		<div style="width: 650px; text-align: center;">
			<button type="button" id="btnSave">확인</button>
			<button type="reset">취소</button>
		</div>
	</form>
</body>
</html>
