<%@page import="group.model.vo.Group"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
    ArrayList<Group> list = (ArrayList<Group>)request.getAttribute("list");
    String pageNavi = (String)request.getAttribute("pageNavi");
    
    /* int groupCategory =(Integer)request.getAttribute("groupCategory"); */
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/views/common/header.jsp" %>
	<br>
	<br>
	<br>
	<div class="container">
		<fieldset>
			<legend>카테고리</legend>
			<table id ="boardTable" class="table-hover" style="width:100%;">
				<tr class="table-primary" style="text-align: center; height : 50px;">
					<th><a href="/groupListView?groupCategory=1&reqPage=1">여행</a></th><th><a href="/groupListView?groupCategory=2&reqPage=1">스포츠</a></th><th><a href="/groupListView?groupCategory=3&reqPage=1">공연전시</a></th><th><a href="/groupListView?groupCategory=4&reqPage=1">이벤트</a></th>
					<th><a href="/groupListView?groupCategory=5&reqPage=1">게임</a></th><th><a href="/groupListView?groupCategory=6&reqPage=1">공예</a></th><th><a href="/groupListView?groupCategory=7&reqPage=1">음악</a></th>
				</tr>
				<tr class="table-primary" style="text-align: center; height : 50px;">	
					<th><a href="/groupListView?groupCategory=8&reqPage=1">그림</a></th><th><a href="/groupListView?groupCategory=9&reqPage=1">사진</a></th><th><a href="/groupListView?groupCategory=10&reqPage=1">어학</a></th><th><a href="/groupListView?groupCategory=11&reqPage=1">독서</a></th><th><a href="/groupListView?groupCategory=12&reqPage=1">기술</a></th>
					<th><a href="/groupListView?groupCategory=13&reqPage=1">재태크</a></th><th><a href="/groupListView?groupCategory=14&reqPage=1">기타</a></th>
				</tr>
			</table>
		</fieldset>	
		<br><br><br>
		<fieldset>
			<legend>모임리스트</legend>
			<div class = "groupListWrap">
				<%for(Group g : list){ %>			
				<div class ="listImg">
				<img src = "img/sample.JPG" class = "groupListImg">
				<a style="text-align: center;" href="#"><%=g.getGroupName() %></a>
				</div>
				<%} %>			
			
			</div>	
			<div id="pageNavi"><%=pageNavi%></div>
				
		</fieldset>	
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<style>
		.container{
			margin : 0 auto;
		}
		.listImg{
			width: 33%;
			
		}
		.groupListImg{
			width : 100%;
			height: 300px;
			padding-right : 20px;
			padding-bottom :20px;
		}
		.groupListWrap{
			width : 1200px;
			margin: 0 auto;
			padding:0;
			
			overflow :hidden;
		}
		.groupListWrap>div{
			float:left;
			margin: 0;
			padding:0;
		}
		.groupList{
			width : 30%;
			margin: 0;
			padding:0;
		}
		.groupListㅈ>div{
			width : 30%;
			margin: 0;
			padding:0;
		}
		
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