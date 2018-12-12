<%--
  Created by IntelliJ IDEA.
  User: liangzehua
  Date: 2018/10/14
  Time: 9:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>店铺商品_已登录状态</title>
    <link type="text/css" rel="stylesheet" href="style/reset.css">
    <link type="text/css" rel="stylesheet" href="style/main.css">
    <link rel="stylesheet" href="style/tinyImgUpload.css">
</head>
<body>
<div class="ShopHead">
    <div class="HeadLeft">
        <p>hello,用户名</p>
        <a href="#">积分<span>1872</span>分</a>
        <a href="#">退出</a>
    </div>
    <div class="HeadRight">
        <a href="#">我卖出的</a>
        <a href="#">我发布的</a>
        <a herf="#">我的</a>
        <a href="#">我的</a>
    </div>
</div>
<div class="hr_25"></div>
<div class="shop_top">
    <div class="shop_introduction">

        <div class="shop_big">
            <div class="shop_icon">
                <img src="images/shop_icon1.jpg"/>
            </div>
            <div class="shop_name">
                <li class="shop_call">大地农产品</li>
                <li class="seller">卖家：大地官方农产品旗舰店</li>
                <li class="main_goods">主营：葡萄 苹果 香蕉 玉米 芹菜</li>
            </div>
        </div>

        <div class="shop_sales">
            <div class="shop_count">
                <li>销量<span class="count1">73945</span></li>
                <li>共<span class="count2">7438</span>种农产品</li>
            </div>
        </div>

    </div>
</div>
<div class="hr_25"></div>
<div class="publish_box">
    <div class="publish_title">
        <h1>请根据下面的提示进行发布商品</h1>
    </div>
    <div class="hr_25"></div>
    <form id="publish_form" action="uploadFile" method="post" enctype="multipart/form-data">
        <div class="start_publish">
            <div class="p_line">
                <label class="p_label">标题：</label>
                <input type="text" name="title" id="title"/>
            </div>
            <div class="p_line">

                <label class="p_label">价格：</label>
                <input type="text" name="price" id="price" />

            </div>
            <div class="p_line">
                <label class="p_label">商品描述：</label>
                <textarea name="description" id="description" cols="80" rows="12" placeholder="不超过200字"></textarea>
            </div>
            <div id="upload">

            </div>
            <script src="tinyImgUpload.js"></script>
            <div class="p_line">
                <label class="p_label">上传图片：</label>
                <div class="imgx_btn">
                    <img src="images/upload.png"/>
                    <span  class="upload_photo">点击"+"上传图片</span>
                    <input type="file" name="uploadImg">
                </div>
            </div>
            <div class="p_line">
                <label class="p_label">联系电话：</label>
                <input type="text" name="telephone" id="telephone"/>
            </div>
            <div class="p_line">
                <label class="p_label">支付宝账号：</label>
                <input type="text" name="alipay" id="alipay"/>
            </div>
            <button type="submit" name="submit" id="submit" class="click_publish">我要发布</button>
        </div>
    </form>
</div>
<div class="hr_25"></div>
<div class="footer">
    <p><a href="#">本站简介</a><i>|</i><a href="#">本站公告</a><i>|</i> <a href="#">招纳贤士</a><i>|</i><a href="#">联系我们</a><i>|</i>客服热线：400-675-1234</p>
    <p>Copyright &copy; 2006 - 2014 本站版权所有&nbsp;&nbsp;&nbsp;京ICP备09037834号&nbsp;&nbsp;&nbsp;京ICP证B1034-8373号&nbsp;&nbsp;&nbsp;某市公安局XX分局备案编号：123456789123</p>
    <p class="web"><a href="#"><img src="images/bottom_1.png" alt="logo"></a><a href="#"><img src="images/bottom_2.jpg" alt="logo"></a><a href="#"><img src="images/bottom_3.png" alt="logo"></p>
</div>
</body>
</html>