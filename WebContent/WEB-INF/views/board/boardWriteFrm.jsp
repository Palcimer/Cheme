
<%@page import="board.model.vo.Board"%>
<%@page import="board.model.vo.BoardComment"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    Board b = (Board)request.getAttribute("b");
    ArrayList<BoardComment> list = (ArrayList<BoardComment>)request.getAttribute("list");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	.container{
		padding-top:150px;
	}
	#write-size{
		height:300px;
	}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet"> 
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
  <script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>
  
  
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container">
		<form action="/boardWrite" method="post" enctype="multipart/form-data">
		<fieldset>
				<legend>글쓰기</legend>
				<table class="table table-striped" style="width:100%; height:500px;">
					<tr>
						<th class="danger">제목</th>
						<td colspan="3"><input type="text" class="form-control" name="boardTitle" style="height:30px;"></td>
					</tr>
					<tr>
						<th class="danger">작성자</th>
						<td>
							<input type="hidden" name="boardWriter" value="<%=m.getMemberId()%>">
							<%=m.getMemberId() %>	
						</td>
						<th class="danger">첨부파일</th>
						<td class="danger" style="text-align:left">
							<input type="file" name="filename">
						</td>
					</tr>
					<tr >
						<th class="danger">내용</th>
						<td colspan="3" class="write-size"><textarea name="boardContent" class="form-control" style="height:400px;"></textarea></td>
					</tr>
					<tr>
						<th colspan="4">
							<button type="submit" class="btn btn-danger btn-block" style="background-color:deepskyblue; border-style:none;">공지사항등록</button>
						</th>
					</tr>
				</table>
			</fieldset>
		</form>
		
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>