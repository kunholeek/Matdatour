<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
div.boardliststyle {
	width: 1000px;
	margin: auto;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>게시글 목록</title>
<script>
	$(document).ready(function() {
		$("#btnWrite").click(function() {
			// 페이지 주소 변경(이동)
			location.href = "write.do";
		});
	});
</script>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<br><br>
	<div class="boardliststyle">
		<center>
			<button type="button" class="btn btn-secondary">BOARD LIST</button>
 
			<form action="list.do" method="get">
				<table class="table table-striped table-hover table-bordered ">
					<tr class="table-secondary">
						<th>제목</th>
						<th>닉네임</th>
						<th>작성일</th>
						<!-- <th>평점</th> -->
					</tr>
					<c:set var="num" value="0"></c:set>
					<c:forEach var="row" items="${board_list}">
						<tr>
							<td><a
								href="view.do?board_num=${row.board_num}&user_nick=${row.user_nick}">${row.title}</a></td>
							<td>${row.user_nick}</td>
							<td>
								<!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 --> <fmt:formatDate
									value="${row.board_date}" pattern="yyyy-MM-dd HH:mm:ss" />
							</td>
							<!--  평점 구축 예정 -->
							<!-- <td></td> -->
						</tr>
						<c:set var="num" value="${ num+1}"></c:set>
						<c:if test="${num%5==0}">
							<br>
						</c:if>
					</c:forEach>
				</table>
			</form>
			<button type="button" class="btn btn-outline-danger" id="btnWrite">글쓰기</button>
		</center>
	</div>
</body>
</html>