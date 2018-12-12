<%--
  Created by IntelliJ IDEA.
  User: liangzehua
  Date: 2018/10/13
  Time: 7:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    String password="";
    String username="";
   Cookie cookies[]=request.getCookies();
   for(Cookie cookie:cookies){
       if(cookie.getName().equals("password")){
           password=cookie.getValue();
       }
       if(cookie.getName().equals("username")){
           username=cookie.getValue();
       }

   }

%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <link type="text/css" rel="stylesheet" href="style/reset.css">
    <link type="text/css" rel="stylesheet" href="style/main.css">
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</head>

<body>
<div class="topBar">
    <div>
        <span class="logotop" >欢迎登陆!</span>
    </div>
    <div class="rightplace">
        <a href="#" style="color: #ff7d48;" >收藏本站</a>
    </div>
</div>
<div class="hr_25"></div>
<div class="loginBox">
    <div class="login_cont">
        <form method="post" name="form" action="verify.jsp">
            <ul class="login">
                <li class="l_tit">用户名</li>
                <li class="mb_10"><input value="<%=username%>" type="text" class="login_input user_icon" id="loginname" name="username" placeholder="用户名"></li>
                <li class="l_tit">密码</li>
                <li class="mb_10"><input value="<%=password%>" type="password" class="login_input user_icon" id="loginpwd" name="password" placeholder="密码"></li>
                <li><input type="submit" value="" class="login_btn" name="submit" id="login"></li>
            </ul>
        </form>
    </div>
    <a class="reg_link" href="register.jsp"></a>
</div>

<div class="hr_25"></div>
<div class="back">
    <p><a href="#">本站简介</a><i>|</i><a href="#">本站公告</a><i>|</i> <a href="#">招纳贤士</a><i>|</i><a href="#">联系我们</a><i>|</i>客服热线：400-675-1234</p>
    <p>Copyright &copy; 2006 - 2014 本站版权所有&nbsp;&nbsp;&nbsp;京ICP备09037834号&nbsp;&nbsp;&nbsp;京ICP证B1034-8373号&nbsp;&nbsp;&nbsp;某市公安局XX分局备案编号：123456789123</p></div>


</div>
</body>
</html>
