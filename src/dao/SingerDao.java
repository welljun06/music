package dao;

import domain.Singer;

import java.util.List;

public interface SingerDao {
    List<Singer> find(String c);
    Singer findSinger(String sid,String pname); //根据歌手名字和歌曲id找到歌手
    String getSingerId(String sid,String pname); //根据歌手名字和id找到歌手id
}
