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
                        <h1 class="m-0 text-dark">글 수정</h1>
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
                    <div class="card-header">
                        <h3 class="card-title">글제목 : ${article.title}</h3>
                    </div><!-- card-header-->
                    <div class="card-body" style="height: 700px">
                        <h3>${article.content}</h3>
                    </div><!--/.card-body-->
                    <div class="card-footer">
                        <div class="user-block">
                            <span class="username">
                                <a href="#">${article.writer}</a>
                            </span>
                            <span class="description"><fmt:formatDate pattern="yyyy-mm-dd a HH:mm" value="${article.regDate}"/></span>
                        </div>
                    </div><!--/.card-footer-->
                    <div class="card-footer">
                        <form role="form" method="post">
                            <input type="hidden" name="articleNo" value="${article.articleNo}">
                        </form>
                        <button type="button" class="btn btn-primary listBtn"><i class="fa fa-list"></i>목록</button>
                        <div class="float-right">
                            <button type="button" class="btn btn-warning modBtn"><i class="fa fa-reply"></i>수정</button>
                            <button type="submit" class="btn btn-success delBtn"><i class="fa fa-save"></i>삭제</button>
                        </div><!--/.float-right -->
                    </div>
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
        var formObj =$("form[role='form']");
        console.log(formObj);

        $(".modBtn").on("click", function () {
            formObj.attr("action", "/article/modify");
            formObj.attr("method", "get");
            formObj.submit();
        });

        $(".delBtn").on("click", function () {
            formObj.attr("action", "/article/delete");
            formObj.attr("method", "post");
            formObj.submit();
        });

        $(".listBtn").on("click", function () {
            self.location = "/article/list"
        });
    });
</script>
</body>
</html>