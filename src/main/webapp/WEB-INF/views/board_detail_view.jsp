<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
/* .contents {
	width: 500px;
	height: 500px;
	border: 1px solid lightgray;
	box-sizing: border-box;
}
 */
div.boarddetailstyle {
	width: 500px;
	margin: auto;
}
 
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>게시글 작성</title>
<script>
	$(document).ready(function() {
		$("#btnDelete").click(function() {
			if (confirm("삭제하시겠습니까?")) {
				document.writing.action = "board/delete.do";
				document.writing.submit();
			}
		});

		$("#btnUpdate").click(function() {
			//var title = document.form1.title.value; ==> name속성으로 처리할 경우
			//var content = document.form1.content.value;
			//var writer = document.form1.writer.value;
			var title = $("#title").val();
			var m_content = $("#m_content").val();
			var user_nick = $("#user_nick").val();

			document.writing.action = "board/update.do"
			// 폼에 입력한 데이터를 서버로 전송
			document.writing.submit();
		});
	});
</script>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<br><br>
	<div class="boarddetailstyle">
		<button type="button" class="btn btn-outline-secondary btn-lg btn-block">BOARD
			DETAIL</button>
		<form name="writing" method="post">

			<div>
				<!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 -->
				작성일자 :
				<fmt:formatDate value="${dto.board_date}"
					pattern="yyyy-MM-dd a HH:mm:ss" />
				<!-- 날짜 형식 => yyyy 4자리연도, MM 월, dd 일, a 오전/오후, HH 24시간제, hh 12시간제, mm 분, ss 초 -->
			</div>
			<div>제목 : ${dto.title}</div>
			<br>
			<div>내용 :</div>
			<br>
			<div class="card border-dark">
				<div class="card-body" id="contentbody">
					<blockquote class="card-blockquote">${dto.m_content}</blockquote>

				</div>
			</div>
			<div>닉네임 : ${nick}</div>
			<div style="width: 650px; text-align: center;">



				<!-- 게시물번호를 hidden으로 처리 -->
				<input type="hidden" name="board_num" value="${dto.board_num}">
				<%-- 			 <c:if test="${sessionScope.user_num == ${dto.user_num}"> --%>



				<button type="button" class="btn btn-outline-success" id="btnUpdate">수정</button>
				<button type="button" class="btn btn-outline-secondary" id="btnDelete">삭제</button>
				<%-- </c:if> --%>

			</div>
		</form>

	</div>

</body>
</html>
