package dao;

import domain.Album;

import java.util.List;

public interface AlbumDao {
    List<Album> find(String c);
    Album findAlbum(String aid); //查找专辑信息
}
