$(document).ready(function () {
    $.ajax({
        url: "/Block/car",
        success: function (result) {
            var json=result;
            var dom = "";
            var allPrice=0;
            $.each(json,function (name,value) {
                var img = value["url"];
                var name = value["name"];
                var price = value["price"];
                var count = value["count"];
                var smallcout = price * count;
                allPrice+=smallcout;
                dom += '<div class="cart_cont clearfix">' +
                    '<div class="cart_item t_name">' +
                    '<div class="cart_shopInfo clearfix">' +
                    '<img src="' + img + '">' +
                    '<div class="cart_shopInfo_cont">' +
                    '<p class="cart_link"><a href="#">微信支付</a></p>' +
                    '<p class="cart_info">支付宝支付</p>' +
                    '</div></div></div>' +
                    '<div class="cart_item t_price">' + price + '</div>' +
                    '<div class="cart_item t_return">返现</div>' +
                    '<div class="cart_item t_num">' + count + '</div>' +
                    '<div class="cart_item t_subtotal t_red">' + smallcout + '</div>' +
                    '</div>';
            });

            $(".cart_head").after(dom);
            var all='<span>'+allPrice+'</span>'
            $("#allPrice").after(all)
        },
        error: function (jqXHR, textStatus, errorThrown) {
            /*弹出jqXHR对象的信息*/
            console.log("response text" + jqXHR.responseText);
            console.log("status:" + jqXHR.status);
            console.log("readystate:" + jqXHR.readyState);
            console.log("statustext:" + jqXHR.statusText);
            /*弹出其他两个参数的信息*/
            console.log("textstatus:" + textStatus);
            console.log("errorthrewn:" + errorThrown);

        }
    });
    $("#pay").click(function () {
        var wallet=$("#payForm").val();
        $.ajax({
            data:{
                "walletAddress":wallet
            },
            url: "/Block/pay",
            success: function (result) {
                alert("提交订单成功，等待支付完成");
            }
        });
    });
});