package web;

import domain.User;
import service.BusinessService;
import service.impl.BusinessServiceImpl;
import util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class loginServlet extends HttpServlet{
    //接受表单请求，并处理请求
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            BusinessService service = new BusinessServiceImpl();
            User c = WebUtils.request2Bean(request, User.class);
            User d = service.loginCheck(c);
            if(d==null) { //如果不存在该用户
                request.setAttribute("message", "登录失败");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            else { //如果存在用户
                request.setAttribute("user", d);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
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
