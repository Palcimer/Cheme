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
<style>
	.photoWrapper{
		padding-top : 20px;
		clear : right;
		display : flex;
		justify-content : space-around;
		flex-wrap : wrap;
	}
	.photo{
		border : 1px solid #ccc;
		margin-top : 30px;
		width : 18%;
		height : 122px;
		overflow : hidden;
		transition-duration : 1s;
	}
	.photo>img{
		width : 100%;
		height : 100px;
	}
	.photo>p{
		text-align : center;
	}
	.photo>img:hover{
		transform : scale(1.4);
	}
</style>
</head>
<body>
	
	<div class="container">
		<fieldset>
			<legend>갤러리</legend>
				<div class="photoWrapper">
					<img src="/upload/photo/"+p.filepath>;
					<p class="caption">+p.photoContent+"</p>";
				</div>
			<div id="pageNavi"><%=pageNavi %></div>
		</fieldset>
	</div>
</body>
</html>