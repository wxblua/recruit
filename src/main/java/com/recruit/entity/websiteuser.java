package com.recruit.entity;

import java.util.Date;

public class websiteuser {
    private Integer wid;
    private String wimage;
    private String wname;
    private String wpwd;
    private Integer position;
    private Integer state;
    private Date createtime;
    private Date updatetime;

    public Integer getWid() {
        return wid;
    }
    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getWimage() {
        return wimage;
    }
    public void setWimage(String wimage) {
        this.wimage = wimage;
    }

    public String getWname() {
        return wname;
    }
    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getWpwd() {
        return wpwd;
    }
    public void setWpwd(String wpwd) {
        this.wpwd = wpwd;
    }

    public Integer getPosition() {
        return position;
    }
    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
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

    @Override
    public String toString() {
        return "websiteuser{" +
                "wid=" + wid +
                ", wimage='" + wimage + '\'' +
                ", wname='" + wname + '\'' +
                ", wpwd='" + wpwd + '\'' +
                ", position=" + position +
                ", state=" + state +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                '}';
    }

}
