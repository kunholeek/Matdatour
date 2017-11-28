<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>

<html>
<head>

<title>Home</title>
<%-- <%@ include file="include/header.jsp" %> --%>
<style>
/* Make the image fully responsive */
.carousel-inner img {
	width: 100%;
	height: 60%;
}
</style>

<script>
	$(document).ready(function() {
		$("#btnSearch").click(function() {

			alert($("#search"));

		});
	});

	$(document).ready(function() {
		$("#userWrite").click(function() {
			// 페이지 주소 변경(이동)
			location.href = "../user/write.do";
		});
	});
</script>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="../vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="../vendor/simple-line-icons/css/simple-line-icons.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<link href="../css/landing-page.min.css" rel="stylesheet">


</head>
<body>
	<%@ include file="menu.jsp"%>

	<!-- Navigation -->
	<nav class="navbar navbar-light bg-light static-top">
		<div class="container">
			<a class="navbar-brand" href="#">Start Bootstrap</a> <a
				class="btn btn-primary" href="#">Sign In</a>
		</div>
	</nav>

	<!-- Masthead -->
	<header class="masthead text-white text-center">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-xl-9 mx-auto">
					<h1 class="mb-5">
						<font color="white">Welcome to Matdatour</font>
					</h1>
				</div>
				<div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
					<!-- 검색기능 -->
					<form method="post" action="../board/search.do">
						<div class="form-row">
							<div class="col-3 col-md-4 mb-2 mb-md-0">
								<select class="form-control" name="searchOption">
									<!-- 검색조건을 검색처리후 결과화면에 보여주기위해  c:out 출력태그 사용, 삼항연산자 -->
									<%-- 		<option value="all"
				<c:out value="${map.searchOption == 'all'?'selected':''}"/>>제목+이름+제목</option> --%>
									<option value="title"
										<c:out value="${map.searchOption == 'title'?'selected':''}"/>>TITLE</option>
									<option value="user_nick"
										<c:out value="${map.searchOption == 'user_nick'?'selected':''}"/>>NICKNAME</option>
									<option value="m_content"
										<c:out value="${map.searchOption == 'm_content'?'selected':''}"/>>CONTENT</option>
								</select>
							</div>
							<div class="col-12 col-md-8 mb-3 mb-md-0">
								<input name="keyword" value="${map.keyword}"
									class="form-control form-control-lg1"
									placeholder="keyword를 입력하세요">
							</div>
						</div>
						<br>
						<div class="form-row">
							<div class="col-12 col-md-12 mb-3 mb-md-0">
								<c:if test="${sessionScope.user_id != null }">
									<input type="submit" class="btn btn-block btn-lg btn-primary"
										value="SEARCH">
								</c:if>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</header>

	<!-- Icons Grid -->
	<section class="features-icons bg-light text-center">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
						<div class="features-icons-icon d-flex">
							<i class="icon-screen-desktop m-auto text-primary"></i>
						</div>
						<h3>REVIEW</h3>
						<p class="lead mb-0">유저가 방문한 맛집을 직접 평가하고 후기를 남기는 공간입니다.</p>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
						<div class="features-icons-icon d-flex">
							<i class="icon-layers m-auto text-primary"></i>
						</div>
						<h3>RECIPE</h3>
						<p class="lead mb-0">음식을 직접 만들어보고 회원들과 공유하는 공간입니다.</p>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="features-icons-item mx-auto mb-0 mb-lg-3">
						<div class="features-icons-icon d-flex">
							<i class="icon-check m-auto text-primary"></i>
						</div>
						<h3>TIP</h3>
						<p class="lead mb-0">음식과 관련한 잡다한 지식을 공유하는 공간입니다.</p>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Testimonials -->
	<section class="testimonials text-center bg-light">
		<div class="container">
			<h2 class="mb-5">개발자의 말..말..말..</h2>
			<div class="row">
				<div class="col-lg-4">
					<div class="testimonial-item mx-auto mb-5 mb-lg-0">
						<img class="img-fluid rounded-circle mb-3"
							src="../img/charmander.png" alt="">
						<h5>Lee Kunho</h5>
						<p class="font-weight-light mb-0">"기본에 충실했습니다. 맛다퉈를 즐겨주세요"</p>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="testimonial-item mx-auto mb-5 mb-lg-0">
						<img class="img-fluid rounded-circle mb-3"
							src="../img/squirtle.png" alt="">
						<h5>Lee Jeongwook</h5>
						<p class="font-weight-light mb-0">"국내 최고의 맛집 공유 커뮤니티로 만들고
							싶습니다"</p>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Call to Action -->
	<section class="call-to-action text-white text-center">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-xl-9 mx-auto">
					<h2 class="mb-4">Ready to get started? Sign up now!</h2>
				</div>
				<div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
					<form>
						<div class="form-row">
							<div class="col-12 col-md-12">
								<button type="button" id="userWrite" class="btn btn-primary">
									SIGN UP</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>



	<!-- Bootstrap core JavaScript -->
	<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


</body>
</html>