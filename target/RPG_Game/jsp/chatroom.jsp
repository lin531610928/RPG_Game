<%--
  Created by IntelliJ IDEA.
  User: 1234561
  Date: 2018/3/25
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>聊天室</title>
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
                <h1 class="whiteChar">聊天室</h1>
                <p class="whiteChar"></p>
            </div>
        </div>
    </div>
</section>
<section>
    <div class="col-sm-12">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <textarea rows="20" class="form-control" readonly id="chatroom"></textarea>
            <br>
            <form class="form-search row">
                <div class="col-sm-11">
                <input type="text" class="input-medium search-query form-control" name="chatmessage" placeholder="请输入信息" id="chatmess">
                </div>
                <div class="col-sm-1">
                <button type="submit" class="btn-sm btn-success" id="button_ok">发送</button>
                </div>
            </form>
        </div>
        <div class="col-sm-3"></div>
    </div>
</section>
</body>
<script src="<%= request.getContextPath() %>/jsp/js/chatRoom.js"></script>
</html>
