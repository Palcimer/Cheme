<%@page import="gnotice.model.vo.GNotice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    GNotice notice = (GNotice)request.getAttribute("notice");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	 <div class="container">
        <div style="margin-bottom:50px">
            <h6>그룹 이름</h6>
            <div class="boardWrite">
                <form action="/updateGNotice" method="post" enctype="multipart/form-data">
                    <fieldset>
                        <legend><div class="bg-success legend">공지사항 수정</div></legend>
                        <div class="form-group">
                            <input type="hidden" name="noticeWriter" value="3">
                            <input type="hidden" name="noticeNo" value="<%=notice.getgNoticeNo() %>">
                            <label for="noticeTitle" class="form-label mt-4">제목</label>
                            <input type="text" class="form-control" name="noticeTitle" value="<%=notice.getgNoticeTitle() %>">
                        </div>
                        <div class="form-group">
                            <label for="noticeContent" class="form-label mt-4">내용</label>
                            <textarea class="form-control" cols="4" style="height:250px" name="noticeContent"><%=notice.getgNoticeContent()%></textarea>
                        </div>
                        <div class="form-group">
                        	<!-- 파일 상태변화 체크용 -->
	                        <input type="hidden" name="status" value="stay">
                            <label for="noticeFile" class="form-label mt-4">첨부파일</label>
                            <!-- 기존에 첨부파일이 있는 경우 -->
							<%if (notice.getFilename() != null) {%>
								<i class="fas fa-clone delFile"></i>
								<span class="delFile"><%=notice.getFilename() %></span>
								<button type="button" id="delBtn" class="btn btn-primary btn-sm delFile">삭제</button>
								<input type="file" class="form-control" name="noticeFile" id="file" style="display:none">
								<input type="hidden" name="oldFilename" value="<%=notice.getFilename() %>">
								<input type="hidden" name="oldFilepath" value="<%=notice.getFilepath() %>">
							<!-- 기존에 첨부파일이 없는 경우 -->
							<%} else { %>							
								<input type="file" class="form-control" name="noticeFile">
							<%} %>
                        </div>      
                        <div class="form-group">
                            <input type="submit" class="btn btn-secondary" style="width:100%; margin-top:30px" value="공지 수정">
                        </div>                  
                    </fieldset>
                </form>
            </div>
        </div>        
    </div>	
    <script>
		$("#delBtn").click(function() {
			if(confirm("첨부파일을 삭제하시겠습니까?")) {
				$(".delFile").hide();
				$("#file").show();
				$("[name=status]").val("del");
			}
		})
	</script>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>