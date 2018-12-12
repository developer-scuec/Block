<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="utf-8">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" charset="utf-8" href="style/index.css"/>
</head>
<body>
<div class="headBar">
    <div class="leftarea"><span class="logoBar">享受生活每一天</span><br>
        <span class="logo">Enjoy your Life everyday</span>
    </div>
    <div class="rightarea">

    </div>
    <div>
        <ul class="shopbar">
            <li><a href="#" class="active">超值好物</a></li>
            <li><a href="#">水果</a></li>
            <li><a href="#">蔬菜</a></li>
            <li><a href="#">谷物</a></li>
            <li><a href="#">禽类</a></li>
            <li><a href="#">更多</a></li>
        </ul>
    </div>
</div>
<div class="scroll">
    <img src="https://imgazure.microsoftstore.com.cn/_ui/desktop/static/img/20181212/official/banner_2x.jpg" width="100%" height="100%">
    <ol id="ol">
        <li class="current"></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ol>
</div>
<div class="showgood">


</div>


<div class="back">
    <p><a href="#">本站简介</a><i>|</i><a href="#">本站公告</a><i>|</i> <a href="#">招纳贤士</a><i>|</i><a href="#">联系我们</a><i>|</i>客服热线：400-675-1234
    </p>
    <p>Copyright &copy; 2006 - 2014 本站版权所有&nbsp;&nbsp;&nbsp;京ICP备09037834号&nbsp;&nbsp;&nbsp;京ICP证B1034-8373号&nbsp;&nbsp;&nbsp;某市公安局XX分局备案编号：123456789123</p>


</div>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>

</body>
</html>