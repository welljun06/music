package domain;

public class User {
    private int cid;
    private String cname;
    private String cpw;
    private String cjpg;
    private String cinfo;

    public int getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    public String getCpw() {
        return cpw;
    }

    public String getCjpg() {
        return cjpg;
    }

    public String getCinfo() {
        return cinfo;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setCpw(String cpw) {
        this.cpw = cpw;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setCjpg(String cjpg) {
        this.cjpg = cjpg;
    }

    public void setCinfo(String cinfo) {
        this.cinfo = cinfo;
    }
}
