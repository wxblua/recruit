package com.recruit.entity;

import java.util.Date;

public class Complain {
    private Integer cid;
    private String ccontents;
    private String cimage;
    private Date ctime;

    public Integer getCid() {
        return cid;
    }
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCcontents() {
        return ccontents;
    }
    public void setCcontents(String ccontents) {
        this.ccontents = ccontents;
    }

    public String getCimage() {
        return cimage;
    }
    public void setCimage(String cimage) {
        this.cimage = cimage;
    }

    public Date getCtime() {
        return ctime;
    }
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "Complain{" +
                "cid=" + cid +
                ", ccontents='" + ccontents + '\'' +
                ", cimage='" + cimage + '\'' +
                ", ctime=" + ctime +
                '}';
    }

}

