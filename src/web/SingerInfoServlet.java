package web;

import domain.Singer;
import domain.Song;
import domain.User;
import service.BusinessService;
import service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SingerInfoServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            BusinessService service = new BusinessServiceImpl();
            String cid = request.getParameter("cid");
            String sid = request.getParameter("sid");
            String pname = request.getParameter("pname");
            String pid = service.getSingerId(sid,pname);
            List<Song> songs = service.getSingerSong(pid);
            User user = service.find(cid);
            Singer singer = service.findSinger(sid,pname);
            request.setAttribute("songs",songs);
            request.setAttribute("user",user);
            request.setAttribute("singer",singer);
            request.getRequestDispatcher("/SingerInfo.jsp").forward(request, response);
        }
        catch (Exception e) {   e.printStackTrace();

        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        doGet(request, response);
    }
}
