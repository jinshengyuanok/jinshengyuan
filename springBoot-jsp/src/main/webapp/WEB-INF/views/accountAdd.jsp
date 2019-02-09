<%--
  Created by IntelliJ IDEA.
  Author: Jinsheng Yuan
  DateTime: 2019/1/1 17:33
  Description:
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE HTML>
<html>
<head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content=""/>
    <!--貌似是浏览器底层代码调用,ctl+鼠标滚轮键时不起作用效果-->
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>

    <jsp:include page="include.jsp"/>
    <script src="${contextPath}/js/commons/echarts/echarts.min.js"></script>
    <!--bootstrap-table-->
    <link rel="stylesheet" href="${contextPath}/js/commons/bootstrap-table-1.13.1/bootstrap-table.css">
    <script src="${contextPath}/js/commons/bootstrap-table-1.13.1/bootstrap-table.js"></script>
    <script src="${contextPath}/js/commons/bootstrap-table-1.13.1/locale/bootstrap-table-zh-CN.js"></script>
    <link rel="stylesheet" href="${contextPath}/js/commons/bootstrap3-editable/css/bootstrap-editable.css">
    <script src="${contextPath}/js/commons/bootstrap3-editable/js/bootstrap-editable.min.js"></script>
    <!--bootstrap-datetimepicker-->
    <link rel="stylesheet"
          href="${contextPath}/js/commons/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript"
            src="${contextPath}/js/commons/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript"
            src="${contextPath}/js/commons/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <script type="text/javascript" src="${contextPath}/js/commons/commonsUtil.js"></script>
</head>
<body class="cbp-spmenu-push">
<div class="main-content">
    <!--将左侧菜单公用部分包含进来-->
    <jsp:include page="include_menu.jsp"/>
    <!-- main content start-->
    <div id="page-wrapper">
        <%--<a href="/consumeType/getConsumeType">获取类型</a>--%>
        <div class="main-page">
            <h3 class="title1">我的消费列表</h3>
            <div class="tables">
                <div class="table-responsive bs-example widget-shadow">
                    <button id="addAccount" type="button" class="btn btn-success btn-sm" data-toggle="modal">新增</button>
                    <table id="myTable" class="table table-bordered" width="100%">
                        <thead>
                        <tr>
                            <th width="5%" style="text-align: center">序号</th>
                            <th width="15%" style="text-align: center">商品名称</th>
                            <th width="5%" style="text-align: center">单价</th>
                            <th width="5%" style="text-align: center">数量</th>
                            <th width="10%" style="text-align: center">金额</th>
                            <th width="10%" style="text-align: center">分类</th>
                            <th width="10%" style="text-align: center">消费者</th>
                            <th width="15%" style="text-align: center">消费时间</th>
                            <th width="15%" style="text-align: center">备注</th>
                            <%--<th width="5%" style="text-align: center">修改</th>
                            <th width="5%" style="text-align: center">删除</th>--%>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="record" items="${pageInfo.list}" varStatus="status">
                            <tr style="text-align: center">
                                <td>${status.index + 1}</td>
                                <td><c:out value="${record.goodsName}"/></td>
                                <td><c:out value="${record.goodsPrice}"/></td>
                                <td><c:out value="${record.goodsAmount}"/></td>
                                <td><c:out value="${record.money}"/></td>
                                <td><c:out value="${record.consumeTypeName}"/></td>
                                <td><c:out value="${record.userName}"/></td>
                                <td><c:out value="${record.createDatetime}"/></td>
                                <td><c:out value="${record.remark}"/></td>
                                <%--<td>
                                    <button type="button" class="btn btn-primary btn-sm"
                                            onclick="accountEdit('<c:out value="${record.id}"/>')">修改
                                    </button>
                                </td>
                                <td>
                                    <button type="button" class="btn btn-warning btn-sm"
                                            onclick="accountDelete('<c:out value="${record.id}"/>')">删除
                                    </button>
                                </td>--%>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <!--分页-->
            <div class="row">
                <!--分页文字描述-->
                <div class="col-md-4">
                    当前第${pageInfo.pageNum}页,共${pageInfo.pages}页,总共${pageInfo.total}条记录
                </div>
                <!--分页导航显示-->
                <div class="col-md-8">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <li><a href="${contextPath}/account/accountInit?pageNum=1">首页</a></li>
                            <c:if test="${pageInfo.hasPreviousPage}">
                                <li>
                                    <a href="${contextPath}/account/accountInit?pageNum=${pageInfo.pageNum - 1}"
                                       aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>

                            <c:forEach items="${pageInfo.navigatepageNums}" var="navigatePageNum">
                                <c:if test="${navigatePageNum == pageInfo.pageNum}">
                                    <li class="active"><a href="#">${navigatePageNum}</a></li>
                                </c:if>
                                <c:if test="${navigatePageNum != pageInfo.pageNum}">
                                    <li>
                                        <a href="${contextPath}/account/accountInit?pageNum=${navigatePageNum}">${navigatePageNum}</a>
                                    </li>
                                </c:if>

                            </c:forEach>
                            <c:if test="${pageInfo.hasNextPage}">
                                <li>
                                    <a href="${contextPath}/account/accountInit?pageNum=${pageInfo.pageNum + 1}"
                                       aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <li><a href="${contextPath}/account/accountInit?pageNum=${pageInfo.pages}">末页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>
