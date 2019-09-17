<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="include/header.jsp" %>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<p>
	<a href="${path}/board/list">게시물 목록</a><br>
	<a href="${path}/board/write">게시물 작성</a><br>
	<a href="${path}/board/listPage?num=1">게시물 [페이지]</a><br>	
</p>
</body>
</html>
