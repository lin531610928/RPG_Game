function getContextPath() {
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    return result;
}
var gamedifficulty = 4;
var friendh=1;
var con = JSON.stringify({"player_id": $.cookie('ID')});
$.ajax({
    type:"post",
    dataType: "json",
    contentType: "application/json",
    url:getContextPath()+"/game/selectfriend",
    data:con,
    success: function (data) {
        if (data[0].message == "true") {
            $("#friend_select").show();
            for(var i = 0;i<data.length;i++){
                $("#players").append("<tr><td>"+data[i].player_name+"</td><td>"+data[i].player_level+"</td><td>全队能力"+data[i].player_level/2+"%UP</td><td><button type=\"button\" class=\"btn btn-xs btn-primary\" onclick=\"friendSelect("+data[i].player_level+")\">选择</button></td></tr>");
            }
        }
        else if(data[0].message == "no"){
            friendh = 0;
            game_select(gamedifficulty);
            $("#game_s1").show();
            //$("#game_s2").show();
            $("#game_s3").show();
        }
    },
});
var fplevel = 1;
function friendSelect(x) {
    $("#friend_select").hide();
    fplevel = x;
    game_select(gamedifficulty);
    $("#game_s1").show();
    //$("#game_s2").show();
    $("#game_s3").show();
}
var hp = new Array(5);
var hpnow = new Array(5);
var dhp = new Array(5);
var dhpnow = new Array(5);
var abi = new Array(5);
var dabi = new Array(5);
var dabib = new Array(5);
var skill = new Array(5);
var dexp = new Array(5);
var plevel = 1;
var abiup = 100;
var skillup = 100;
var myVar;
function game_select(x) {
    var con = JSON.stringify({"player_id": $.cookie('ID'), "message": x});
    $.ajax({
        type: "post",
        dataType: "json",
        contentType: "application/json",
        url: getContextPath() + "/eventgame/start",
        data: con,
        success: function (data) {
            if (data[0].message == "true") {
                plevel = data[0].player_level;
                for (var i = 0; i < 5; i++) {
                    $("#10" + (i + 1)).attr("src", data[i].card_path + "");
                    $("#1" + (i + 1)).attr("src", data[i].npc_path + "");
                    if (data[i].card_rare == "SSR") {
                        hp[i] = 200;
                    } else if (data[i].card_rare == "SR") {
                        hp[i] = 150;
                    } else hp[i] = 100;
                    hpnow[i] = hp[i];
                    $("#h10" + (i + 1)).text("hp:" + hpnow[i] + "/" + hp[i]);
                    dhp[i] = data[i].npc_hp;
                    dhpnow[i] = dhp[i];
                    $("#h1" + (i + 1)).text("hp:" + dhpnow[i] + "/" + dhp[i]);
                    abi[i] = parseInt(data[i].card_ability * plevel / 200) +parseInt(data[i].card_ability * fplevel / 200) + parseInt(data[i].card_ability);
                    dabi[i] = data[i].npc_ability;
                    dabib[i] = data[i].npc_ability_d;
                    skill[i] = data[i].card_skill_type;
                    if(skill[i] > 200){
                        skillup = skillup + skill[i] - 200;
                    }
                    dexp[i] = data[i].npc_dropexp;
                }
                for (var i = 0;i < 5;i++){
                    abi[i] = parseInt((abi[i] * skillup)/100);
                }
                myVar = setInterval(function(){ Timer(tt) }, 1000);
            }
            else if (data[0].message == "no") {
                alert("请先组好5人队");
                window.location.href = getContextPath() + '/';
            }
            else {
                alert("活动尚未开放");
                window.location.href = getContextPath() + '/';
            }
        },
    });
}