<%--
  Created by IntelliJ IDEA.
  User: jinshengyuan
  Date: 2019-01-17
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<script>
    //加载左侧菜单导航
    var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
        showLeftPush = document.getElementById( 'showLeftPush' ),
        body = document.body;

    showLeftPush.onclick = function() {
        classie.toggle( this, 'active' );
        classie.toggle( body, 'cbp-spmenu-push-toright' );
        classie.toggle( menuLeft, 'cbp-spmenu-open' );
        disableOther( 'showLeftPush' );
    };

    function disableOther( button ) {
        if( button !== 'showLeftPush' ) {
            classie.toggle( showLeftPush, 'disabled' );
        }
    }
</script>

<!--scrolling js 下面两个js文件一定要放到最后引入,否则不出现最右边的纵向滚动条-->
<script src="${contextPath}/js/jquery.nicescroll.js"></script>
<script src="${contextPath}/js/scripts.js"></script>

<script>
    $('.sidebar-menu').SidebarNav();//初始左侧菜单折叠用
</script>
<!-- //side nav js -->