<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<form method="post">
  <div>
    <label>제목</label> <input type="text" name="title" value="${view.title}" readonly="readonly"/>
  </div>

  <div>
    <label>작성자</label> <input type="text" name="writer" value="${view.writer}"/>
  </div>

  <div>
    <label>작성날짜</label> <input type="text" name="regDate"
 value="<fmt:formatDate value="${view.regDate}" pattern="yyyy-MM-dd" />"/>
</div>

  <div>
    <label>내용</label>
    <textarea rows="5" cols="50" name="content">${view.content}</textarea>
  </div>
  
   <div>
  	<a href="${path}/board/update?bno=${view.bno}">수정</a><br>
  	<a href="${path}/board/delete?bno=${view.bno}">삭제</a>
  </div>
  
</form>
</body>
</html>