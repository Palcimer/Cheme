<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/loginCheck" method ="get">
		<input type="text" placeholder="아이디를 입력해주세요" name="id"><br>
		<input type="text" placeholder = "비밀번호를 입력해주세요" name="pw">
		<input type="submit" value="로그인">
	</form>
</body>
</html>