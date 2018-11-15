package com.recruit.entity;

public class Collections {
    private Integer coid;
    private Integer infoid;
    private Object useid;

    public Integer getCoid() {
        return coid;
    }
    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    public Integer getInfoid() {
        return infoid;
    }
    public void setInfoid(Integer infoid) {
        this.infoid = infoid;
    }

    public Object getUseid() {
        return useid;
    }
    public void setUseid(Object useid) {
        this.useid = useid;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "coid=" + coid +
                ", infoid=" + infoid +
                ", useid=" + useid +
                '}';
    }
}
