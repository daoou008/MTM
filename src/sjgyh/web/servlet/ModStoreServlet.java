package sjgyh.web.servlet;

import sjgyh.domain.ModStore;
import sjgyh.domain.PageBean;
import sjgyh.service.SearchService;
import sjgyh.service.impl.SearchServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/modStore")
public class ModStoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码，防止乱码
        request.setCharacterEncoding("utf-8");
        //判断，如果不是从登陆页面来，并且用户信息不正确，则返回到登录页面
        HttpSession session = request.getSession();
        try {
            Object user = session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("/index.jsp");
                return;
            }
        } catch (Exception e) {
            response.sendRedirect("/index.jsp");
            return;
        }

        //调用modStore service完成查询
        SearchService service = new SearchServiceImpl();
        List<ModStore> modStores = service.findAllModStore();
        int quantity_sum = 0;
        if (modStores != null && modStores.size() > 0) {
            for (int i = 0; i < modStores.size(); i++) {
                quantity_sum += modStores.get(i).getQuantity();
            }
        }
        //将list存入request域
        request.setAttribute("modStores", modStores);
        request.setAttribute("quantity_sum" , quantity_sum);
        //同理，查找出客户列表，以及客户对应的可用模块库存
        request.setAttribute("customers", service.findAllCustomer());
        //request.setAttribute("cusModFunctions", service.findAllCusModFunc());
        //希望分页查询客户可用模块
        //获取查询条件
        String cusName = request.getParameter("cusName");

        String currentPage = request.getParameter("currentPage");
        if (null == currentPage || "".equals(currentPage)) {
            currentPage = "1";
        }
        String row = request.getParameter("row");
        if (null == row || "".equals(row)) {
            row = "3";
        }
        PageBean pb = service.findPageBean(currentPage, row, cusName);
        request.setAttribute("pb", pb);
        request.setAttribute("cusName", cusName);
        //转发到jsp
        request.getRequestDispatcher("/modStoreList.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
