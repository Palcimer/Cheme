<%@page import="gnotice.model.vo.GNotice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    GNotice gNotice = (GNotice)request.getAttribute("gNotice");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<table class="table">
			<tr class="table-success">
				<td><%=gNotice.getgNoticeTitle() %></td>
				<td><%=gNotice.getgNoticeDate() %></td>
			</tr>
			<tr>
				<td colspan="2"><%=gNotice.getgNoticeContent() %></td>
			</tr>
			<%if(gNotice.getFilename() != null) {%>
			<tr>
				<td colspan="2"><%=gNotice.getFilename() %></td>
			</tr>
			<%} %>
		</table>
	</div>
</body>
</html>