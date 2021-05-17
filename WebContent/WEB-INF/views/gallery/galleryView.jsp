<%@page import="gallery.model.vo.GalleryComment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="gallery.model.vo.Gallery"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Gallery g = (Gallery)request.getAttribute("g");
    	ArrayList<GalleryComment> list = (ArrayList<GalleryComment>)request.getAttribute("list");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/gallery/freeHeader.jsp" %>
	<div class="container">
		<fieldset>
			<table class="table" id="galleryView" style="width:100%;">
				<tr class="table-info">
					<th colspan="4"><%=g.getGalleryContent() %></th>
				</tr>
				<tr class="table-light">
					<th>작성자</th>
					<th><%=g.getGalleryWriter() %></th>
					<th>작성일</th>
					<th><%=g.getGalleryDate() %></th>
				</tr>
				<tr>
					<th>첨부파일</th>
					<th colspan="3">
			</table>
		</fieldset>
	</div>
</body>
</html>