package register;

import Database.ConnectDatabase;

import javax.servlet.http.*;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Login extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();


        ConnectDatabase connectDatabase = new ConnectDatabase();
        Connection conn = connectDatabase.getConnection();
        String sql = "select password from register where username='" + username + "'";
        try {
            Writer writer=response.getWriter();
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            if (resultSet != null && resultSet.next()) {

                String rePassword = resultSet.getString("password");
                if (password.equals(rePassword)) {

                    Cookie cookie=new Cookie("username",username);
                    Cookie cookie1=new Cookie("password",rePassword);
                    response.addCookie(cookie);
                    List<String> session_info=(List)session.getAttribute("users");
                    if(session_info==null){
                        List<String> users=new ArrayList<>();
                        users.add(username);
                        session.setAttribute("users",users);
                    }else{
                        session_info.add(username);
                    }
                    response.sendRedirect("/Block/index.jsp");



//                    session.setAttribute("username", username);
//                    session.setAttribute("delete", "[注销]");

                } else {

                    writer.write("用户名或者密码错误");


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }
}
