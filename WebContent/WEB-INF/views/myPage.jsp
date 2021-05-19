<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>마이 페이지</title>
    <!-- TODO:삭제 -->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
      crossorigin="anonymous"
    ></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <link rel="stylesheet" href="bootstrap.css" />
    <link rel="stylesheet" href="bootstrap.min.css" />
    <!-- 밑에 건 필요 -->
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <style>
      .content {
        width: 760px;
      }
      .content-wrap {
        margin-top: 100px;
        margin-bottom: 100px;
        display: flex;
        justify-content: center;
      }
      .nav-item {
        width: 380px;
        text-align: center;
      }
      .updateMyInfo {
        height: 900px;
        width: 760px;
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
        padding: 50px;
        display: flex;
        justify-content: center;
        justify-content: space-around;
      }
      .myPage {
        width: 760px;
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
        padding: 50px;
      }
      img {
        width: 220px;
        height: 150px;
      }
      .moimRow {
        display: flex;
        flex-direction: row;
        justify-content: space-around;
        flex-wrap: wrap;

        padding: 10px;
      }

      .card-header {
        width: 700px;
      }
      .moimName {
        text-align: center;
      }
      .card-body {
        padding: 0;
      }
    </style>
  </head>
  <body>
    <%@include file="/WEB-INF/views/common/header.jsp"%>
    <div class="content-wrap">
      <div class="content">
        <ul class="nav nav-tabs">
          <li class="nav-item">
            <a class="nav-link active" data-bs-toggle="tab" href="#myPage"
              >마이페이지</a
            >
          </li>
          <li class="nav-item">
            <a class="nav-link" data-bs-toggle="tab" href="#updateMyInfo"
              >내 정보수정</a
            >
          </li>
        </ul>
        <div id="myTabContent" class="tab-content">
          <div class="tab-pane fade active show" id="myPage">
            <div class="myPage">
              <div class="manageMoim-wrap">
                <div class="card">
                  <div class="card-header">나의 모임 관리하기</div>
                  <div class="card-body">
                    <div class="list-wrap">
                      <div class="moimRow">
                        <!-- 자바로 구현 -->
                        <div class="moim">
                          <div class="photo">
                            <a href="#">
                              <img src="회원가입 이미지.png" alt="" />
                            </a>
                          </div>
                          <div class="moimName">dd</div>
                        </div>
                        <div class="moim">
                          <div class="photo">
                            <a href="#">
                              <img src="회원가입 이미지.png" alt="" />
                            </a>
                          </div>
                          <div class="moimName">dd</div>
                        </div>
                        <div class="moim">
                          <div class="photo">
                            <a href="#">
                              <img src="회원가입 이미지.png" alt="" />
                            </a>
                          </div>
                          <div class="moimName">dd</div>
                        </div>
                        <div class="moim">
                          <div class="photo">
                            <a href="#">
                              <img src="회원가입 이미지.png" alt="" />
                            </a>
                          </div>
                          <div class="moimName">dd</div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="myMoim-wrap">
                <div class="card">
                  <div class="card-header">나의 모임</div>
                  <div class="card-body">
                    <div class="list-wrap">
                      <div class="moimRow">
                        <!-- 자바로 구현 -->
                        <div class="moim">
                          <div class="photo">
                            <a href="#">
                              <img src="회원가입 이미지.png" alt="" />
                            </a>
                          </div>
                          <div class="moimName">dd</div>
                        </div>
                        <div class="moim">
                          <div class="photo">
                            <a href="#">
                              <img src="회원가입 이미지.png" alt="" />
                            </a>
                          </div>
                          <div class="moimName">dd</div>
                        </div>
                        <div class="moim">
                          <div class="photo">
                            <a href="#">
                              <img src="회원가입 이미지.png" alt="" />
                            </a>
                          </div>
                          <div class="moimName">dd</div>
                        </div>
                        <div class="moim">
                          <div class="photo">
                            <a href="#">
                              <img src="회원가입 이미지.png" alt="" />
                            </a>
                          </div>
                          <div class="moimName">dd</div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="tab-pane fade active show" id="updateMyInfo">
            <div class="updateMyInfo-wrap">
              <div class="updateMyInfo">
                <form action="/updateMember" method="post" id="updateForm">
                  <div class="form-group">
                    <fieldset disabled="">
                      <label class="form-label" for="memberId">ID</label>
                      <input
                        class="form-control"
                        id="memberId"
                        type="text"
                        placeholder="당신의 ID"
                        disabled=""
                      />
                    </fieldset>
                  </div>
                  <input type="hidden" value="" name="memberNo" />
                  <!-- TODO: value에 m.getMemberNo%넣기 -->
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
                      <label class="form-label" for="memberName">이름</label>
                      <input
                        class="form-control"
                        id="memberName"
                        type="text"
                        placeholder="당신의 이름"
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
                        placeholder="당신의 전화번호"
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
                        <label class="form-label" for="post-button">주소</label>
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

                  <div class="button-form">
                    <button type="submit" class="btn btn-primary btn-lg">
                      변경하기
                    </button>
                    <button type="reset" class="btn btn-secondary btn-lg">
                      다시하기
                    </button>
                  </div>
                  <!-- TODO: alert 창 띄우기 -->
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
        $(this).attr("class", "form-control form-control-sm is-valid");
        self.bool1 = true;
      } else if (!Reg.test(name)) {
        $(this).attr("class", "form-control form-control-sm is-invalid");
        $("[id = error-msg1]").attr("class", "invalid-feedback");
        $("[id = error-msg1]").html("8~12 자, 최소 하나의 문자 및 하나의 숫자");
        self.bool1 = false;
      }
    });
    $("#memberPwRe").keyup(function () {
      var pw = $("#memberPw").val();
      var pwRe = $(this).val();
      if (pw == pwRe) {
        $(this).attr("class", "form-control form-control-sm is-valid");
        self.bool2 = true;
      } else {
        $(this).attr("class", "form-control form-control-sm is-invalid");
        $("[id = error-msg2]").attr("class", "invalid-feedback");
        $("[id = error-msg2]").html("비밀번호가 같지 않습니다.");
        self.bool2 = false;
      }
    });
    $("#memberName").keyup(function () {
      var Reg = /^[a-zA-Z0-9가-힣]{2,9}$/;
      var name = $(this).val();
      if (Reg.test(name)) {
        $(this).attr("class", "form-control form-control-sm is-valid");
        self.bool3 = true;
      } else if (!Reg.test(name)) {
        $(this).attr("class", "form-control form-control-sm is-invalid");
        $("[id = error-msg3]").attr("class", "invalid-feedback");
        $("[id = error-msg3]").html("2~8글자 및 특수문자, 단모음, 단자음 제한");
        self.bool3 = false;
      }
    });
    $("#memberPhone").keyup(function () {
      var Reg = /^\d{2,3}\d{3,4}\d{4}$/;
      var name = $(this).val();
      if (Reg.test(name)) {
        $(this).attr("class", "form-control form-control-sm is-valid");
        self.bool4 = true;
      } else if (!Reg.test(name)) {
        $(this).attr("class", "form-control form-control-sm is-invalid");
        $("[id = error-msg4]").attr("class", "invalid-feedback");
        $("[id = error-msg4]").html("ex)010-1234-5678");
        self.bool4 = false;
      }
    });

    $("#updateForm").submit(function () {
      console.log("ㅎㅇ");
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
          $("#memberPw").attr(
            "class",
            "form-control form-control-sm is-invalid"
          );
          $("#noSpace1").attr("class", "invalid-feedback");
          $("#noSpace1").html("필수 입력항목입니다.");
        }
        if ($("#memberPwRe").val() == "") {
          $("#memberPwRe").attr(
            "class",
            "form-control form-control-sm is-invalid"
          );
          $("[id = noSpace2]").attr("class", "invalid-feedback");
          $("[id = noSpace2]").html("필수 입력항목입니다.");
        }
        if ($("#memberName").val() == "") {
          $("#memberName").attr(
            "class",
            "form-control form-control-sm is-invalid"
          );
          $("[id = noSpace3]").attr("class", "invalid-feedback");
          $("[id = noSpace3]").html("필수 입력항목입니다.");
        }
        if ($("#memberPhone").val() == "") {
          $("#memberPhone").attr(
            "class",
            "form-control form-control-sm is-invalid"
          );
          $("[id = noSpace4]").attr("class", "invalid-feedback");
          $("[id = noSpace4]").html("필수 입력항목입니다.");
        }
        return false;
      }
      alert("dd");
      return true;
    });
  </script>
</html>
