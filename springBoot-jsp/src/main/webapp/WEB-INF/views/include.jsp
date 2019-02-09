<%--
  Created by IntelliJ IDEA.
  User: jinshengyuan
  Date: 2019-01-11
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<!-- Bootstrap Core CSS th:href="@{/webjars/bootstrap/4.1.3/css/bootstrap.css}" -->
<%--<link href="${contextPath}/css/bootstrap.css" rel='stylesheet' type='text/css'/>

<!-- Custom CSS -->
<link href="${contextPath}/css/style.css" rel='stylesheet' type='text/css'/>
<!-- Bootstrap Core CSS -->
<link href="${contextPath}/css/bootstrap.css" rel='stylesheet' type='text/css'/>
<!-- Custom CSS -->
<link href="${contextPath}/css/style.css" rel='stylesheet' type='text/css'/>

<!-- js-->
<script src="${contextPath}/js/jquery-1.11.1.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${contextPath}/js/bootstrap.js"></script>
<!-- //Bootstrap Core JavaScript -->

<script src="${contextPath}/js/commons/bootbox.min.js"></script>

<!-- Metis Menu 控制布局相关js与CSS -->
<script src="${contextPath}/js/metisMenu.min.js"></script>
<script src="${contextPath}/js/custom.js"></script>
<link href="${contextPath}/css/custom.css" rel="stylesheet">--%>

<!-- Bootstrap Core CSS -->
<link href="${contextPath}/css/bootstrap.css" rel='stylesheet' type='text/css' />

<!-- Custom CSS -->
<link href="${contextPath}/css/style.css" rel='stylesheet' type='text/css' />

<!-- font-awesome icons CSS -->
<link href="${contextPath}/css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome icons CSS-->

<!-- side nav css file -->
<link href='${contextPath}/css/SidebarNav.min.css' media='all' rel='stylesheet' type='text/css'/>
<!-- //side nav css file -->

<!-- js-->
<script src="${contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${contextPath}/js/modernizr.custom.js"></script>


<!-- Metis Menu -->
<script src="${contextPath}/js/metisMenu.min.js"></script>
<script src="${contextPath}/js/custom.js"></script>
<link href="${contextPath}/css/custom.css" rel="stylesheet">

<!-- 引入 echarts.js -->
<script src="${contextPath}/echarts/echarts.min.js"></script>
<script src="${contextPath}/echarts/themes/macarons.js"></script>


<!-- requried-jsfiles-for owl -->
<link href="${contextPath}/css/owl.carousel.css" rel="stylesheet">
<script src="${contextPath}/js/owl.carousel.js"></script>


<!-- Bootstrap Core JavaScript -->
<script src="${contextPath}/js/bootstrap.js"> </script>
<!-- //Bootstrap Core JavaScript -->
<script src="${contextPath}/js/commons/bootbox.min.js"></script>


<!-- Classie --><!-- for toggle left push menu script -->
<script src="${contextPath}/js/classie.js"></script>

<!-- side nav js -->
<script src='${contextPath}/js/SidebarNav.min.js' type='text/javascript'></script>

<script>
    $(document).ready(function() {
        //图片切换效果
        $("#owl-demo").owlCarousel({
            items : 3,
            lazyLoad : true,
            autoPlay : true,
            pagination : true,
            nav:true
        });
    });
</script>

<%--x-editable 官网--%>
<%--http://vitalets.github.io/x-editable/--%>




