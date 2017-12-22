package web;

import domain.Song;
import domain.User;
import service.BusinessService;
import service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PlayServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            BusinessService service = new BusinessServiceImpl();
            String cid = request.getParameter("cid");
            String sid = request.getParameter("sid");
            User user = service.find(cid);
            Song song = service.findSong(sid);
            request.setAttribute("user",user);
            request.setAttribute("song",song);
            request.getRequestDispatcher("/play.jsp").forward(request, response);
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
