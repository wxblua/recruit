package com.recruit.entity;

public class Attention {
    private Integer atid;
    private Integer epid;
    private Object useid;

    public Integer getAtid() {
        return atid;
    }
    public void setAtid(Integer atid) {
        this.atid = atid;
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
        return "Attention{" +
                "atid=" + atid +
                ", epid=" + epid +
                ", useid=" + useid +
                '}';
    }

}
