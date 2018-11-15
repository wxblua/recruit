package com.recruit.entity;

import java.util.Date;

public class Reply {
    private Integer rid;
    private String rcontents;
    private Date rtime;
    private Integer cid;
    private Integer rstate;

    public Integer getRid() {
        return rid;
    }
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRcontents() {
        return rcontents;
    }
    public void setRcontents(String rcontents) {
        this.rcontents = rcontents;
    }

    public Date getRtime() {
        return rtime;
    }
    public void setRtime(Date rtime) {
        this.rtime = rtime;
    }

    public Integer getCid() {
        return cid;
    }
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getRstate() {
        return rstate;
    }
    public void setRstate(Integer rstate) {
        this.rstate = rstate;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "rid=" + rid +
                ", rcontents='" + rcontents + '\'' +
                ", rtime=" + rtime +
                ", cid=" + cid +
                ", rstate=" + rstate +
                '}';
    }

}
