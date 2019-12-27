<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<%@ include file="../include/head.jsp"%>
<body class="hold-transition skin-blue sidebar-mini layout-boxed">

<div class="wrapper">
    <!-- Main Header -->
    <%@ include file="../include/main_header.jsp"%>

    <!-- Left side column. contains the logo and sidebar -->
    <%@ include file="../include/left_column.jsp"%>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0 text-dark">글수정</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">글수정</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <section class="content container-fluid">
            <div class="col-lg-12">
                <div class="card card-primary card-outline">
                    <form role="form" id="writeForm" method="post" action="${path}/article/modify">
                        <div class="card-body">
                            <input type="hidden" name="articleNo" value="${article.articleNo}">
                            <div class="form-group">
                                <label for="title">제목</label>
                                <input class="form-control" id="title" name="title" placeholder="내용을 입력하세요"
                                    value="${article.title}">
                            </div> <!--/.form-group -->

                            <div class="form-group">
                                <label for="content">내용</label>
                                <textarea class="form-control" id="content" name="content" rows="30"
                                          placeholder="내용을 입력하세요" value="${article.content}"></textarea>
                            </div> <!--/.form-group -->
                            <div class="form-group">
                                <label for="writer">작성자</label>
                                <input class="form-control" id="writer" name="writer" value="${article.writer}" readonly>
                            </div> <!--/.form-group -->
                        </div><!--/.card-body-->
                        <div class="card-footer">
                            <button type="button" class="btn btn-primary listBtn"><i class="fa fa-list"></i>목록</button>
                            <div class="float-right">
                                <button type="button" class="btn btn-warning cancleBtn"><i class="fa fa-reply"></i>취소</button>
                                <button type="submit" class="btn btn-success modBtn"><i class="fa fa-save"></i>저장</button>
                            </div><!--/.float-right -->
                        </div><!--/.card-footer-->
                    </form><!--/.form-->
                </div>
            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <%@ include file="../include/main_footer.jsp"%>
</div>
<!-- ./wrapper -->
<%@ include file="../include/plugin_js.jsp"%>
<script>
    $(document).ready(function () {
       var formObj = $("form[role='form']");
       console.log(formObj);

       $(".listBtn").on("click", function () {
           self.location = "/article/list"
       });

       $(".cancleBtn").on("click", function () {
          history.go(-1); // 뒤로가기
       });

       $(".modBtn").on("click", function () {
          formObj.attr("method", "post");
          formObj.submit();
       });
    });
</script>
</body>
</html>