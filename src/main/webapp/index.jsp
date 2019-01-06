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
    <meta charset="utf-8">
    <title>RPG_Game</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/jsp/css/bootstrap.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/jsp/css/index-main.css">
    <script src="<%= request.getContextPath() %>/jsp/js/jquery-3.2.1.min.js"></script>
    <script src="<%= request.getContextPath() %>/jsp/js/jquery.cookie.js"></script>
    <script src="<%= request.getContextPath() %>/jsp/js/UserCookie.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){

        })
    </script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#myDefaultNavbar1" aria-expanded="false"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">首页</a> </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="myDefaultNavbar1">
            <div id="searchArea"></div>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
<section>
    <div class="jumbotron text-center" id="background" >
        <div class="container " id="hBox">
            <div class="infomation row">
                <div class="col-sm-12">
                    <h1 class="whiteChar">RPG Game</h1>
                    <p class="whiteChar">欢迎来到RPG Game</p>
                    <p class="whiteChar" id="loginRegister" style="display: none"><a class="btn btn-primary btn-lg link" href="/player/login" role="button"> 登陆 »</a><a class="btn btn-primary btn-lg link" href="/player/register" role="button">注册 »</a></p>
                </div>
            </div>
        </div>
    </div>
</section>
<hr>
<section>
    <div class="col-sm-12">
        <div class="col-lg-9 col-lg-offset-15">
            <div class="col-sm-4">
                <div class="little"> <img src="<%= request.getContextPath() %>/jsp/img/icon_card.svg" alt="Card" class="tile-image">
                    <h2 class="tile-title">卡牌管理</h2>
                    <p class="blackFont">管理你的私人卡牌</p>
                    <a class="btn btn-primary btn-block littleButton" href="${pageContext.request.contextPath}/backpack" id="littleButton1">进入页面</a> <br>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="little"> <img src="<%= request.getContextPath() %>/jsp/img/icon_play.png" alt="Card" class="tile-image">
                    <h2 class="tile-title">开始游戏</h2>
                    <p class="blackFont">开始点击游戏</p>
                    <a class="btn btn-primary btn-block littleButton" href="${pageContext.request.contextPath}/game" id="littleButton2">进入页面</a> <br>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="little"> <img src="<%= request.getContextPath() %>/jsp/img/icon_drawcard.png" alt="Card" class="tile-image">
                    <h2 class="tile-title">卡牌抽取</h2>
                    <p class="blackFont">从卡池获得新的卡牌</p>
                    <a class="btn btn-primary btn-block littleButton" href="${pageContext.request.contextPath}/drawcard" id="littleButton5">进入页面</a> <br>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-12">
        <p class="whiteChar"></p>
    </div>
    <div class="col-sm-12">
        <div class="col-lg-9 col-lg-offset-15">
            <div class="col-sm-4">
                <div class="little"> <img src="<%= request.getContextPath() %>/jsp/img/font-368.png" alt="Card" class="tile-image">
                    <h2 class="tile-title">好友管理</h2>
                    <p class="blackFont">管理你的好友</p>
                    <a class="btn btn-primary btn-block littleButton" href="${pageContext.request.contextPath}/friends" id="littleButton10">进入页面</a> <br>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="little"> <img src="<%= request.getContextPath() %>/jsp/img/gift.png" alt="Card" class="tile-image">
                    <h2 class="tile-title">每日签到</h2>
                    <p class="blackFont">每日0点更新</p>
                    <a type="submit" onclick="signinOk()" class="btn btn-primary btn-block littleButton" id="signIn">签到<br></a> <br>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="little"> <img src="<%= request.getContextPath() %>/jsp/img/bubbles-alt-icon.png" alt="Card" class="tile-image">
                    <h2 class="tile-title">聊天室</h2>
                    <p class="blackFont">与其他玩家进行交流</p>
                    <a class="btn btn-primary btn-block littleButton" href="${pageContext.request.contextPath}/chatroom" id="littleButton12">进入页面</a> <br>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-12">
        <p class="whiteChar"></p>
    </div>
    <div class="col-sm-12">
        <div class="col-lg-9 col-lg-offset-15">
            <div class="col-sm-4">
                <div class="little"> <img src="<%= request.getContextPath() %>/jsp/img/tasks.png" alt="Card" class="tile-image">
                    <h2 class="tile-title">任务管理</h2>
                    <p class="blackFont">管理你的任务</p>
                    <a class="btn btn-primary btn-block littleButton" href="${pageContext.request.contextPath}/task" id="littleButton13">进入页面</a> <br>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="little"> <img src="<%= request.getContextPath() %>/jsp/img/colosseum.png" alt="Card" class="tile-image">
                    <h2 class="tile-title">竞技场</h2>
                    <p class="blackFont">与其他玩家进行切磋</p>
                    <a class="btn btn-primary btn-block littleButton" href="${pageContext.request.contextPath}/game/pvp" id="littleButton14">进入页面</a> <br>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="little"> <img src="<%= request.getContextPath() %>/jsp/img/internet_e.png" alt="Card" class="tile-image">
                    <h2 class="tile-title">活动</h2>
                    <p class="blackFont">参加限时活动</p>
                    <a class="btn btn-primary btn-block littleButton" href="${pageContext.request.contextPath}/event" id="littleButton15">进入页面</a> <br>
                </div>
            </div>
        </div>
    </div>
</section>
<div class="container">
    <div class="row">
    </div>
</div>
<hr>
<div class="section well">
    <div class="container">
        <div class="row">
            <div class="col-sm-4 col-sm-4 blackFont">
                <h3 class="text-center">这是一个什么样的游戏？</h3>
                <h5>这是一个RPG卡牌游戏，您可以通过培养自己的卡牌角色，并通过提升自己的等级来击败对手。<br>如果您觉得自己的卡牌强度不足的话还可以在抽取页面抽取新的卡牌以供使用。</h5>
            </div>
            <div class="col-sm-4 col-sm-4 blackFont">
                <h3 class="text-center">网页作者</h3>
                <address class="text-center">
                    <strong>李梓林</strong>  20145901<br>
                    计算机科学与技术·中加1班
                </address>
            </div>
            <div class="col-sm-4 col-sm-4 blackFont">
            </div>
        </div>
    </div>
</div>
<footer class="text-center">
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <p>Copyright © MyCompany. All rights reserved.</p>
            </div>
        </div>
    </div>
</footer>
</body>
<script type="text/javascript">
    var con = JSON.stringify({"player_id": cookieID});
    $.ajax({
        type:"post",
        dataType: "json",
        contentType: "application/json",
        url:"${pageContext.request.contextPath}/signin/can",
        data:con,
        success: function (data) {
            if (data.message == "false") {
                $("#signIn").removeAttr("onclick");
                $("#signIn").text("已签到");
            }
        },
    });
    function signinOk(){
        $("#signIn").removeAttr("onclick");
        var con = JSON.stringify({"player_id": cookieID});
        $.ajax({
            type:"post",
            dataType: "json",
            contentType: "application/json",
            url:"${pageContext.request.contextPath}/signin/day",
            data:con,
            success: function (data) {
                if (data.message == "true") {
                    $("#signIn").text("已签到");
                    alert("签到成功\n获得100经验+一个经验瓶");
                } else alert("签到失败");
            },
        });
    }
</script>
</html>
