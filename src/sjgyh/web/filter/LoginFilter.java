package sjgyh.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //转成http request
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //获取请求路径
        String uri = request.getRequestURI();
        //判断资源是否和login有关，或者是否包含user的session如果是，直接放行，否则，跳转到Login.jsp
        //另外还需要排除一些css,js等资源
        if (uri.endsWith("index.jsp")) {
            //判断默认页面
            request.setAttribute("login_msg", "您尚未登录，请登录!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        if (uri.endsWith("login.jsp") || uri.endsWith("login") || null != request.getSession().getAttribute("user")
                ||uri.contains("/css/") || uri.contains("/fonts/") || uri.contains("/js/") || uri.contains("/img/")) {
            chain.doFilter(request, response);
        } else {
            request.setAttribute("login_msg", "您尚未登录，请登录!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            //response.sendRedirect("/login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {

    }

}
