<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>注册</title>
<link type="text/css" rel="stylesheet" href="style/reset.css">
<link type="text/css" rel="stylesheet" href="style/main.css">
<script src="js/jquery-3.3.1.min.js"></script>
</head>

<body>
	<div class="topBar">
		<div>
			<span class="logotop">欢迎注册!</span>

		</div>
		<div class="rightplace">
			<a href="#" style="color: #ff7d48;">收藏本站</a>
		</div>
	</div>
	<div class="hr_25"></div>

	<div class="regBox">
		<div class="login_cont">
			<form method="post" name="form" action="/Block/toRegister">
				<ul class="login">
					<li><span class="reg_item"><i>*</i>账户名：</span>
						<div class="input_item">
							<input type="text" class="login_input user_icon" id="loginname"
								name="username"> <span id="user_msg"></span>
						</div></li>


					<li><span class="reg_item"><i>*</i>密码：</span>
						<div class="input_item">
							<input type="password" class="login_input user_icon"
								id="loginpwd" name="password"> <span id="pwd_msg"></span>
						</div></li>


					<li><span class="reg_item"><i>*</i>确认密码：</span>
						<div class="input_item">
							<input type="password" class="login_input user_icon"
								id="check_loginpwd" name="checkpwd"> <span
								id="check_pwd_msg"></span>
						</div></li>


					<li class="autoLogin"><span class="reg_item">&nbsp;</span><input
						type="checkbox" id="t1" class="checked" checked="checked"><label
						for="t1">同意以上条款</label><br />
					<span id="accept"></span></li>

					<li><span class="reg_item">&nbsp;</span><input type="submit"
						value="注册" class="register_btn" id="sign"></li>
				</ul>
			</form>

		</div>
	</div>

	<div class="hr_25"></div>
	<div class="back">
		<p>
			<a href="#">本站简介</a><i>|</i><a href="#">本站公告</a><i>|</i> <a href="#">招纳贤士</a><i>|</i><a
				href="#">联系我们</a><i>|</i>客服热线：400-675-1234
		</p>
		<p>Copyright &copy; 2006 - 2014
			本站版权所有&nbsp;&nbsp;&nbsp;京ICP备09037834号&nbsp;&nbsp;&nbsp;京ICP证B1034-8373号&nbsp;&nbsp;&nbsp;某市公安局XX分局备案编号：123456789123</p>
	</div>


	</div>

</body>
</html>
