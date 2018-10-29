package com.recruit.entity;

/**
 * 职位类别外键表
 */
public class Jobcategory {
    private Integer jobcgid;
    private String jobcgname;

    public Integer getJobcgid() {
        return jobcgid;
    }

    public void setJobcgid(Integer jobcgid) {
        this.jobcgid = jobcgid;
    }

    public String getJobcgname() {
        return jobcgname;
    }

    public void setJobcgname(String jobcgname) {
        this.jobcgname = jobcgname;
    }
}
