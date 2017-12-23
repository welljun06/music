package dao;

import domain.Song;

import java.util.List;

public interface SongDao {
    List<Song> getAll();
    List<Song> hotSong();
    List<Song> newSong();
    List<Song> findSongs(String c);
    Song findSong(String sid);
    List<Song> findFavSongs(String cid);
    List<Song> findSongListSongs(String lid);
    void addFavSong(String cid, String sid);
    void delFavSong(String cid, String sid);
    List<Song> findAlbumSongs(String aid); //找到专辑里面的歌曲
    void addSongToList(String sid,String lid); //添加歌曲到歌单
}
