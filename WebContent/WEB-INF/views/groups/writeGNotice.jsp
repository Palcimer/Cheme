<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    int groupId = (int)request.getAttribute("groupId");
    String groupName = (String)request.getAttribute("groupName");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 작성</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	 <div class="container">
        <div style="margin-bottom:50px">
            <h6><%=groupName %></h6>
            <div class="boardWrite">
                <form action="/writeGNotice" method="post" enctype="multipart/form-data">
                    <fieldset>
                        <legend><div class="bg-success legend">공지사항 작성</div></legend>
                        <div class="form-group">
                            <input type="hidden" name="noticeWriter" value="3">
                            <input type="hidden" name="groupId" value="<%=groupId%>">
                            <label for="noticeTitle" class="form-label mt-4">제목</label>
                            <input type="text" class="form-control" name="noticeTitle" >
                        </div>
                        <div class="form-group">
                            <label for="noticeContent" class="form-label mt-4">내용</label>
                            <textarea class="form-control" cols="4" style="height:250px" name="noticeContent"></textarea>
                        </div>
                        <div class="form-group">
                            <label for="noticeFile" class="form-label mt-4">첨부파일</label>
                            <input type="file" class="form-control" name="noticeFile" >
                        </div>      
                        <div class="form-group">
                            <input type="submit" class="btn btn-secondary" style="width:100%; margin-top:30px" value="공지 작성">
                        </div>                  
                    </fieldset>
                </form>
            </div>
        </div>        
    </div>	
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>