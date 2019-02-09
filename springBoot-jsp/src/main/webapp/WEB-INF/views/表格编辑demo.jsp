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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="" />
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
    <link rel="stylesheet" href="${contextPath}/js/commons/bootstrap-table-1.13.1/bootstrap-table.css" >
    <script src="${contextPath}/js/commons/bootstrap-table-1.13.1/bootstrap-table.js"></script>
    <script src="${contextPath}/js/commons/bootstrap-table-1.13.1/locale/bootstrap-table-zh-CN.js"></script>
    <link  rel="stylesheet" href="${contextPath}/js/commons/bootstrap3-editable/css/bootstrap-editable.css">
    <script src="${contextPath}/js/commons/bootstrap3-editable/js/bootstrap-editable.min.js"></script>

</head>
<body class="cbp-spmenu-push">
<div class="main-content">
    <!--将左侧菜单公用部分包含进来-->
    <jsp:include page="include_menu.jsp"/>
    <!-- main content start-->
    <div id="page-wrapper">
        <div class="main-page">
            <div class="tables">
                <h2 class="title1">我的消费列表</h2>
                <div class="table-responsive bs-example widget-shadow">
                    <button id="add" class="btn-info">新增</button>
                    <button id="doSubmit" class="but-info">提交</button>
                    <h4>Responsive Table:</h4>
                    <table id="table" class="table table-bordered"></table>
                    <table class="table table-bordered"> <thead> <tr> <th>#</th> <th>Table heading</th> <th>Table heading</th> <th>Table heading</th> <th>Table heading</th> <th>Table heading</th> <th>Table heading</th> </tr> </thead> <tbody> <tr> <th scope="row">1</th> <td>Table cell</td> <td>Table cell</td> <td>Table cell</td> <td>Table cell</td> <td>Table cell</td> <td>Table cell</td> </tr> <tr> <th scope="row">2</th> <td>Table cell</td> <td>Table cell</td> <td>Table cell</td> <td>Table cell</td> <td>Table cell</td> <td>Table cell</td> </tr> <tr> <th scope="row">3</th> <td>Table cell</td> <td>Table cell</td> <td>Table cell</td> <td>Table cell</td> <td>Table cell</td> <td>Table cell</td> </tr> </tbody> </table>
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

<!--末尾 初始化左侧菜单的公用js-->
<jsp:include page="include_tail.jsp"/>
</body>
</html>
<script>
    $(function () {
        var $table = $('#table');
        $('#table').bootstrapTable({
            clickEdit: true,

            //表格高度
            //height: getHeight(),
            //服务器数据的请求方式 'get' 或 'post'。
            //method: 'get',
            //url: '/MsgDealCenterAction/listData',//请求后台的URL
            //dataType: 'json',//服务器返回的数据类型。
            //classes: "table table-hover",
            striped: false, //设置为 true 会有隔行变色效果
            //设置为 true 会在表格底部显示分页条。
            toolbar: '#toolbar', //工具按钮用哪个容器
            cache: false,//是否使用缓存，默认为true，所以一般情况下需要设置一下这个属
            //paginationLoop: true,//设置为 true 启用分页条无限循环的功能
            //sidePagination: 'server',//设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置服务器数据地址（url）或者重写ajax方法
            pagination: true, //显示分页条
            pageNumber: 1,//初始化加载第一页，默认第一页
            pageSize: 10,//每页的记录行数
            pageList: [10,15,20, 50, 100],//可供选择的每页的行数
            paginationPreText: '‹',//指定分页条中上一页按钮的图标或文字,这里是<
            paginationNextText: '›',//指定分页条中下一页按钮的图标或文字,这里是>
            sortable: true,//设置为false 将禁止所有列的排序。
            //sortName: 'insert_time',//设置默认排序为 name
            //sortOrder: "desc",//定义排序方式，'asc' 或者 'desc'。
            showRefresh: true,//是否显示刷新按钮
            showColumns: true,//是否显示内容列下拉框。
            showExport: true,//显示导出插件
            search: true,//是否显示右上角的搜索框
            showPaginationSwitch: true,     //隐藏/显示分页开关
            showToggle:true,//是否显示切换视图（table/card）按钮。
            //clickToSelect: true,//是否启用点击选中行
            //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
            //设置为limit可以获取limit, offset, search, sort, order
            queryParamsType:'undefined',
            search: false,                      //是否显示表格搜索
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列（选择显示的列）
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            //height: 500,                      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "id",                     //每一行的唯一标识，一般为主键列
            showToggle: true,                   //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                  //是否显示父子表
            //请求服务器数据
            /*queryParams: function queryParams(params){
                var param = {
                    pageNumber: params.pageNumber,
                    pageSize: params.pageSize,
                    sortName: params.sortName,
                    sortOrder: params.sortOrder
                };
                return param;
            },*/
            columns: [{
                checkbox: true,
            }, {

                field: 'id',
                title: 'Item ID'
            }, {
                id:"toolTipId",
                field: 'name',
                title: 'Item Name',
                "data-editable":true,
                titleTooltip: 'this is Item Name'
            }, {
                field: 'price',
                title: 'Item Price'
            }],
            data: [{
                id: 1,
                name: 'Item 1',
                price: '$1'
            }, {
                id: 2,
                name: 'Item 2',
                price: '$2'
            }, {
                id: 3,
                name: 'Item 2',
                price: '$2'
            }], onClickRow: function () {
                //alert("aaa");
            }, onClickCell: function (field, value, row, $element) {
                $element.attr('contenteditable', true);
                $element.blur(function () {
                    var index = $element.parent().data('index');
                    var tdValue = $element.html();

                    saveData(index, field, tdValue);
                })
            }
        })


       /* $('#toolTipId').editable({
            type: 'text',
            pk: 1,
           // url: '/post',
            title: 'Enter username'
        });*/
        /**
         * 保存更新的数据
         * @param index
         * @param field
         * @param value
         */
        function saveData(index, field, value) {
            $table.bootstrapTable('updateCell', {
                index: index,       //行索引
                field: field,       //列名
                value: value        //cell值
            })
        }

        /**
         * 新增数据
         */
        $("#add").click(function () {
            var len = $('#table').bootstrapTable('getData').length;
            console.info("len:" + len);
            $('#table').bootstrapTable('insertRow', {
                index: len + 1,
                row: {
                    id: len + 1,
                    name: '',
                    price: ''
                }
            })
        })

        /**
         * 提交数据
         */
        $("#doSubmit").click(function(){
            var datas = $('#table').bootstrapTable('getSelections');
            if(datas == null || datas == ""){
                alert('请选择要提交的数据！');
            }else{
                console.info(JSON.stringify($('#table').bootstrapTable('getSelections')));
            }

        })
    })
</script>