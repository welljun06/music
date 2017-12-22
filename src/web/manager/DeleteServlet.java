package web.manager;
import domain.User;
import service.BusinessService;
import service.impl.BusinessServiceImpl;
import util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String sid = request.getParameter("sid");
            BusinessService service = new BusinessServiceImpl();
            service.deletesong(sid);
            request.setAttribute("message", "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "删除失败");
        }
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}