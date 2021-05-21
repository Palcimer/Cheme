<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <% Member member =
(Member)request.getAttribute("member"); %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>모임 개설하기</title>
    <script
      type="text/javascript"
      src="http://code.jquery.com/jquery-3.3.1.js"
    ></script>
 <script
              src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
              integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
              crossorigin="anonymous"
            ></script>
    <style>
      .content-wrap {
        margin-top: 50px;
        margin-bottom: 50px;
        background-color: #F8F9FA;
      }
      .content {
        width: 770px;
        margin: 0 auto;
        padding-left: 100px;
        padding-right: 100px;
      }
      .button-form {
        padding-top: 30px;
        padding-bottom: 30px;
        display: flex;
        justify-content: center;
      }
      button {
        width: 284px;
      }
      .card-header {
        width: 568;
      }
    </style>
  </head>
  <body>
    <%@include file="/WEB-INF/views/common/header.jsp"%>

    
    <div class="content-wrap">
      <hr />
      <div class="content">
        <form
          action="/insertGroup"
          method="post"
          enctype="multipart/form-data"
          id="moimForm"
        >
        <div class="modal" id="modal">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title">모임 등록 확인</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true"></span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <p>이대로 등록하시겠습니까?</p>
		      </div>
		      <div class="modal-footer">
		        <button type="submit" class="btn btn-primary" id = submit>네</button>
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">아니오</button>
		      </div>
		    </div>
		  </div>
		</div>
          <legend>모임 만들기</legend>

          <div class="form-group">
            <label class="col-form-label col-form-label-lg mt-4" for="moim-name"
              >모임명</label
            >
            <input
              class="form-control form-control-lg"
              type="text"
              id="moim-name"
              placeholder="모임명을 입력해주세요."
              name="moimName"
            />
            <div id="nameReg"></div>
            <div id="noSpace1"></div>
          </div>
          <div class="form-group">
            <fieldset disabled="">
              <label
                class="col-form-label col-form-label-lg mt-4"
                for="moim-leader"
                >모임장</label
              >
              <input
                class="form-control form-control-lg"
                type="text"
                id="moim-leader"
                value="<%=member.getMemberId() %>"
              />
            </fieldset>
          </div>

          <hr />
          <!-- 멤버 번호 값 DB에 넘겨줘야 함 -->
          <input
            type="hidden"
            value="<%=member.getMemberNo() %>"
            name="memberNo"
          />
          <div class="form-group">
            <label for="moim-categori" class="form-label mt-4"
              >모임 카테고리 설정</label
            >
            <select class="form-select" id="moim-categori" name="moimCategori">
              <option>여행</option>
              <option>스포츠</option>
              <option>공연전시</option>
              <option>이벤트</option>
              <option>게임</option>
              <option>공예</option>
              <option>음악</option>
              <option>그림</option>
              <option>사진</option>
              <option>어학</option>
              <option>독서</option>
              <option>기술</option>
              <option>제태크</option>
              <option>기타</option>
            </select>
          </div>

          <div class="form-group">
            <label for="exampleSelect1" class="form-label mt-4"
              >모임 설정인원</label
            >
            <select class="form-select" id="exampleSelect1" name="moimMax">
              <option>10</option>
              <option>20</option>
              <option>30</option>
              <option>40</option>
              <option>50</option>
            </select>
          </div>
          <hr />
          <div class="form-group">
            <label for="formFile" class="form-label mt-4"
              >모임 대표사진 설정(?x?)</label
            >
            <!-- TODO: 리스트 나오면 변경 -->
            <input
              class="form-control"
              type="file"
              id="formFile"
              name="moimPicture"
              onchange="loadImg(this);"
            />
            <div id="img-viewer">
              <div
                class="card border mb-3"
                style="max-width: 564px"
                id="imageCard"
              >
                <div class="card-header">대표사진</div>

                <img id="img-view" width="568px" />
              </div>
            </div>
            <div id="noSpace2"></div>
          </div>
          <hr />

          <div class="form-group">
            <label for="moim-intro" class="form-label mt-4"
              >모임 간단 소개글</label
            >
            <textarea
              class="form-control"
              id="moim-intro"
              rows="5"
              name="moimIntro"
            ></textarea>
            <div id="noSpace3"></div>
          </div>
          <hr />
          <div class="form-group">
            <label
              class="col-form-label col-form-label-sm mt-1"
              for="inputSmall"
              >모임 키워드(1)</label
            >
            <input
              class="form-control form-control-sm"
              type="text"
              placeholder="ex) #여행홀릭"
              id="inputSmall"
              name="moimKeyword1"
            />
            <div id="error-msg1"></div>
            <div id="error-msg2"></div>
          </div>

          <div class="form-group">
            <label
              class="col-form-label col-form-label-sm mt-1"
              for="inputSmall"
              >모임 키워드(2)</label
            >
            <input
              class="form-control form-control-sm"
              type="text"
              placeholder="ex) #여행홀릭"
              id="inputSmall"
              name="moimKeyword2"
            />
            <div id="error-msg3"></div>
            <div id="error-msg4"></div>
          </div>

          <div class="form-group">
            <label
              class="col-form-label col-form-label-sm mt-1"
              for="inputSmall"
              >모임 키워드(3)</label
            >
            <input
              class="form-control form-control-sm"
              type="text"
              placeholder="ex) #여행홀릭"
              id="inputSmall"
              name="moimKeyword3"
            />
            <div id="error-msg5"></div>
            <div id="error-msg6"></div>
          </div>

          <div class="form-group">
            <label
              class="col-form-label col-form-label-sm mt-1"
              for="inputSmall"
              >모임 키워드(4)</label
            >
            <input
              class="form-control form-control-sm"
              type="text"
              placeholder="ex) #여행홀릭"
              id="inputSmall"
              name="moimKeyword4"
            />
            <div id="error-msg7"></div>
            <div id="error-msg8"></div>
          </div>

          <div class="form-group">
            <label
              class="col-form-label col-form-label-sm mt-1"
              for="inputSmall"
              >모임 키워드(5)</label
            >
            <input
              class="form-control form-control-sm"
              type="text"
              placeholder="ex) #여행홀릭"
              id="inputSmall"
              name="moimKeyword5"
            />
            <div id="error-msg9"></div>
            <div id="error-msg10"></div>
          </div>
          <hr />

          <div class="button-form">
            <button id="sb"  class="btn btn-primary btn-lg">모임등록</button>

            <button type="reset" class="btn btn-secondary btn-lg">
              다시하기
            </button>

            <!-- TODO: alert 창 띄우기 -->
          </div>
        </form>
      </div>
      <hr />
    </div>

    <%@include file="/WEB-INF/views/common/footer.jsp"%>
  </body>
  <script>
    function loadImg(f) {
      console.log(f.files); //input file 에서 선택한 파일을 배열로 가지고 옴
      if (f.files.length != 0) {
        //첨부파일이 있는경우
        var reader = new FileReader(); //첨부파일을 읽어올 객체
        reader.readAsDataURL(f.files[0]);
        //경로를 다 읽어오면 실행할 함수 지정
        reader.onload = function (e) {
          $("#img-view").attr("src", e.target.result);
          $("[name = moimPicture]").attr("class", "form-control is-valid");
          $("#imageCard").attr("class", "card border-success mb-3");
        };
      } else {
        //첨부파일이 없는경우
        $("#img-view").attr("src", "");
        $("[name = moimPicture]").attr("class", "form-control");
      }
    }
    var bool = true;
    var nameBool = false;
    $("[name = moimName]").keyup(function () {
      var Reg = /^[a-zA-Z0-9가-힣\s]{1,}$/;
      var name = $(this).val();
      console.log(name.length);
      if (Reg.test(name)) {
        $(this).attr("class", "form-control form-control-lg is-valid");
        self.nameBool = true;
        if (name.length > 20) {
          $(this).attr("class", "form-control form-control-lg is-invalid");
          $("[id = nameReg ]").attr("class", "invalid-feedback");
          $("[id = nameReg]").html("최대 20글자");
          self.nameBool = false;
        }
      } else if (!Reg.test(name)) {
        $(this).attr("class", "form-control form-control-lg is-invalid");
        $("[id = nameReg]").attr("class", "invalid-feedback");
        $("[id = nameReg]").html("특수문자 및 자음, 모음 제한");
        self.nameBool = false;
      }
    });

    $("[id = moim-categori").mousedown(function () {
      if ($("[id = moim-categori]").val()) {
        $("[id = moim-categori]").attr("class", "form-control is-valid");
      }
    });
    $("[name = moimMax").mousedown(function () {
      if ($("[name = moimMax]").val()) {
        $("[name = moimMax]").attr("class", "form-control is-valid");
      }
    });

    $("#moim-intro").keyup(function () {
      var content = $(this).val();
      if (!(content == "")) {
        $(this).attr("class", "form-control is-valid");
      }
    });

    $("[name = moimKeyword1]").keyup(function () {
      var Reg = /^#[a-zA-Z0-9가-힣ㄱ-ㅎ]{1,11}$/;
      var name = $(this).val();
      var Reg2 = /^.{0,12}$/;
      if (Reg.test(name)) {
        $(this).attr("class", "form-control form-control-sm is-valid");
        self.bool = true;
      } else if (!Reg2.test(name)) {
        $(this).attr("class", "form-control form-control-sm is-invalid");
        $("[id = error-msg2]").attr("class", "invalid-feedback");
        $("[id = error-msg2]").html("ex)11글자 내에서 작성해주세요.");
        self.bool = false;
      } else if (!Reg.test(name)) {
        $(this).attr("class", "form-control form-control-sm is-invalid");
        $("[id = error-msg1]").attr("class", "invalid-feedback");
        $("[id = error-msg1]").html("ex)#북한산둘레길");
        self.bool = false;
      }
    });

    $("[name = moimKeyword2]").keyup(function () {
      var Reg = /^#[a-zA-Z0-9가-힣ㄱ-ㅎ]{1,11}$/;
      var name = $(this).val();
      var Reg2 = /^.{0,12}$/;
      if (Reg.test(name)) {
        $(this).attr("class", "form-control form-control-sm is-valid");
        self.bool = true;
      } else if (!Reg2.test(name)) {
        $(this).attr("class", "form-control form-control-sm is-invalid");
        $("[id = error-msg4]").attr("class", "invalid-feedback");
        $("[id = error-msg4]").html("ex)11글자 내에서 작성해주세요.");
        self.bool = false;
      } else if (!Reg.test(name)) {
        $(this).attr("class", "form-control form-control-sm is-invalid");
        $("[id = error-msg3]").attr("class", "invalid-feedback");
        $("[id = error-msg3]").html("ex)#북한산둘레길");
        self.bool = false;
      }
    });

    $("[name = moimKeyword3]").keyup(function () {
      var Reg = /^#[a-zA-Z0-9가-힣ㄱ-ㅎ]{1,11}$/;
      var name = $(this).val();
      var Reg2 = /^.{0,12}$/;
      if (Reg.test(name)) {
        $(this).attr("class", "form-control form-control-sm is-valid");
        self.bool = true;
      } else if (!Reg2.test(name)) {
        $(this).attr("class", "form-control form-control-sm is-invalid");
        $("[id = error-msg6]").attr("class", "invalid-feedback");
        $("[id = error-msg6]").html("ex)11글자 내에서 작성해주세요.");
        self.bool = false;
      } else if (!Reg.test(name)) {
        $(this).attr("class", "form-control form-control-sm is-invalid");
        $("[id = error-msg5]").attr("class", "invalid-feedback");
        $("[id = error-msg5]").html("ex)#북한산둘레길");
        self.bool = false;
      }
    });

    $("[name = moimKeyword4]").keyup(function () {
      var Reg = /^#[a-zA-Z0-9가-힣ㄱ-ㅎ]{1,11}$/;
      var name = $(this).val();
      var Reg2 = /^.{0,12}$/;
      if (Reg.test(name)) {
        $(this).attr("class", "form-control form-control-sm is-valid");
        self.bool = true;
      } else if (!Reg2.test(name)) {
        $(this).attr("class", "form-control form-control-sm is-invalid");
        $("[id = error-msg8]").attr("class", "invalid-feedback");
        $("[id = error-msg8]").html("ex)11글자 내에서 작성해주세요.");
        self.bool = false;
      } else if (!Reg.test(name)) {
        $(this).attr("class", "form-control form-control-sm is-invalid");
        $("[id = error-msg7]").attr("class", "invalid-feedback");
        $("[id = error-msg7]").html("ex)#북한산둘레길");
        self.bool = false;
      }
    });

    $("[name = moimKeyword5]").keyup(function () {
      var Reg = /^#[a-zA-Z0-9가-힣ㄱ-ㅎ]{1,11}$/;
      var name = $(this).val();
      var Reg2 = /^.{0,12}$/;
      if (Reg.test(name)) {
        $(this).attr("class", "form-control form-control-sm is-valid");
        self.bool = true;
      } else if (!Reg2.test(name)) {
        $(this).attr("class", "form-control form-control-sm is-invalid");
        $("[id = error-msg10]").attr("class", "invalid-feedback");
        $("[id = error-msg10]").html("ex)11글자 내에서 작성해주세요.");
        self.bool = false;
      } else if (!Reg.test(name)) {
        $(this).attr("class", "form-control form-control-sm is-invalid");
        $("[id = error-msg9]").attr("class", "invalid-feedback");
        $("[id = error-msg9]").html("ex)#북한산둘레길");
        self.bool = false;
      }
    });

    $("#sb").click(function (e) {
      if (
        !self.nameBool ||
        !self.bool ||
        $("#moim-name").val() == "" ||
        $("#formFile").val() == "" ||
        $("#moim-intro").val() == ""
      ) {
        console.log(bool);
        console.log($("#moim-name").val());
        alert("작성한 내용을 다시 확인해주세요.");
        if ($("#moim-name").val() == "") {
          $("#moim-name").attr(
            "class",
            "form-control form-control-lg is-invalid"
          );
          $("#noSpace1").attr("class", "invalid-feedback");
          $("#noSpace1").html("필수 입력항목입니다.");
        }
        if ($("#formFile").val() == "") {
          $("#formFile").attr(
            "class",
            "form-control form-control is-invalid"
          );
          $("[id = noSpace2]").attr("class", "invalid-feedback");
          $("[id = noSpace2]").html("필수 입력항목입니다.");
        }
        if ($("#moim-intro").val() == "") {
          $("#moim-intro").attr(
            "class",
            "form-control form-control is-invalid"
          );
          $("[id = noSpace3]").attr("class", "invalid-feedback");
          $("[id = noSpace3]").html("필수 입력항목입니다.");
        }
        return false;
      }
      	e.preventDefault();
		$('#modal').modal("show");
      return true;
    });
  </script>
</html>
