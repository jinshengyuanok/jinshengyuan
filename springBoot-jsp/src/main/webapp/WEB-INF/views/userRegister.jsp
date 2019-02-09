<%--
  Created by IntelliJ IDEA.
  Author: Jinsheng Yuan
  DateTime: 2018/12/14 13:30
  Decscription: 
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新用户注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content=""/>
    <jsp:include page="include.jsp"/>
    <style>
        .img-circle {
            border-radius: 50%;
        }

        body {
            background-color: #C7EDCC;
            font-family: "microsoft yahei";
        }

    </style>
</head>
<body class="text-center">

<div class="modal-dialog" align="center">
    <div class="modal-content">
        <%--<div class="modal-body">
            <button class="close" data-dismiss="modal">
                <span>&times;</span>
            </button>
        </div>--%>
        <div class="modal-title,modal-sm">
            <h2 class="text-center">新用户注册</h2>
        </div>
        <form id="userRegisiterForm" class="form-signin" style="width: 450px;" action="${pageContext.request.contextPath}/user/userRegister">
            <label class="form-inline">
                邮&nbsp;&nbsp;&nbsp;箱：<input type="email" style="width: 350px;" id="email" name="email" class="form-control" placeholder="例：123@qq.com" required autofocus>
            </label>
            <br>
            <label class="form-inline">
                用户名：<input type="text" style="width: 350px;" id="userName" name="userName" class="form-control" placeholder="用户名" required>
            </label>

            <br>
            <label class="form-inline">
                昵&nbsp;&nbsp;&nbsp;称：<input type="text" style="width: 350px;" id="nickname" name="nickname" class="form-control" placeholder="昵称" required>
            </label>
            <br>
            <label class="form-inline">
                密&nbsp;&nbsp;&nbsp;码：<input type="password" style="width: 350px;" id="password" name="password" class="form-control" placeholder="密码" required>
            </label>
            <br>
            <label class="form-inline">
                手机号：<input type="text" style="width: 350px;" id="mobilePhone" name="mobilePhone" class="form-control" placeholder="手机号码" required>
            </label>
            <br>
            <label class="form-inline">
                性&nbsp;&nbsp;&nbsp;别：<input type="radio" name="gender" value="0"> 男 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="gender" value="1">女
            </label>
            <br>
            <label class="form-inline">
                头&nbsp;&nbsp;&nbsp;像：<input type="file" name="photoUrl">
            </label>
            <div class="text-center" style="padding-bottom: 10px;">
                <button class="btn btn-primary" type="submit">提交</button>
                <button class="btn btn-danger" data-dismiss="modal">重置</button>
            </div>

            <a href="<%=request.getContextPath()%>/user/login" data-toggle="modal" data-dismiss="modal" data-target="#register">已有账号？直接登录</a>
        </form>

    </div>
</div>
</body>
</html>
<script>
    function doSubmit() {
        document.getElementById("userRegisiterForm").form(0).submit();
    }
</script>