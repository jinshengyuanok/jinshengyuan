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
    <title>个人日常消费记录</title>
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

</head>
<body class="cbp-spmenu-push">
<div class="main-content">
    <!--将左侧菜单公用部分包含进来-->
    <jsp:include page="include_menu.jsp"/>
    <!-- main content start-->
    <div id="page-wrapper">
        <div class="main-page">
            <!---图表数据显示--->
            <div class="charts">
                <div class="col-md-7 charts-grids widget">
                    <div class="card-header">
                        <h3>消费类型统计表</h3>
                    </div>
                    <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
                    <div id="myPie" style="width: 98%;height:350px;"></div>

                </div>

                <div class="col-md-5 charts-grids widget states-mdl">
                    <div class="card-header" align="center">
                        <h3><select id="countYear" onchange="loadBarData(this.value)"></select>
                            &nbsp;&nbsp;年度消费记录统计表
                        </h3>
                    </div>
                    <div id="myBar" style="width: 98%;height:350px;"></div>
                </div>

                <div class="clearfix"></div>
            </div>

            <!---图片切换--->
            <div>
                <div class="mid-content-top charts-grids">
                    <div class="middle-content">
                        <!-- <h4 class="title">Carousel Slider</h4>-->
                        <!-- start content_slider -->
                        <div id="owl-demo" class="owl-carousel text-center">
                            <div class="item">
                                <img class="lazyOwl img-responsive" data-src="${contextPath}/images/slider1.jpg"
                                     alt="name">
                            </div>
                            <div class="item">
                                <img class="lazyOwl img-responsive" data-src="${contextPath}/images/slider2.jpg"
                                     alt="name">
                            </div>
                            <div class="item">
                                <img class="lazyOwl img-responsive" data-src="${contextPath}/images/slider3.jpg"
                                     alt="name">
                            </div>
                            <div class="item">
                                <img class="lazyOwl img-responsive" data-src="${contextPath}/images/slider4.jpg"
                                     alt="name">
                            </div>
                            <div class="item">
                                <img class="lazyOwl img-responsive" data-src="${contextPath}/images/slider5.jpg"
                                     alt="name">
                            </div>
                            <div class="item">
                                <img class="lazyOwl img-responsive" data-src="${contextPath}/images/slider6.jpg"
                                     alt="name">
                            </div>
                            <div class="item">
                                <img class="lazyOwl img-responsive" data-src="${contextPath}/images/slider7.jpg"
                                     alt="name">
                            </div>

                        </div>
                    </div>
                    <!--//sreen-gallery-cursual---->
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


<script>
    /* var myPieChart = echarts.init(document.getElementById('myPie'),'macarons');

     // 指定图表的配置项和数据
     var pieOption = {
         title : {
             text: '某站点用户访问来源',
             subtext: '纯属虚构',
             x:'center'
         },
         tooltip : {
             trigger: 'item',
             formatter: "{a} <br/>{b} : {c} ({d}%)"
         },
         legend: {
             orient: 'vertical',
             left: 'left',
             data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
         },
         series : [
             {
                 name: '访问来源',
                 type: 'pie',
                 radius : '55%',
                 center: ['50%', '60%'],
                 data:[
                     {value:335, name:'直接访问'},
                     {value:310, name:'邮件营销'},
                     {value:234, name:'联盟广告'},
                     {value:135, name:'视频广告'},
                     {value:1548, name:'搜索引擎'}
                 ],
                 itemStyle: {
                     emphasis: {
                         shadowBlur: 10,
                         shadowOffsetX: 0,
                         shadowColor: 'rgba(0, 0, 0, 0.5)'
                     }
                 }
             }
         ]
     };


     // 使用刚指定的配置项和数据显示图表。
     myPieChart.setOption(pieOption);*/


    /*var myBarChart = echarts.init(document.getElementById('myBar'),'macarons');

    // 指定图表的配置项和数据
    var barOption = {
        title : {
            text: '某地区蒸发量和降水量',
            subtext: '纯属虚构'
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['蒸发量','降水量']
        },
        toolbox: {
            show : true,
            feature : {
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'蒸发量',
                type:'bar',
                data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
                markPoint : {
                    data : [
                        {type : 'max', name: '最大值'},
                        {type : 'min', name: '最小值'}
                    ]
                },
                markLine : {
                    data : [
                        {type : 'average', name: '平均值'}
                    ]
                }
            },
            {
                name:'降水量',
                type:'bar',
                data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
                markPoint : {
                    data : [
                        {name : '年最高', value : 182.2, xAxis: 7, yAxis: 183},
                        {name : '年最低', value : 2.3, xAxis: 11, yAxis: 3}
                    ]
                },
                markLine : {
                    data : [
                        {type : 'average', name : '平均值'}
                    ]
                }
            }
        ]
    };



    // 使用刚指定的配置项和数据显示图表。
    myBarChart.setOption(barOption);*/
