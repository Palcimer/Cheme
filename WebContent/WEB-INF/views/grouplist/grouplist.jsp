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
         <div class="categoryWrap">
               <a type="button" class="btn btn-primary" href="/groupList?reqPage=1">전체보기</a>
         </div>
         <div class="categoryWrap">
               <a type="button" class="btn btn-secondary" href="/groupListView?groupCategory=1&reqPage=1">여행</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=2&reqPage=1">스포츠</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=3&reqPage=1">공연전시</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=4&reqPage=1">이벤트</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=5&reqPage=1">게임</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=6&reqPage=1">공예</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=7&reqPage=1">음악</a>
         </div>
         <div class="categoryWrap">
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=8&reqPage=1">그림</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=9&reqPage=1">사진</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=10&reqPage=1">어학</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=11&reqPage=1">독서</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=12&reqPage=1">기술</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=13&reqPage=1">재태크</a>
               <a type="button" class="btn btn-secondary"  href="/groupListView?groupCategory=14&reqPage=1">기타</a>
            </div>
      </fieldset>   
		<br><br><br>
		<fieldset>
			<legend>모임리스트</legend>
			<div class = "groupListWrap">
				<%for(Group g : list){ %>			
				<div class ="listImg">
				<img src ="/upload/grouprepresenphoto/<%=g.getGroupImg()%>" class = "groupListImg">
				<%if(m!= null){ %>
				<a style="text-align: center;" href="/groupDetail?Id=<%=g.getGroupId()%>&mem=<%=m.getMemberNo()%>"><%=g.getGroupName() %></a>
				<%}else{ %>
				<a style="text-align: center;" href="/groupDetail?Id=<%=g.getGroupId()%>"><%=g.getGroupName() %></a>
				<%} %>
				</div>
				<%} %>						
			</div>	
			<div id="pageNavi"><%=pageNavi%></div>
				
		</fieldset>	
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<style>
	.categoryWrap{
         display : flex;
      }
      .categoryWrap a {
         margin : 5px;   
         flex-grow: 1;
         width : 150px
      }
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