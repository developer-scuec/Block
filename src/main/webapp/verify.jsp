<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %><%--
  Created by IntelliJ IDEA.
  User: liangzehua
  Date: 2018-12-10
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>verify</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String driver="com.mysql.jdbc.Driver";
    Class.forName(driver);
    String dbname="root";
    String dbpassword="lzh199801";
    String url="jdbc:mysql://localhost:3306/java?useSSL=false&allowPublicKeyRetrieval=true";
    try{
        Connection conn=DriverManager.getConnection(url,dbname,dbpassword);
        String sql = "select password from register where username='" + username + "'";
        Statement st = conn.createStatement();
        ResultSet resultSet = st.executeQuery(sql);
        if (resultSet != null && resultSet.next()) {

            String rePassword = resultSet.getString("password");
            if (password.equals(rePassword)) {

                Cookie cookie=new Cookie("username",username);
                Cookie cookie1=new Cookie("password",rePassword);
                response.addCookie(cookie);
                response.addCookie(cookie1);
                response.sendRedirect("index.jsp");

            } else {
                response.sendRedirect("loginFail.jsp");
            }
        }
    }catch (Exception e){
        e.printStackTrace();
    }
%>

<%--<jsp:forward page="loginFail.jsp"></jsp:forward>--%>
</body>
</html>
