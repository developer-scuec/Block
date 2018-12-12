package Filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) {
        String method = request.getParameter("method");
        HttpServletRequest res = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = res.getSession();
        System.out.println(method);
        try {
            Cookie cookies[]=res.getCookies();
            if (method.equals("login")) {

                String path="/login.jsp";
                for(Cookie cookie:cookies){
                    if(cookie.getName().equals("username")){
                        path="/publish_goods";
                        break;
                    }
                }

                resp.sendRedirect(path);
            }
            else if (method.equals("delete")) {


                String path="/register.jsp";

                for(Cookie cookie:cookies){
                    if(cookie.getName().equals("username")){
                       cookie.setMaxAge(0);
                       path="/index.jsp";
                       break;
                    }
                }

                resp.sendRedirect(path);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
