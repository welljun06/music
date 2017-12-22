package web.manager;

import domain.Manager;
import domain.User;
import service.BusinessService;
import service.impl.BusinessServiceImpl;
import util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ManagerLoginServlet extends HttpServlet{
    //接受表单请求，并处理请求
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            BusinessService service = new BusinessServiceImpl();
            Manager c = WebUtils.request2Bean(request, Manager.class);
            Manager d = service.loginCheck(c);
            if(d==null) { //如果不存在该用户
                request.setAttribute("message", "登录失败");
                request.getRequestDispatcher("/manager/index.jsp").forward(request, response);
            }
            else { //如果存在用户
                request.setAttribute("manager", d);
                request.getRequestDispatcher("/managerIndex.jsp").forward(request, response);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
