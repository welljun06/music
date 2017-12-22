package web.manager;
import domain.User;
import service.BusinessService;
import service.impl.BusinessServiceImpl;
import util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class AddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //request.getRequestDispatcher("/add.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String pname=request.getParameter("pname");
            String ptype=request.getParameter("ptype");
            String pjpg =request.getParameter("pjpg");
            String pinfo=request.getParameter("pinfo");
            BusinessService service = new BusinessServiceImpl();
            String pid=service.addsinger(pname,ptype,pjpg,pinfo);

            String aname=request.getParameter("aname");
            String ayear=request.getParameter("ayear");
            String ainfo=request.getParameter("ainfo");
            String aid=service.addalbum(aname,ayear,ainfo,pid);

            String sname=request.getParameter("sname");
            String stime=request.getParameter("stime");
            String scount=request.getParameter("scount");
            int iscount=Integer.parseInt(scount);
            String stype=request.getParameter("stype");
            String sid=service.addsong(sname,stime,iscount,stype,aid);
            request.setAttribute("message", "添加成功,歌曲id为:"+sid);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "添加失败");
        }
        request.getRequestDispatcher("/message.jsp").forward(request, response);

    }

}