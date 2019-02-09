var batchFracasId = "";
var pager = null;
$(function () {
    batchFracasId = $("#batchFracasId").val();//上一页面传过来的值
    $('#batchExamineDg').datagrid({
        method: 'post',
        fit: true,
        fitColumns: true,
        url: "com.rskytech.process.newProcess.batchExamineInfoByPerson.biz.ext?batchFracasId=" + batchFracasId,
        pageSize: 15,
        singleSelect: true,
        scrollbarSize: 0,
        rownumbers: true,
        pageList: [15, 20, 30, 50],
        pagination: true,
        toolbar: [{
            id: 'saveId',
            text: '保存',
            iconCls: 'icon-save',
            disabled: false,
            handler: function () {
                doSave()
            }
        }],
        columns: [[
            {field: 'id', hidden: true},
            {field: 'productId', hidden: true},
            {field: 'faultId', hidden: true},
            {field: 'processId', hidden: true},
            {field: 'batchFracasId', title: '批量核查流程编号', align: 'center', width: 100},
            {field: 'faultModel', title: '故障模式', align: 'center', width: 100},
            {
                field: 'fracasId',
                title: '核查流程编号',
                align: 'center',
                width: 100,
                formatter: function (value, row, index) {
                    return '<a class="see" onclick="fracasIdLink(\'' + value + '\',\'' + row.faultId + '\')" href="javascript:void(0)">' + value + '</a>';
                }
            },
            {field: 'fracasNo', title: 'FRACAS单号', align: 'center', width: 100},
            {
                field: 'isQuestion', title: '是否存在类似问题', align: 'center', width: 100,
                formatter: function (value, row, index) {
                    if (value == "1") {
                        return "是";
                    } else if (value == "0") {
                        return "否"
                    }
                    $('#batchExamineDg').datagrid('beginEdit', index);
                },
                editor: {
                    type: 'combobox',
                    options: {
                        valueField: 'vid',
                        textField: 'text',
                        panelHeight: 50,
                        editable: false,
                        data: [{
                            "vid": "0",
                            "text": "否"
                        }, {
                            "vid": "1",
                            "text": "是"
                        }]
                    }
                }
            },
            {
                field: 'afterMeasure', title: '后续措施', align: 'center', width: 100,
                editor: {
                    type: "validatebox",
                    options: {
                        required: false,
                        validType: 'length[0,200]'
                    }
                }
            },
            {field: 'empName', title: '人员', align: 'center', width: 150}
        ]], onBeforeLoad: function (p) {
            p.startRow = p.page ? ((p.page - 1) * p.rows) : 0;//当前第几页
            p.pageRows = p.rows;//每页行数
            return true;
        }, onLoadSuccess: function (row) {
            $('#batchExamineDg').datagrid('doCellTip', {'max-width': '300px', 'delay': 500});
            var allRows = $('#batchExamineDg').datagrid('getRows');
            $.each(allRows, function (i, d) {
                $('#batchExamineDg').datagrid('beginEdit', i);//加载默认开启可编辑的列
                //$($('#batchExamineDg').datagrid('getEditor', {index: i, field: 'isQuestion'}).target).combobox("setValue","0");//设置默认值
            });
            pager = null;
        }
    });

    pager = $("#batchExamineDg").datagrid("getPager");
    var currentPage = $('#batchExamineDg').datagrid('options');
    console.info();

    if (pager) {
        $(pager).pagination({
            onBeforeRefresh: function () {
                alert('刷新前。。。。');
            },
            onRefresh: function (pageNumber, pageSize) {
                alert(pageNumber);
                alert(pageSize);
            },
            onChangePageSize: function () {
                alert('pagesize 更变。。。');
            },
            onSelectPage: function (pageNumber, pageSize) {
                var dgRows = $("#batchExamineDg").datagrid("getRows");
                var isSave = true;
                var isQuestion = "";
                var isQuestionVal = "";
                var afterMeasure = "";
                var afterMeasureVal = "";
                var jsonObj = [];//json类型的数组
                $.each(dgRows, function (i, j) {
                    isQuestion = $('#batchExamineDg').datagrid('getEditor', {index: i, field: 'isQuestion'});//是否存在类似问题的可编辑行
                    afterMeasure = $('#batchExamineDg').datagrid('getEditor', {index: i, field: 'afterMeasure'});
                    isQuestionVal = $(isQuestion.target).combobox('getValue');//取每一行是否存在类似问题的值
                    afterMeasureVal = $(afterMeasure.target).val();
                    if (isQuestionVal == "" || isQuestionVal == null) {
                        $.messager.alert("提示", "请选择第" + (i + 1) + "行的是否存在类似问题", "info");
                        isSave = false;
                        return false;
                    }
                    if (isQuestionVal == "1" && (afterMeasureVal == "" || afterMeasureVal == null)) {
                        $.messager.alert("提示", "第" + (i + 1) + "行的\"是否存在类似问题\"选择为\"是\"时,必须填写后续措施", "info");
                        isSave = false;
                        return false;
                    }
                    /*if (isQuestionVal != "" && isQuestionVal != null) {
                        jsonObj.push("{\"id\":\"" + dgRows[i].id + "\",\"processId\":\"" + dgRows[i].processId + "\",\"isQuestion\":\"" + isQuestionVal + "\",\"afterMeasure\":\"" + afterMeasureVal + "\"}");
                    }*/
                });
                return;
                if (isSave) {
                    //console.info("data:"+JSON.stringify(dataRows));
                    alert(pageNumber + "---------" + pageSize);
                    var start = (pageNumber - 1) * pageSize;
                    var end = start + pageSize;

                    console.info(start + "-----end:" + end)
                    //$("#batchExamineDg").datagrid("loadData", JSON.stringify(dataRows).slice(start, end));


                    $("#batchExamineDg").datagrid({
                        queryParams: {
                            startRow: start,
                            pageRows: pageSize
                        }
                    })

                    pager.pagination('refresh', {
                        pageNumber: pageNumber,
                        pageSize: pageSize
                    });

                }
            }
        });
    }
})

