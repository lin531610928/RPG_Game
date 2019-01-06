var arr = new Array(100);
var cvvv =new Array(100);
var cvvv2=new Array(100);
var ci1= new Array(100);
var ci2= new Array(100);
var ci3= new Array(100);
var ci4= new Array(100);
var ci5= new Array(100);
var ci6= new Array(100);
var ci7= new Array(100);
var tarr1 = new Array(5);
var con = JSON.stringify({"player_id": cookieID});
$.ajax({
    type:"post",
    dataType: "json",
    contentType: "application/json",
    url:getContextPath()+"/backpack/playercards",
    data:con,
    success: function (data) {
        //alert(data.length);
        var info1="<div class=\"col-sm-12 divPack\"></div>";
        var info2="<div class=\"col-sm-2\"></div>\n" + "  </div>";
        var info4="<div class=\"col-sm-2\"></div>";
        var j=0;
        var t=1;
        for(var i = 0;i<data.length;i++){
            if(j==0) {
                $("#backpack").append("<div class=\"col-sm-12 divPack\" id=\"ty" + t + "\"></div>");
                t++;
            }
            //var info3="<div class=\"col-sm-1 littlePack\" id=\"packImgDiv"+i+1+"\"><img src=\"<%= request.getContextPath() %>/"+data[i].card_path+"\" class=\"Backpack\" id="+i+1+" onMouseOver=\"teamThrowCard('1')\" onMouseOut=\"divOutDislay()\"></div>";
            //$("#ty"+t-1).append(info3);
            if(parseInt(data[i].card_state)>0){
                $("#10"+parseInt(data[i].card_state)).attr("src",data[i].card_path+"");
                tarr1[parseInt(data[i].card_state)-1]=data[i].card_bid;

            }
            cvvv[i]=data[i].card_state;
            cvvv2[i]=data[i].card_id;
            arr[i]=data[i].card_bid;
            ci1[i]=data[i].card_exp;
            ci2[i]=data[i].card_needexp;
            ci3[i]=data[i].card_level;
            ci4[i]=data[i].card_skill_desc;
            ci5[i]=data[i].card_ability;
            ci6[i]=data[i].card_rare;
            ci7[i]=data[i].card_name;
            j++;
            if(j==8){
                $("#backpack").append(info2);
                j=0;
            }
        }
        if(j!=0){
            $("#backpack").append(info2);
        }
        t=1;
        j=0;
        for(var i = 0;i<data.length;i++){
            if(j==0){
                $("#ty"+t).append(info4);
            }
            var info3="<div class=\"col-sm-1 littlePack\" id=\"packImgDiv"+(i+1)+"\"><img src=\""+data[i].card_path+"\" class=\"Backpack\" id="+(i+1)+" onclick=\"cardclick(this)\" onMouseOver=\"fff("+(i+1)+")\" onMouseOut=\"fff2()\"></div>";
            $("#ty"+t).append(info3);
            j++;
            if(j==8) {
                t++;
                j=0;
            }
        }
    },
});
var tarr2 = new Array(2);
var arr2 = new Array(100);
var dr=0;
$("#deleteButton").hide();
$("#cardup").hide();
function cardclick(obj){
    var tid = parseInt(obj.id);
    //alert(obj.id);
    if(tarr2[0]==null) {
        if (arr2[tid - 1] != null) {
            arr2[tid - 1] = null;
            dr--;
            $("#packImgDiv"+tid).css("border","solid rgba(255,99,0,0.00) 0px");
            if(dr==0) {
                $("#deleteButton").hide();
                $("#cardup").hide();
            }
            if(dr==1){
                $("#cardup").show();
            }
        }else {
            arr2[tid - 1] = arr[tid - 1];
            dr++;//选中
            $("#packImgDiv"+tid).css("border","solid rgba(255,99,0,1.00) 3px");
            $("#deleteButton").show();
            $("#cardup").show();
            if(dr>1){
                $("#cardup").hide();
            }
        }
    }else {
        if(tarr2[0]==cvvv[tid-1]){
            tarr2[0]=null;//取消
            $("#packImgDiv"+tid).css("border","solid rgba(255,99,0,0.00) 0px");
        }else{
            tarr2[1]=arr[tid-1];//中
            $("#packImgDiv"+tid).css("border","solid rgba(255,99,0,1.00) 3px");
        }
    }
    if(tarr2[0]!=null&&tarr2[1]!=null){
        var con = JSON.stringify({"player_id": cookieID,"card_bid": tarr2[1],"card_state": tarr2[0]});
        $.ajax({
            type:"post",
            dataType: "json",
            contentType: "application/json",
            url:getContextPath()+"/backpack/update",
            data:con,
            success: function (data) {
                if (data.message == "true") {
                    window.location.href=getContextPath()+"/backpack";
                } else {
                    alert(data.message);
                }
            },
        });
    }
}
$(document).ready(function(){
    $(".Team").click(function(){
        var tid=parseInt(this.id);
        if(dr==0) {
            if (tarr2[0] != null && tarr2[0] == "" + (tid - 100)) {
                tarr2[0] = null; //取消
                $("#teamImgDiv"+tid).css("border","solid rgba(255,99,0,0.00) 0px");
            }
            else if (tarr2[0] != null && tarr1[tid - 101] == null){
                tarr2[1] = tarr1[parseInt(tarr2[0])-1];//取消

                if(tarr2[1]==null) {
                    $("#teamImgDiv" + tid).css("border", "solid rgba(255,99,0,0.00) 0px");
                }
                else{
                    tarr2[0] ="" +(tid-100);
                    //alert(tarr2[1]);
                    $("#packImgDiv"+tid).css("border","solid rgba(255,99,0,1.00) 3px");
                }
            }
            else if (tarr2[0] == null) {
                tarr2[0] = "" + (tid - 100);//中
                $("#teamImgDiv"+tid).css("border","solid rgba(255,99,0,1.00) 3px");
            }
            else{
                tarr2[1] = tarr1[tid - 101];//中
                $("#teamImgDiv"+tid).css("border","solid rgba(255,99,0,1.00) 3px");
            }
            //alert(tarr2[0]+" "+tarr2[1]);
        }
        if(tarr2[0]!=null&&tarr2[1]!=null){
            var con = JSON.stringify({"player_id": $.cookie('ID'),"card_bid": tarr2[1],"card_state": tarr2[0]});
            $.ajax({
                type:"post",
                dataType: "json",
                contentType: "application/json",
                url:getContextPath()+"/backpack/update",
                data:con,
                success: function (data) {
                    if (data.message == "true") {
                        window.location.href=getContextPath()+"/backpack";
                    } else {
                        alert(data.message);
                    }
                },
            });
        }
    });
});
function deletecards() {
    var deletecs=[];
    for (var i = 0; i < 100; i++) {
        var card = {};
        if(arr2[i]!=null) {
            card['player_id'] = $.cookie('ID');
            card['card_bid'] = arr2[i];
            deletecs.push(card)
        }
    }
    console.log(JSON.stringify(deletecs));
    $.ajax({
        type:"post",
        dataType: "json",
        contentType: "application/json",
        url:getContextPath()+"/backpack/delete",
        data:JSON.stringify(deletecs),
        success: function (data) {
            if (data.message == "true") {
                window.location.href=getContextPath()+"/backpack";
            } else {
                alert(data.message);
            }
        },
    });
}
var expNow = 0;
var con = JSON.stringify({"player_id": $.cookie('ID')});
$.ajax({
    type:"post",
    dataType: "json",
    contentType: "application/json",
    url:getContextPath()+"/backpack/item",
    data:con,
    success: function (data) {
        if (data.message == "true") {
            $("#expnow").text("经验瓶："+data.item_num+"个");
            expNow = parseInt(data.item_num);
        }
    },
});
function NumberCheck(t){
    var nubmer = t.value;
    if(nubmer != "") {
        if (!/^\d+$/.test(nubmer)) {
            alert("请输入正确的数值,只允许输入整数!");
            t.value = "";
            return false;
        }
        if (nubmer > expNow || nubmer == 0) {
            t.value = "";
            alert("请输入正确的数值");
        }
    }
}
function cardUp() {
    var expnum = $("#expnum").val();
    if(expnum !="") {
        var cardb;
        for (var i = 0; i < 100; i++) {
            if (arr2[i] != null) {
                cardb = arr2[i];
                break;
            }
        }
        var con = JSON.stringify({"player_id": $.cookie('ID'),"card_bid": cardb,"item_num": expnum});
        $.ajax({
            type:"post",
            dataType: "json",
            contentType: "application/json",
            url:getContextPath()+"/backpack/cardup",
            data:con,
            success: function (data) {
                if (data.message == "true") {
                    alert("升级成功");
                    window.location.href=getContextPath()+"/backpack";
                }
                else {
                    alert("升级失败");
                }
            },
        });
    }
}
function fff(tid){
    //alert(tid);
    var imgAdrress= $("#"+tid).attr("src");

    //var con = JSON.stringify({"player_id": $.cookie('ID'),"card_bid": arr[tid-1]});
    mTips.c.x = 30;
    mTips.c.y = 30;
    //$("#1000").text(data.card_rare+" "+data.card_name+" "+data.card_ability+" "+data.card_skill);
    cardDisplay ="<div class=\"col-sm-12\"><div class=\"col-sm-5\" style=\"line-height: 5px\"><img src=\""+imgAdrress+" \" class=\"blockImg\"\"></div><div class=\"\" style=\"line-height: 5px\"><h3 style=\"line-height: 5px\">"+ci6[tid-1]+"</h3><h5 style=\"line-height: 5px\">稀有度</h5><h3 style=\"line-height: 5px\">"+ci7[tid-1]+"</h3><h5 style=\"line-height: 5px\">名字</h5><h3 style=\"line-height: 5px\">"+ci3[tid-1]+ "</h3><h5 style=\"line-height: 5px\">等级</h5><h3 style=\"line-height: 5px\">"+ci1[tid-1]+"/"+ci2[tid-1]+ "</h3><h5 style=\"line-height: 5px\">经验</h5><h3 style=\"line-height: 5px\">"+ci5[tid-1]+ "</h3><h5 style=\"line-height: 5px\">属性值</h5><h3>"+ci4[tid-1]+"</h3><h5>技能</h5></div></div>";
    mTips.s(cardDisplay, 'white');
}
function fff2(){
    //$("#1000").text("");
    mTips.h();
    mTips.c.x = 10;
    mTips.c.y = 10;
}