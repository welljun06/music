package web;

import domain.Album;
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

public class SearchServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            BusinessService service = new BusinessServiceImpl();
            String cid = request.getParameter("cid");
            String search = request.getParameter("search");
            List<Song> songs = service.findSongs(search);
            List<Singer> singers = service.findSingers(search);
            List<Album> albums = service.findAlbums(search);
            User user = service.find(cid);
            request.setAttribute("user",user);
            request.setAttribute("songs", songs);
            request.setAttribute("singers", singers);
            request.setAttribute("albums",albums);
            request.getRequestDispatcher("/search.jsp").forward(request, response);
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
