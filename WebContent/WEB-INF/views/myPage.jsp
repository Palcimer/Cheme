<%@page import="java.util.Arrays"%>
<%@page import="group.model.vo.Group"%>
<%@page import="java.util.ArrayList"%> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <% Member member =
(Member)request.getAttribute("member"); 
ArrayList<Group> groupAsMemberList =(ArrayList<Group>)request.getAttribute("groupAsMemberList");
ArrayList<Group> groupAsLeaderList =(ArrayList<Group>)request.getAttribute("groupAsLeaderList");
ArrayList<String> colorList = new ArrayList<String>(Arrays.asList("primary","secondary","success","danger","warning","info"));


%>

        <!DOCTYPE html>
        <html>
          <head>
            <meta charset="UTF-8" />
            <title>마이 페이지</title>
            <script
              src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
              integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
              crossorigin="anonymous"
            ></script>
            <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
            <style>
              .content {
                width: 1024px;
              }
              .content-wrap {
                 margin-top: 50px;
                 margin-bottom: 50px;
       			 background-color: #F8F9FA;
                display: flex;
                justify-content: center;
              }
              .nav-item {
                width: 341.33px;
                text-align: center;
              }
              .nav-link active{
                background-color: #ccc;
              }
              .updateMyInfo {
                height: 900px;
                display: flex;
                justify-content: center;
                align-items: center;
                margin: 0;
                border: 1px solid #ddd;
                border-top: 0;
                border-bottom-left-radius: 1.5%;
                border-bottom-right-radius: 1.5%;
              }
              .deleteId{
              height: 450px;
               display: flex;
                justify-content: center;
                align-items: center;
                margin: 0;
                border: 1px solid #ddd;
                border-top: 0;
                border-bottom-left-radius: 1.5%;
                border-bottom-right-radius: 1.5%;
              }
              form > div {
                width: 550px;
              }
              .juso > input {
                width: 452px;
                float: left;
              }
              .form-label {
                margin-top: 0;
              }
              .button-form {
                padding-top: 30px;
                padding-bottom: 30px;
                display: flex;
                justify-content: center;
                justify-content: space-around;
              }
              .myPage {
                width: 1024px;
                display: flex; 
                justify-content: center;
                align-items: center;
                margin: 0;
                border: 1px solid #ddd;
                border-top: 0;
                border-bottom-left-radius: 1.5%;
                border-bottom-right-radius: 1.5%;
                flex-direction: column;
              }
              .myPage > div {
                padding: 25px;
                width: 1022px;
              }
              .moimName{
              	text-align: center;
              }
              img {
                width: 100%;
                height: 100%;
                object-fit: cover;
              }
              .moimRow {
                display: flex;
                flex-direction: row;
                flex-wrap: wrap;
                padding: 0px;
              }
              .button-form button {
                width: 50%;
              }
              .moim{
              	padding: 15px;
              }
              .photo{
                width: 213px;
                height: 213px;
              	border-radius: 5%;
              	overflow: hidden;
              }
              .badge-wrap{
              	display: flex;
              }
            </style>
          </head>
          <body>
            <%@include file="/WEB-INF/views/common/header.jsp"%>
            <div class="content-wrap">
              <div class="content">
                <ul class="nav nav-tabs">
                  <li class="nav-item">
                    <a
                      class="nav-link active"
                      data-bs-toggle="tab"
                      href="#myPage"
                      >마이페이지</a
                    >
                  </li>
                  <li class="nav-item">
                    <a
                      class="nav-link"
                      data-bs-toggle="tab"
                      href="#updateMyInfo"
                      >내 정보수정</a
                    >
                  </li>
                  <li class="nav-item">
                    <a
                      class="nav-link"
                      data-bs-toggle="tab"
                      href="#deleteMyId"
                      >회원 탈퇴</a
                    >
                  </li>
                </ul>
                <div id="myTabContent" class="tab-content">
                  <div class="tab-pane fade active show" id="myPage">
                   <div class="myPage">
					<% if((groupAsLeaderList.size()!=0)) {%>
					<div class="manageMoim-wrap">
					  <h2>나의 모임 관리하기</h2>
					  <hr />
					  <div class="list-wrap">
					    <div class="moimRow">
					      <!-- 자바로 구현 -->
					      <% for(Group g : groupAsLeaderList) { %>
					        <a href="#">
					      <div class="moim">
					        <div class="photo">
					            <img
					              src="../../upload/grouprepresenphoto\<%=g.getGroupImg() %>"
					              alt=""
					            />
					        </div>
					        <div class="moimName"><%=g.getGroupName()%></div>
					        <div class="badge-wrap">
					        <%if(g.getKeyword1()!=null){ %>
					        <div class="badge bg-primary">
					        <%=g.getKeyword1()%> 
					        </div>
					         <%}%>
					        <%if(g.getKeyword2()!=null){ %>
					        <div class="badge bg-secondary">
					        <%=g.getKeyword2()%> 
					        </div>
					         <%}%>
					        <%if(g.getKeyword3()!=null){ %>
					        <div class="badge bg-danger">
					        <%=g.getKeyword3()%> 
					        </div>
					         <%}%>
					        <%if(g.getKeyword4()!=null){ %>
					        <div class="badge bg-warning">
					        <%=g.getKeyword4()%> 
					        </div>
					         <%}%>
					        <%if(g.getKeyword5()!=null){ %>
					        <div class="badge bg-info">
					        <%=g.getKeyword5()%> 
					        </div>
					         <%}%>
					        </div>
					        <div class="recom">
					        <span class="badge rounded-pill bg-light">추천수<%=g.getRecom()%></span>
					        </div>
					      </div>
					      <%} %>
					    </div>
					  </div>
					</div>
					  </a>
					<%} %>
                     <div class="myMoim-wrap">
					  <h2>나의 모임</h2>
					  <hr />
					  <div class="list-wrap">
					    <div class="moimRow">
					      <!-- 자바로 구현 -->
					      <% for(Group g : groupAsMemberList) { %>
					
					      <div class="moim">
					        <div class="photo">
					          <a href="#">
					            <img
					              src="../../upload/grouprepresenphoto\<%=g.getGroupImg() %>"
					              alt=""
					            />
					          </a>
					        </div>
					        <div class="moimName"><%=g.getGroupName()%></div>
					        <div class="moimTag"><%%></div>
					      </div>
					      <%} %>
					    </div>
					  </div>
					</div>
                     
                    </div>
                  </div>
                  <div class="tab-pane fade" id="updateMyInfo">
                    <div class="updateMyInfo-wrap">
                      <div class="updateMyInfo">
                        <form
                          action="/updateMember"
                          method="post"
                          id="updateForm"
                        >
                      
                          <div class="form-group">
                            <fieldset disabled="">
                              <label class="form-label" for="memberId"
                                >ID</label
                              >
                              <input
                                class="form-control"
                                id="memberId"
                                type="text"
                                placeholder="<%=member.getMemberId() %>"
                                disabled=""
                              />
                            </fieldset>
                          </div>
                          <input
                            type="hidden"
                            value= "<%=member.getMemberNo()%>"
                            name="memberNo"
                          />
                          <div class="form-group">
                            <label for="memberPw" class="form-label mt-4"
                              >비밀번호</label
                            >
                            <input
                              type="password"
                              class="form-control"
                              id="memberPw"
                              placeholder="변경할 비밀번호를 입력해주세요."
                              name="memberPw"
                            />
                            <div id="error-msg1"></div>
                            <div id="noSpace1"></div>
                          </div>

                          <div class="form-group">
                            <label for="memberPw" class="form-label mt-4"
                              >비밀번호 확인</label
                            >
                            <input
                              type="password"
                              class="form-control"
                              id="memberPwRe"
                              placeholder="변경할 비밀번호를 다시 입력해주세요."
                            />
                            <div id="error-msg2"></div>
                            <div id="noSpace2"></div>
                          </div>
                          <hr />
                          <div class="form-group">
                            <fieldset>
                              <label class="form-label" for="memberName"
                                >이름</label
                              >
                              <input
                                class="form-control"
                                id="memberName"
                                type="text"
                                placeholder="<%=member.getMemberName() %>"
                                name="memberName"
                              />
                              <div id="error-msg3"></div>
                              <div id="noSpace3"></div>
                            </fieldset>
                          </div>
                          <hr />
                          <div class="form-group">
                            <fieldset>
                              <label class="form-label" for="memberPhone"
                                >전화번호</label
                              >
                              <input
                                class="form-control"
                                id="memberPhone"
                                type="text"
                                placeholder="<%=member.getPhone() %>"
                                name="memberPhone"
                              />
                              <div id="error-msg4"></div>
                              <div id="noSpace4"></div>
                            </fieldset>
                          </div>
                          <hr />
                          <div class="form-group">
                            <div class="juso">
                              <fieldset>
                                <label class="form-label" for="post-button"
                                  >주소</label
                                >
                              </fieldset>
                              <input
                                type="text"
                                id="postCode"
                                class="short form-control"
                                readonly=""
                              />
                              <button
                                type="button"
                                onclick="addSearch();"
                                class="btn btn-primary"
                                id="post-button"
                              >
                                주소검색
                              </button>
                            </div>

                            <div>
                              <input
                                type="text"
                                id="roadAddr"
                                class="form-control"
                                placeholder="도로명주소"
                                readonly
                              />
                            </div>

                            <div>
                              <input
                                type="text"
                                id="jibunAddr"
                                class="form-control"
                                placeholder="지번주소"
                                readonly
                              />
                            </div>

                            <div>
                              <input
                                type="text"
                                id="detailAddr"
                                placeholder="상세주소"
                                class="form-control"
                              />
                            </div>
                          </div>
                         <div class="modal" id="modal">
                            <div class="modal-dialog" role="document">
                              <div class="modal-content">
                                <div class="modal-header">
                                  <h5 class="modal-title">회원 정보 변경확인</h5>
                                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true"></span>
                                  </button>
                                </div>
                                <div class="modal-body">
                                  <p>이대로 등록하시겠습니까?</p>
                                </div>
                                <div class="modal-footer">
                                  <button type="submit" class="btn btn-primary" id = "smbtn">네</button>
                                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">아니오</button>
                                </div>
                              </div>
                            </div>
						            </div>

                          <div class="button-form">
                            <button
                             id = "btnbtn"
                             type ="button"
                              class="btn btn-primary btn-lg"
                            >
                              변경하기
                            </button>
                            <button
                              type="reset"
                              class="btn btn-secondary btn-lg"
                            >
                              다시하기
                            </button>
                          </div>
                          <!-- TODO: alert 창 띄우기 -->
                        </form>
                      </div>
                    </div>
                  </div>
                    <div class="tab-pane fade" id="deleteMyId">
	                    <div class="checkPage">
	                      <div class="deleteId">
	                        <form action="/deleteMyId">
	                          <div class="form-group">
	                           
	                            <input
	                              type="password"
	                              class="form-control form-control-lg"
	                              id="memberPwDelete"
	                              placeholder="비밀번호를 입력해주세요."
	                              name="memberPwDelete"
	                            />
	                              <input
                            type="hidden"
                            value= "<%=member.getMemberId()%>"
                            name="memberIdDelete"
                            id="memberIdDelete"
                          />
                                   <input
                            type="hidden"
                            value= "<%=member.getMemberNo()%>"
                            name="memberNo"
                          />
	                            <div class="d-grid gap-2">
 									 <button class="btn btn-lg btn-danger" type="button" id="modalbtn">확인</button>
									</div>
	                            <div id="error-msg1"></div>
	                            <div id="noSpace1"></div>
	                          </div>
	                             <div class="modal" id="modalDelete">
                            <div class="modal-dialog" role="document">
                              <div class="modal-content">
                                <div class="modal-header">
                                  <h5 class="modal-title">회원 정보 삭제확인</h5>
                                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true"></span>
                                  </button>
                                </div>
                                <div class="modal-body">
                                  <p>해당 정보는 복구할 수 없습니다.
                                 정말 삭제하시겠습니까?</p>
                                </div>
                                <div class="modal-footer">
                                  <button type="submit" class="btn btn-primary" id = "deleteBtn">네</button>
                                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">아니오</button>
                                </div>
                              </div>
                            </div>
						            </div>
	                        </form>
	                      </div>
	                    </div>
                    </div>
                </div>
              </div>
            </div>
            <%@include file="/WEB-INF/views/common/footer.jsp"%>
          </body>
          <script>
            var bool1 = false;
            var bool2 = false;
            var bool3 = false;
            var bool4 = false;

            function addSearch() {
              new daum.Postcode({
                oncomplete: function (data) {
                  $("#postCode").val(data.zonecode);
                  $("#roadAddr").val(data.roadAddress);
                  $("#jibunAddr").val(data.jibunAddress);
                  $("#detailAddr").focus();
                },
              }).open();
            }
            $("#memberPw").keyup(function () {
              var Reg = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,12}$/;
              var name = $(this).val();
              if (Reg.test(name)) {
                $(this).attr("class", "form-control is-valid");
                self.bool1 = true;
              } else if (!Reg.test(name)) {
                $(this).attr("class", "form-control is-invalid");
                $("[id = error-msg1]").attr("class", "invalid-feedback");
                $("[id = error-msg1]").html(
                  "8~12 자, 최소 하나의 문자 및 하나의 숫자"
                );
                self.bool1 = false;
              }
            });
            $("#memberPwRe").keyup(function () {
              var pw = $("#memberPw").val();
              var pwRe = $(this).val();
              if (pw == pwRe) {
                $(this).attr("class", "form-control is-valid");
                self.bool2 = true;
              } else {
                $(this).attr("class", "form-control is-invalid");
                $("[id = error-msg2]").attr("class", "invalid-feedback");
                $("[id = error-msg2]").html("비밀번호가 같지 않습니다.");
                self.bool2 = false;
              }
            });
            $("#memberName").keyup(function () {
              var Reg = /^[a-zA-Z0-9가-힣]{2,9}$/;
              var name = $(this).val();
              if (Reg.test(name)) {
                $(this).attr("class", "form-control is-valid");
                self.bool3 = true;
              } else if (!Reg.test(name)) {
                $(this).attr("class", "form-control is-invalid");
                $("[id = error-msg3]").attr("class", "invalid-feedback");
                $("[id = error-msg3]").html(
                  "2~8글자 및 특수문자, 단모음, 단자음 제한"
                );
                self.bool3 = false;
              }
            });
            $("#memberPhone").keyup(function () {
              var Reg = /^\d{2,3}\d{3,4}\d{4}$/;
              var name = $(this).val();
              if (Reg.test(name)) {
                $(this).attr("class", "form-control is-valid");
                self.bool4 = true;
              } else if (!Reg.test(name)) {
                $(this).attr("class", "form-control is-invalid");
                $("[id = error-msg4]").attr("class", "invalid-feedback");
                $("[id = error-msg4]").html("ex)01012345678");
                self.bool4 = false;
              }
            });

            $("#btnbtn").click(function (e) {
              if (
                !self.bool1 ||
                !self.bool2 ||
                !self.bool3 ||
                !self.bool4 ||
                $("#memberPw").val() == "" ||
                $("#memberPwRe").val() == "" ||
                $("#memberName").val() == "" ||
                $("#memberPhone").val() == ""
              ) {
                alert("작성한 내용을 다시 확인해주세요.");
                if ($("#memberPw").val() == "") {
                  $("#memberPw").attr("class", "form-control is-invalid");
                  $("#noSpace1").attr("class", "invalid-feedback");
                  $("#noSpace1").html("필수 입력항목입니다.");
                }
                if ($("#memberPwRe").val() == "") {
                  $("#memberPwRe").attr("class", "form-control is-invalid");
                  $("[id = noSpace2]").attr("class", "invalid-feedback");
                  $("[id = noSpace2]").html("필수 입력항목입니다.");
                }
                if ($("#memberName").val() == "") {
                  $("#memberName").attr("class", "form-control is-invalid");
                  $("[id = noSpace3]").attr("class", "invalid-feedback");
                  $("[id = noSpace3]").html("필수 입력항목입니다.");
                }
                if ($("#memberPhone").val() == "") {
                  $("#memberPhone").attr("class", "form-control is-invalid");
                  $("[id = noSpace4]").attr("class", "invalid-feedback");
                  $("[id = noSpace4]").html("필수 입력항목입니다.");
                }
                return false;
              }
              e.preventDefault();
      		$('#modal').modal("show");
            });
            $("#modalbtn").click(function (e){
            	if($("#memberPwDelete").val()==""){
            		  alert("작성한 내용을 다시 확인해주세요.");
            	}else{
            		var id = $("#memberIdDelete").val();
                    var pw = $("#memberPwDelete").val();
            	        $.ajax({
            	          url: "/pwCheck",
            	          type: "post",
            	          data: {
            	        	  memberIdDelete: id,
            	        	  memberPwDelete: pw,
            	            },
            	          success: function (data) {
            	        	  if(data==0){
            	        		  alert("비밀번호를 잘못 입력하셨습니다.");
            	        		  return
            	        	  }else if (data==1){
            	        		  e.preventDefault();
                	        	  $("#modalDelete").modal("show");
            	        	  }
            	          },
            	          error: function () {
            	          alert("서버 연결 이상");
            	          }
            	        });
            	}
            });
         
        
          </script>
        </html>
