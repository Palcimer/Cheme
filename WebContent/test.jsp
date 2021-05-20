<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/bootstrap.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container">
	테스트 from sort222
	테스트2
	테스트3
	테스트4
		<form action="/groupDetail" method="post">
			그룹번호<input type="text" name="Id">
			멤버번호<input type="text" name="mem">
			<input type="submit" value="상세페이지">
		</form>
		<%if(m != null) {%>
    	<a href="/groupDetail?Id=1&mem=<%=m.getMemberNo()%>">모임 상세페이지</a>
    	<% } else {%>
    	<a href="/groupDetail?Id=1">모임 상세페이지</a>
    	<%} %>
    	<a href="/writeGBoardFrm?groupId=1">모임 게시글 쓰기 페이지</a>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
