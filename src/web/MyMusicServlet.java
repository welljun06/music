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

public class MyMusicServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            BusinessService service = new BusinessServiceImpl();
            String cid = request.getParameter("cid");
            User user = service.find(cid);
            List<SongList> songList = service.findSongList(cid);
            List<SongList> favSongList = service.findFavSongList(cid);
            List<Song> songs = service.findFav(cid);
            request.setAttribute("favSongList",favSongList);
            request.setAttribute("songs",songs);
            request.setAttribute("user",user);
            request.setAttribute("songList",songList);
            request.getRequestDispatcher("/myMusic.jsp").forward(request, response);
        }
        catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message","查看歌曲失败");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        doGet(request, response);
    }
}
