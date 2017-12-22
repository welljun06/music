package dao.impl;

import dao.SongDao;
import domain.Song;
import util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SongDaoImpl implements SongDao{
    private List<Song> setSong(ResultSet rs){
        List<Song> list = new ArrayList<Song>();
        try {
            while (rs.next()) {
                Song c = new Song();
                c.setSid(rs.getInt("sid"));
                c.setAid(rs.getInt("aid"));
                c.setScount(rs.getInt("scount"));
                c.setSname(rs.getString("sname"));
                c.setStime(rs.getString("stime"));
                c.setStype(rs.getString("stype"));
                c.setAname(rs.getString("aname"));
                c.setPname(rs.getString("pname"));
                list.add(c);
            }
        } catch (Exception e){

        }
        return list;
    }
    @Override
    public List<Song> getAll(){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            String sql = "select * from songs";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            List<Song> list = new ArrayList<Song>();

            list = setSong(rs);
            return list;
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }
    @Override
    public List<Song> hotSong(){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            String sql = "select * from albums,songs,singers where songs.aid = albums.aid and albums.pid = singers.pid order by scount desc LIMIT 10 OFFSET 0;";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            List<Song> list = new ArrayList<Song>();
            list = setSong(rs);
            return list;
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }
    @Override
    public List<Song> newSong(){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            String sql = "select * from albums,songs,singers where songs.aid = albums.aid and albums.pid = singers.pid " +
                    "order by albums.ayear desc LIMIT 10 OFFSET 0";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            List<Song> list = new ArrayList<Song>();
            list = setSong(rs);
            return list;
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }
    @Override
    public List<Song> findSongs(String c){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            String sql = "select * from albums,songs,singers where sname LIKE ? and songs.aid = albums.aid and albums.pid = singers.pid";
            st = conn.prepareStatement(sql);
            st.setString(1, "%"+c+"%");
            rs = st.executeQuery();
            List<Song> list = new ArrayList<Song>();
            list = setSong(rs);
            return list;
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }
    @Override
    public Song findSong(String sid){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            String sql = "select * from albums,songs,singers where sid=? and songs.aid = albums.aid and albums.pid = singers.pid";
            st = conn.prepareStatement(sql);
            st.setString(1, sid);
            rs = st.executeQuery();
            Song c = new Song();
            while (rs.next()){
                c.setSid(rs.getInt("sid"));
                c.setAid(rs.getInt("aid"));
                c.setScount(rs.getInt("scount"));
                c.setSname(rs.getString("sname"));
                c.setStime(rs.getString("stime"));
                c.setStype(rs.getString("stype"));
                c.setAname(rs.getString("aname"));
                c.setPname(rs.getString("pname"));
            }
            return c;
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }
    @Override
    public List<Song> findFavSongs(String cid){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            String sql = "(select sname,aname,pname,stime,stype,songs.sid,albums.aid,scount from singers,albums,songs,song_list,lists,users,user_list where users.cid= ? and users.cid =lists.cid and lists.lid = song_list.lid and song_list.sid = songs.sid and songs.aid = albums.aid and singers.pid = albums.pid )" +
                    "UNION " +
                    "(select sname,aname,pname,stime,stype,songs.sid,albums.aid,scount from singers,albums,songs,song_list,lists,users,user_list where users.cid= ? and users.cid = user_list.cid and user_list.lid = lists.lid AND lists.lid = song_list.lid and song_list.sid = songs.sid and songs.aid = albums.aid and singers.pid = albums.pid);";
            st = conn.prepareStatement(sql);
            st.setString(1, cid);
            st.setString(2, cid);
            rs = st.executeQuery();
            List<Song> list = new ArrayList<Song>();
            list = setSong(rs);
            return list;
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }
    @Override
    public List<Song> findSongListSongs(String lid){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            String sql = "select * from lists,song_list,songs,albums,singers where lists.lid=? " +
                    "and songs.aid=albums.aid and albums.pid = singers.pid and songs.sid = song_list.sid and lists.lid = song_list.lid";
            st = conn.prepareStatement(sql);
            st.setString(1, lid);
            rs = st.executeQuery();
            List<Song> list = new ArrayList<Song>();
            list = setSong(rs);
            return list;
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }
    @Override
    public void addFavSong(String cid, String sid){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            /*先找到用户喜爱歌单id*/
            String sql = "select lid from lists where cid=? and lname like '%喜爱的歌曲%'";
            st = conn.prepareStatement(sql);
            st.setString(1, cid);
            rs = st.executeQuery();
            String lid = null;
            while(rs.next()) {
                lid = rs.getString("lid");
            }
            /*插入歌曲到对应的歌单*/
            sql = "INSERT INTO song_list VALUES (?,?,now())";
            st = conn.prepareStatement(sql);
            st.setString(1, sid);
            st.setString(2, lid);
            st.executeUpdate();
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
    @Override
    public void delFavSong(String cid, String sid){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            /*先找到用户喜爱歌单id*/
            String sql = "select lid from lists where cid=? and lname like '%喜爱的歌曲%'";
            st = conn.prepareStatement(sql);
            st.setString(1, cid);
            rs = st.executeQuery();
            String lid = null;
            while(rs.next()) {
                lid = rs.getString("lid");
            }
            /*插入歌曲到对应的歌单*/
            sql = "DELETE FROM song_list WHERE sid=? AND lid=?";
            st = conn.prepareStatement(sql);
            st.setString(1, sid);
            st.setString(2, lid);
            st.executeUpdate();
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}
