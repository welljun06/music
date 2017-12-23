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

public class AlbumInfoServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            BusinessService service = new BusinessServiceImpl();
            String cid = request.getParameter("cid");
            String aid = request.getParameter("aid");
            User user = service.find(cid);
            Album album = service.findAlbum(aid);
            List<Song> songs = service.findAlbumSongs(aid);
            request.setAttribute("album",album);
            request.setAttribute("user",user);
            request.setAttribute("songs",songs);
            request.getRequestDispatcher("/AlbumInfo.jsp").forward(request, response);
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
