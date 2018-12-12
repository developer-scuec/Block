
<%@ page import="showShop.getDetail" %>
<%@ page import="java.util.Map" %>
<%@ page import="addCar.AlterCar" %>
<%@ page import="addCar.item" %>
<%@ page import="java.io.Writer" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
   String id=request.getParameter("id");
   getDetail get=new getDetail(id);
   Map<String,String> info=get.get_info();
%>
<html>
<head>
    <meta charset="utf-8">
    <title>商品介绍</title>
    <link type="text/css" rel="stylesheet" href="style/reset.css">
    <link type="text/css" rel="stylesheet" href="style/main.css">
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="js/detail.js" type="text/javascript"></script>

    <script src="js/jquery.cookie.js" type="text/javascript"></script>

</head>

<body class="grey">
<div class="topBar">
    <div class="search_box fl">
        <input type="text" class="search_text fl">
        <input type="button" value="搜 索" class="search_btn fr">
    </div>
    <div class="shopCar fr">
        <%
            int size=0;
            PrintWriter writer=response.getWriter();
            Cookie cookies[]=request.getCookies();
            String username=null;
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("username")){
                    username=cookie.getValue();
                    break;
                }
            }
            HttpSession session1=request.getSession();
            if(session1.getAttribute(username)==null){
                writer.print(size);
            }else {
                AlterCar CarInfo=(AlterCar)session1.getAttribute(username);
                Map<Integer, item> mapinfo=CarInfo.getItem();
                size=mapinfo.size();
                writer.print(size);
            }



        %>
        <a href="car.jsp" class="shopText fl">购物车</a>
        <span class="shopNum fl">

        </span>
    </div>
</div>
<div class="description_info comWidth">
    <div class="description clearfix" id="<%=id%>">
        <div class="leftArea">
            <div class="description_imgs">
                <div class="big">
                    <img src="<%=info.get("imgUrl")%>" alt="" width="300px" height="320px">
                </div>
            </div>
        </div>
        <div class="rightArea">
            <div class="des_content">
                <h3 class="des_content_tit"><%=info.get("title")%></h3>
                <div class="dl clearfix">
                    <div class="dt">价格</div>
                    <div class="dd clearfix"><span class="des_money"><em>￥</em><%=info.get("price")%></span></div>
                </div>
                <div class="dl clearfix">
                    <div class="dt">优惠</div>
                    <div class="dd clearfix"><span class="hg"><i class="hg_icon">满减</i><em>满50元减5元</em></span></div>
                </div>
                <div class="des_position">
                    <div class="dl">
                        <div class="dt des_num">数量</div>
                        <div class="dd clearfix">
                            <div class="des_number">
                                <div class="reduction">-</div>
                                <div class="des_input">
                                    <input type="text" name="count" value="1">
                                </div>
                                <div class="plus">+</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="des_select">
                    已选择 <span>"1件"</span>
                </div>
                <div class="shop_buy">
                    <p class="shopping_btn"></p>
                </div>
                <div class="notes">
                    注意：此商品可提供普通发票，不提供增值税发票。
                </div>
            </div>
        </div>
    </div>
</div>
<div class="hr_15"></div>
<div class="des_info comWidth clearfix">
    <div class="des_infoContent">
        <ul class="des_tit">
            <li class="active"><span>产品介绍</span></li>
            <li><span>产品评价</span></li>
        </ul>
        <div class="info_text">
            <div class="info_text_left">
                <li>包装方式: 食用农产品</li>
                <li>香薯果径: 75mm（含）-80mm(不含)</li>
                <li>城市: 郑安市</li>
                <li>蔬菜种类：香薯</li>
            </div>
            <div class="info_text_right">
                <li>套餐周期: 3周</li>
                <li>生鲜储存温度: 10-20℃</li>
                <li>价格: 0-50元</li>
                <li>净含量: 10斤</li>
            </div>

        </div>
        <div class="ad">
            <img src="images/goodone_detail1.jpg"></a>
        </div>
        <div class="ad">
            <img src="images/goodone_detail2.jpg">

        </div>





        <div class="hr_15"></div>
        <div class="des_infoContent">
            <h3 class="shopDes_tit">商品评价</h3>

            <div class="review_list clearfix"  style="border-bottom: 1px solid #ccc;">
                <div class="review_userHead fl">
                    <div class="review_user">
                        <img src="images/user.png" alt="">
                        <p>lyx123</p>
                    </div>
                </div>
                <div class="review_cont">
                    <div class="review_t clearfix">
                    </div>
                    <p>感觉挺好吃的！！还会回购的哦</p>
                </div>
            </div>

            <div class="review_list clearfix">

                <div class="review_userHead fl">
                    <div class="review_user">
                        <img src="images/user.png" alt="">
                        <p>qy233</p>
                    </div>
                </div>
                <div class="review_cont">
                    <div class="review_t clearfix">
                    </div>
                    <p>不错不错！质量蛮好的！好评！</p>
                </div>
            </div>

        </div>

        <div class="hr_25"></div>
        <div class="back">
            <p><a href="#">本站简介</a><i>|</i><a href="#">本站公告</a><i>|</i> <a href="#">招纳贤士</a><i>|</i><a href="#">联系我们</a><i>|</i>客服热线：400-675-1234</p>
            <p>Copyright &copy; 2006 - 2014 本站版权所有&nbsp;&nbsp;&nbsp;京ICP备09037834号&nbsp;&nbsp;&nbsp;京ICP证B1034-8373号&nbsp;&nbsp;&nbsp;某市公安局XX分局备案编号：123456789123</p>


        </div>
    </div>
</div>
</body>
</html>
