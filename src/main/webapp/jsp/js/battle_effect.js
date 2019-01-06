function bts(x,x2,y,skil,id){
    switch (x){
        case 5:
            x=1;
            break;
        case 4:
            x=2;
            break;
        case 3:
            x=3;
            break;
        case 2:
            x=4;
            break;
        case 1:
            x=5;
            break;
    }
    switch (x2){
        case 5:
            x2=1;
            break;
        case 4:
            x2=2;
            break;
        case 3:
            x2=3;
            break;
        case 2:
            x2=4;
            break;
        case 1:
            x2=5;
            break;
    }
    var canvasContainer = document.getElementById('canvas-container');
    var cw=canvasContainer.offsetWidth-2;
    var ch=canvasContainer.offsetHeight-2;
    var c=document.getElementById("c");
    var ctx=c.getContext("2d");
    x=(cw/10)*((x*2)-1);
    x2=(cw/10)*((x2*2)-1);
    var y2 = 0;
    if(y==1){
        y=0;
        y2=ch;
    }
    else{
        y=ch;
        y2=0
    }
    var n = (x2-x)/200;
    var n2 = (y2-y)/200;
    var ctx2 = document.getElementById('c').getContext('2d');
    var canvasContainer = document.getElementById('canvas-container');
    ctx2.canvas.width  = canvasContainer.offsetWidth-2;
    ctx2.canvas.height = canvasContainer.offsetHeight-2;
    function tx(){
        ctx.fillStyle='#FFFFFF';
        ctx.fillRect(0,0,cw,ch);
        if(skil==1) {
            var imgObj = new Image();
            imgObj.src = $("#" + id).attr("src");
            imgObj.onload = function () {
                ctx2.drawImage(this, cw / 2 - (ch * 255 / 720), 0, ch * 255 / 360, ch);
                ctx2.font="30px 黑体";
                ctx2.fillStyle='#D9D919';
                ctx2.fillText("技能发动", cw / 2 - (ch * 255 / 720), ch / 2);
                x = x + n;
                y = y + n2;
                if (y > ch || y < 0) {
                    clearInterval(bt);
                } else {
                    ctx.save();
                    ctx.strokeStyle = "#D9534F";
                    ctx.beginPath();
                    //ctx.moveTo(x,y);
                    ctx.arc(x, y, 10, 0, 2 * Math.PI);
                    ctx.closePath();
                    ctx.fillStyle = '#D9534F';
                    ctx.fill();
                    //ctx.stroke();
                    //ctx.restore();
                }
            }
        }else {
            x = x + n;
            y = y + n2;
            if (y > ch || y < 0) {
                clearInterval(bt);
            } else {
                ctx.save();
                ctx.strokeStyle = "#D9534F";
                ctx.beginPath();
                //ctx.moveTo(x,y);
                ctx.arc(x, y, 10, 0, 2 * Math.PI);
                ctx.closePath();
                ctx.fillStyle = '#D9534F';
                ctx.fill();
                //ctx.stroke();
                //ctx.restore();
            }
        }
    }

    var bt = setInterval(tx,5);
}
var click=0;
function pyy() {
    var canvasContainer = document.getElementById('canvas-container');
    var cw=canvasContainer.offsetWidth-2;
    var ch=canvasContainer.offsetHeight-2;
    var ctx2 = document.getElementById('c').getContext('2d');
    ctx2.canvas.width  = canvasContainer.offsetWidth-2;
    ctx2.canvas.height = canvasContainer.offsetHeight-2;
    ctx2.fillStyle='#FFFFFF';
    ctx2.fillRect(0,0,cw,ch);
    ctx2.font="30px 黑体";
    ctx2.fillStyle='#d9198f';
    ctx2.fillText("应援开始", (cw / 2)-60 , (ch / 2)-50);
    ctx2.save();
    ctx2.strokeStyle = "#000ad9";
    ctx2.beginPath();
    //ctx.moveTo(x,y);
    ctx2.arc(cw/2, ch/2, 30, 0, 2 * Math.PI);
    ctx2.closePath();
    ctx2.fillStyle = "#000ad9";
    ctx2.fill();
    $("#c").mousedown(function(e){
        var x = e.offsetX; // 鼠标落下时的X
        var y = e.offsetY; // 鼠标落下时的Y
        if((((x-(cw/2))*(x-(cw/2)))+((y-(ch/2))*(y-(ch/2)))) <= 30*30 && cti>0) {
            ctx2.fillStyle='#FFFFFF';
            ctx2.fillRect(0,0,cw,ch);
            ctx2.font="30px 黑体";
            ctx2.fillStyle='#d9198f';
            ctx2.fillText("应援开始", (cw / 2)-60 , (ch / 2)-50);
            ctx2.save();
            ctx2.strokeStyle = "#000ad9";
            ctx2.beginPath();
            //ctx.moveTo(x,y);
            ctx2.arc(cw/2, ch/2, 30, 0, 2 * Math.PI);
            ctx2.closePath();
            ctx2.fillStyle = "#000ad9";
            ctx2.fill();
            ctx2.fillStyle='#FFFFFF';
            abiup+=1;
            click+=1;
            ctx2.fillText(""+click, (cw / 2)-15 , (ch / 2)+15);
        }
    })
}
function clearpyy() {
    var canvasContainer = document.getElementById('canvas-container');
    var cw=canvasContainer.offsetWidth-2;
    var ch=canvasContainer.offsetHeight-2;
    var ctx2 = document.getElementById('c').getContext('2d');
    ctx2.canvas.width  = canvasContainer.offsetWidth-2;
    ctx2.canvas.height = canvasContainer.offsetHeight-2;
    ctx2.fillStyle='#FFFFFF';
    ctx2.fillRect(0,0,cw,ch);
    ctx2.save();
    ctx2.font="30px 黑体";
    ctx2.fillStyle='#d9198f';
    ctx2.fillText("应援结束", (cw / 2)-60 , (ch / 2)-50);
}