package sjgyh.web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import sjgyh.domain.User;
import sjgyh.service.UserService;
import sjgyh.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码，防止乱码
        request.setCharacterEncoding("utf-8");
        //获取session
        HttpSession session = request.getSession();
        //获取请求参数
        Map<String, String[]> map = request.getParameterMap();
        //验证用户名密码
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService service = new UserServiceImpl();
        User user = service.login(loginUser);
        if (user != null) {
            //验证通过
            session.setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/modStore");
        } else {
            //验证失败
            //移除用户session信息，防止别人使用登录过的session
            session.removeAttribute("user");
            request.setAttribute("login_msg", "用户名或密码错误!");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
