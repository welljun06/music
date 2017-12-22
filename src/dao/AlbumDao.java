package dao;

import domain.Album;

import java.util.List;

public interface AlbumDao {
    List<Album> find(String c);
}
