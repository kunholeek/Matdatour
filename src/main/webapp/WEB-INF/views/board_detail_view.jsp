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
	$(document)
			.ready(
					function() {

/************************************************************************************************/
						$("#btnDelete")
								.click(
										function() {
											if (confirm("삭제하시겠습니까?")) {
												document.writing.action = "delete.do?";
												document.writing.submit();
											}
										});

						$("#btnUpdate").click(function() {
						
							/* $("#f").serialize() ->?board_num=100&board_group=한식 */
									
							var str = $("#writing").serialize();
							document.writing.action = "boardUpdate.do?"+str
							// 폼에 입력한 데이터를 서버로 전송
							document.writing.submit();
						});

						$("#btnList")
								.click(
										function() {
											location.href = "list.do?board_group=${dto.board_group}";
										});

					});
	/********************************************************************************************************/
</script>


</head>
<body >
<!--style="background-color:#78c2ad2e;"  -->
	<%@ include file="menu.jsp"%>
	<br>
	<br>
	<div class="boarddetailstyle">
		<button type="button"
			class="btn btn-outline-secondary btn-lg btn-block">BOARD
			DETAIL</button>
		<form name="writing" method="post" id="writing">

			<div>
				<!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 -->
				DATE :
				<fmt:formatDate value="${dto.board_date}"
					pattern="yyyy-MM-dd a HH:mm:ss" />
				<!-- 날짜 형식 => yyyy 4자리연도, MM 월, dd 일, a 오전/오후, HH 24시간제, hh 12시간제, mm 분, ss 초 -->
			</div>
			
		<!-- 글 제목  -->
			<div>TITLE : ${dto.title}</div>
			<br>
			<div>
				<center>
					<img
						src="${pageContext.request.contextPath}/upload/${dto.m_image }" class="rounded"
						width="90%" height="90%">
				</center>
			</div><br>
		<!-- 글내용  -->
			<div>CONTENT :</div><br>
			<div class="card border-dark">
				<div class="card-body" id="contentbody">
					<blockquote class="card-blockquote">${dto.m_content}</blockquote>
				</div>
			</div>
			
			<div>NICKNAME : ${nick}</div>
			<div style="width: 650px; text-align: center;">



				<!-- 게시물 hidden으로 처리 -->
				<input type="hidden" name="board_num" value="${dto.board_num}">
				<input type="hidden" name="board_group" value="${dto.board_group}">
				<input type="hidden" name="title" value="${dto.title}">
				<input type="hidden" name="m_content" value="${dto.m_content}">
				<input type="hidden" name="m_image" value="${dto.m_image }">
			
				<c:if test="${dto.user_num == sessionScope.user_num}">
					<button type="button" class="btn btn-outline-success"
						id="btnUpdate">수정</button>
					<button type="button" class="btn btn-outline-secondary"
						id="btnDelete">삭제</button>
				</c:if>
				<button type="button" id="btnList" class="btn btn-outline-danger">목록</button>
			</div>


		</form>
	</div>

</body>
</html>
