package addCar;

import showShop.getDetail;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class Car extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        Cookie cookies[]=req.getCookies();
        Writer out=resp.getWriter();
        String username=null;
        boolean isLogin=false;
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("username")){
                username=cookie.getValue();
                isLogin=true;
                break;
            }
        }
        if(!isLogin){

            out.write("请先登录账号");
        }else {
            String id=req.getParameter("id");
            int count=Integer.parseInt(req.getParameter("count"));
            getDetail getInfo=new getDetail(id);
            Map<String,String> info=getInfo.get_info();


            int index=Integer.parseInt(id);
            String url=info.get("imgUrl");
            String name=info.get("title");
            int price = Integer.parseInt(info.get("price"));
            HttpSession session=req.getSession();
            item i=new item(index,url,name,price,count);
            if(session.getAttribute(username)==null){
                AlterCar alterCar=new AlterCar();
                alterCar.add(i);
                session.setAttribute(username,alterCar);

            }else {
                AlterCar alterCar=(AlterCar)session.getAttribute(username);
                alterCar.add(i);
            }
            out.write("添加购物车成功");




        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
