<%@page import="gallery.model.vo.Gallery"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Gallery> list = (ArrayList<Gallery>)request.getAttribute("list");
    String pageNavi = (String)request.getAttribute("pageNavi");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<fieldset>
			<legend>갤러리</legend>
			<table class="table-hover" style="width:100%;">
			</table>
			<div id="pageNavi"><%=pageNavi %></div>
		</fieldset>
	</div>
</body>
</html>