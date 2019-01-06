<%--
  Created by IntelliJ IDEA.
  User: 1234561
  Date: 2018/3/17
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>背包</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/jsp/css/bootstrap.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/jsp/css/index-main.css">
    <link href="<%= request.getContextPath() %>/jsp/css/drawCard-main.css" rel="stylesheet" type="text/css">
    <link href="<%= request.getContextPath() %>/jsp/css/backPack.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/csS" href="<%= request.getContextPath() %>/jsp/css/mTips.css">
    <script src="<%= request.getContextPath() %>/jsp/js/jquery-3.2.1.min.js"></script>
    <script src="<%= request.getContextPath() %>/jsp/js/bootstrap.js"></script>
    <script src="<%= request.getContextPath() %>/jsp/js/jquery.cookie.js"></script>
    <script src="<%= request.getContextPath() %>/jsp/js/UserCookie.js"></script>
    <script src="<%= request.getContextPath() %>/jsp/js/mTips.js"></script>
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
<div class="jumbotron text-center" id="backgroundBackPack" >
    <div class="infomationDrawCard row">
        <div class="col-sm-12">
            <h1 class="whiteChar">卡牌管理</h1>
            <p class="whiteChar"></p>
        </div>
    </div>
</div>
<section>
    <div class="col-sm-12">
        <div class="col-sm-12 text-center">
            <h1 class="blackFont">队伍</h1>
        </div>
        <div class="col-sm-1"></div>
        <div class="col-sm-2 littlePack" id="teamImgDiv105"><img src="<%= request.getContextPath() %>/jsp/img/empty.png" class="Team" id="105" onMouseOver="teamThrowCard('5')" onMouseOut="divOutDislay()"></div>
        <div class="col-sm-2 littlePack" id="teamImgDiv104"><img src="<%= request.getContextPath() %>/jsp/img/empty.png" class="Team" id="104" onMouseOver="teamThrowCard('4')" onMouseOut="divOutDislay()"></div>
        <div class="col-sm-2 littlePack" id="teamImgDiv103"><img src="<%= request.getContextPath() %>/jsp/img/empty.png" class="Team" id="103" onMouseOver="teamThrowCard('3')" onMouseOut="divOutDislay()"></div>
        <div class="col-sm-2 littlePack" id="teamImgDiv102"><img src="<%= request.getContextPath() %>/jsp/img/empty.png" class="Team" id="102" onMouseOver="teamThrowCard('2')" onMouseOut="divOutDislay()"></div>
        <div class="col-sm-2 littlePack" id="teamImgDiv101"><img src="<%= request.getContextPath() %>/jsp/img/empty.png" class="Team" id="101" onMouseOver="teamThrowCard('1')" onMouseOut="divOutDislay()"></div>
        <div class="col-sm-1"></div>
    </div>
</section>
<section>
    <div class="col-sm-12 text-center" style="margin-top: 3%">
        <h1 class="blackFont">背包</h1>
    </div>
    <div class="col-sm-12 grayDiv" id="backpack">
    </div>
</section>
<div class="col-sm-12">
    <a class="btn btn-primary btn-block whiteChar deleteButton" href="#" onclick="deletecards()" id="deleteButton">删除</a>
</div>
<div class="col-sm-12" id="cardup">
    <p id="expnow" class="text-center col-sm-12">经验瓶：</p>
    <div class="col-sm-12">
        <div class="col-sm-5"></div>
        <div class="col-sm-2">
            <input type="text" id="expnum" placeholder="请输入要使用的经验瓶数量" onkeyup="NumberCheck(this)" class="col-sm-12">
        </div>
        <div class="col-sm-5"></div>
    </div>
    <div class="col-sm-12">
    <a class="btn btn-primary btn-block whiteChar deleteButton" onclick="cardUp()" id="cardupok">升级</a>
    </div>
</div>
</body>
<script src="<%= request.getContextPath() %>/jsp/js/backpack.js"></script>
</html>
