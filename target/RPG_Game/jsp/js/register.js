// JavaScript Document
document.getElementById( "button_ok" ).disabled = true;
		function pw() {
			var pw1 = document.getElementById( 'password' ).value;
			var pw2 = document.getElementById( "insurepassword" ).value;
			var em = document.getElementById( "user" ).value;
			var a=1;
            console.log($("#user").val().length);
			if ( em == '' ) {
				document.getElementById( 'emalert' ).innerHTML = "用户名不能为空";
				document.getElementById( "button_ok" ).disabled = true;
			}
			else if(pw1 != pw2){
                    document.getElementById('alert').innerHTML = "两次密码不相同"
                    document.getElementById("button_ok").disabled = true;
			}
            else if($("#password").val().length>=16) {
                    document.getElementById('alert').innerHTML = "密码长度不能超过16字符"
                    document.getElementById("button_ok").disabled = true;
                }
            else if($("#user").val().length>=12){
                    document.getElementById( 'emalert' ).innerHTML = "用户名不能超过12字符";
                    document.getElementById( "button_ok" ).disabled = true;
                }
			else if(pw1 != ""){
				document.getElementById( "button_ok" ).disabled = false;
				document.getElementById( 'alert' ).innerHTML = "";
                document.getElementById( 'emalert' ).innerHTML = "";
			}
		}