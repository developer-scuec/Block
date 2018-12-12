package showShop;

import Database.ConnectDatabase;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class getInfo {
    private Map<String,String> good=null;
    private List<Map<String,String>> goods=new ArrayList<>();
    private String json_info=null;
    public getInfo(){
        ConnectDatabase connectDatabase=new ConnectDatabase();
        Connection connection=connectDatabase.getConnection();
        String sql="select * from goods";
        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet!=null&&resultSet.next()){
                this.good=new LinkedHashMap<>();
                int id=resultSet.getInt("id");
                String title=resultSet.getString("title");
                String price=String.valueOf(resultSet.getInt("price"));
                String description=resultSet.getString("description");
                String imgUrl=resultSet.getString("img_url");
                good.put("id",String.valueOf(id));
                good.put("title",title);
                good.put("price",price);
                good.put("description",description);
                good.put("imgUrl",imgUrl);
                goods.add(good);
            }
            this.json_info= JSON.toJSONString(goods);

        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public String getJson_info(){
        return this.json_info;
    }
}
