$(document).ready(function() {
    $("#button_ok").click(function sendMessage() {
        var message = $("#chatmess").val();
        var messLen = len(message);
        if(messLen>255){
            alert("输入信息过长，请重新输入");
        }else {
            var con = JSON.stringify({"player_id": cookieID, "chat_message": message});
            $.ajax({
                type:"post",
                dataType: "json",
                contentType: "application/json",
                url:getContextPath()+"/chatroom/sendmessage",
                data:con,
                success: function (data) {
                    if(data.message == "true"){
                        $("#chatmess").val("");
                    }else {
                        alert("发送失败");
                    }
                },
            });
        }
    });
});
function len(str) {
    return str.replace(/[\u0391-\uFFE5]/g,"aa").length;
}
var myVar;
$.ajax({
    type:"post",
    dataType: "json",
    contentType: "application/json",
    url:getContextPath()+"/chatroom/getmessageh",
    success: function (data) {
        if (data[0].message == "true") {
            //alert(data[0].player_name);
            for(var i = 0;i<data.length;i++){
                $("#chatroom").append(data[i].player_name+"("+data[i].chat_date+"):"+data[i].chat_message+"\n");
            }
            $("#chatroom").scrollTop($("#chatroom")[0].scrollHeight);
            myVar = setInterval(function(){ chatTimer() }, 1000);
        }
    },
});
function chatTimer() {
    $.ajax({
        type:"post",
        dataType: "json",
        contentType: "application/json",
        url:getContextPath()+"/chatroom/getmessages",
        success: function (data) {
            if (data[0].message == "true") {
                //alert(data[0].player_name);
                for(var i = 0;i<data.length;i++){
                    $("#chatroom").append(data[i].player_name+"("+data[i].chat_date+"):"+data[i].chat_message+"\n");
                }
                $("#chatroom").scrollTop($("#chatroom")[0].scrollHeight);
            }
        },
    })
}