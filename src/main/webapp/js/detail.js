$(document).ready(function () {
    var username=$.cookie("username");
    if(username==null){
        var login='<a href="login.jsp" style="color: #ff7d48;">[登录]</a>' ;
        var resist='<a href="register.jsp" style="color: #ff7d48;">[注册]</a>' ;
        $(".rightplace").html(login+resist);
    }
    else {
        var login='<span id="tologin" style="color: #ff7d48;">['+username+']</span>' ;
        var resist='<span id="toregister" style="color: #ff7d48;">[注销]</span>' ;
        $(".rightplace").html(login+resist);
    }
    $("#tologin").click(function () {
        window.location.href="publish_goods.jsp";
    });
    $("#toregister").click(function () {
        $.cookie("username", "", {expires: -1});
        window.location.reload();
    });
    $(".shopping_btn").click(function () {
        var id=$(".description").attr("id");
        var count=$("input[name='count']").val();
        $.ajax({
            url:"/Block/addCar",
            data:{
                "id":id,
                "count":count
            },
            success:function (result) {
                alert(result);
                window.location.reload();
            }
        });
    });

});