<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${principal.name}님 로그인!!
	<a href="/security_logout">로그아웃</a><br/>
	<a href="/user/userInfo">내 정보</a>
	<a href="/admin/manageUser">회원 관리</a>
</body>
</html>