$(document).ready(function () {
    var username=$.cookie("username");
    if(username==null){
        var login='<a href="login.jsp" style="color: #ff7d48;">[登录]</a>' ;
        var resist='<a href="register.jsp" style="color: #ff7d48;">[注册]</a>' ;
        $(".rightarea").html(login+resist);
    }
    else {
        var login='<span id="tologin" style="color: #ff7d48;">['+username+']</span>' ;
        var resist='<span id="toregister" style="color: #ff7d48;">[注销]</span>' ;
        $(".rightarea").html(login+resist);
    }
    $.ajax({
        url : "/Block/showShop",
        success : function(result) {
            var json = eval(result);
            var dom = "";
            for (var i = 0; i < json.length; i++) {

                var id = json[i]["id"];
                var img = json[i]["imgUrl"];
                var title = json[i]["title"];
                var price = json[i]["price"];


                dom += '<div class="goodone" id="' + id + '"><img src=' + img + ' width="100%" height:200px>' +
                    '<span style="color: red;"><strong>¥' + price + '</strong><span style="color: white; background-color: red;"> 包邮</span>' +
                    '<span style="float: right;font-size: 13px; text-decoration:underline; "> 评价（220条）</span> </span><h5>' + title + '</h5>' +
                    '<h6 style="color: gray;text-decoration: underline;">大地旗舰店<span style="float: right;">♡488人付款</span></h6></div>';


            }
            $(".showgood").html(dom);

            $(".goodone").click(function() {
                var id = $(this).attr("id");
                window.location.href = "/Block/detail.jsp?id=" + id;

            });


        }
    });
    $("#tologin").click(function () {
        window.location.href="publish_goods.jsp";
    });
    $("#toregister").click(function () {
        $.cookie("username", "", {expires: -1});
        window.location.reload();
    });

});