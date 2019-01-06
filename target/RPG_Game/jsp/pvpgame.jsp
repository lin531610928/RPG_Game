<%--
  Created by IntelliJ IDEA.
  User: 1234561
  Date: 2018/5/8
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>竞技场</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/jsp/css/bootstrap.css">
    <link href="<%= request.getContextPath() %>/jsp/css/index-main.css" rel="stylesheet" type="text/css">
    <link href="<%= request.getContextPath() %>/jsp/css/drawCard-main.css" rel="stylesheet" type="text/css">
    <script src="<%= request.getContextPath() %>/jsp/js/jquery-3.2.1.min.js"></script>
    <script src="<%= request.getContextPath() %>/jsp/js/jquery.cookie.js"></script>
</head>
<body>
<section>
    <div class="jumbotron text-center" id="backgroundDrawCard" >
        <div class="row">
            <div class="col-sm-12">
                <h1 class="whiteChar">请选择对手</h1>
                <p class="whiteChar"></p>
            </div>
        </div>
    </div>
    <div class="col-sm-12" id="players_select">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div class="row">
                <div class="table-responsive">
                    <table class="table table-striped text-center">
                        <thread>
                            <tr>
                                <th class="col-sm-4 text-center">
                                    玩家
                                </th>
                                <th class="col-sm-4 text-center">
                                    等级
                                </th>
                                <th class="col-sm-4 text-center">
                                </th>
                            </tr>
                        </thread>
                        <tbody id="players">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-sm-3"></div>
    </div>
</section>
<section>
    <div class="col-sm-12" id="game_s1" style="display: none">
        <div class="col-sm-12 text-center">
            <h1 class="blackFont">己方队伍</h1>
        </div>
        <div class="col-sm-1"></div>
        <div class="col-sm-2 littlePack" id="teamImgDiv105"><img src="<%= request.getContextPath() %>/jsp/img/empty.png" class="img-responsive center-block" id="105" onMouseOver="teamThrowCard('5')" onMouseOut="divOutDislay()"><p id="h105">hp:100/100</p></div>
        <div class="col-sm-2 littlePack" id="teamImgDiv104"><img src="<%= request.getContextPath() %>/jsp/img/empty.png" class="img-responsive center-block" id="104" onMouseOver="teamThrowCard('4')" onMouseOut="divOutDislay()"><p id="h104">hp:100/100</p></div>
        <div class="col-sm-2 littlePack" id="teamImgDiv103"><img src="<%= request.getContextPath() %>/jsp/img/empty.png" class="img-responsive center-block" id="103" onMouseOver="teamThrowCard('3')" onMouseOut="divOutDislay()"><p id="h103">hp:100/100</p></div>
        <div class="col-sm-2 littlePack" id="teamImgDiv102"><img src="<%= request.getContextPath() %>/jsp/img/empty.png" class="img-responsive center-block" id="102" onMouseOver="teamThrowCard('2')" onMouseOut="divOutDislay()"><p id="h102">hp:100/100</p></div>
        <div class="col-sm-2 littlePack" id="teamImgDiv101"><img src="<%= request.getContextPath() %>/jsp/img/empty.png" class="img-responsive center-block" id="101" onMouseOver="teamThrowCard('1')" onMouseOut="divOutDislay()"><p id="h101">hp:100/100</p></div>
        <div class="col-sm-1"></div>
    </div>
</section>
<section>
    <div class="col-sm-12" id="game_s2">
        <div class="col-sm-1"></div>
        <div class="col-sm-10" id="canvas-container" style="padding: 0; margin: 0; height: 200px;">
            <canvas id="c" style="border:1px solid #FFFFFF;">
                Sorry. your browser not support canvas.
            </canvas>
        </div>
        <div class="col-sm-1"></div>
    </div>
</section>
<section>
    <div class="col-sm-12" id="game_s3" style="display: none">
        <div class="col-sm-1"></div>
        <div class="col-sm-2 littlePack" id="teamImgDiv15"><img src="<%= request.getContextPath() %>/jsp/img/empty.png" class="img-responsive center-block" id="15" onMouseOver="teamThrowCard('5')" onMouseOut="divOutDislay()"><p id="h15">hp:100/100</p></div>
        <div class="col-sm-2 littlePack" id="teamImgDiv14"><img src="<%= request.getContextPath() %>/jsp/img/empty.png" class="img-responsive center-block" id="14" onMouseOver="teamThrowCard('4')" onMouseOut="divOutDislay()"><p id="h14">hp:100/100</p></div>
        <div class="col-sm-2 littlePack" id="teamImgDiv13"><img src="<%= request.getContextPath() %>/jsp/img/empty.png" class="img-responsive center-block" id="13" onMouseOver="teamThrowCard('3')" onMouseOut="divOutDislay()"><p id="h13">hp:100/100</p></div>
        <div class="col-sm-2 littlePack" id="teamImgDiv12"><img src="<%= request.getContextPath() %>/jsp/img/empty.png" class="img-responsive center-block" id="12" onMouseOver="teamThrowCard('2')" onMouseOut="divOutDislay()"><p id="h12">hp:100/100</p></div>
        <div class="col-sm-2 littlePack" id="teamImgDiv11"><img src="<%= request.getContextPath() %>/jsp/img/empty.png" class="img-responsive center-block" id="11" onMouseOver="teamThrowCard('1')" onMouseOut="divOutDislay()"><p id="h11">hp:100/100</p></div>
        <div class="col-sm-1"></div>
        <div class="col-sm-12 text-center">
            <h1 class="blackFont">敌方队伍</h1>
        </div>
    </div>
</section>
<script src="<%= request.getContextPath() %>/jsp/js/game-pvp.js"></script>
<script src="<%= request.getContextPath() %>/jsp/js/canvas-atuo.js"></script>
<script src="<%= request.getContextPath() %>/jsp/js/battle_effect.js"></script>
<script src="<%= request.getContextPath() %>/jsp/js/battle-pvp.js"></script>
</body>
</html>
