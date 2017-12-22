package domain;

public class Singer {
    private int pid;
    private String pname;
    private String ptype;
    private String pjpg;
    private String pinfo;

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public void setPjpg(String pjpg) {
        this.pjpg = pjpg;
    }

    public void setPinfo(String pinfo) {
        this.pinfo = pinfo;
    }

    public int getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public String getPtype() {
        return ptype;
    }

    public String getPjpg() {
        return pjpg;
    }

    public String getPinfo() {
        return pinfo;
    }
}
