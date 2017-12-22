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
//    manager
    String addsinger(String pname,String ptype,String pjpg,String pinfo);
    String addalbum(String aname, String atime, String ainfo,String pid);
    String addsong(String sname,String stime,int scount,String stype,String aid);
    void deletesong(String sid);
}
