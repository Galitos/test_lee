<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<table border="1">
 <thead>
  <tr>
   <th>번호</th>
   <th>제목</th>
   <th>작성일</th>
   <th>작성자</th>
   <th>조회수</th>
  </tr>
 </thead>
 
 <tbody>
  	<c:forEach items="${list}" var="list">
 <tr>
  <td>${list.bno}</td>
  <td><a href="${path}/board/view?bno=${list.bno}">${list.title}</a></td>
  <td><fmt:formatDate value="${list.regDate}"
  pattern="yyyy-MM-dd hh:mm:ss"/></td>
  <td>${list.writer}</td>
  <td>${list.viewCnt}</td>
 </tr>
</c:forEach>
 </tbody>

</table>
</body>
</html>