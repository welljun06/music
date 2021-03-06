package web;

import domain.SongList;
import domain.User;
import service.BusinessService;
import service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

public class AddFavSongServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            BusinessService service = new BusinessServiceImpl();
            String cid = request.getParameter("cid");
            String sid = request.getParameter("sid");
            service.addFavSong(cid,sid);
            User user = service.find(cid);
            request.setAttribute("message","收藏成功!");
            request.setAttribute("user",user);
//            JOptionPane.showMessageDialog(null, "登录成功", "提示", JOptionPane.WARNING_MESSAGE);
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }
        catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message","收藏失败~");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        doGet(request, response);
    }
}
