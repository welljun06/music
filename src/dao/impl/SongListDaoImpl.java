package dao.impl;

import dao.SongListDao;
import domain.Song;
import domain.SongList;
import util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

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
    /*根据歌单id删除歌单*/
    @Override
    public void delList(String lid){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            //先删除该歌单与歌曲的连接
            String sql = "DELETE FROM song_list WHERE lid=?";
            st = conn.prepareStatement(sql);
            st.setString(1, lid);
            st.executeUpdate();
            //删除该歌单
            sql = "DELETE FROM lists WHERE lid=?";
            st = conn.prepareStatement(sql);
            st.setString(1, lid);
            st.executeUpdate();
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
    /*根据歌单id返回歌单最多类型*/
    @Override
    public String findListType(String lid){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.GetConnection();
            //得到用户favsong的stype的list
            String sql = "select stype from songs,song_list where songs.sid = song_list.sid and lid=?;";
            st = conn.prepareStatement(sql);
            st.setString(1, lid);
            rs = st.executeQuery();
            //得到用户喜爱歌单中
            Map<String, Integer> stype = new HashMap<String , Integer>();
            while(rs.next()){
                String type = rs.getString("stype");
                if(!stype.containsKey(type)){
                    stype.put(type,0);
                }
                else{
                    Integer count = stype.get(type);
                    stype.put(type,++count);
                }
            }
            //找出次数最大的stype
            Iterator<Map.Entry<String, Integer>> entries = stype.entrySet().iterator();
            int count = 0;
            String type = null;
            while (entries.hasNext()) {
                Map.Entry<String, Integer> entry = entries.next();
                if(entry.getValue()>count){
                    count = entry.getValue();
                    type = entry.getKey();
                }
            }
            return type;
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }
}
