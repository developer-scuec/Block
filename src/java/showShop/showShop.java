package showShop;

import Socket.Server;
import transmit.Client;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class showShop extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Server server=new Server();
            }
        }).start();
    }

    @Override
    public void destroy() {
        System.out.println("finish");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        getInfo get = new getInfo();
        String info = get.getJson_info();
        try {
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write(info);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }
}
