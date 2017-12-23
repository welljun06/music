package service.impl;

import dao.*;
import dao.impl.*;
import domain.*;
import service.BusinessService;

import java.util.List;

public class BusinessServiceImpl implements BusinessService{
    private SongDao songDao = new SongDaoImpl();
    private UserDao userDao = new UserDaoImpl();
    private SingerDao singerDao = new SingerDaoImpl();
    private AlbumDao albumDao = new AlbumDaoImpl();
    private ManagerDao managerDao = new ManagerDaoImpl();
    private SongListDao songListDao = new SongListDaoImpl();
    @Override
    public List<Song> getAllSongs(){return songDao.getAll();}
    @Override
    public List<Song> hotSongs(){return songDao.hotSong();}
    @Override
    public List<Song> newSongs(){return songDao.newSong();}
    @Override
    public User loginCheck(User c){return userDao.find(c);}
    @Override
    public User find(String cid){return userDao.find(cid);}
    @Override
    public List<Song> findSongs(String c){return songDao.findSongs(c);}
    @Override
    public List<Singer> findSingers(String c){return singerDao.find(c);}
    @Override
    public List<Album> findAlbums(String c){return albumDao.find(c);}
    @Override
    public Song findSong(String sid){return songDao.findSong(sid);}
    @Override
    public Singer findSinger(String sid,String pname){return singerDao.findSinger(sid,pname);}
    @Override
    public Manager loginCheck(Manager c){return managerDao.find(c);}
    @Override
    public List<SongList> getAllSongList(){return songListDao.getAllSongList();}
    @Override
    public List<Song> findFav(String cid){return songDao.findFavSongs(cid);}
    @Override
    public List<SongList> findSongList(String cid){return songListDao.findSongList(cid);}
    @Override
    public List<SongList> findFavSongList(String cid){return songListDao.findFavSongList(cid);}
    @Override
    public List<Song> findSongListSongs(String lid){return songDao.findSongListSongs(lid);}
    @Override
    public void addFavSong(String cid, String sid){songDao.addFavSong(cid,sid);}
    @Override
    public void delFavSong(String cid, String sid){songDao.delFavSong(cid,sid);}
    @Override
    public String findFavListId(String cid){return songListDao.findFavListID(cid);}
    @Override
    public void colList(String cid, String lid){songListDao.colList(cid,lid);}
    @Override
    public void takeOffList(String cid,String lid){songListDao.takeOffList(cid,lid);}
    @Override
    public List<Song> findAlbumSongs(String aid){return songDao.findAlbumSongs(aid);}
    @Override
    public Album findAlbum(String aid){return albumDao.findAlbum(aid);}
    @Override
    public void createList(String lname, String cid, String ltype,String linfo){songListDao.createList(lname,cid,ltype,linfo);}
    @Override
    public String findListID(String cid, String lname){return songListDao.findListID(cid, lname);}
    @Override
    public void addSongToList(String sid,String lid){songDao.addSongToList(sid,lid);}
    @Override
    public void delList(String lid){songListDao.delList(lid);}
    @Override
    public void addSongCount(String sid){songDao.addSongCount(sid);}
    @Override
    public List<Song> commend(String lid, String stype){return songDao.commend(lid,stype);}
    @Override
    public String findListType(String lid){return songListDao.findListType(lid);}
    //manager
    @Override
    public String addsinger(String pname, String ptype, String pjpg, String pinfo) {
        return managerDao.addsinger(pname,ptype,pjpg,pinfo);
    }

    @Override
    public String addalbum(String aname, String atime, String ainfo, String pid) {
        return managerDao.addalbum(aname,atime,ainfo,pid);
    }

    @Override
    public String addsong(String sname, String stime, int scount, String stype, String aid) {
        return managerDao.addsong(sname,stime,scount,stype,aid);
    }

    @Override
    public void deletesong(String sid) {managerDao.deletesong(sid);}
}
