function getContextPath() {
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    return result;
}
$.ajax({
    type:"post",
    dataType: "json",
    contentType: "application/json",
    url:getContextPath()+"/event/can",
    success: function (data) {
        if (data.message == "true") {
            $("#littleButton1").removeAttr("disabled");
            $("#littleButton1").text("进入");
        }
        else {
            $("#littleButton1").attr("disabled",true);
            $("#littleButton1").text("活动尚未开放");
        }
    },
});