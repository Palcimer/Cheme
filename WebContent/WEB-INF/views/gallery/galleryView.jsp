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
<style>
	.view-photo{
		text-align: center;
	}
	#photo{
		border-bottom: none;
	}
	.view-photo>img{
		width : 750px;
		margin : 0 auto;
	}
	.title{
		text-align: center;
		width : 40%;
	}
	.writer{
		width : 30%;
	}
	.date{
		text-align: right;
		width : 30%;
	}	
	.list{
		text-align: right;
	}
	li{
		list-style-type: none;
		margin-left: 5px;
	}
	.profile{
		width: 100px;
        height: 100px;
	}
	.commentWrap{
		display : flex;
	}
	.btn-box{
		display: flex;
		align-items: flex-end;
	}
	
</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<br><br><br>	
	<div class="container">
		<fieldset>
			<table class="table" id="galleryView" style="width:100%;">
				<tr class="table-light">
					<th scope="col" class=writer>작성자 : <%=g.getGalleryNickName() %></th>
					<th colspan="3" class=title><%=g.getGalleryTitle() %></th>
					<th scope="col" class="date">작성일 : <%=g.getGalleryDate() %></th>
				</tr>
				<tr>
				</tr>
				<tr>
					<th colspan="5" class="view-photo" id="photo"><img src="/upload/photo/<%=g.getGalleryFilepath() %>"></th>
				</tr>
				<tr>
					<td colspan="5"><%=g.getGalleryContentBr() %></td>
				</tr>
			</table>
			<div class="list">
			<button type="button" class="btn btn-secondary" onclick="history.go(-1)">목록가기</button>
			<%if(m!=null && m.getMemberNo() == (g.getGalleryWriter())) {%>
				<a class="btn btn-secondary" href="/galleryUpdateFrm?galleryNo=<%=g.getGalleryNo() %>">수정하기</a>
				<a class="btn btn-secondary" href="/galleryDelete?galleryNo=<%=g.getGalleryNo()%>">삭제하기</a>
			<%} %>
			</div>
			<br><br><br>
			
		</fieldset>
		<%--댓글 출력 시작 --%>
		<div class="commentBox">
			<%for(GalleryComment gc : list) {%>
			<%if(gc.getGalleryCommentLevel() == 1) {%>
			<ul class="comments">
				<li>
					<p><%=gc.getGalleryCommentWriter() %></p>
				</li>
				<li>
					<p><%=gc.getGalleryCommentContentBr() %></p>
					<textarea name="galleryCommentContent" class="form-control" style="display:none;"><%=gc.getGalleryCommentContent() %></textarea>
					<p class="commentsBtn">
					<%if(m != null) { %>
						<%if(m.getMemberNo() == (gc.getGalleryCommentWriter())) {%>
							<a href="javascript:void(0)" onclick="modifyComment(this,'<%=gc.getGalleryCommentNo()%>','<%=g.getGalleryNo()%>');">수정</a>
							<a href="javascript:void(0)" onclick="deleteComment(this,'<%=gc.getGalleryCommentNo()%>','<%=g.getGalleryNo()%>');">삭제</a>
						<%} //댓글 작성자와 로그인 회원이 일치하는 경우%>
						<a href="javascript:void(0)" class="recShow">답글달기</a>
					<%} //로그인 되어있는경우%>
					</p>
					<%if(m != null) {%>
					<form action="/galleryInsertComment" class="recoment">
						<input type="hidden" name="galleryCommentLevel" value="2">
						<input type="hidden" name="galleryCommentWriter" value="<%=m.getMemberId() %>">
						<input type="hidden" name="galleryNo" value="<%=g.getGalleryNo() %>">
						<input type="hidden" name="galleryCommentRef" value="<%=gc.getGalleryCommentNo() %>"> 
						<textarea class="form-control" name="galleryCommentContent"></textarea>
						<div>
							<button type="submit" class="btn btn-outline-primary">등록</button>
							<button type="button" class="btn btn-outline-primary recCancel">취소</button>
						</div>
					</form>
					<%}//대댓글을 입력하는 창 끝 %>
				</li>
			</ul>
				<%for(GalleryComment gcc : list){ %>
					<%if(gcc.getGalleryCommentLevel() == 2 && gcc.getGalleryCommentRef() == gc.getGalleryNo()) {%>
						<ul class="recomments">
							<li>
								<i class="fas fa-angle-double-right fa-3x"></i>
							</li>
							<li>
								<i class="far fa-user fa-3x"></i>
								<p><%=gcc.getGalleryCommentWriter() %></p>
							</li>
							<li>
								<p><%=gcc.getGalleryCommentContentBr() %></p>
								<textarea name="ncContent" class="form-control" style="display:none;"><%=gcc.getGalleryCommentContent()%></textarea>
								<p class="commentsBtn">
									<%if(m!=null && m.getMemberNo() == (gcc.getGalleryCommentWriter())) {%>
									<a href="javascript:void(0)" onclick="modifyComment(this,'<%=gcc.getGalleryCommentNo()%>','<%=g.getGalleryNo()%>');">수정</a>
									<a href="javascript:void(0)" onclick="deleteComment(this,'<%=gcc.getGalleryCommentNo()%>','<%=g.getGalleryNo()%>');">삭제</a>
									<%} %>
								</p>
							</li>
						</ul>
					<%} %>
				<%}//대댓글 반복문 끝나는 지점 %>
			<%} %>
			<%} //전체댓글 반복문 끝나는 지점%>
		</div>
		<%if(m!=null) { %>
		<div class="inputCommentBox">
			<form action="/galleryInsertComment" method="post">
				<ul class="commentWrap">
					<li>
						<img class="profile" src="/img/user2.png">
					</li>
					<li>
						<input type="hidden" name="galleryCommentLevel" value="1">
						<input type="hidden" name="galleryCommentWriter" value="<%=m.getMemberName() %>">
						<input type="hidden" name="galleryNo" value="<%=g.getGalleryNo() %>">
						<input type="hidden" name="galleryCommentRef" value="0">
						<textarea class="form-control" name="galleryCommentContent" style = "resize: none; width: 900px; height: 100px"></textarea>
					</li>
					<li class="btn-box">
						<button type="submit" class="btn btn-primary btn-lg btn btn-block down-btn">등록</button>
					</li>
				</ul>
			</form>
		</div>
		<%} %>
		
	</div>
	<script>
		$(".recShow").click(function(){
			var idx = $(".recShow").index(this); //클릭한게 몇번째 댓글달기 버튼인지 구하는 코드
			$(this).hide();
			$(".recoment").eq(idx).css("display","flex");
			
		})
		$(".recCancel").click(function(){
			var idx = $(".recCancel").index(this);
			$(".recoment").eq(idx).css("display","none");
			$(".recShow").eq(idx).show();
		})
		function modifyComment(obj,ncNo,noticeNo){
			//textarea를 보여줌
			$(obj).parent().prev().show();
			//기존본문내용을 숨김
			$(obj).parent().prev().prev().hide();
			//수정 -> 수정완료
			$(obj).html('수정완료');
			$(obj).attr("onclick","modifyComplete(this,'"+galleryCommentNo+"','"+galleryNo+"')");
			//삭제 -> 수정취소
			$(obj).next().html("수정취소");
			$(obj).next().attr("onclick","modifyCancel(this,'"+galleryCommentNo+"','"+galleryNo+"')");
			//답글달기 버튼 삭제
			$(obj).next().next().hide();
		}
		function modifyCancel(obj,ncNo,noticeNo){
			//textarea 숨김
			$(obj).parent().prev().hide();
			//기존본문내용 다시 보여줌
			$(obj).parent().prev().show();
			//수정완료 -> 수정
			$(obj).prev().html("수정");
			$(obj).prev().attr("onclick","modifyComment(this,'"+galleryCommentNo+"','"+galleryNo+"')");
			//수정취소 -> 삭제
			$(obj).html("삭제");
			$(obj).attr("onclick","deleteComment(this,'"+galleryCommentNo+"','"+galleryNo+"')");
			//답글달기버튼 보이게
			$(obj).next().show();		
		}
		function modifyComplete(obj,ncNo,noticeNo){
			var form = $("<form action='/galleryCommentUpdate' method='post'></form>");
			form.append($("<input type='text' name='galleryCommentNo' value='"+galleryCommentNo+"'>"));
			form.append($("<input type='text' name='galleryNo' value='"+galleryNo+"'>"));
			form.append($(obj).parent().prev());
			$("body").append(form);
			form.submit();
		}
		function deleteComment(obj,ncNo,noticeNo){
			if(confirm("댓글을 삭제하시겠습니까?")){
				location.href="/galleryCommentDelete?galleryCommentNo="+galleryCommentNo+"&galleryNo="+galleryNo;
			}			
		}
	</script>
</body>
</html>