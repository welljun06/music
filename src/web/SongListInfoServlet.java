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
import java.util.List;

public class SongListInfoServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            BusinessService service = new BusinessServiceImpl();
            String lid = request.getParameter("lid");
            String lname = request.getParameter("lname");
            String cid = request.getParameter("cid");
            User user = service.find(cid);
            List<Song> songs = service.findSongListSongs(lid);
            request.setAttribute("lname",lname);
            request.setAttribute("user",user);
            request.setAttribute("songs",songs);
            request.getRequestDispatcher("/SongListInfo.jsp").forward(request, response);
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
