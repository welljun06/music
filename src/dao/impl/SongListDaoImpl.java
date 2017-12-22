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
}
