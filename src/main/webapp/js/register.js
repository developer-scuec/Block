$(document).ready(function(){
	$('#sign').click(function() {
		var username = $('#loginname').val();
		var password = $("#loginpwd").val();
		if (username != "" && password != "") {
			$.ajax({
				type : "POST",
				url : "/Block/toRegister",
				dataType : "JSON",
				data : {
					"username" : username,
					"password" : password
				},
				success : function(data) {
					alert("success");
					switch (data) {
					case 1: //用户已存在
						alert("该用户已存在！请换一个用户名注册。")
						break;
					case 2: //注册成功
						alert("注册成功！");
						break;
					case 0: //验证码错误
						alert("验证码不正确！");
						break;
					}

				},
				error:function(data,type, err){
			         console.log("ajax错误类型："+type);
			         console.log(err);
			    }

			})
		} else {
			alert("请检查您的输入！");
		}
	});
});
