// JavaScript Document
$(document).ready(function() {
    if (ten == "" && single == "") {
        $("#tenDraw").hide();
        $("#oneDraw").hide();
    }
    else if (single != "") {
        $("#tenDraw").hide();
        $("#oneDraw").show();
    }
    else if (ten != "") {
        $("#tenDraw").show();
        $("#oneDraw").hide();
    }
});
	var cardDisplay="ssr";
	function throwCard(name){
		var cardName= "#cardImg"+name;
		//alert(cardName);
		var imgAdrress= $(cardName).attr("src");
		cardDisplay ="<img src=\""+imgAdrress+"\">";
	}
	function divDisplay(){
		$('.cardImage').on('mouseenter', function(e) {
				//显示提示
				mTips.c.x = 30;
				mTips.c.y = 30;
				mTips.s(cardDisplay, 'white');
			});
			$('.cardImage').on('mouseleave', function(e) {
				mTips.h();
				mTips.c.x = 10;
				mTips.c.y = 10;
			});
	}
	setTimeout(divDisplay(),500);