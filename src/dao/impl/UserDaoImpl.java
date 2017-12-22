package dao.impl;

import dao.UserDao;
import domain.User;
import util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}