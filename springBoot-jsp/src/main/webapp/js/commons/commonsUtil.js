/**
 * Created by IntelliJ IDEA.
 * User: jinshengyuan
 * Date: 2018-07-24
 * Time: 17:53
 * description: 公用js
 **/
/**
 * 进度条提示
 */
function progressTip() {
    $.messager.progress({
        title: '系统提示',
        msg:'数据处理中,请稍后...',
        text: '正在处理...',
        interval: '300'
    });
}

/**
 * 自定义内容的进度条提示
 * @param titleVal 标题
 * @param msgVal 提示信息
 * @param textVal 进度条上显示的文本
 * @param intervalVal 时间
 */
function progressTipOne(titleVal,msgVal,textVal, intervalVal) {
    $.messager.progress({
        title: titleVal,
        msg: msgVal,
        text: textVal,
        interval: intervalVal
    });
}

/**
 * 进度条关闭
 */
function progressTipClose() {
    $.messager.progress('close');//关闭进度条
}

/**
 * bootstrap-datetimepicker 设置
 * @param id  对象id
 */

function showDate(id) {
    $('#'+id).datetimepicker({
        bootcssVer:3, //不加这一句，左右箭头不显示
        format:"yyyy-mm-dd HH:ii:ss",
        todayBtn:true,//或1=true
        autoclose: true,
        language:  'zh-CN', //中文
        minView: 4, //
        todayHighlight: 1,//或 true
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });
}

function bootboxSmallAlert(message){
    bootbox.alert({
        size: "small",
        title: '系统提示',
        message: message,
        callback: function () {
            //console.log('This was logged in the callback!');
        }
    })
}


//Easyui icon 图标
var iconData = [{
    value: '',
    text: '默认'
},  {
    value: 'icon-add',
    text: 'icon-add'
}, {
    value: 'icon-edit',
    text: 'icon-edit'
}, {
    value: 'icon-remove',
    text: 'icon-remove'
}, {
    value: 'icon-save',
    text: 'icon-save'
}, {
    value: 'icon-cut',
    text: 'icon-cut'
}, {
    value: 'icon-ok',
    text: 'icon-ok'
}, {
    value: 'icon-no',
    text: 'icon-no'
}, {
    value: 'icon-cancel',
    text: 'icon-cancel'
}, {
    value: 'icon-reload',
    text: 'icon-reload'
}, {
    value: 'icon-search',
    text: 'icon-search'
}, {
    value: 'icon-print',
    text: 'icon-print'
}, {
    value: 'icon-help',
    text: 'icon-help'
}, {
    value: 'icon-undo',
    text: 'icon-undo'
}, {
    value: 'icon-redo',
    text: 'icon-redo'
}, {
    value: 'icon-back',
    text: 'icon-back'
}, {
    value: 'icon-sum',
    text: 'icon-sum'
}, {
    value: 'icon-tip',
    text: 'icon-tip'
}, {
    value: 'icon-mini-add',
    text: 'icon-mini-add'
}, {
    value: 'icon-mini-edit',
    text: 'icon-mini-edit'
}, {
    value: 'icon-mini-refresh',
    text: 'icon-mini-refresh'
}];