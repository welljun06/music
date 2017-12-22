package domain;

public class Manager {
    private int mid;
    private String mname;
    private String mpw;
    private String mbox;

    public int getMid() {
        return mid;
    }

    public String getMname() {
        return mname;
    }

    public String getMpw() {
        return mpw;
    }

    public String getMbox() {
        return mbox;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public void setMpw(String mpw) {
        this.mpw = mpw;
    }

    public void setMbox(String mbox) {
        this.mbox = mbox;
    }
}
