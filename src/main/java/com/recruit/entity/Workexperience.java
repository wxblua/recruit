package com.recruit.entity;

import java.util.Date;

public class Workexperience {

    private Integer wpid;
    private String wpcompanyname;
    private String wpinposition;
    private Date wpstarttime;
    private Date wpstopetime;
    private String wpworkdescribe;
    private Integer reid;
    private Resume resume;

    public Integer getWpid() {
        return wpid;
    }

    public void setWpid(Integer wpid) {
        this.wpid = wpid;
    }

    public String getWpcompanyname() {
        return wpcompanyname;
    }

    public void setWpcompanyname(String wpcompanyname) {
        this.wpcompanyname = wpcompanyname;
    }

    public String getWpinposition() {
        return wpinposition;
    }

    public void setWpinposition(String wpinposition) {
        this.wpinposition = wpinposition;
    }

    public Date getWpstarttime() {
        return wpstarttime;
    }

    public void setWpstarttime(Date wpstarttime) {
        this.wpstarttime = wpstarttime;
    }

    public Date getWpstopetime() {
        return wpstopetime;
    }

    public void setWpstopetime(Date wpstopetime) {
        this.wpstopetime = wpstopetime;
    }

    public String getWpworkdescribe() {
        return wpworkdescribe;
    }

    public void setWpworkdescribe(String wpworkdescribe) {
        this.wpworkdescribe = wpworkdescribe;
    }

    public Integer getReid() {
        return reid;
    }

    public void setReid(Integer reid) {
        this.reid = reid;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }
}
