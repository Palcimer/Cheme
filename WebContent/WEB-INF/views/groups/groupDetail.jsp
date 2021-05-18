<%@page import="gnotice.model.vo.GNotice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<GNotice> list = (ArrayList<GNotice>)request.getAttribute("list");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/bootstrap.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<div class="container">
	테스트테스트
		<table>
			<%for(GNotice n : list) {%>
			<tr>
				<td><a href="/gNoticeView?noticeNo=<%=n.getgNoticeNo()%>"><%=n.getgNoticeTitle() %></a></td>
				<td><%=n.getgNoticeDate() %></td>
			</tr>
			<%} %>
		</table>
	</div>
</body>
</html>