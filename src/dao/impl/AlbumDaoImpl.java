package dao.impl;

import dao.AlbumDao;
import domain.Album;
import domain.Singer;
import util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlbumDaoImpl implements AlbumDao{
    private List<Album> setAlbum(ResultSet rs){
        List<Album> list = new ArrayList<Album>();
        try {
            while (rs.next()) {
                Album c = new Album();
                c.setPid(rs.getInt("pid"));
                c.setAid(rs.getInt("aid"));
                c.setAinfo(rs.getString("ainfo"));
                c.setAname(rs.getString("aname"));
                c.setAyear(rs.getString("ayear"));
                c.setPname(rs.getString("pname"));
                list.add(c);
            }
        } catch (Exception e){

        }
        return list;
    }
    @Override
    public List<Album> find(String c){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            String sql = "select * from albums, singers where aname LIKE ? and albums.pid=singers.pid";
            st = conn.prepareStatement(sql);
            st.setString(1, "%"+c+"%");
            rs = st.executeQuery();
            List<Album> list = new ArrayList<Album>();
            list = setAlbum(rs);
            return list;
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }
    /*按照专辑id查找歌曲*/
    @Override
    public Album findAlbum(String aid){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            String sql = "select * from albums,singers where aid = ? and singers.pid=albums.pid";
            st = conn.prepareStatement(sql);
            st.setString(1, aid);
            rs = st.executeQuery();
            Album c = new Album();
            while (rs.next()) {
                c.setPid(rs.getInt("pid"));
                c.setAid(rs.getInt("aid"));
                c.setAinfo(rs.getString("ainfo"));
                c.setAname(rs.getString("aname"));
                c.setAyear(rs.getString("ayear"));
                c.setPname(rs.getString("pname"));
            }
            return c;
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }
}
