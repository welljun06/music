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
import java.net.URLEncoder;
import java.util.List;
/*添加选中歌曲到歌单*/
public class AddListSongServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            BusinessService service = new BusinessServiceImpl();
            String lname = request.getParameter("lname");
            String cid = request.getParameter("cid");
            String linfo = request.getParameter("linfo");
            String ltype = request.getParameter("ltype");
            User user = service.find(cid);
            //创建歌单
            service.createList(lname,cid,ltype,linfo);
            String lid = service.findListID(cid,lname);
            //添加歌曲
            String[] values = request.getParameterValues("checkDelete");
            int length = values.length;
            for(int i = 0; i < length; i++){
                service.addSongToList(values[i],lid);
            }

            request.setAttribute("user",user);
            request.setAttribute("message","创建成功");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
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