//查看方法
function fracasIdLink(reportNumber, id) {
    var subtitle = 'fracas单' + reportNumber;
    var url = '/default/process/lookBatchDetailInfo.jsp?id=' + id;
    var icon = 'icon-imagic';
    addTab(subtitle, url, icon);
}

//打开新的选项卡
function addTab(subtitle, url, icon) {
    //alert(url)
    if (!parent.$('#tabs').tabs('exists', subtitle)) {
        parent.$('#tabs').tabs('add', {
            title: subtitle,
            content: createFrame(url),
            closable: true,
            icon: icon
        });
    } else {
        parent.$('#tabs').tabs('select', subtitle);
    }
}

//创建frame
function createFrame(url) {
    var s = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
    return s;
}

function doSave() {
    var isSave = true;
    var dgRows = $("#batchExamineDg").datagrid("getRows");
    var isQuestion = "";
    var isQuestionVal = "";
    var afterMeasure = "";
    var afterMeasureVal = "";
    var jsonObj = [];//json类型的数组
    $.each(dgRows, function (i, j) {
        isQuestion = $('#batchExamineDg').datagrid('getEditor', {index: i, field: 'isQuestion'});//是否存在类似问题的可编辑行
        afterMeasure = $('#batchExamineDg').datagrid('getEditor', {index: i, field: 'afterMeasure'});
        isQuestionVal = $(isQuestion.target).combobox('getValue');//取每一行是否存在类似问题的值
        afterMeasureVal = $(afterMeasure.target).val();
        if (isQuestionVal == "" || isQuestionVal == null) {
            $.messager.alert("提示", "请选择第" + (i + 1) + "行的是否存在类似问题", "info");
            isSave = false;
            return false;
        }
        if (isQuestionVal == "1" && (afterMeasureVal == "" || afterMeasureVal == null)) {
            $.messager.alert("提示", "第" + (i + 1) + "行的\"是否存在类似问题\"选择为\"是\"时,必须填写后续措施", "info");
            isSave = false;
            return false;
        }
        if (isQuestionVal != "" && isQuestionVal != null) {
            jsonObj.push("{\"id\":\"" + dgRows[i].id + "\",\"processId\":\"" + dgRows[i].processId + "\",\"isQuestion\":\"" + isQuestionVal + "\",\"afterMeasure\":\"" + afterMeasureVal + "\"}");
        }
    });

    if (isSave) {
        var mainId = $('#batchExamineDg').datagrid("getRows")[0].mainId;
        if (jsonObj.length == 0) {
            $.messager.alert("提示", "请选择是否存在类似问题及填写后续措施再保存", "info");
            return false;
        }
        $.messager.progress({
            title: '系统提示',
            text: '数据处理中...',
            interval: '300'
        });
        $.ajax({
            type: "POST",
            url: "com.rskytech.process.newProcess.batchExamineModifyState.biz.ext",
            data: {"jsonStr": "[" + jsonObj + "]", "mainId": mainId},
            cache: false,
            dataType: "json",
            success: function (data) {
                $.messager.progress("close");
                if (data.msg == "1") {
                    //$.messager.alert("提示", "保存成功", "info");
                    //linkFracas();
                    var state = $('#batchExamineDg').datagrid('getRows')[0].state;
                    $('#dg').datagrid('load', {'batchFracasId': batchFracasId});
                    $.messager.confirm("提示", "保存成功,是否转到研制设计核查页面?", function (ok) {
                        if (ok) {
                            linkFracas();
                        } else {
                            closeTab();//关闭选项卡
                        }
                    });
                } else {
                    $.messager.alert("提示", "保存失败", "info");
                }
            }
        });
    }
}

//保存成功后跳转到典型故障批量核查(batchFracas.jsp)页面中
function linkFracas() {
    var parentTabs = parent.$('#tabs');
    var tabTitle = "流程" + batchFracasId;
    //alert("tabTitle:"+tabTitle);
    var existsTab = parentTabs.tabs('exists', tabTitle);//是否存在选项卡，true为存在
    if (existsTab) {
        var getTab = parentTabs.tabs('getTab', tabTitle);//存在则获取选项卡对象
        var getExisitsTabIndex = parentTabs.tabs('getTabIndex', getTab);//根据选项卡对象获取选项卡的index
        parentTabs.tabs('close', getExisitsTabIndex);//根据index关闭已经存在的选项卡
    }
    var subtitle = 'FRACAS';
    //var url =  '/default/process/fracas.jsp';
    var url = '/default/process/batchFracas.jsp';
    var icon = 'icon-imagic';
    parentTabs.tabs("add", {
        title: subtitle,
        content: createFrame(url),
        closable: true,
        icon: icon
    });
}

//所有审核成功后关闭选项卡
function closeTab() {
    var parentTabs = parent.$('#tabs');
    var tabTitle = "流程" + batchFracasId;
    var existsTab = parentTabs.tabs('exists', tabTitle);//是否存在选项卡，true为存在
    if (existsTab) {
        var getTab = parentTabs.tabs('getTab', tabTitle);//存在则获取选项卡对象
        var getExisitsTabIndex = parentTabs.tabs('getTabIndex', getTab);//根据选项卡对象获取选项卡的index
        parentTabs.tabs('close', getExisitsTabIndex);//根据index关闭已经存在的选项卡
    }
}
