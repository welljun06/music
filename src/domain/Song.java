package domain;

public class Song {
    private int sid;
    private int aid;
    private String sname;
    private String stime;
    private int scount;
    private String stype;
    private String aname;
    private String pname;

    public int getSid() {
        return sid;
    }

    public int getAid() {
        return aid;
    }

    public String getSname() {
        return sname;
    }

    public String getStime() {
        return stime;
    }

    public int getScount() {
        return scount;
    }

    public String getStype() {
        return stype;
    }

    public String getAname() {
        return aname;
    }

    public String getPname() {
        return pname;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public void setScount(int scount) {
        this.scount = scount;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
