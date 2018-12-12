<%--
  Created by IntelliJ IDEA.
  User: liangzehua
  Date: 2018/10/21
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>购物车</title>
    <link type="text/css" rel="stylesheet" href="style/reset.css">
    <link type="text/css" rel="stylesheet" href="style/main.css">
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/jquery.cookie.js"></script>
    <script type="text/javascript" src="js/car.js"></script>
</head>

<body>
<div class="topBar">
    <div class="leftarea"> <span class="logoBar">享受生活每一天</span><br>
        <span class="logo">Enjoy your Life everyday</span>
    </div>
    <div>
        <span class="logotop" >谨慎剁手哟~</span>

    </div>
    <div class="rightplace">
        <a href="#" style="color: #ff7d48;" >收藏本站</a>
    </div>
</div>
<div class="shoppingCart comWidth">
    <div class="shopping_item">
        <h3 class="shopping_tit">收货地址</h3>
        <div class="shopping_cont padding_shop">
            <ul class="shopping_list">
                <li><span class="shopping_list_text"><em>*</em>选择地区：</span>
                    <div class="select">
                        <h3>海淀区五环内</h3><span></span>
                        <ul class="show_select">
                            <li>上帝</li>
                            <li>五道口</li>
                            <li>上帝</li>
                        </ul>
                    </div>
                </li>
                <li><span class="shopping_list_text"><em>*</em>详细地址：</span><input type="text" placeholder="最多输入20个汉字" class="input input_b"></li>
                <li><span class="shopping_list_text"><em>*</em>收 货 人：</span><input type="text" placeholder="最多10个" class="input"></li>
                <li><span class="shopping_list_text"><em>*</em>手	机：</span><input type="text" class="input">
                    <input type="text" class="input input_s"><span class="jian">-</span><input type="text" class="input input_s2"><span class="jian">-</span><input type="text" class="input input_s2"></li>
                <li><input type="button" class="affirm"></li>
            </ul>
        </div>
    </div>
    <div class="hr_25"></div>
    <div class="shopping_item">
        <h3 class="shopping_tit">支付方式</h3>
        <div class="shopping_cont padding_shop">
            <ul class="shopping_list">
                <li><input type="radio" class="radio" id="r1"><label for="r1"></label>微信支付</li>
                <li><input type="radio" class="radio" id="r2"><label for="r2"></label>支付宝支付</li>
            </ul>
        </div>
    </div>
    <div class="hr_25"></div>
    <div class="shopping_item">
        <h3 class="shopping_tit">送货清单<a href="#" class="backCar">返回购物车修改</a></h3>
        <div class="shopping_cont pb_10">
            <div class="cart_inner">
                <div class="cart_head clearfix">
                    <div class="cart_item t_name">商品名称</div>
                    <div class="cart_item t_price">单价</div>
                    <div class="cart_item t_return">返现</div>
                    <div class="cart_item t_num">数量</div>
                    <div class="cart_item t_subtotal">小计</div>
                </div>
            </div>
        </div>
    </div>
    <div class="hr_25"></div>
    <div class="shopping_item">
        <h3 class="shopping_tit">订单结算</h3>
        <div class="shopping_cont padding_shop clearfix">
            <div class="cart_count fr">
                <div class="cart_rmb">
                    <i id="allPrice">总计：</i>
                </div>
                <div class="cart_btnBox">
                    <from>
                        <input type="text" placeholder="请输入钱包地址" name="walletAddress" id="payForm"/>
                        <input type="submit" id="pay" class="cart_btn" value="提交订单">
                    </from>

                </div>
            </div>
        </div>
    </div>
</div>
<div class="hr_25"></div>
<div class="back">
    <p><a href="#">本站简介</a><i>|</i><a href="#">本站公告</a><i>|</i> <a href="#">招纳贤士</a><i>|</i><a href="#">联系我们</a><i>|</i>客服热线：400-675-1234</p>
    <p>Copyright &copy; 2006 - 2014 本站版权所有&nbsp;&nbsp;&nbsp;京ICP备09037834号&nbsp;&nbsp;&nbsp;京ICP证B1034-8373号&nbsp;&nbsp;&nbsp;某市公安局XX分局备案编号：123456789123</p></div>


</div>
</body>
</html>