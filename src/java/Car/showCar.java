package Car;

import addCar.AlterCar;
import addCar.item;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class showCar extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookies[] = request.getCookies();

        String username = null;
        boolean isLogin = false;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                isLogin = true;
                username = cookie.getValue();
                break;
            }
        }
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            Writer writer = response.getWriter();
            if (isLogin) {
                HttpSession session = request.getSession();
                if (session.getAttribute(username) != null) {
                    AlterCar alterCar = (AlterCar) session.getAttribute(username);
                    Map<Integer, item> map = alterCar.getItem();
                    JSONObject jsonObject1=new JSONObject();
                    for(Map.Entry<Integer, item> entry:map.entrySet()){
                        int key=entry.getKey();
                        item value=entry.getValue();
                        JSONObject jsonObject2=new JSONObject();
                        jsonObject2.put("url",value.getUrl());
                        jsonObject2.put("name",value.getName());
                        jsonObject2.put("price",value.getPrice());
                        jsonObject2.put("count",value.getCount());
                        jsonObject1.put(String.valueOf(key),jsonObject2);

                    }

                    String json_info = jsonObject1.toJSONString();
                    writer.write(json_info);
                    System.out.println("json info:" + json_info);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }
}
