package web;

import domain.Song;
import domain.SongList;
import service.BusinessService;
import service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AllSongServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            BusinessService service = new BusinessServiceImpl();
            List<SongList> songLists = service.getAllSongList();
            //通过request打包list
            request.setAttribute("songLists", songLists);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
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
