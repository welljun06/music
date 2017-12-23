package web;

import domain.Song;
import domain.SongList;
import domain.User;
import service.BusinessService;
import service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddListServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            BusinessService service = new BusinessServiceImpl();

            String cid = request.getParameter("cid");
            User user = service.find(cid);
            String lid = service.findFavListId(cid);
            List<Song> songs = service.findSongListSongs(lid);
            request.setAttribute("user",user);
            request.setAttribute("songs",songs);
            request.getRequestDispatcher("/AddList.jsp").forward(request, response);
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
