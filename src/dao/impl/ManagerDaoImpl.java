package dao.impl;

import dao.ManagerDao;
import domain.Log;
import domain.Manager;
import domain.User;
import util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ManagerDaoImpl implements ManagerDao{
    @Override
    public Manager find(Manager d) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.GetConnection();
            String sql = "select * from managers WHERE mname=? and mpw=?";
            st = conn.prepareStatement(sql);
            st.setString(1, d.getMname());
            st.setString(2, d.getMpw());
            rs = st.executeQuery();
            Manager c = new Manager();
            while (rs.next()) {
                c.setMid(rs.getInt("mid"));
                c.setMname(rs.getString("mname"));
                c.setMpw(rs.getString("mpw"));
                c.setMbox(rs.getString("mbox"));
            }
            return c;
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }
    public String addsinger(String pname,String ptype,String pjpg,String pinfo)
    {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Statement stmt;
        try{
            conn = JdbcUtils.GetConnection();
            String sql1 = "select * from singers where pname= ?";
            st = conn.prepareStatement(sql1);
            st.setString(1, pname);
            rs = st.executeQuery();
            if(rs.next())
            {
                return rs.getString("pid");
            }
            else{
                String sql = "call add_singer("+pname+","+ptype+","+pjpg+","+pinfo+")";
                stmt =conn.createStatement();
                rs=stmt.executeQuery(sql);
                String sql2="select * from singers where pname= ?";
                st = conn.prepareStatement(sql2);
                st.setString(1, pname);
                rs = st.executeQuery();
                while(rs.next()) {
                    String c = rs.getString("pid");
                    return c;
                }
            }
        } catch (Exception e) {
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }

    @Override
    public String addalbum(String aname, String ayear, String ainfo,String pid) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Statement stmt;
        try{
            conn = JdbcUtils.GetConnection();
            String sql1 = "select * from albums where pid=?";
            st = conn.prepareStatement(sql1);
            st.setString(1, pid);
            rs = st.executeQuery();
            if(rs.next())
            {
                return rs.getString("aid");
            }
            else{
                int ipid=Integer.parseInt(pid);
                String sql2 = "insert into albums(pid,aname,ayear,ainfo) values(?,?,?,?)";
                st = conn.prepareStatement(sql2);
                st.setInt(1, ipid);
                st.setString(2, aname);
                st.setString(3, ayear);
                st.setString(4, ainfo);
                st.executeUpdate();
                String sql3="select * from albums where pid= ?";
                st = conn.prepareStatement(sql3);
                st.setString(1, pid);
                rs = st.executeQuery();
                while(rs.next()) {
                    String c = rs.getString("aid");
                    return c;
                }
            }
        } catch (Exception e) {
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }

    public String addsong(String sname, String stime, int scount, String stype,String aid) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Statement stmt;
        try {
            conn = JdbcUtils.GetConnection();
            String sql1 = "select * from songs where aid=?";
            st = conn.prepareStatement(sql1);
            st.setString(1, aid);
            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString("sid");
            } else {
                int iaid = Integer.parseInt(aid);
                String sql2 = "insert into songs(aid,sname,stime,scount,stype) values(?,?,?,?,?)";
                st = conn.prepareStatement(sql2);
                st.setInt(1, iaid);
                st.setString(2, sname);
                st.setString(3, stime);
                st.setInt(4, scount);
                st.setString(5, stype);
                st.executeUpdate();
                String sql3="select * from songs where aid= ?";
                st = conn.prepareStatement(sql3);
                st.setString(1, aid);
                rs = st.executeQuery();
                while(rs.next()) {
                    String c = rs.getString("sid");
                    return c;
                }
            }
        } catch (Exception e) {
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }

    public void deletesong(String sid) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            String sql = "delete from songs where sid=?";
            st = conn.prepareStatement(sql);
            st.setString(1, sid);
            st.executeUpdate();

        } catch (Exception e) {
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
    private List<Log> setLog(ResultSet rs){
        List<Log> list = new ArrayList<Log>();
        try {
            while (rs.next()) {
                Log c = new Log();
                c.setLogid(rs.getInt("logid"));
                c.setWho(rs.getString("who"));
                c.setTime(rs.getDate("time"));
                c.setTable_name(rs.getString("table_name"));
                c.setOperation(rs.getString("operation"));
                c.setKey_value(rs.getString("key_value"));
                list.add(c);
            }
        } catch (Exception e){
        }
        return list;
    }
    @Override
    public List<Log> getAllLog() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            String sql = "select * from logs";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            List<Log> list = new ArrayList<Log>();
            list = setLog(rs);
            return list;
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }
}
