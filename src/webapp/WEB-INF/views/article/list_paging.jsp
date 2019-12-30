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
                        <h1 class="m-0 text-dark">게시판</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">게시판</li>
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
                    <div class="card-body">
                        <table class="table table-bordered">
                            <tbody>
                            <tr>
                                <th style="width: 30px">#</th>
                                <th>제목</th>
                                <th style="width: 100px">작성자</th>
                                <th style="width: 150px">작성시간</th>
                                <th style="width: 60px">조회</th>
                            </tr>
                            <c:forEach items="${articles}" var="article">
                                <tr>
                                    <td>${article.articleNo}</td>
                                    <td><a href="${path}/article/read?articleNo=${article.articleNo}">${article.title}</a></td>
                                    <td>${article.writer}</td>
                                    <td><fmt:formatDate value="${article.regDate}" pattern="yyyy-MM-dd a HH:mm"/></td>
                                    <td><span class="badge bg-red">${article.viewCnt}</span></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div><!--/.card-body-->
                    <div class="card-footer">
                        <button type="button" class="btn btn-success"><i class="fa fa-pencil-alt"></i>글쓰기</button>
                    </div><!--/.card-footer-->
                    <div class="card-footer">
                        <div class="text-center">
                            <ul class="pagination">
                                <c:if test="${pageMaker.prev}">
                                    <li class="page-item"><a href="${path}/article/listPaging?page=${pageMaker.startPage - 1}">이전</a></li>
                                </c:if>
                                <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
                                    <li class="page-item" <c:out value="${pageMaker.criteria.page == idx ? 'class=active' : ''}"/> >
                                        <a href = "${path}/article/listPaging?page=${idx}">${idx}</a>
                                    </li>
                                </c:forEach>
                                <c:if test="${pageMaker.next}">
                                    <li class="page-item"><a href="${path}/article/listPaging?page=${pageMaker.endPage + 1}">다음</a></li>
                                </c:if>
                            </ul><!--/.pagination -->
                        </div><!--/.text-center-->
                    </div><!--/.card-footer-->
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


    var result = "${msg}";
    if (result == "regSuccess") {
        alert("게시글 등록이 완료되었습니다.");
    } else if (result == "modSuccess") {
        alert("게시글 수정이 완료되었습니다.");
    } else if (result == "delSuccess") {
        alert("게시글 삭제가 완료되었습니다.");
    }
</script>
</body>
</html>