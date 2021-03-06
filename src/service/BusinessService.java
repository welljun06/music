package service;

import domain.*;

import java.util.List;

public interface BusinessService {
    List<Song> getAllSongs();
    List<Song> hotSongs();
    List<Song> newSongs();
    Song findSong(String sid);
    User loginCheck(User c);
    User find(String cid);
    List<Song> findSongs(String c);
    List<Singer> findSingers(String c);
    List<Album> findAlbums(String c);
    Singer findSinger(String sid,String pname);
    Manager loginCheck(Manager c);
    List<SongList> getAllSongList();
    List<Song> findFav(String cid);
    List<SongList> findSongList(String cid);
    List<SongList> findFavSongList(String cid);
    List<Song> findSongListSongs(String lid);
    void addFavSong(String cid, String sid);
    void delFavSong(String cid, String sid);
    String findFavListId(String cid); //找到用户的喜爱歌曲歌单ID
    void colList(String cid, String lid); //用户收藏歌单
    void takeOffList(String cid, String lid); //用户取消收藏歌单
    List<Song> findAlbumSongs(String aid); //查找专辑歌曲
    Album findAlbum(String aid); //按照专辑id查找信息
    void createList(String lname, String cid, String ltype,String linfo); //用户自定义歌单
    String findListID(String cid, String lname); //根据用户id和歌单名字查找歌单ID
    void addSongToList(String sid,String lid); //添加歌曲到歌单
    void delList(String lid); //删除歌单
    void addSongCount(String sid); //增加播放次数
    List<Song> commend(String lid,String stype); //根据用户爱歌单id和类型推荐歌曲
    String findListType(String lid); //根据歌单id返回类型
    List<Album> rankAlbum(); //返回热门专辑
    List<SongList> getHotSongList(); //返回热门歌单
    List<Song> getSingerSong(String pid); //返回该歌手所有歌
    String getSingerId(String sid,String pname); //返回该歌手的id
    void addListCount(String lid); //增加歌曲播放量
//    manager
    String addsinger(String pname,String ptype,String pjpg,String pinfo);
    String addalbum(String aname, String atime, String ainfo,String pid);
    String addsong(String sname,String stime,int scount,String stype,String aid);
    void deletesong(String sid);
    List<Log> getAllLog();
    int addUser(String cid,String cname,String cpw,String cjpg,String cinfo);
}
