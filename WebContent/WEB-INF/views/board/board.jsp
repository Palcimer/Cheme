<%@page import="member.model.vo.Member"%>
<%@page import="board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
    String pageNavi = (String)request.getAttribute("pageNavi");
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<br>
	<br>
	<br>
	<div class="container">
		<fieldset>
			<legend>공지사항</legend>
			<%if(m != null && m.getMemberLv() == 1) {%>
			<div id ="createBtn">
				<a class="btn btn-info writeBt" href="/boardWriteFrm">글쓰기</a>
			</div>
			<%} %>
			<table id ="boardTable" class="table-hover" style="width:100%;">
				<tr class="table-primary" style="text-align: center; height : 50px;">
					<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th>
				</tr>
				<%for(Board b : list){ %>
				<tr id = "boardList" class="table-light">
					<td style="text-align: center;"><%=b.getRnum() %></td>
					<td style="text-align: center;"><a href="/boardView?boardNo=<%=b.getBoardNo()%>"><%=b.getBoardTitle() %></a></td>
					<td style="text-align: center;"><%=b.getBoardWriter() %></td>
					<td style="text-align: center;"><%=b.getDate() %></td>
				</tr> 
				<%} %>
			</table>
			
			<div id="pageNavi"><%=pageNavi%></div>
			
		</fieldset>	
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<style>
		#boardList{
			height : 50px;
		}
		#boardTable{
			text-aline:center;
			margin:0 auto;
		}
		#createBtn{
			float : right;
			padding-bottom:10px;
		}
		#pageNavi{
		padding-top:20px;
		}
		
	</style>
</body>
</html>









