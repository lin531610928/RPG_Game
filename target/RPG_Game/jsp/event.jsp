<%--
  Created by IntelliJ IDEA.
  User: 1234561
  Date: 2018/5/8
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>活动</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/jsp/css/bootstrap.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/jsp/css/index-main.css">
    <link href="<%= request.getContextPath() %>/jsp/css/drawCard-main.css" rel="stylesheet" type="text/css">
    <script src="<%= request.getContextPath() %>/jsp/js/jquery-3.2.1.min.js"></script>
    <script src="<%= request.getContextPath() %>/jsp/js/jquery.cookie.js"></script>
    <script src="<%= request.getContextPath() %>/jsp/js/UserCookie.js"></script>
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
    <div class="jumbotron text-center" id="backgroundDrawCard" >
        <div class="infomationDrawCard row">
            <div class="col-sm-12">
                <h1 class="whiteChar">活动</h1>
                <p class="whiteChar"></p>
            </div>
        </div>
    </div>
</section>
<section>
    <div class="col-sm-12">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-sm-7">
            <h2 class="featurette-heading"> <span class="text-muted">限时活动</span></h2>
            <p class="lead">限时活动仅在每周六、日开放。</p>
            <p class="lead">限时活动难度较高，建议20级以上尝试，并准备好高练度的队伍。</p>
            <p class="lead">玩家通关限时活动后，可获得丰富奖励。</p>
        </div>
        <div class="col-sm-5">
            <img class="featurette-image img-responsive center-block" src="<%= request.getContextPath() %>/jsp/cards/npc/E_DevilBoss.png">
        </div>
    </div>

    <hr class="featurette-divider">
            <div class="row">
                <div class="col-sm-4"></div>
                <div class="col-sm-4">
                    <a class="btn btn-primary btn-block littleButton" style="display: none" href="${pageContext.request.contextPath}/eventgame" id="littleButton1">活动尚未开放</a>
                </div>
                <div class="col-sm-4"></div>
            </div>
        </div>
        <div class="col-sm-3"></div>
    </div>
</section>
<script src="<%= request.getContextPath() %>/jsp/js/event.js"></script>
</body>
</html>
