package com.recruit.entity;

import java.util.Date;

public class Backeducation {
    private Integer beid;
    private String bename;
    private String beducation;
    private String bemajorname;
    private Date bestarttime;
    private Date bestopetime;
    private String reid;

    public Integer getBeid() {
        return beid;
    }

    public void setBeid(Integer beid) {
        this.beid = beid;
    }

    public String getBename() {
        return bename;
    }

    public void setBename(String bename) {
        this.bename = bename;
    }

    public String getBeducation() {
        return beducation;
    }

    public void setBeducation(String beducation) {
        this.beducation = beducation;
    }

    public String getBemajorname() {
        return bemajorname;
    }

    public void setBemajorname(String bemajorname) {
        this.bemajorname = bemajorname;
    }

    public Date getBestarttime() {
        return bestarttime;
    }

    public void setBestarttime(Date bestarttime) {
        this.bestarttime = bestarttime;
    }

    public Date getBestopetime() {
        return bestopetime;
    }

    public void setBestopetime(Date bestopetime) {
        this.bestopetime = bestopetime;
    }

    public String getReid() {
        return reid;
    }

    public void setReid(String reid) {
        this.reid = reid;
    }
}
