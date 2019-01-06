function getContextPath() {
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    return result;
}
var cookieID=$.cookie('ID');
var cookieName=$.cookie('name');
var cookiePassword=$.cookie('password');
var myVar;
if(cookieID==""||cookieID==null||cookieName==""||cookieName==null||cookiePassword==""||cookiePassword==null){
    $("#loginRegister").show();
    window.location.href= getContextPath()+'/player/login';
}else {
    var con = JSON.stringify({"player_name": cookieName, "player_password": cookiePassword});
    $.ajax({
        type: "post",
        dataType: "json",
        contentType: "application/json",
        url: getContextPath() + "/player/login",
        data: con,
        success: function (data) {
            if (data.message == "true") {
                //-------------插cookie---------------
                //alert(data.player_id+""+data.player_name);
                var info = "<p style=\" float:right; margin-top:5px \">用户名： " + cookieName + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbspLV："+data.player_level+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp经验值："+data.player_exp+"/"+data.player_needexp+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp水晶数："+data.player_money+"<a class=\"btn btn-primary \" role=\"button\" onClick=\"Logout()\" style=\" font-size:14px;float:right;	margin-left:15px;margin-bottom:0px \">注销</a></p>";
                $(".searchA").hide();
                $("#loginRegister").hide();
                $(".littleButton").show();
                $("#searchArea").append(info);
                myVar = setInterval(function(){ Timer() }, 1000);
            } else {
                alert("请重新登陆");
                window.location.href = getContextPath() + '/player/login';
            }
        },
    })
}
function Logout() {
    window.clearInterval(myVar);
    $.cookie('ID', null);
    $.cookie('name', null);
    $.cookie('password', null);
    window.location.href = getContextPath() + '/player/login';
}
function Timer() {
    var con = JSON.stringify({"player_name": cookieName, "player_password": cookiePassword});
    $.ajax({
        type: "post",
        dataType: "json",
        contentType: "application/json",
        url: getContextPath() + "/player/login",
        data: con,
        success: function (data) {
            if (data.message == "true") {
                //-------------插cookie---------------
                //alert(data.player_id+""+data.player_name);
                var info = "<p style=\" float:right; margin-top:5px \">用户名： " + cookieName + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbspLV："+data.player_level+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp经验值："+data.player_exp+"/"+data.player_needexp+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp水晶数："+data.player_money+"<a class=\"btn btn-primary \"  role=\"button\" onClick=\"Logout()\" style=\" font-size:14px;float:right;	margin-left:15px;margin-bottom:0px \">注销</a></p>";
                $("#searchArea").html(info);
            } else {
                alert("请重新登陆");
                window.location.href = getContextPath() + '/player/login';
            }
        },
    })
}