package dao.impl;

import dao.UserDao;
import domain.User;
import util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{
    private User setUser(ResultSet rs){
        User c = new User();
        try {
            while (rs.next()) {
                c.setCid(rs.getInt("cid"));
                c.setCname(rs.getString("cname"));
                c.setCpw(rs.getString("cpw"));
                c.setCjpg(rs.getString("cjpg"));
                c.setCinfo(rs.getString("cinfo"));
            }
        } catch (Exception e){

        }
        return c;
    }
    @Override
    public User find (User d){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.GetConnection();
            String sql = "select * from users WHERE cname=? and cpw=?";
            st = conn.prepareStatement(sql);
            st.setString(1, d.getCname());
            st.setString(2, d.getCpw());
            rs = st.executeQuery();
            User c = setUser(rs);
            return c;

        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }
    @Override
    public User find (String cid){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.GetConnection();
            String sql = "select * from users WHERE cid=?";
            st = conn.prepareStatement(sql);
            st.setString(1, cid);
            rs = st.executeQuery();
            User c = setUser(rs);
            return c;
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }
    @Override
    public int addUser(String cid, String cname, String cpw,String cjpg, String cinfo) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Statement stmt;
        int flag=1;
        try {
            conn = JdbcUtils.GetConnection();
            String sql1 = "select * from users where cid=?";
            st = conn.prepareStatement(sql1);
            st.setString(1, cid);
            rs = st.executeQuery();
            if (rs.next()) {
                flag=0;
            } else {
                String sql2 = "insert into users(cid,cname,cpw,cjpg,cinfo) values(?,?,?,?,?)";
                st = conn.prepareStatement(sql2);
                int icid=Integer.parseInt(cid);
                st.setInt(1, icid);
                st.setString(2, cname);
                st.setString(3, cpw);
                st.setString(4, cjpg);
                st.setString(5, cinfo);
                st.executeUpdate();

                String sql5="select * from users where cid= ?";
                st = conn.prepareStatement(sql5);
                st.setString(1, cid);
                rs = st.executeQuery();
                rs.next();
                String name=rs.getString("cname");
                String lname1=name+"喜欢的歌曲";
                String sql4="insert into lists(lname,cid,ltype,lcount,ltime,linfo) values(?,?,'流行音乐',0,current_timestamp(),'喜欢的歌曲')";
                st = conn.prepareStatement(sql4);
                st.setString(1, lname1);
                st.setInt(2, icid);
                st.executeUpdate();

                String sql3="select * from users where cid= ?";
                st = conn.prepareStatement(sql3);
                st.setString(1, cid);
                rs = st.executeQuery();
                while(rs.next()) {
                    flag=1;
                }
            }
        } catch (Exception e) {
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return flag;
    }
}