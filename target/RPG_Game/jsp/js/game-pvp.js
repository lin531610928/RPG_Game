function getContextPath() {
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    return result;
}
var con = JSON.stringify({"player_id": $.cookie('ID')});
$.ajax({
    type:"post",
    dataType: "json",
    contentType: "application/json",
    url:getContextPath()+"/game/pvpplayers",
    data:con,
    success: function (data) {
        if (data[0].message == "true") {
            for(var i = 0;i<data.length;i++){
                $("#players").append("<tr><td>"+data[i].player_name+"</td><td>"+data[i].player_level+"</td><td><button type=\"button\" class=\"btn btn-xs btn-primary\" onclick=\"playerSelect("+data[i].player_id+")\">对决</button></td></tr>");
            }
        }
    },
});
var hp = new Array(5);
var hpnow = new Array(5);
var dhp = new Array(5);
var dhpnow = new Array(5);
var abi = new Array(5);
var dabi = new Array(5);
var skill = new Array(5);
var dskill = new Array(5);
var plevel = 1;
var dplevel = 1;
var abiup = 100;
var dabiup = 100;
var skillup = 100;
var dskillup = 100;
var myVar;
function playerSelect(dplayer_id) {
    $("#backgroundBackPack").hide();
    $("#players_select").hide();
    $("#game_s1").show();
    $("#game_s2").show();
    $("#game_s3").show();
    var con = JSON.stringify({"player_id": $.cookie('ID'),"dplayer_id": dplayer_id});
    $.ajax({
        type:"post",
        dataType: "json",
        contentType: "application/json",
        url:getContextPath()+"/game/pvpgame",
        data:con,
        success: function (data) {
            if (data[0].message == "true") {
                plevel = data[0].player_level;
                dplevel = data[0].dplayer_level;
                for (var i = 0; i < 5; i++) {
                    $("#10" + (i + 1)).attr("src", getContextPath()+"/"+data[i].card_path + "");
                    $("#1" + (i + 1)).attr("src", getContextPath()+"/"+data[i].dcard_path + "");
                    if (data[i].card_rare == "SSR") {
                        hp[i] = 200;
                    } else if (data[i].card_rare == "SR") {
                        hp[i] = 150;
                    } else hp[i] = 100;
                    if (data[i].dcard_rare == "SSR") {
                        dhp[i] = 200;
                    } else if (data[i].dcard_rare == "SR") {
                        dhp[i] = 150;
                    } else dhp[i] = 100;
                    hpnow[i] = hp[i];
                    dhpnow[i] = dhp[i];
                    $("#h10" + (i + 1)).text("hp:" + hpnow[i] + "/" + hp[i]);
                    $("#h1" + (i + 1)).text("hp:" + dhpnow[i] + "/" + dhp[i]);
                    abi[i] = parseInt(data[i].card_ability * plevel / 200) + parseInt(data[i].card_ability);
                    dabi[i] = parseInt(data[i].dcard_ability * dplevel / 200) + parseInt(data[i].dcard_ability);
                    skill[i] = data[i].card_skill_type;
                    if(skill[i] > 200){
                        skillup = skillup + skill[i] - 200;
                    }
                    dskill[i] = data[i].dcard_skill_type;
                    if(dskill[i] > 200){
                        dskillup = dskillup + dskill[i] - 200;
                    }
                }
                for (var i = 0;i < 5;i++){
                    abi[i] = parseInt((abi[i] * skillup)/100);
                    dabi[i] = parseInt((dabi[i] * dskillup)/100);
                }
                myVar = setInterval(function(){ Timer(tt) }, 1000);
            }
        },
    });
}