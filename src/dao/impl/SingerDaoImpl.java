package dao.impl;

import dao.SingerDao;
import domain.Singer;

import util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SingerDaoImpl implements SingerDao{
    private List<Singer> setSinger(ResultSet rs){
        List<Singer> list = new ArrayList<Singer>();
        try {
            while (rs.next()) {
                Singer c = new Singer();
                c.setPid(rs.getInt("pid"));
                c.setPname(rs.getString("pname"));
                c.setPtype(rs.getString("ptype"));
                c.setPjpg(rs.getString("pjpg"));
                c.setPinfo(rs.getString("pinfo"));
                list.add(c);
            }
        } catch (Exception e){

        }
        return list;
    }
    @Override
    public List<Singer> find(String c) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            String sql = "select * from singers where pname LIKE ? ";
            st = conn.prepareStatement(sql);
            st.setString(1, "%"+c+"%");
            rs = st.executeQuery();
            List<Singer> list = new ArrayList<Singer>();
            list = setSinger(rs);
            return list;
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }
    /*按照歌曲id和歌手名字定位歌手*/
    @Override
    public Singer findSinger(String sid,String pname) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Statement stmt;
        try {
            conn = JdbcUtils.GetConnection();
            stmt=conn.createStatement();
            //String sql = "select * from singers,songs,albums where sid=? and pname=? and singers.pid = albums.pid and albums.aid = songs.aid";
            String sql = "call find_singer_pro("+sid+",'"+pname+"')";
            //st = conn.prepareStatement(sql);
            //st.setString(1, sid);
            //st.setString(2,pname);
            rs = stmt.executeQuery(sql);
            Singer c = new Singer();
            while (rs.next()){
                c.setPid(rs.getInt("pid"));
                c.setPname(rs.getString("pname"));
                c.setPtype(rs.getString("ptype"));
                c.setPjpg(rs.getString("pjpg"));
                c.setPinfo(rs.getString("pinfo"));
            }
            return c;
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }
    @Override
    public String getSingerId(String sid, String pname){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            String sql = "select singers.pid from singers,albums,songs where singers.pid=albums.pid and albums.aid=songs.aid and singers.pname=? and sid=?;";
            st = conn.prepareStatement(sql);
            st.setString(1, pname);
            st.setString(2, sid);
            rs = st.executeQuery();
            String pid=null;
            while (rs.next()){
                pid=rs.getString("pid");
            }
            return pid;
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }
}
