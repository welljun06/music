package domain;

public class Album {
    private int aid;
    private int pid;
    private String aname;
    private String ayear;
    private String ainfo;
    private String pname;

    public int getAid() {
        return aid;
    }

    public int getPid() {
        return pid;
    }

    public String getAname() {
        return aname;
    }

    public String getAyear() {
        return ayear;
    }

    public String getAinfo() {
        return ainfo;
    }
    public String getPname(){
        return pname;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public void setAyear(String ayear) {
        this.ayear = ayear;
    }

    public void setAinfo(String ainfo) {
        this.ainfo = ainfo;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
