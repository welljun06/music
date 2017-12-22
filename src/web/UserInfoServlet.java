package web;

import domain.Song;
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

public class UserInfoServlet extends HttpServlet {
    //接受表单请求，并处理请求
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            BusinessService service = new BusinessServiceImpl();
            String cid = request.getParameter("cid");
            User user = service.find(cid);
            request.setAttribute("user",user);
            request.getRequestDispatcher("/userInfo.jsp").forward(request, response);
        }
        catch (Exception e) {
            e.printStackTrace();

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        doGet(request, response);
    }
}
