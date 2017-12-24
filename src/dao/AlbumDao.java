package dao;

import domain.Album;

import java.util.List;

public interface AlbumDao {
    List<Album> find(String c); //模糊查找专辑
    Album findAlbum(String aid); //查找专辑信息
    List<Album> rankAlbum(); //查找热门专辑
}
