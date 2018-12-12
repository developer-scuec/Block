package register;

import Database.ConnectDatabase;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class registerClass extends HttpServlet {
    public void doGet(HttpServletRequest res, HttpServletResponse resp){
        doPost(res,resp);
    }
    public void doPost(HttpServletRequest res, HttpServletResponse resp){
        String username=res.getParameter("username");
        String password=res.getParameter("password");
        ConnectDatabase connectDatabase=new ConnectDatabase();
        Connection conn=connectDatabase.getConnection();
        String sql="insert into register(username,password) values (?,?)";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            int result=ps.executeUpdate();
            if(result>0){
                resp.sendRedirect("/Block/login.jsp");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}



