<%--
  Created by IntelliJ IDEA.
  User: 1234561
  Date: 2018/5/8
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>任务</title>
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
            <h1 class="whiteChar">任务</h1>
            <p class="whiteChar"></p>
        </div>
    </div>
</div>
</section>
<section>
<div class="col-sm-12">
    <div class="col-sm-3">
    </div>
    <div class="col-sm-6">
        <div class="row">
        <div class="table-responsive">
            <table class="table table-striped text-center">
                <thread>
                    <tr>
                        <th class="col-sm-4 text-center">
                            任务
                        </th>
                        <th class="col-sm-4 text-center">
                            任务奖励
                        </th>
                        <th class="col-sm-2 text-center">
                            完成情况
                        </th>
                        <th class="col-sm-2 text-center">

                        </th>
                    </tr>
                </thread>
                <tbody id="mission">
                </tbody>
            </table>
        </div>
        </div>
    </div>
    <div class="col-sm-3">
    </div>
</div>
</section>
<script src="<%= request.getContextPath() %>/jsp/js/task.js"></script>
</body>
</html>
