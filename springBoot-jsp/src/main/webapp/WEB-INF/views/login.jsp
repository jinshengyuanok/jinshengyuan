<%--
  Created by IntelliJ IDEA.
  User: jinshengyuan
  Date: 2019-01-10
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<html>
<head>
    <title>系统登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content=""/>
    <!--js、css等静态资源包含进来-->
    <jsp:include page="include.jsp"/>
</head>
<body class="cbp-spmenu-push-toright">
<div class="main-content" style="align-items: center">
    <!-- main content start-->
    <div id="page-wrapper">
        <div class="main-page login-page ">
            <h2 class="title1">${sysLogin} login in</h2>
            <div class="widget-shadow">
                <div class="login-body">
                    <form action="#" method="post">
                        <input id="email" type="email" class="user" name="email"
                               placeholder='<fmt:message key="userName"/>'>
                        <input id="password" type="password" name="password" class="lock" placeholder="Password"
                               required="no">

                        <input type="submit" name="Sign In" value='<fmt:message key="signIn"/>' onclick="userLogin();">
                        <div class="forgot-grid">
                            <label class="checkbox"><input type="checkbox" name="checkbox"
                                                           checked=""><i></i><fmt:message key="rememberMe"/>
                                <!--Remember me--></label>
                            <div class="forgot">
                                <a href="#"><fmt:message key="forgotPassword"/> </a>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="registration">
                            <label><fmt:message key="notAccount"/> </label>
                            <a class="" href="<%=request.getContextPath()%>/user/userRegisterInit">
                                <fmt:message key="createAccount"/>
                            </a>
                        </div>
                        <div class="registration">
                            <a class="" href="${contextPath}/user/login?language='zh_CN'"><fmt:message key="Chinese"/> </a>
                            &nbsp;&nbsp;
                            <a class="" href="${contextPath}/user/login?language='en_US'"><fmt:message key="English"/> </a>
                        </div>
                        <%--<div class="registration">
                            <a class="" th:href="@{/login.html(language='zh_CN')}" th:text="#{Chinese}">中文</a>
                            &nbsp;&nbsp;
                            <a class="" th:href="@{/login.html(language='en_US')}" th:text="#{English}">英文</a>
                        </div>--%>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- main content end-->

    <!--footer-->
    <!--<div class="footer">
    页脚：有需要时填写自己的内容
    </div>-->
    <!--//footer-->
</div>
</body>
</html>
<script>
    var path = "${contextPath}";
    $(function () {
        /*bootbox.alert({
            message: "请输入邮箱地址!",
            callback: function () {
                console.log('This was logged in the callback!');
            }
        })*/
    })

    function userLogin() {
        var email = $("#email").val();
        var password = $("#password").val();
        var isLogin = true;
        if (email == null || email == "") {
            bootbox.alert({
                size: "small",
                title: '系统提示',
                message: "请输入邮箱地址!",
                callback: function () {
                    console.log('This was logged in the callback!');
                }
            })
            isLogin = false;
            return;
        }
        if (password == null || password == "") {
            bootbox.alert({
                size: "small",
                title: '系统提示',
                message: "请输入密码!",
                callback: function () {
                    console.log('This was logged in the callback!');
                }
            })
            isLogin = false;
            return;
        }
        if(isLogin){
            $.ajax({
                url: '${contextPath}/user/userLogin',
                type: 'post', data: {email: email, password: password},
                dataTye: 'json',
                success: function (data) {
                    console.info(data);
                    if (data != null && data != "") {
                        var userName = data.userName;
                        if (userName == null || "" == userName) {
                            bootbox.alert({
                                size: "small",
                                title: '系统提示',
                                message: "用户名或密码错误!",
                                callback: function () {
                                    //console.log('This was logged in the callback!');
                                }
                            })
                            isLogin = true;
                            return;
                        } else {
                            //window.location = '<%=request.getContextPath()%>/MyIndexOld.jsp';
                            window.location.href = '${contextPath}/user/index';
                        }
                    } else {
                        bootbox.alert({
                            size: "small",
                            title: '系统提示',
                            message: "登录失败!",
                            callback: function () {
                                //console.log('This was logged in the callback!');
                            }
                        })
                    }
                    /*bootbox.alert({
                    message: "This is an alert with a callback!",
                    callback: function () {
                    console.log('This was logged in the callback!');
                    }
                    })*/
                }
            })
        }

    }
</script>