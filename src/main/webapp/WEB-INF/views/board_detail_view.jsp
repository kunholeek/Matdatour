<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true"%>
<!DOCTYPE html>
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
	margin: 60px;
	bottom: 30px;
}

div.form-group {
	margin: 50px;
}

#comments {
	width: 40%;
	margin: auto;
}

.scroll_table table {
	border-collapse: collapse;
}

.scroll_table tbody#tbody1 {
	overflow-y: scroll;
	display: table-caption;
}

#tbody2 {
	overflow: hidden;
}

.scroll_table table th {
	padding: 10px;
}

.scroll_table table td {
	padding: 10px;
}

.scroll_table table td div {
	display: block;
}

#leftcontent {
	width: 40%;
	float: left;
}

.footer {
	clear: both;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ed6070bb4d07348ab14113cdaebe6664&libraries=services"></script>
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
									history.go(0);
								}
							});
						});

				/* ************************toggle********************* */

				$("#mapbutton").click(function() {
					$(".collapse").collapse('toggle');

					/* $(".map_wrap").css({"display": "block", "height":"0", "overflow":"hidden" }); 
					$("#map").css({"display": "block", "height":"auto" }); */

				});
				/************************************************************************************************/
				$("#btnDelete").click(function() {
					if (confirm("삭제하시겠습니까?")) {
						document.writing.action = "delete.do?";
						document.writing.submit();
					}
				});

				$("#btnUpdate").click(function() {

					/* $("#f").serialize() ->?board_num=100&board_group=한식 */

					//var str = $("#writing").serialize();
					//alert(str);
					document.writing.action = "boardUpdate.do"
					// 폼에 입력한 데이터를 서버로 전송
					document.writing.submit();
				});

				$("#btnList").click(function() {
					location.href = "list.do?board_group=${dto.board_group}";
				});
				
				$("#btnCUpdate").click(function(){ 
					alert(c_num);
					location.href = "../reply/update.do?board_num=${dto.board_num}&c_num=${row.c_num}&c_comment=${c_com}";
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
  	function fUpdate(c_num, num){
	
		alert(c_num);
		alert(num);
		
		
		
		location.href = "../reply/update.do?board_num=${dto.board_num}&c_num="+c_num+"&c_comment="+c_comment[num].value;
		
	}  
  	
  	
  	function call(board_num, c_num, num){
  		c_comment = $("input[name='c_comment2']");
  		console.log(num + ":"  + c_comment)	;
  		alert(num + ":" + c_comment[num].value);
  		location.href = "../reply/update.do?board_num="+board_num+"&c_num="+c_num +"&c_comment="+ c_comment[num].value;
  	}
  	

	/********************************************************************************************************/
</script>
</head>

<body>
	<!--style="background-color:#78c2ad2e;"  -->
	<%@ include file="menu.jsp"%>
	<br>
	<br>
	<div class="boarddetailstyle">
		<button type="button"
			class="btn btn-outline-secondary btn-lg btn-block" id="mapbutton">BOARD
			DETAIL</button>


		<table id="leftcontent">
			<tr>
				<td>
					<form name="writing" method="post" id="writing">
						<div>
							<!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 -->
							DATE :
							<fmt:formatDate value="${dto.board_date}" pattern="yyyy-MM-dd" />
							<!-- 날짜 형식 => yyyy 4자리연도, MM 월, dd 일, a 오전/오후, HH 24시간제, hh 12시간제, mm 분, ss 초 -->
						</div>

						<!-- 글 제목 div  -->
						<div>TITLE : ${dto.title}</div>
						<br>
						<!-- 콘텐츠 div -->
						<div>
							<div style="text-align: center">
								<br> 
								<img src="${pageContext.request.contextPath}/upload/${dto.m_image }" class="rounded" width="70%" height="70%"><br>
							</div>
							
							<div>
								NICKNAME : <b>${nick}</b>
							</div>
							
							<div>
								<br> ${dto.m_content}<br>
							</div>
							
						</div>
						<br> <br>

						<div style="width: 650px; text-align: center; position: relative;">

							<!-- 게시물 hidden으로 처리 -->
							<input type="hidden" name="board_num" value="${dto.board_num}">
							<input type="hidden" name="board_group"	value="${dto.board_group}"> 
							<input type="hidden" name="title" value="${dto.title}">
							<input type="hidden" name="m_content" value="${dto.m_content}"> 
							<input type="hidden" name="m_image" value="${dto.m_image }">

							<c:if test="${dto.user_num == sessionScope.user_num}">
								<button type="button" class="btn btn-outline-success" id="btnUpdate">수정</button>
								<button type="button" class="btn btn-outline-secondary" id="btnDelete">삭제</button>
							</c:if>
							
							<button type="button" id="btnList" class="btn btn-outline-danger">목록</button>
							
						</div>
					</form> 
					<br> 
					<br>
				</td>
			</tr>
		</table>
		<!-- ********************* 작성한 댓글 목록**************************************  -->
		<br> 
		<br>
		
		<div class="scroll_table">
			<table class="table table-striped table-hover table-bordered" id="comments">
				<hr>
				
				<!-- 리플 리스트  -->
				<tbody id="tbody1" style="height: 600px;">
				<c:set var="num" value="0"/>
					<c:forEach var="row" items="${commentlist}">
						<tr>
							<td style="width: 20%">${row.c_replyer}<input type="hidden"	id="c_replyer" value="${row.c_replyer}"></td>
							<td style="width: 70%">
							<c:if test="${sessionScope.user_id != row.c_replyer}">
 								${row.c_comment}
							</c:if> 
							<c:if test="${sessionScope.user_id == row.c_replyer}">
								<input type=text class="form-control" name="c_comment2"  value="${row.c_comment}">
								<!----------------------------댓글 삭제 버튼----------------> 
								<input type="hidden" id="c_num" value="${row.c_num }">
									<a href = "javascript:call(${dto.board_num},${row.c_num},${num})">✎</a>
									<a href="../reply/delete.do?board_num=${dto.board_num}&c_num=${row.c_num }">x</a>
								<c:set var="num" value="${num+1 }"/>
								</c:if>
								</td>
						</tr>
					</c:forEach>
				</tbody>
				<!-- ******************************************  -->



				<!-- 리플 등록  -->
				<tbody id="tbody2">
					<tr>
						<td colspan="2">
							<!-- **로그인 한 회원에게만 댓글 작성폼이 보이게 처리 --> <c:if
								test="${sessionScope.user_id != null}">
								<br>
								<textarea class="form-control" id="c_comment"
									placeholder="댓글을 작성해주세요"></textarea>
								<br>
								<button type="button" class="btn btn-primary btn-lg btn-block"
									id="btnReply">COMMENT</button>
							</c:if>
						</td>
					</tr>
				</tbody>
				<!-- 리플 등록  -->
			</table>
		</div>
		<!-- **************************************************************************************  -->
		<!-- ********************* 댓글 등록**************************************  -->
		<div class="form-group">
			<input type="hidden" id="board_num" value="${dto.board_num }">
			<input type="hidden" id="user_num" value="${sessionScope.user_num }">
			<input type="hidden" id="user_nick" value="${sessionScope.user_nick}">

		</div>
		<!-- **************************************************************************************  -->
	</div>
	<!-- ******************************table 2개 div 끝****************************  -->

	<!--**************************** MAP 띄우기 ****************************-->

	<footer>

		<div class="footer">
			<table>
				<tr>
					<td><%@include file="mapview.jsp"%></td>
				</tr>
			</table>
		</div>
	</footer>
	<!-- ****************************************************************** -->
</body>
</html>
