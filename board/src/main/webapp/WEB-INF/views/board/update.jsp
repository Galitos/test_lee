<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
	<form method="post">
	<input type="hidden" name="bno" value="${view.bno}" />
	
  <div>
    <label>제목</label> <input type="text" name="title" value="${view.title}" />
  </div>

  <div>
    <label>작성자</label> <input type="text" name="writer" value="${view.writer}" readonly="readonly" />
  </div>

  <div>
    <label>작성날짜</label>
    <input type="text" name="regDate" value="<fmt:formatDate value="${view.regDate}" pattern="yyyy-MM-dd" />" readonly="readonly" />
     
  </div>

  <div>
    <label>내용</label>
    <textarea rows="5" cols="50" name="content" >${view.content}</textarea>
  </div>
 

  <div>
    <button type="submit">수정</button>
  </div>
</form>
</body>
</html>