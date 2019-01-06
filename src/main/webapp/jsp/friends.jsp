<%--
  Created by IntelliJ IDEA.
  User: 1234561
  Date: 2018/3/24
  Time: 1:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>好友</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/jsp/css/bootstrap.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/jsp/css/index-main.css">
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
<div class="col-sm-12">
    <p class="whiteChar"></p>
</div>
<section>
    <div class="row">
        <div class="col-sm-12">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="btn-group col-sm-12" data-toggle="buttons">
                    <button id="b01" onclick="searchpl()" class="col-sm-3 btn btn-primary">搜索好友</button>
                    <button id="b02" onclick="waitFriends()" class="col-sm-3 btn btn-primary">待对方接受</button>
                    <button id="b03" onclick="waitMe()" class="col-sm-3 btn btn-primary">待确认</button>
                    <button id="b04" onclick="friendsList()" class="col-sm-3 btn btn-primary">好友列表</button>
                </div>
            </div>
            <div class="col-sm-3"></div>
        </div>
    </div>
</section>
<div class="col-sm-12">
    <p class="whiteChar"></p>
</div>
<section>
    <div id="searchp" class="row" style="display: none">
        <div class="col-sm-12">
            <div class="col-sm-4"></div>
            <div class="col-sm-5 form-search">
                <input type="text" name="name" placeholder="用户名" style="height:30px; width:77%" id="user" class="col-sm-11 input-medium search-query form-control" />
                <button id="button_ok" class="col-sm-1 btn-sm btn-success">搜索</button>
            </div>
            <div class="col-sm-3"></div>
        </div>
        <div class="col-sm-12">
            <p class="whiteChar"></p>
        </div>
        <div class="col-sm-12">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="row">
                    <div class="table-responsive">
                        <table class="table table-striped text-center" id="search1">
                            <thread>
                                <tr>
                                    <th class="col-sm-5 text-center">
                                        用户名
                                    </th>
                                    <th class="col-sm-5 text-center">
                                        等级
                                    </th>
                                    <th class="col-sm-2 text-center">

                                    </th>
                                </tr>
                            </thread>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-sm-3"></div>
        </div>
</div>
</section>
<section>
    <div id="waitf" class="row" style="display: none">
        <div class="col-sm-12">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="row">
                    <div class="table-responsive">
                        <table class="table table-striped text-center" id="waitf1">
                            <thread>
                                <tr>
                                    <th class="col-sm-5 text-center">
                                        用户名
                                    </th>
                                    <th class="col-sm-5 text-center">
                                        等级
                                    </th>
                                    <th class="col-sm-2 text-center">

                                    </th>
                                </tr>
                            </thread>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-sm-3"></div>
        </div>
    </div>
</section>
<section>
    <div id="waitm" class="row" style="display: none">
        <div class="col-sm-12">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="row">
                    <div class="table-responsive">
                        <table class="table table-striped text-center" id="waitm1">
                            <thread>
                                <tr>
                                    <th class="col-sm-4 text-center">
                                        用户名
                                    </th>
                                    <th class="col-sm-4 text-center">
                                        等级
                                    </th>
                                    <th class="col-sm-2 text-center">

                                    </th>
                                    <th class="col-sm-2 text-center">

                                    </th>
                                </tr>
                            </thread>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-sm-3"></div>
        </div>
    </div>
</section>
<section>
    <div id="friendslist" class="row" style="display: none">
        <div class="col-sm-12">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="row">
                    <div class="table-responsive">
                        <table class="table table-striped text-center" id="friendslist1">
                            <thread>
                                <tr>
                                    <th class="col-sm-5 text-center">
                                        用户名
                                    </th>
                                    <th class="col-sm-5 text-center">
                                        等级
                                    </th>
                                    <th class="col-sm-2 text-center">

                                    </th>
                                </tr>
                            </thread>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-sm-3"></div>
        </div>
    </div>
