package dao;

import domain.Singer;

import java.util.List;

public interface SingerDao {
    List<Singer> find(String c);
    Singer findSinger(String sid,String pname);
}
