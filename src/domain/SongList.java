package domain;

import java.util.Date;

public class SongList {
    private int lid;
    private String lname;
    private int cid;
    private String ltype;
    private int lcount;
    private Date ltime;
    private String linfo;

    public int getLid() {
        return lid;
    }

    public String getLname() {
        return lname;
    }

    public int getCid() {
        return cid;
    }

    public String getLtype() {
        return ltype;
    }

    public int getLcount() {
        return lcount;
    }

    public Date getLtime() {
        return ltime;
    }

    public String getLinfo() {
        return linfo;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setLcount(int lcount) {
        this.lcount = lcount;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public void setLinfo(String linfo) {
        this.linfo = linfo;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setLtime(Date ltime) {
        this.ltime = ltime;
    }

    public void setLtype(String ltype) {
        this.ltype = ltype;
    }

}