</section>
</body>
<script type="text/javascript">
    $(document).ready(function() {
        $("#button_ok").click(function searchPlayers() {
            $(".searchr1").remove();
            var name = $("#user").val();
            var con = JSON.stringify({"player_id": cookieID,"player_name": name});
            $.ajax({
                type:"post",
                dataType: "json",
                contentType: "application/json",
                url:"${pageContext.request.contextPath}/friends/searchplayers",
                data:con,
                success: function (data) {
                    if (data[0].message == "true") {
                        //alert(data[0].player_name);
                        for(var i = 0;i<data.length;i++){
                            $("#search1").append("<tr class=\"searchr1\"><td>"+data[i].player_name+"</td><td>"+data[i].player_level+"</td><td><button onclick=\"addFriend("+parseInt(data[i].player_id)+")\">添加</button></td></tr>");
                        }
                    }else {
                        alert("未搜到用户");
                    }
                },
            });
        });
    });
    function addFriend(pid) {
        var con = JSON.stringify({"player_id": cookieID,"friend_id": pid});
        $.ajax({
            type:"post",
            dataType: "json",
            contentType: "application/json",
            url:"${pageContext.request.contextPath}/friends/addfriend",
            data:con,
            success: function (data) {
                $(".searchr1").remove();
                alert("添加成功");
            },
        });
    }
    function searchpl() {
        $("#searchp").show();
        $(".searchr1").remove();
        $("#waitf").hide();
        $(".waitfr1").remove();
        $("#waitm").hide();
        $(".waitme1").remove();
        $("#friendslist").hide();
        $(".friendsl1").remove();
    }
    function waitFriends() {
        $("#searchp").hide();
        $(".searchr1").remove();
        $("#waitf").show();
        $(".waitfr1").remove();
        $("#waitm").hide();
        $(".waitme1").remove();
        $("#friendslist").hide();
        $(".friendsl1").remove();
        var con = JSON.stringify({"player_id": cookieID});
        $.ajax({
            type:"post",
            dataType: "json",
            contentType: "application/json",
            url:"${pageContext.request.contextPath}/friends/waitfriends",
            data:con,
            success: function (data) {
                if (data[0].message == "true") {
                    //alert(data[0].player_name);
                    for(var i = 0;i<data.length;i++){
                        $("#waitf1").append("<tr class=\"waitfr1\"><td>"+data[i].player_name+"</td><td>"+data[i].player_level+"</td><td><button onclick=\"deleteWait("+parseInt(data[i].player_id)+")\">取消</button></td></tr>");
                    }
                }
            },
        });
    }
    function deleteWait(fid) {
        var con = JSON.stringify({"player_id": cookieID,"friend_id": fid});
        $.ajax({
            type:"post",
            dataType: "json",
            contentType: "application/json",
            url:"${pageContext.request.contextPath}/friends/deletewait",
            data:con,
            success: function (data) {
                if (data.message == "true") {
                    $(".waitfr1").remove();
                    $("#waitf").hide();
                    alert("取消成功");
                }else alert("操作失败");
            },
        });
    }
    function waitMe() {
        $("#searchp").hide();
        $(".searchr1").remove();
        $("#waitf").hide();
        $(".waitfr1").remove();
        $("#waitm").show();
        $(".waitme1").remove();
        $("#friendslist").hide();
        $(".friendsl1").remove();
        var con = JSON.stringify({"player_id": cookieID});
        $.ajax({
            type:"post",
            dataType: "json",
            contentType: "application/json",
            url:"${pageContext.request.contextPath}/friends/waitme",
            data:con,
            success: function (data) {
                if (data[0].message == "true") {
                    //alert(data[0].player_name);
                    for(var i = 0;i<data.length;i++){
                        $("#waitm1").append("<tr class=\"waitme1\"><td>"+data[i].player_name+"</td><td>"+data[i].player_level+"</td><td><button onclick=\"agreeFriend("+parseInt(data[i].friend_id)+")\">同意</button></td><td><button onclick=\"deleteWait2("+parseInt(data[i].friend_id)+")\">拒绝</button></td></tr>");
                    }
                }
            },
        });
    }
    function deleteWait2(fid) {
        var con = JSON.stringify({"player_id": fid,"friend_id": cookieID});
        $.ajax({
            type:"post",
            dataType: "json",
            contentType: "application/json",
            url:"${pageContext.request.contextPath}/friends/deletewait",
            data:con,
            success: function (data) {
                if (data.message == "true") {
                    $(".waitme1").remove();
                    $("#waitm").hide();
                    alert("取消成功");
                }else alert("操作失败");
            },
        });
    }
    function agreeFriend(fid) {
        var con = JSON.stringify({"player_id": cookieID,"friend_id": fid});
        $.ajax({
            type:"post",
            dataType: "json",
            contentType: "application/json",
            url:"${pageContext.request.contextPath}/friends/agreefriend",
            data:con,
            success: function (data) {
                if (data.message == "true") {
                    $(".waitme1").remove();
                    $("#waitm").hide();
                    alert("添加成功");
                }else alert("操作失败");
            },
        });
    }
    function friendsList() {
        $("#searchp").hide();
        $(".searchr1").remove();
        $("#waitf").hide();
        $(".waitfr1").remove();
        $("#waitm").hide();
        $(".waitme1").remove();
        $("#friendslist").show();
        $(".friendsl1").remove();
        var con = JSON.stringify({"player_id": cookieID});
        $.ajax({
            type:"post",
            dataType: "json",
            contentType: "application/json",
            url:"${pageContext.request.contextPath}/friends/myfriends",
            data:con,
            success: function (data) {
                if (data[0].message == "true") {
                    //alert(data[0].player_name);
                    for(var i = 0;i<data.length;i++){
                        $("#friendslist1").append("<tr class=\"friendsl1\"><td>"+data[i].player_name+"</td><td>"+data[i].player_level+"</td><td><button onclick=\"deleteFriend("+parseInt(data[i].friend_id)+")\">删除</button></td></tr>");
                    }
                }
            },
        });
    }
    function deleteFriend(fid) {
        var con = JSON.stringify({"player_id": cookieID,"friend_id": fid});
        $.ajax({
            type:"post",
            dataType: "json",
            contentType: "application/json",
            url:"${pageContext.request.contextPath}/friends/deletefriend",
            data:con,
            success: function (data) {
                if (data.message == "true") {
                    $(".friendsl1").remove();
                    $("#friendslist").hide();
                    alert("删除成功");
                }else alert("操作失败");
            },
        });
    }
</script>
</html>