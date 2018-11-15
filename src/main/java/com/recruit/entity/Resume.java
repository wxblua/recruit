package com.recruit.entity;

import java.util.List;

public class Resume {

    private Integer reid;
    private String rename;   //姓名
    private String resex;     //性别
    private Integer reage;    //年龄
    private String dwelladdress;  //地址
    private String jobhunter;  //求职的状态
    private String rexperience;  //求职状态
    private String rephone;    //手机号
    private String remail;     //邮箱
    private String reimage;    //图片
    private Integer restate;    //简历状态
    private Integer userid;    //用户表外键

    private List<Workexperience> workexperiences;

    public Integer getReid() {
        return reid;
    }

    public void setReid(Integer reid) {
        this.reid = reid;
    }

    public String getRename() {
        return rename;
    }

    public void setRename(String rename) {
        this.rename = rename;
    }

    public String getResex() {
        return resex;
    }

    public void setResex(String resex) {
        this.resex = resex;
    }

    public Integer getReage() {
        return reage;
    }

    public void setReage(Integer reage) {
        this.reage = reage;
    }

    public String getDwelladdress() {
        return dwelladdress;
    }

    public void setDwelladdress(String dwelladdress) {
        this.dwelladdress = dwelladdress;
    }

    public String getRexperience() {
        return rexperience;
    }

    public void setRexperience(String rexperience) {
        this.rexperience = rexperience;
    }

    public String getRephone() {
        return rephone;
    }

    public void setRephone(String rephone) {
        this.rephone = rephone;
    }

    public String getRemail() {
        return remail;
    }

    public void setRemail(String remail) {
        this.remail = remail;
    }

    public String getReimage() {
        return reimage;
    }

    public void setReimage(String reimage) {
        this.reimage = reimage;
    }

    public String getJobhunter() {
        return jobhunter;
    }

    public void setJobhunter(String jobhunter) {
        this.jobhunter = jobhunter;
    }

    public Integer getRestate() {
        return restate;
    }

    public void setRestate(Integer restate) {
        this.restate = restate;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public List<Workexperience> getWorkexperiences() {
        return workexperiences;
    }

    public void setWorkexperiences(List<Workexperience> workexperiences) {
        this.workexperiences = workexperiences;
    }
}
