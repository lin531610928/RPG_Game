<%--
  Created by IntelliJ IDEA.
  User: 1234561
  Date: 2018/3/13
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>用户注册</title>
    <script src="<%= request.getContextPath() %>/jsp/js/bootstrap.js"></script>
    <link href="<%= request.getContextPath() %>/jsp/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/jsp/css/register.css">
    <script src="<%= request.getContextPath() %>/jsp/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#button_ok").click(function login() {
                var name = $("#user").val();
                var password = $('#password').val();
                var con = JSON.stringify({"player_name": name,"player_password": password});
                $.ajax({
                    type:"post",
                    dataType: "json",
                    contentType: "application/json",
                    url:"${pageContext.request.contextPath}/player/register",
                    data:con,
                    success: function (data) {
                        if (data.message == "true") {
                            alert("注册成功");
                            window.location.href= '${pageContext.request.contextPath}/player/login';
                        } else if (data.message == "false"){
                            alert("用户名已存在");
                        } else {
                            alert("注册失败");
                        }
                    },
                });
            });
        });
    </script>
</head>
<body>
<div id="main">
    <div id="regest" align="center" style="width:35%; height:330px;">

        <form>
            <div class="title">
                <h3>注册</h3>
            </div>
            <div class="usrpassword">
                <div class="usr">
                    <input type="text" name="user" placeholder="用户名" style="height:30px; width:77%" id="user" onKeyUp="pw()"/>
                </div>
                <div class="usr">
                    <input type="password" name="password" id="password" placeholder="密码" style="height:30px; width:77%; position:relative" onKeyUp="pw()"/><br/>
                </div>
                <div class="password">
                    <input type="password" name="insurepassword" id="insurepassword" placeholder="确认密码" style="height:30px; width:77%" onKeyUp="pw()"/>
                    <p id="emalert"></p>
                    <p id="alert"></p>
                </div>
                <br/>
            </div>
        </form>
        <div class="button">
            <button id="button_ok" class="btn btn-primary btn-lg link" >注册</button>
        </div>
        <div class="login">
            <div style="margin-right:auto; float:left">
                <p align="left" style="font-size:24px; font-family:'微软雅黑', '黑体'; color:rgba(122,122,122,1.00)">已有帐号?</p>
            </div>
            <div class="login_button">
                <a href="${pageContext.request.contextPath}/player/login">
                    <p style="font-size:24px; font-family:'微软雅黑', '黑体'; color:rgba(255,255,255,1.00)">登录</p>
                </a>
            </div>
        </div>
    </div>
</div>
<script src="<%= request.getContextPath() %>/jsp/js/register.js"></script>
</body>
</html>
