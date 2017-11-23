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
div.form-group {
	width: 500px;
	margin: auto;
}

#comments {
	width: 500px;
	margin: auto;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<title>게시글</title>
<script>
	$(document).ready(
			function() {

				listReply(); // **댓글 목록 불러오기
				//listReply2(); // ** json 리턴방식

				// ** 댓글 쓰기 버튼 클릭 이벤트 (ajax로 처리)
				$("#btnReply").click(
						function() {
							var board_num = $("#board_num").val();
							var user_num = $("#user_num").val();
							var c_comment = $("#c_comment").val();
							var user_nick = $("#user_nick").val();
							var param = "board_num=" + board_num + "&user_num="
									+ user_num + "&c_comment=" + c_comment
									+ "&user_nick=" + user_nick;

							if (c_comment == "") {
								alert("내용을 입력하세요");
								document.form - group.c_comment.focus();
								return;
							}
							$.ajax({
								type : "post",
								url : "../reply/insert.do",
								data : param,
								success : function() {
									alert("댓글이 등록되었습니다.");
									listReply();
								}
							});
						});

				/* ********************************************* */
				$("#btnDelete").click(function() {
					if (confirm("삭제하시겠습니까?")) {
						document.writing.action = "delete.do";
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

					document.writing.action = "update.do"
					// 폼에 입력한 데이터를 서버로 전송
					document.writing.submit();
				});

				$("#btnList").click(function() {
					location.href = "list.do?board_group=${dto.board_group}";
				});

			});

	// Controller방식
	// **댓글 목록1
	function listReply() {
		$.ajax({
			type : "get",
			url : "view.do?board_num=${dto.board_num}",
			success : function(result) {
				// responseText가 result에 저장됨.
				$("#replyList").html(result);
			}
		});
	}
</script>



</head>
<body>
	<%@ include file="menu.jsp"%>
	<br>
	<br>
	<div class="boarddetailstyle">
		<button type="button"
			class="btn btn-outline-secondary btn-lg btn-block">BOARD
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
			<div>
				<%-- 				<img src="upload/${dto.m_image}" />
 --%>
				<%-- <IMG src='../upload/${dto.m_image }'><br> --%>
				<%-- 	<a href="${dto.m_image }">${dto.m_image }</a><br /> <img alt="그림"
					src="${dto.m_image }"> --%>
				<img src="${pageContext.request.contextPath}/upload/${dto.m_image }">
			</div>

			<div>내용 :</div>
			<br>
			<div class="card border-dark">
				<div class="card-body" id="contentbody">
					<blockquote class="card-blockquote">${dto.m_content}</blockquote>

				</div>
			</div>
			<div>닉네임 : ${user_nick}</div>
			<div style="width: 650px; text-align: center;">



				<!-- 게시물번호를 hidden으로 처리 -->
				<input type="hidden" name="board_num" value="${dto.board_num}">
				<%-- 			 <c:if test="${sessionScope.user_num == ${dto.user_num}"> --%>



				<button type="button" class="btn btn-outline-success" id="btnUpdate">수정</button>
				<button type="button" class="btn btn-outline-secondary"
					id="btnDelete">삭제</button>
				<%-- </c:if> --%>
				<button type="button" id="btnList" class="btn btn-outline-danger">목록</button>


			</div>
		</form>
	</div>
	<br>
	<br>



	<div class="form-group">
		<input type="hidden" id="board_num" value="${dto.board_num }">
		<input type="hidden" id="user_num" value="${sessionScope.user_num }">
		<input type="hidden" id="user_nick" value="${sessionScope.user_nick}">

		<!-- **로그인 한 회원에게만 댓글 작성폼이 보이게 처리 -->
		<c:if test="${sessionScope.user_id != null}">
			<br>
			<textarea class="form-control" rows="2" id="c_comment"
				placeholder="댓글을 작성해주세요"></textarea>
			<br>
			<button type="button" id="btnReply">댓글 작성</button>

			<br>
			<br>
	</div>

	<table class="table table-striped table-hover table-bordered"
		id="comments">
		<thead class="thead-dark">
			<tr>
				<th>NickName</th>
				<th>comment</th>
			</tr>
		</thead>

		<hr>
		<tbody>
			<c:forEach var="row" items="${commentlist}">
				<tr>
					<td>${row.c_replyer}</td>
					<td>${row.c_comment}</td>
				</tr>
			</c:forEach>
			</c:if>
		</tbody>
	</table>
</body>
</html>