<!--footer-->
<div class="footer">
    <p>Copyright &copy; 2018.Company name All rights reserved.&nbsp;&nbsp;<a target="_blank" href="#">袁金生</a></p>
</div>
<!--//footer-->
</div>

<!--新增消费记录模态框-->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="exampleModalLabel">新增记录</h4>
            </div>
            <div class="modal-body">
                <form id="addAccountForm" method="post" action="${contextPath}/account/addAccount">
                    <div class="form-group">
                        <label for="goodsName" class="control-label">名称:</label>
                        <input type="text" name="goodsName" class="form-control" id="goodsName">
                    </div>
                    <div class="form-group">
                        <label for="goodsPrice" class="control-label">单价:</label>
                        <input type="number" name="goodsPrice" class="form-control" id="goodsPrice"
                               onblur="calcMoney();">
                    </div>
                    <div class="form-group">
                        <label for="goodsAmount" class="control-label">数量:</label>
                        <input type="number" name="goodsAmount" class="form-control" id="goodsAmount"
                               onblur="calcMoney();">
                    </div>
                    <div class="form-group">
                        <label for="money" class="control-label">消费金额:</label>
                        <input type="text" name="money" class="form-control" id="money">
                    </div>
                    <div class="form-group">
                        <label for="consumeTypeCode" class="control-label">消费类型:</label>
                        <select id="consumeTypeCode" name="consumeTypeCode" class="form-control">
                            <option></option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="createDatetime" class="control-label">消费日期:</label>
                        <div class="input-group date form_datetime" data-link-field="createDatetime">
                            <input class="form-control" size="16" type="text" readonly>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>
                        <input type="hidden" name="createDatetime" id="createDatetime"/><br/>
                    </div>
                    <div class="form-group">
                        <label for="remark" class="control-label">备注:</label>
                        <textarea name="remark" class="form-control" id="remark"></textarea>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button id="submitId" type="button" class="btn btn-primary">提交</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<!--删除from-->
<form id="deleteForm" method="post">
    <input type="hidden" name="id" id="keyId"/>
</form>
<!--末尾 初始化左侧菜单的公用js-->
<jsp:include page="include_tail.jsp"/>
</body>
</html>
<script>
    $(function () {
        //添加复选框,但是样式会乱
        /*$('#myTable').bootstrapTable({
            clickEdit: true,
            columns: [{
                checkbox: true
            }]
        })*/
        //加载消费类型
        $.ajax({
            url: '${contextPath}/consumeType/getConsumeType',
            type: 'get',
            dataType: 'json',
            success: function (data) {
                if ("" != data && null != data && data.length > 0) {
                    $.each(data, function (i, type) {
                        //填充下拉框的option的值
                        $("#consumeTypeCode").append("<option value='" + type.consumeTypeCode + "'>" + type.consumeTypeName + "</option>");
                    })
                }
            }
        })
        //点击新增按钮
        $("#addAccount").click(function () {
            $('#exampleModal').modal({backdrop: 'static', keyboard: false});
        })

        //新增记录提交
        $("#submitId").click(function () {
            var goodsName = $("#goodsName").val();
            var goodsAmount = $("#goodsAmount").val();
            var goodsPrice = $("#goodsPrice").val();
            var money = $("#money").val();
            var consumeTypeCode = $("#consumeTypeCode");
            var createDatetime = $("#createDatetime");
            if ("" == goodsName || goodsName == null) {
                bootboxSmallAlert("请输入名称！");
                return false;
            }
            //校验单价
            if ("" == goodsPrice || goodsPrice == null) {
                bootboxSmallAlert("请输入单价！");
                return false;
            }
            //校验数量
            if ("" == goodsAmount || goodsAmount == null) {
                bootboxSmallAlert("请输入数量！");
                return false;
            }

            //校验金额
            if ("" == money || money == null) {
                bootboxSmallAlert("消费金额不能为空,请检查！");
                return false;
            }
            //消费类型
            if ("" == consumeTypeCode || consumeTypeCode == null) {
                bootboxSmallAlert("请选择消费类型！");
                return false;
            }
            $("#addAccountForm").submit();
        })

        //showDate("createDatetime");

        $('.form_datetime').datetimepicker({
            weekStart: 0, //一周从哪一天开始
            todayBtn: 1, //
            autoclose: 1,
            language: 'zh-CN', //中文
            todayHighlight: 1,
            startView: 2,
            forceParse: 0,
            showMeridian: 1
        });
    })

    /**
     * 计算消费总额
     */
    function calcMoney() {
        var goodsPrice = $("#goodsPrice").val();
        var goodsAmount = $("#goodsAmount").val();
        var money = null;
        if(goodsPrice != null && goodsAmount != null){
            money = goodsPrice * goodsAmount;
        }
        $("#money").val(money);
    }

    function accountEdit(id) {
        console.info(id);
    }

    //删除记录
    function accountDelete(id) {
        bootbox.confirm({
            //size: "small",
            message: "您确定要删除所选记录吗？",
            callback: function (result) {
                /* result is a boolean; true = OK, false = Cancel*/
                if (result) {
                    $("#keyId").val(id);
                    //$("#deleteForm").attr("action","${contextPath}/account/deleteAccount");//物理删除
                    $("#deleteForm").attr("action", "${contextPath}/account/deleteAccountLogic");//逻辑删除
                    $("#deleteForm").submit();
                }
            }
        })
    }
</script>