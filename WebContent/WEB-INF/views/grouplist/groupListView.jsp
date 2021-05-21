<%@page import="group.model.vo.Group"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<Group> list = (ArrayList<Group>) request.getAttribute("list");
String pageNavi = (String) request.getAttribute("pageNavi");

int groupCategory = (Integer) request.getAttribute("groupCategory");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<br>
	<br>
	<br>
	<div class="container">
		<fieldset>
			<div class="categoryWrap">
               <a type="button" class="btn btn-primary" href="/groupList?reqPage=1">전체보기</a>
               <a type="button" class="btn btn-secondary" href="/groupListView?groupCategory=1&reqPage=1">여행</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=2&reqPage=1">스포츠</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=3&reqPage=1">공연전시</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=4&reqPage=1">이벤트</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=5&reqPage=1">게임</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=6&reqPage=1">공예</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=7&reqPage=1">음악</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=8&reqPage=1">그림</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=9&reqPage=1">사진</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=10&reqPage=1">어학</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=11&reqPage=1">독서</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=12&reqPage=1">기술</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=13&reqPage=1">재태크</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=14&reqPage=1">기타</a>
            </div>
		</fieldset>
		<br>
		<br>
		<br>
		<fieldset>

			<%
			if (groupCategory == 1) {
			%>
			<legend>여행</legend>
			<%
			}
			%>
			<%
			if (groupCategory == 2) {
			%>
			<legend>스포츠</legend>
			<%
			}
			%>
			<%
			if (groupCategory == 3) {
			%>
			<legend>공연전시</legend>
			<%
			}
			%>
			<%
			if (groupCategory == 4) {
			%>
			<legend>이벤트</legend>
			<%
			}
			%>
			<%
			if (groupCategory == 5) {
			%>
			<legend>게임</legend>
			<%
			}
			%>
			<%
			if (groupCategory == 6) {
			%>
			<legend>공예</legend>
			<%
			}
			%>
			<%
			if (groupCategory == 7) {
			%>
			<legend>음악</legend>
			<%
			}
			%>
			<%
			if (groupCategory == 8) {
			%>
			<legend>그림</legend>
			<%
			}
			%>
			<%
			if (groupCategory == 9) {
			%>
			<legend>사진</legend>
			<%
			}
			%>
			<%
			if (groupCategory == 10) {
			%>
			<legend>어학</legend>
			<%
			}
			%>
			<%
			if (groupCategory == 11) {
			%>
			<legend>독서</legend>
			<%
			}
			%>
			<%
			if (groupCategory == 12) {
			%>
			<legend>기술</legend>
			<%
			}
			%>
			<%
			if (groupCategory == 13) {
			%>
			<legend>재태크</legend>
			<%
			}
			%>
			<%
			if (groupCategory == 14) {
			%>
			<legend>기타</legend>
			<%
			}
			%>

			<div class="groupListWrap">
				<%
				for (Group g : list) {
				%>
				<div class="listImg">
					<img src="img/sample.JPG" class="groupListImg">
					<%
					if (m != null) {
					%>
					<a style="text-align: center;"
						href="/groupDetail?Id=1&mem=<%=m.getMemberNo()%>">모임 상세페이지</a>
					<%
					} else {
					%>
					<a style="text-align: center;" href="/groupDetail?Id=1">모임
						상세페이지</a>
					<%
					}
					%>
				</div>
				<%
				}
				%>

			</div>

			<div id="pageNavi"><%=pageNavi%></div>
		</fieldset>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
	<style>
	.categoryWrap{
         display : flex;
      }
      .categoryWrap a {
         margin-left : 2px;   
         flex-grow: 1;
      }
.container {
	margin: 0 auto;
}

.listImg {
	width: 33%;
}

.groupListImg {
	width: 100%;
	height: 300px;
	padding-right: 20px;
	padding-bottom: 20px;
}

.groupListWrap {
	width: 1200px;
	margin: 0 auto;
	padding: 0;
	overflow: hidden;
}

.groupListWrap>div {
	float: left;
	margin: 0;
	padding: 0;
}

.groupList {
	width: 30%;
	margin: 0;
	padding: 0;
}

.groupListㅈ>div {
	width: 30%;
	margin: 0;
	padding: 0;
}

#boardList {
	height: 50px;
}

#boardTable {
	text-aline: center;
	margin: 0 auto;
}

#createBtn {
	float: right;
	padding-bottom: 10px;
}

#pageNavi {
	padding-top: 20px;
}
</style>
</body>
</html>