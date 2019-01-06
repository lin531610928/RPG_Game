var con = JSON.stringify({"player_id": cookieID});
$.ajax({
    type:"post",
    dataType: "json",
    contentType: "application/json",
    url:getContextPath()+"/task/all",
    data:con,
    success: function (data) {
        if (data[0].message == "true") {
            for(var i = 0;i<data.length;i++){
                if(parseInt(data[i].task_aim) > parseInt(data[i].task_now))
                    $("#mission").append("<tr><td>"+data[i].task_name+"</td><td>"+data[i].task_award_desc+"</td><td>"+data[i].task_now+"/"+data[i].task_aim+"</td><td><button id=\""+data[i].task_id+"\" type=\"button\" class=\"btn btn-xs btn-primary disabled\">未完成</button></td></tr>");
                else if(data[i].task_complete == 1)
                    $("#mission").append("<tr><td>"+data[i].task_name+"</td><td>"+data[i].task_award_desc+"</td><td>"+data[i].task_now+"/"+data[i].task_aim+"</td><td><button id=\""+data[i].task_id+"\" type=\"button\" class=\"btn btn-xs btn-primary disabled\">已完成</button></td></tr>");
                else {
                    $("#mission").append("<tr><td>"+data[i].task_name+"</td><td>"+data[i].task_award_desc+"</td><td>"+data[i].task_now+"/"+data[i].task_aim+"</td><td><button id=\""+data[i].task_id+"\" type=\"button\" class=\"btn btn-xs btn-primary\" onclick=\"missionComplete("+data[i].task_id+")\">完成</button></td></tr>");
                }
            }
        }
    },
});
function missionComplete(task_id) {
    var con = JSON.stringify({"player_id": cookieID,"task_id": task_id});
    $.ajax({
        type:"post",
        dataType: "json",
        contentType: "application/json",
        url:getContextPath()+"/task/complete",
        data:con,
        success: function (data) {
            if (data.message == "true") {
                alert("Missin Complete!");
                $("#"+task_id).text("已完成");
                $("#"+task_id).attr("disabled",true);
            }else if(data.message == "no2"){
                alert("背包已满");
            } else {
                alert("发生错误");
            }
        },
    });
}