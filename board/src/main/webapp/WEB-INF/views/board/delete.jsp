<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<form method="post">

<input type="hidden" name="bno" value="${view.bno}" />

  <div>
    <label>제목</label> <input type="text" name="title" value="${view.title}" readonly="readonly"/>
  </div>

  <div>
    <button type="submit">삭제</button>
  </div>

</form>
</body>
</html>