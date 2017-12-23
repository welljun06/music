package dao.impl;

import dao.SongListDao;
import domain.Song;
import domain.SongList;
import util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SongListDaoImpl implements SongListDao{
    private List<SongList> setSongList(ResultSet rs){
        List<SongList> list = new ArrayList<SongList>();
        try {
            while (rs.next()) {
                SongList c = new SongList();
                c.setCid(rs.getInt("cid"));
                c.setLcount(rs.getInt("lcount"));
                c.setLid(rs.getInt("lid"));
                c.setLinfo(rs.getString("linfo"));
                c.setLname(rs.getString("lname"));
                c.setLtime(rs.getDate("ltime"));
                c.setLtype(rs.getString("ltype"));
                list.add(c);
            }
        } catch (Exception e){
        }
        return list;
    }
    @Override
    public List<SongList> getAllSongList() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            String sql = "select * from lists";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            List<SongList> list = new ArrayList<SongList>();
            list = setSongList(rs);
            return list;
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }
    @Override
    public List<SongList> findSongList(String cid){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            String sql = "select * from lists where cid=?";
            st = conn.prepareStatement(sql);
            st.setString(1, cid);
            rs = st.executeQuery();
            List<SongList> list = new ArrayList<SongList>();
            list = setSongList(rs);
            return list;
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }
    @Override
    public List<SongList> findFavSongList(String cid){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            String sql = "select * from user_list,lists where user_list.cid=? AND user_list.lid=lists.lid;";
            st = conn.prepareStatement(sql);
            st.setString(1, cid);
            rs = st.executeQuery();
            List<SongList> list = new ArrayList<SongList>();
            list = setSongList(rs);
            return list;
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }
    /*找到用户喜爱歌曲歌单*/
    @Override
    public String findFavListID(String cid){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            String sql = "select lid from lists where cid=? and lname like '%喜爱的歌曲%';";
            st = conn.prepareStatement(sql);
            st.setString(1, cid);
            rs = st.executeQuery();
            String lid = null;
            while(rs.next()) {
                lid = rs.getString("lid");
            }
            return lid;
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }
    /*收藏歌单*/
    @Override
    public void colList(String cid, String lid){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            String sql = "insert into user_list value( ?, ?,now());";
            st = conn.prepareStatement(sql);
            st.setString(1, cid);
            st.setString(2, lid);
            st.executeUpdate();
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
    /*用户取消收藏歌单*/
    @Override
    public void takeOffList(String cid, String lid){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            String sql = "DELETE FROM user_list WHERE cid=? and lid=?;";
            st = conn.prepareStatement(sql);
            st.setString(1, cid);
            st.setString(2, lid);
            st.executeUpdate();
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
    /*用户创建自定义歌单*/
    @Override
    public void createList(String lname, String cid, String ltype,String linfo){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            String sql = "INSERT INTO lists(lname,cid,ltype,lcount,ltime,linfo) VALUES (?,?,?,0,now(),?)";
            st = conn.prepareStatement(sql);
            st.setString(1, lname);
            st.setString(2, cid);
            st.setString(3,ltype);
            st.setString(4,linfo);
            st.executeUpdate();
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
    /*根据用户id和歌单名字查找歌单ID*/
    @Override
    public String findListID(String cid,String lname){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            String sql = "select lid from lists where cid=? and lname=?";
            st = conn.prepareStatement(sql);
            st.setString(1, cid);
            st.setString(2, lname);
            rs = st.executeQuery();
            String lid = null;
            while(rs.next()) {
                lid = rs.getString("lid");
            }
            return lid;
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }

}
