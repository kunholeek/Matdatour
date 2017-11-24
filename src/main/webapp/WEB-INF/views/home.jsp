<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>

<html>
<head>

<title>Home</title>
<%-- <%@ include file="include/header.jsp" %> --%> 
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script> 
<style>
/* Make the image fully responsive */
.carousel-inner img {
	width: 100%;
	height: 60%;
}
</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(
		function() {
		$("#btnSearch").click(function(){
		
			alert($("#search"));
	
		
		});
		});
</script>
	
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div id="demo" class="carousel slide" data-ride="carousel">
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="../img/desert.jpg" alt="desert" width="1100" height="500">
      <div class="carousel-caption">
        <h3>Los Angeles</h3>
        <p>We had such a great time in LA!</p>
      </div>   
    </div>
    <div class="carousel-item">
      <img src="../img/japanese.jpg" alt="japanese" width="1100" height="500">
      <div class="carousel-caption">
        <h3>Chicago</h3>
        <p>Thank you, Chicago!</p>
      </div>   
    </div>
    <div class="carousel-item">
      <img src="../img/sushi.jpg" alt="sushi" width="1100" height="500">
      <div class="carousel-caption">
        <h3>New York</h3>
        <p>We love the Big Apple!</p>
      </div>   
    </div>
  </div>
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>
	<form id ="search" name ="search">
	<br>
		<p><input type="text" id="search">  <button type="button" id="btnSearch">검색</button></p>
	<br>
	</form>

	
	
	
	
	
	<c:if test="${msg == 'success'}">
		<right><h2>${sessionScope.user_nick}(${sessionScope.user_id})님환영합니다.</h2></right>
	</c:if>
	<%-- <%=request.getSession().getAttribute("user_nick")%> --%>
</body>
</html>