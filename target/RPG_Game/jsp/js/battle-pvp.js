function Roll(m) {
    return parseInt(Math.random()*(m+1),10);
}
function Roll2() {
    return parseInt(Math.random()*(1000+1),10);
}

var tt=5;
var dtt=5;
var lun=1;
var ti=0;
var mlnum = 5;
var dlnum = 5;
var a1;
var damage;
var myVar2;
function Timer(cw) {
    ti++;
    if(ti == 1) {
        //$("#h10" + cw).text("攻击中");                                           //我方攻击
        var obj = Roll(dlnum-1);
        var t=0;
        for(var i = 0;i < 5;i++){
            if(parseInt(dhpnow[i])>0){
                if(t==obj){
                    a1=i;
                }
                t++;
            }
        }
        damage=parseInt(battle(cw,a1));
        //$("#h1" + (a1+1)).text("被攻击");                                          //敌方受到攻击
        $("#h10" + cw).text("hp:"+hpnow[cw-1]+"/"+hp[cw-1]);
        //$("#h10" + cw).text(damage);
    }
    if(ti==2){
        dhpnow[a1]=dhpnow[a1]-damage;
        if(dhpnow[a1]<=0){
            dhpnow[a1]=0;
            dlnum--;
            if(dlnum==0){
                gameResult(1);
            }
        }
        $("#h1" + (a1+1)).text("hp:"+dhpnow[a1]+"/"+dhp[a1]);                        //敌方掉血
        clearInterval(myVar);
        tt--;
        if(dtt>0) {
            ti=0;
            if (dhpnow[dtt-1] > 0 && dlnum > 0) {
                myVar = setInterval(function () {
                    Timer2(dtt)
                }, 1000);
            }else if(mlnum > 0 && tt>0 && hpnow[tt-1] > 0){
                dtt--;
                myVar = setInterval(function () {
                    Timer(tt)
                }, 1000);
            }else {
                dtt--;
                tt--;
                while(tt>0 || dtt>0){
                    if(dhpnow[dtt-1] > 0 && dlnum > 0){
                        myVar = setInterval(function () {
                            Timer2(dtt)
                        }, 1000);
                        break;
                    }
                    dtt--;
                    if(hpnow[tt-1]>0&& mlnum > 0){
                        myVar = setInterval(function () {
                            Timer(tt)
                        }, 1000);
                        break;
                    }
                    tt--;
                }
            }
        }
        if(tt <= 0 && dtt<=0 && lun == 1){
            lun--;
            tt=5;
            dtt=5;
            ti=0;
            setTimeout(function(){ pyy() }, 500);
            myVar2 = setInterval(function(){ pyyTime() }, 1000);
        }
        if(mlnum>0 && dlnum > 0 && tt <= 0 && dtt<=0 && lun == 0)
            gameResult(2);
    }
}
function Timer2(dcw) {
    ti++;
    if(ti == 1) {
        //$("#h1" + dcw).text("攻击中");                                     //敌方攻击
        var obj = Roll(mlnum-1);
        var t=0;
        for(var i = 0;i < 5;i++){
            if(parseInt(hpnow[i])>0){
                if(t==obj){
                    a1=i;
                }
                t++;
            }
        }
        damage=parseInt(battle2(dcw,a1));
        //$("#h10" + (a1+1)).text("被攻击");                              //我方受到攻击
        $("#h1" + dcw).text("hp:"+dhpnow[dcw-1]+"/"+dhp[dcw-1]);
    }
    if(ti==2){
        hpnow[a1]=hpnow[a1]-damage;
        if(hpnow[a1]<=0){
            hpnow[a1]=0;
            mlnum--;
            if(mlnum==0){
                gameResult(0);
            }
        }
        $("#h10" + (a1+1)).text("hp:"+hpnow[a1]+"/"+hp[a1]);                       //我方掉血
        clearInterval(myVar);
        dtt--;
        if(tt>0) {
            ti=0;
            if (hpnow[tt-1] > 0 && mlnum > 0) {
                myVar = setInterval(function () {
                    Timer(tt)
                }, 1000);
            }else if(dlnum > 0 && dtt>0 && dhpnow[dtt-1] > 0){
                tt--;
                myVar = setInterval(function () {
                    Timer2(dtt)
                }, 1000);
            }else {
                dtt--;
                tt--;
                while (tt > 0 || dtt > 0) {
                    if (hpnow[tt-1] > 0 && mlnum > 0) {
                        myVar = setInterval(function () {
                            Timer(tt)
                        }, 1000);
                        break;
                    }
                    tt--;
                    if (dhpnow[dtt-1] > 0 && dlnum > 0) {
                        myVar = setInterval(function () {
                            Timer2(dtt)
                        }, 1000);
                        break;
                    }
                    dtt--;
                }
            }
        }
        if(tt <= 0 && dtt <=0 && lun == 1){
            //alert(2);
            lun--;
            tt=5;
            dtt=5;
            ti=0;
            setTimeout(function(){ pyy() }, 500);
            myVar2 = setInterval(function(){ pyyTime() }, 1000);
        }
        if(mlnum>0 && dlnum > 0 && tt <= 0 && dtt<=0 && lun == 0)
            gameResult(2);
    }
}
function battle(m,d) {
    damage=2*(((abi[m-1]-dabi[d])/10)*abiup)/100;
    var skil = 0;
    if(damage<=0)
        damage=1;
    if(skill[m-1]<200){
        var p = Roll2();
        //alert(p);
        if((skill[m-1]-100)*10>=p){
            damage=damage*2;                                                                  //我方技能发动
            skil=1;
        }
    }
    bts(m,d+1,1,skil,100+m);
    return damage;
}
function battle2(d,m) {
    damage=2*(((dabi[d-1]-abi[m])/10)*dabiup)/100;
    var skil = 0;
    if(damage<=0)
        damage=1;
    if(dskill[d-1]<200){
        var p = Roll2();
        if((dskill[d-1]-100)*10<=p){
            damage=damage*2;                                                                  //我方技能发动
            skil=1;
        }
    }
    bts(d,m+1,2,skil,10+d);
    return damage;
}
var mexp = 0;
var mmoney = 0;
var pexp = 0;
var lr = 0;
function gameResult(result){
    lr=result;
    if(result==1){
        mexp = getResult(1);
        pexp = 60;
        returnResult();
    }else if(result==0){
        mexp = getResult(0);
        returnResult();
    }else if(result==2){
        mexp = getResult(2);
        returnResult();
    }
}
function getResult(result) {
    var myExp = 0;
    myExp =parseInt(dplevel)*100;
    if(result == 0){
        myExp = myExp/10;
    }
    if(result == 2){
        myExp = myExp/5;
    }
    return myExp;
}
function returnResult() {
    var con = JSON.stringify({"player_id": $.cookie('ID'), "player_gexp": pexp, "player_gmoney": mmoney, "card_gexp": mexp, "message": lr});
    $.ajax({
        type: "post",
        dataType: "json",
        contentType: "application/json",
        url: getContextPath() + "/game/result",
        data: con,
        success: function (data) {
            if (data.message == "true") {
                if(lr == 1) {
                    alert("YOU WIN\n获得卡片经验：" + mexp + "\n人物经验：" + pexp);
                    window.location.href = getContextPath() + '/';
                } else if(lr == 0){
                    alert("YOU LOSE\n获得卡片经验："+mexp);
                    window.location.href = getContextPath() + '/';
                } else if(lr == 2){
                    alert("DRAW\n获得卡片经验："+mexp);
                    window.location.href = getContextPath() + '/';
                }
            }
            else {
                alert("发生错误");
                window.location.href = getContextPath() + '/';
            }
        },
    });
}
var cti = 3;
function pyyTime() {
    cti--;
    if(cti==0){
        clearpyy();
        clearInterval(myVar2);
        setTimeout(function(){lun2() }, 500);
    }
}
function lun2() {
    while (tt > 0 || dtt > 0) {
        if (hpnow[tt-1] > 0 && mlnum > 0 && dlnum > 0) {
            myVar = setInterval(function () {
                Timer(tt)
            }, 1000);
            break;
        }
        tt--;
        if (dhpnow[dtt-1] > 0 && dlnum > 0 && mlnum > 0) {
            myVar = setInterval(function () {
                Timer2(dtt)
            }, 1000);
            break;
        }
        dtt--;
    }
}