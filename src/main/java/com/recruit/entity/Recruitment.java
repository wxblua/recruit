package com.recruit.entity;

/**
 * 招聘信息表
 */
public class Recruitment {
    private Integer infoid;
    private Integer jobcgid;/*职位类别*/
    private String introduction;/*职位名称*/
    private Integer jobnature;/*工作性质*/
    private String workaddress;/*工作地址*/
    private Integer srangeid;/*月薪范围*/
    private Integer ywrangeid;/*工作年限*/
    private Integer educationid;/*最低学历*/
    private String stcontent;/*岗位职责*/
    private String ricontent;/*任职要求*/
    private Integer rnumbers;/*招聘人数*/
    private Integer cpwelfareid;/*公司福利*/
    private Integer epid;/*企业公司编号*/
    private Integer restate;/*招聘状态*/
    /**
     * 城市拼接
     */
    private String province1;
    private String city;
    private String districtl;

    public Integer getInfoid() {
        return infoid;
    }

    public void setInfoid(Integer infoid) {
        this.infoid = infoid;
    }

    public Integer getJobcgid() {
        return jobcgid;
    }

    public void setJobcgid(Integer jobcgid) {
        this.jobcgid = jobcgid;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getJobnature() {
        return jobnature;
    }

    public void setJobnature(Integer jobnature) {
        this.jobnature = jobnature;
    }

    public String getWorkaddress() {
        return workaddress;
    }

    public void setWorkaddress(String workaddress) {
        this.workaddress = workaddress;
    }

    public Integer getSrangeid() {
        return srangeid;
    }

    public void setSrangeid(Integer srangeid) {
        this.srangeid = srangeid;
    }

    public Integer getYwrangeid() {
        return ywrangeid;
    }

    public void setYwrangeid(Integer ywrangeid) {
        this.ywrangeid = ywrangeid;
    }

    public Integer getEducationid() {
        return educationid;
    }

    public void setEducationid(Integer educationid) {
        this.educationid = educationid;
    }

    public String getStcontent() {
        return stcontent;
    }

    public void setStcontent(String stcontent) {
        this.stcontent = stcontent;
    }

    public String getRicontent() {
        return ricontent;
    }

    public void setRicontent(String ricontent) {
        this.ricontent = ricontent;
    }

    public Integer getRnumbers() {
        return rnumbers;
    }

    public void setRnumbers(Integer rnumbers) {
        this.rnumbers = rnumbers;
    }

    public Integer getCpwelfareid() {
        return cpwelfareid;
    }

    public void setCpwelfareid(Integer cpwelfareid) {
        this.cpwelfareid = cpwelfareid;
    }

    public Integer getEpid() {
        return epid;
    }

    public void setEpid(Integer epid) {
        this.epid = epid;
    }

    public Integer getRestate() {
        return restate;
    }

    public void setRestate(Integer restate) {
        this.restate = restate;
    }

    public String getProvince1() {
        return province1;
    }

    public void setProvince1(String province1) {
        this.province1 = province1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrictl() {
        return districtl;
    }

    public void setDistrictl(String districtl) {
        this.districtl = districtl;
    }
}

