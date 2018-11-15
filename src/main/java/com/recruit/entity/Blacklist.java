package com.recruit.entity;

public class Blacklist {
    private Integer bid;
    private Integer epid;
    private Object useid;

    public Integer getBid() {
        return bid;
    }
    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getEpid() {
        return epid;
    }
    public void setEpid(Integer epid) {
        this.epid = epid;
    }

    public Object getUseid() {
        return useid;
    }
    public void setUseid(Object useid) {
        this.useid = useid;
    }

    @Override
    public String toString() {
        return "Blacklist{" +
                "bid=" + bid +
                ", epid=" + epid +
                ", useid=" + useid +
                '}';
    }
}
