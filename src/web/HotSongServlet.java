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

public class HotSongServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
                BusinessService service = new BusinessServiceImpl();
                String cid = request.getParameter("cid");
                List<Song> list2 = service.hotSongs();
                request.setAttribute("list2", list2);
                List<Song> list1 = service.newSongs();
                User user = service.find(cid);
                request.setAttribute("list1", list1);
                List<SongList> songLists = service.getHotSongList();
                request.setAttribute("songLists",songLists);
                request.setAttribute("user",user);
                request.getRequestDispatcher("/discover.jsp").forward(request, response);
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
