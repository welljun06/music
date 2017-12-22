package dao;

import domain.Manager;

public interface ManagerDao {
    Manager find(Manager c);
    String addsinger(String pname,String ptype,String pjpg,String pinfo);
    String addalbum(String aname, String atime, String ainfo,String pid);
    String addsong(String sname,String stime,int scount,String stype,String aid);
    void deletesong(String sid);
}
