package dao;

import domain.SongList;

import java.util.List;

public interface SongListDao {
    List<SongList> getAllSongList();
    List<SongList> findSongList(String cid);
    List<SongList> findFavSongList(String cd);
}
