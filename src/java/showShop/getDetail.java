package showShop;

import Database.ConnectDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

public class getDetail {
    private Map<String,String> good=null;
    public getDetail(String id){
        ConnectDatabase connectDatabase=new ConnectDatabase();
        Connection connection=connectDatabase.getConnection();
        String sql="select * from goods where id="+id;
        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet!=null&&resultSet.next()){
                this.good=new LinkedHashMap<>();
                String title=resultSet.getString("title");
                String price=String.valueOf(resultSet.getInt("price"));
                String description=resultSet.getString("description");
                String imgUrl=resultSet.getString("img_url");
                good.put("title",title);
                good.put("price",price);
                good.put("description",description);
                good.put("imgUrl",imgUrl);

            }
            //this.json_info= JSON.toJSONString(goods);

        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public Map<String,String> get_info(){
        return good;
    }

}
