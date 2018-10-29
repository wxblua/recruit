package com.recruit.entity;

import java.util.Date;

public class Advertising {
    private Integer aid;
    private String atitle;
    private String aimage;
    private Date createtime;
    private Date updatetime;
    private Integer positionid;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAtitle() {
        return atitle;
    }

    public void setAtitle(String atitle) {
        this.atitle = atitle;
    }

    public String getAimage() {
        return aimage;
    }

    public void setAimage(String aimage) {
        this.aimage = aimage;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getPositionid() {
        return positionid;
    }

    public void setPositionid(Integer positionid) {
        this.positionid = positionid;
    }

    @Override
    public String toString() {
        return "Advertising{" +
                "aid=" + aid +
                ", atitle='" + atitle + '\'' +
                ", aimage='" + aimage + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", positionid=" + positionid +
                '}';
    }
}