</script>
</body>
</html>
<script>
    $(function () {
        var date = new Date();
        var countYear = date.getFullYear();
        for(var i=countYear;i>=2015;i--){
            $("#countYear").append("<option value='" + i + "'>" + i + "</option>");
        }

        $.ajax({
            url: '${contextPath}/account/countByConsumeType',
            type: 'get',
            data: null,
            dataTye: 'json',
            success: function (data) {
                if ("" != data && data != null) {
                    var legendData = [];
                    $.each(data, function (i, d) {
                        legendData.push(d.name);
                    })
                    initPie(legendData, data);
                }

            }
        })
        //
        var date = new Date();
        console.info(date.getFullYear());
        loadBarData(date.getFullYear());

    })
    //初始化饼图
    function initPie(legendData, seriesData) {
        var myPieChart = echarts.init(document.getElementById('myPie'), 'macarons');
        // 指定图表的配置项和数据
        var pieOption = {
            title: {
                text: '消费类型统计',
                subtext: '单位: 元',
                x: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                type: 'scroll',
                orient: 'vertical',
                //left: 'left',
                right: 2,
                top: 10,
                bottom: 10,
                data: legendData
            },
            series: [
                {
                    name: '消费类型',
                    type: 'pie',
                    radius: '55%',
                    center: ['40%', '50%'],
                    data: seriesData,
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        // 使用刚指定的配置项和数据显示图表。
        myPieChart.setOption(pieOption);
    }

    /**
     * 加载饼图数据
     * @param countYear
     */
    function loadBarData(countYear){
        $.ajax({
            url: '${contextPath}/account/countByYear',
            type: 'get',
            data: {year: countYear},
            dataTye: 'json',
            success: function (data) {
                if ("" != data && data != null) {
                    var xAxisData = [];
                    var seriesData = [];
                    $.each(data, function (i, d) {
                        xAxisData.push(d.month);
                        seriesData.push(d.money);
                    })
                    initBar(xAxisData, seriesData);
                }
            }
        })
    }

    /**
     * 初始化柱状图
     * @param legendData
     * @param seriesData
     */
    function initBar(legendData, seriesData) {
        var myBarChart = echarts.init(document.getElementById('myBar'), 'macarons');
        // 指定图表的配置项和数据
        var barOption = {
            title: {
                text: '消费金额',
                subtext: '单位： 元'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['月份']
            },
            toolbox: {
                show: true,
                feature: {
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                }
            },
            calculable: true,
            xAxis: [
                {
                    type: 'category',
                    data: legendData
                }
            ],
            yAxis: [
                {
                    type: 'value'
                }
            ],
            series: [
                {
                    name: '月份',
                    type: 'bar',
                    data: seriesData,
                    markPoint: {
                        data: [
                            {type: 'max', name: '最大值'},
                            {type: 'min', name: '最小值'}
                        ]
                    },
                    markLine: {
                        data: [
                            {type: 'average', name: '平均值'}
                        ]
                    }
                }/*,
                {
                    name:'降水量',
                    type:'bar',
                    data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
                    markPoint : {
                        data : [
                            {name : '年最高', value : 182.2, xAxis: 7, yAxis: 183},
                            {name : '年最低', value : 2.3, xAxis: 11, yAxis: 3}
                        ]
                    },
                    markLine : {
                        data : [
                            {type : 'average', name : '平均值'}
                        ]
                    }
                }*/
            ]
        };
        // 使用刚指定的配置项和数据显示图表.
        myBarChart.setOption(barOption);
    }
</script>