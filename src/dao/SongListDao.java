package dao;

import domain.SongList;

import java.util.List;

public interface SongListDao {
    List<SongList> getAllSongList();
    List<SongList> findSongList(String cid);
    List<SongList> findFavSongList(String cd);
    String findFavListID(String cid); //找到用户喜爱歌单id
    void colList(String cid, String lid); //用户收藏歌单
    void takeOffList(String cid, String lid); //用户取消收藏歌单
    void createList(String lname, String cid, String ltype,String linfo); //用户创建歌单
    String findListID(String cid,String lname); //根据用户id和歌单名字寻找歌单id
    void delList(String lid); //根据歌单id和删除歌单
    String findListType(String lid); //根据歌单id返回该歌单最多类型
    List<SongList> getHotSongList(); //返回热门歌单
    void addListCount(String lid); //增加歌单播放量
}
