<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
div.boardwritestyle {
	width: 1000px;
	margin: auto;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>게시글 작성</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<br>
	<br>
	<div class="boardwritestyle">
		<center>
			<button type="button" class="btn btn-outline-secondary">BOARD WRITE</button>
			
			<form name="writing" method="post" action="update.do"  
				enctype="multipart/form-data">
				
				
				<div>
					<label class="col-form-label" for="inputDefault">TITLE </label> 
					<input	name="title" class="form-control" id="title" value="<%=request.getParameter("title")%>">
				</div>
				<br>
				
				
				
				<div class="form-group1">
					<label for="exampleTextarea">CONTENTS</label>
					<textarea class="form-control" name="m_content" id="m_content"
						rows="3"
						style="margin-top: 0px; margin-bottom: 0px; height: 176px;"
						>${m_content}</textarea>
				</div>
 
 
 
 
				<div class="form-group2">
					<label for="exampleImageUpload">사진 업로드</label> 
					<input type="file" class="form-control-file" name="pic">
					
					<%-- -------------<%=request.getParameter("m_image")%>-------------- --%>
				</div>
				 <%-- value = "<%=request.getParameter("m_image")%>" --%>
				
				
				
				
				
				
				<div class="form-group3">
					<label>말머리</label> <select name="board_group" id="board_group" 
						class="form-control">
						<option value='<%=request.getParameter("board_group")%>' selected><%=request.getParameter("board_group")%></option>
						<option value="한식">한식</option>
						<option value="일식">일식</option>
						<option value="중식">중식</option>
						<option value="양식">양식</option>
						<option value="기타">기타</option>
					</select>
				</div>
				
				
				
				
				
				<div class="form-group4">
					<label class="col-form-label" for="inputDefault">NICKNAME</label> 
					<input name="user_nick" id="user_nick" class="form-control"  disabled="" value="<%=request.getSession().getAttribute("user_nick")%>">
					<!--  -->
					<!-- 닉네임  -->
					<input type="hidden" name="user_num" id="user_num"
						value="<%=request.getSession().getAttribute("user_num")%>">
					<input type="hidden" name="board_num" id="board_num"
						value="<%=request.getParameter("board_num")%>">
					<input type="hidden" name="m_image" id="m_image"
						value="<%=request.getParameter("m_image")%>">
					<!--  -->
				</div>
				<br> <br>
				
				
				<div style="width: 650px; text-align: center;">
					<input type="submit" class="btn btn-outline-success" id="btnUpdate" value="수정">
					<button class="btn btn-outline-danger" type="reset">취소</button>
				</div>
			</form>
		</center>
</body>
</html>
