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
                                    <td>
                                        <a href="${path}/article/readPaging${pageMaker.makeSearch(pageMaker.criteria.page)}&articleNo=${article.articleNo}">
                                            ${article.title}
                                        </a>
                                    </td>
                                    <td>${article.writer}</td>
                                    <td><fmt:formatDate value="${article.regDate}" pattern="yyyy-MM-dd a HH:mm"/></td>
                                    <td><span class="badge bg-red">${article.viewCnt}</span></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div><!--/.card-body-->
                    <div class="card-footer">
                        <div class="text-center">
                            <ul class="pagination justify-content-center">
                                <c:if test="${pageMaker.prev}">
                                   <!-- <li class="page-item"><a href="${path}/article/listPagingRead?${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li> -->
                                    <li class="page-item"><a class="page-link" href="${path}/article/list${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
                                </c:if> <!-- li prev -->
                                <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
                                    <li class="page-item <c:out value="${pageMaker.criteria.page == idx ? 'active' : ''}"/>"   >
                                       <!-- <a href = "${path}/article/listPagingRead?${pageMaker.makeSearch(idx)}">${idx}</a> -->
                                        <a class="page-link" href = "${path}/article/list${pageMaker.makeSearch(idx)}">${idx}</a>
                                    </li> <!--li page -->
                                </c:forEach>
                                <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
                                    <!-- <li class="page-item"><a href="${path}/article/listPagingRead?${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li> -->
                                    <li class="page-item"><a class="page-link" href = "${path}/article/list${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
                                </c:if> <!-- li next -->
                            </ul><!--/.pagination -->
                        </div><!--/.text-center-->
                    </div><!--/.card-footer-->
                    <div class="card-footer">
                        <div class="form-group col-sm-2">
                            <select class="form-control" name="searchType" id="searchType">
                                <option value="n" <c:out value="${criteria.searchType == null ? 'selected' : ''}"/>>===선택===</option> <!-- 아무 선택도 안함 -->
                                <option value="t" <c:out value="${criteria.searchType == 't' ? 'selected' : ''}" />>제목</option> <!-- 제목 -->
                                <option value="c" <c:out value="${criteria.searchType == 'c' ? 'selected' : ''}" /> >내용</option> <!-- 내용 -->
                                <option value="w" <c:out value="${criteria.searchType == 'w' ? 'selected' : ''}" /> >작성자</option> <!-- 작성자 -->
                                <option value="tc" <c:out value="${criteria.searchType == 'tc' ? 'selected' : ''}" />> 제목+내용 </option><!-- 제목, 내용 -->
                                <option value="cw" <c:out value="${criteria.searchType == 'cw' ? 'selected' : ''}" /> >내용+작성자</option> <!-- 내용, 작성자 -->
                                <option value="tcw" <c:out value="${criteria.searchType == 'tcw' ? 'selected' : ''}" /> >제목+내용+작성자</option><!-- 제목, 내용, 작성자 -->
                            </select>
                        </div><!-- form-group col-sm-2 -->
                            <div class="form-group col-sm-10">
                                <div class="input-group">
                                    <input type="text" class="form-control" name="keyword" id="keywordInput" value="${criteria.keyword}" placeholder="검색어">
                                    <span>
                                        <button type="button" class="btn btn-primary btn-flat searchBtn">
                                            <i class="fa fa-search"></i>검색
                                        </button>
                                    </span> <!-- input-group btn -->
                                </div> <!-- input-group -->
                            </div> <!-- form-group col-sm-10 -->
                            <div class="float-right">
                                <button type="button" class="btn btn-success btn-flat" id="writeBtn">
                                    <i class="fa fa-pencil"></i> 글쓰기
                                </button>
                            </div><!-- float-right -->
                    </div><!--/.card-footer-->
                </div><!-- /.card card-primary card-outline-->
            </div><!-- /.col-lg-12 -->
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

    $(document).ready(function () {

        $('.searchBtn').on("click", function () {

         self.location =
               "/article/list${pageMaker.makeQuery(1)}"
            + "&searchType=" +$("select option:selected").val()
            + "&keyword=" + encodeURIComponent($('#keywordInput').val());
        });

        $('#writeBtn').on("click", function () {
           self.location = "/article/write"
        });
    });


</script>
</body>
</html>