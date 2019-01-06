<%--
  Created by IntelliJ IDEA.
  User: 1234561
  Date: 2018/3/13
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <link href="<%= request.getContextPath() %>/jsp/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/jsp/css/login.css">
    <script src="<%= request.getContextPath() %>/jsp/js/jquery-3.2.1.min.js"></script>
    <script src="<%= request.getContextPath() %>/jsp/js/jquery.cookie.js"></script>
    <script type="text/javascript">
        function getContextPath() {
            var pathName = document.location.pathname;
            var index = pathName.substr(1).indexOf("/");
            var result = pathName.substr(0,index+1);
            return result;
        }
        $(document).ready(function() {
            $("#1").click(function login() {
                var name = $("#name").val();
                var password = $('#password').val();
                var con = JSON.stringify({"player_name": name,"player_password": password});
                $.ajax({
                    type:"post",
                    dataType: "json",
                    contentType: "application/json",
                    url:"${pageContext.request.contextPath}/player/login",
                    data:con,
                    success: function (data) {
                        if (data.message == "true") {
                            //-------------插cookie---------------
                            //alert(data.player_id+""+data.player_name);
                            alert("登陆成功");
                            $.cookie('ID',data.player_id,{ expires: 1,path: getContextPath()+"/"});
                            $.cookie('name',data.player_name,{ expires: 1,path: getContextPath()+"/"});
                            $.cookie('password',data.player_password,{ expires: 1,path: getContextPath()+"/"});
                            window.location.href="${pageContext.request.contextPath}/";
                        } else if(data.message == "no"){
                            alert("用户名不存在");
                        }
                        else alert("密码错误");
                    },
                });
            });
        });
    </script>
</head>
<body>
<div id="main">
    <div id="regest" align="center" style="width:35%; height:270px;">

        <form>
            <div class="title">
                <h3>登录</h3>
            </div>
            <div class="usrpassword">
                <div class="usr">
                    <input type="text" name="user" id="name" placeholder="用户名" style="height:30px; width:300px">
                </div>
                <div class="password">
                    <input type="password" name="password" id="password" placeholder="密码" style="height:30px; width:300px"><br/>
                </div>
            </div>
        </form>
        <div class="button">
            <button  id="1" class="btn btn-primary btn-lg link" >登陆</button>
        </div>
        <div class="login">
            <div style="margin-right:auto; float:left">
                <p align="left" style="font-size:24px; font-family:'微软雅黑', '黑体'; color:rgba(122,122,122,1.00)">没有帐号?</p>
            </div>
            <div class="login_button">
                <a href="${pageContext.request.contextPath}/player/register">
                    <p style="font-size:24px; font-family:'微软雅黑', '黑体'; color:rgba(255,255,255,1.00)">注册</p>
                </a>
            </div>
        </div>
    </div>

</div>
</body>
</html>
