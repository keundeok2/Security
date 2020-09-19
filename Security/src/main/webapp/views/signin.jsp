<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/login" method="post">
ID : <input type="text" name="email">
PW : <input type="password" name="password">
<button type="submit">로그인</button>
</form>
<a href="/signup">회원가입</a>
</body>
</html>