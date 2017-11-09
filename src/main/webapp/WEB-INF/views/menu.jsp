<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- jstl 코어 태그 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<a href="list.do">회원 목록</a>
<c:choose>
    <c:when test="${sessionScope.user_id == null}">
        <a href="login.do">로그인</a>
    </c:when>
    <c:otherwise>
        ${sessionScope.user_nick}님이 로그인중입니다.
        <a href="logout.do">로그아웃</a>
    </c:otherwise>
</c:choose>
    
<hr>
