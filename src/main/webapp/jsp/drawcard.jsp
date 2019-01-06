<%--
  Created by IntelliJ IDEA.
  User: 1234561
  Date: 2018/3/16
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>抽卡</title>
    <link href="<%= request.getContextPath() %>/jsp/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="<%= request.getContextPath() %>/jsp/css/index-main.css" rel="stylesheet" type="text/css">
    <link href="<%= request.getContextPath() %>/jsp/css/drawCard-main.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/csS" href="<%= request.getContextPath() %>/jsp/css/mTips.css">
    <script src="<%= request.getContextPath() %>/jsp/js/jquery-3.2.1.min.js"></script>
    <script src="<%= request.getContextPath() %>/jsp/js/jquery.cookie.js"></script>
    <script src="<%= request.getContextPath() %>/jsp/js/UserCookie.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container blackFont">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#myDefaultNavbar1" aria-expanded="false"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">首页</a> </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="myDefaultNavbar1">
            <ul class="nav navbar-nav" id="navUl">

            </ul>
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
                <h1 class="whiteChar">卡牌抽取</h1>
                <p class="whiteChar"></p>
            </div>
        </div>
    </div>
</section>
<section>
    <div class="col-sm-12">
        <div class="col-sm-4 col-sm-offset-4">
            <div class="col-sm-6"><a class="btn btn-primary btn-block whiteChar" href="#" id="oneDraws" onclick="singledraw()">单抽1次(消耗钻石:250)</a> <br> </div>
            <div class="col-sm-6"><a class="btn btn-primary btn-block whiteChar " href="#" id="tenDraws" onclick="tendraw()">10次连抽(消耗钻石:2500)</a> <br> </div>
        </div>
    </div>
    <div class="col-sm-12" id="tenDraw" style="display: none">
        <div class="col-sm-10 cardLine col-lg-offset-12">
            <div class="col-sm-2 whiteBlocks" >
                <div class="little"><img src="cards/1/1-14.png" class="cardImage" id="cardImg01" onMouseOver="throwCard('01')" onMouseOut="divOutDislay()"></div>
            </div>
            <div class="col-sm-2 whiteBlocks" >
                <div class="little"><img src="cards/1/1-13.png" class="cardImage" id="cardImg02" onMouseOver="throwCard('02')" onMouseOut="divOutDislay()"></div>
            </div>
            <div class="col-sm-2 whiteBlocks" >
                <div class="little"><img src="cards/1/1-12.png" class="cardImage" id="cardImg03" onMouseOver="throwCard('03')" onMouseOut="divOutDislay()"> </div>
            </div>
            <div class="col-sm-2 whiteBlocks" >
                <div class="little"><img src="cards/1/1-11.png" class="cardImage" id="cardImg04" onMouseOver="throwCard('04')" onMouseOut="divOutDislay()"></div>
            </div>
            <div class="col-sm-2 whiteBlocks" >
                <div class="little"><img src="cards/1/1-10.png" class="cardImage" id="cardImg05" onMouseOver="throwCard('05')" onMouseOut="divOutDislay()"></div>
            </div>
            <div class="col-sm-1"> </div>
        </div>
        <div class="col-sm-10 col-lg-offset-12 cardLine">
            <div class="col-sm-2 whiteBlocks" >
                <div class="little"><img src="cards/1/1-14.png" class="cardImage" id="cardImg06" onMouseOver="throwCard('06')" onMouseOut="divOutDislay()"></div>
            </div>
            <div class="col-sm-2 whiteBlocks" >
                <div class="little"><img src="cards/1/1-13.png" class="cardImage" id="cardImg07" onMouseOver="throwCard('07')" onMouseOut="divOutDislay()"></div>
            </div>
            <div class="col-sm-2 whiteBlocks" >
                <div class="little"><img src="cards/1/1-12.png" class="cardImage" id="cardImg08" onMouseOver="throwCard('08')" onMouseOut="divOutDislay()"> </div>
            </div>
            <div class="col-sm-2 whiteBlocks" >
                <div class="little"><img src="cards/1/1-11.png" class="cardImage" id="cardImg09" onMouseOver="throwCard('09')" onMouseOut="divOutDislay()"></div>
            </div>
            <div class="col-sm-2 whiteBlocks" >
                <div class="little"><img src="cards/1/1-10.png" class="cardImage" id="cardImg10" onMouseOver="throwCard('10')" onMouseOut="divOutDislay()"></div>
            </div>
            <div class="col-sm-1"> </div>
        </div>
    </div>
    <div class="col-sm-2 col-sm-offset-5 cardLine" id="oneDraw" style="display: none">
        <div class="col-sm-12 whiteBlocks " >
            <div class="little"><img src="cards/1/1-08.png" class="cardImage" id="cardImg11" onMouseOver="throwCard('11')" onMouseOut="divOutDislay()"></div>
        </div>
    </div>
    <!--<img src="" class="cardImage" id="cardImg12" onMouseOver="throwCard('01')" onMouseOut="divOutDislay()">-->
</section>
</body>
<script src="<%= request.getContextPath() %>/jsp/js/mTips.js"></script>
<script src="<%= request.getContextPath() %>/jsp/js/drawCard.js"></script>
<script type="text/javascript">
    function singledraw(){
        $("#tenDraw").hide();
        $("#oneDraw").hide();
        var con = JSON.stringify({"player_id": cookieID});
        $.ajax({
            type:"post",
            dataType: "json",
            contentType: "application/json",
            url:"${pageContext.request.contextPath}/drawcard/singledraw",
            data:con,
            success: function (data) {
                if (data.message == "true") {
                    //-------------插cookie---------------
                    //alert(data.player_id+""+data.player_name);
                    document.getElementById("cardImg11").src = "<%= request.getContextPath() %>/"+data.card_path;
                    $("#oneDraw").show();
                } else if(data.message == "nomoney"){
                    alert("没有足够的水晶");
                }else if(data.message == "noplace"){
                    alert("背包没有足够的空间");
                } else alert("发生错误");
            },
        });
    }
    function tendraw() {
        $("#oneDraw").hide();
        $("#tenDraw").hide();
        var con = JSON.stringify({"player_id": cookieID});
        $.ajax({
            type:"post",
            dataType: "json",
            contentType: "application/json",
            url:"${pageContext.request.contextPath}/drawcard/tendraw",
            data:con,
            success: function (data) {
                if (data[0].message == "true") {
                    //-------------插cookie---------------
                    //alert(data.player_id+""+data.player_name);
                    for(var i = 0;i<9;i++){
                        document.getElementById("cardImg0"+(i+1)).src = "<%= request.getContextPath() %>/"+data[i].card_path;
                    }
                    document.getElementById("cardImg10").src = "<%= request.getContextPath() %>/"+data[9].card_path;
                    $("#tenDraw").show();
                } else if(data[0].message == "nomoney"){
                    alert("没有足够的水晶");
                }else if(data[0].message == "noplace"){
                    alert("背包没有足够的空间");
                } else alert("发生错误");
            },
        });
    }
</script>
</html>
