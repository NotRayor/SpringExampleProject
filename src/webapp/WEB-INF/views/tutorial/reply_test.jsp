<%--
  Created by IntelliJ IDEA.
  User: home
  Date: 2019-12-31
  Time: PM 2:43
  To change this template use File | Settings | File Templates.
--%>
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
        <!-- Main content -->
        <section class="content container-fluid">
            <div class="col-lg-12">
                <div class="card card-primary card-outline">
                    <div class="card-header">
                        <h5 class="m-0">댓글 작성</h5>
                    </div>
                    <div class="card-body">
                        <div class="form-group">
                            <label for="newReplyText">댓글내용</label>
                            <input class="form-control" id="newReplyText" name="replyText" placeholder="댓글 내용"/>
                        </div>
                        <div class="form-group">
                            <input class="form-control" id="newReplyWriter" name="replyWriter" placeholder="댓글 작성자"/>
                        </div>
                    </div><!--/.card-body-->
                    <div class="card-footer">
                        <ul id="replies">
                            <!-- 댓글 목록들-->
                        </ul>
                    </div><!--/.card-footer-->
                    <div class="card-footer">
                        <div class="text-center">
                            <ul class="pagination pagination-sm no-margin">

                            </ul>
                        </div><!--/.text-center-->
                    </div><!--/.card-footer-->
                </div><!--/.card-primary-->

                <div class="modal fade" id="modifyModal" role="dialog">
                    <div class="modal-content">
                        <button type="button" class="class" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">댓글 수정 창</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="replyNo">댓글 번호</label>
                            <input class="form-control" id="replyNo" name="replyNo" readOnly>
                        </div>
                        <div class="form-group">
                            <label for="replyText">댓글 내용</label>
                            <input class="form-control" id="replyText" name="replyText" placeholder="댓글내용">
                        </div>
                        <div class="form-group">
                            <label for="replyWriter">댓글 작성자</label>
                            <input class="form-control" id="replyWriter" name="replyWriter" placeholder="댓글작성자" readonly>
                        </div>
                    </div><!--/.modal-body-->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default float-left" data-dismiss="modal">닫기</button>
                        <button type="button" class="btn btn-success modalModBtn" data-dismiss="modal">수정</button>
                        <button type="button" class="btn btn-danger modalDelBtn" data-dismiss="modal">삭제</button>
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

</script>
</body>
</html>