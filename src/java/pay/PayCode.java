package pay;
import Database.ConnectDatabase;
import addCar.AlterCar;
import addCar.item;
import com.alibaba.fastjson.JSONObject;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import static Socket.Server.payInfo;

public class PayCode extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String walletAddress=request.getParameter("walletAddress");
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
            if (isLogin) {
                HttpSession session = request.getSession();
                if (session.getAttribute(username) != null) {
                    AlterCar alterCar = (AlterCar) session.getAttribute(username);
                    Map<Integer, item> map = alterCar.getItem();
                    JSONObject jsonObject1=new JSONObject();
                    long allMoney=0;
                    for(Map.Entry<Integer, item> entry:map.entrySet()){
                        int key=entry.getKey();
                        item value=entry.getValue();
                        int price=value.getPrice();
                        int count=value.getCount();
                        allMoney=allMoney+(price*count);
                        JSONObject jsonObject2=new JSONObject();
                        jsonObject2.put("name",value.getName());
                        jsonObject2.put("price",value.getPrice());
                        jsonObject2.put("count",value.getCount());
                        jsonObject1.put(String.valueOf(key),jsonObject2);
                        JSONObject info=new JSONObject();
                        info.put("fromWalletAddress",walletAddress);
                        info.put("shopData",jsonObject1.toJSONString());
                        info.put("allPrice",allMoney);
                        info.put("toWalletAddress",getWalletAddress(key));
                        info.put("preString","pay");
                        try {
                            payInfo(walletAddress,info.toJSONString());
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }



                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        doPost(request,response);
    }
    public String getWalletAddress(int index) throws Exception{
        ConnectDatabase connectDatabase=new ConnectDatabase();
        Connection connection=connectDatabase.getConnection();
        Statement st=connection.createStatement();
        String sql="select pay from goods where id="+"'"+index+"'";
        ResultSet resultSet=st.executeQuery(sql);
        while (resultSet!=null&&resultSet.next()){
            String walletAddress=resultSet.getString(1);
            return walletAddress;
        }
        return null;
    }
}
