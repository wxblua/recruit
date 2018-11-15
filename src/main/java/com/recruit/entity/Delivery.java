package com.recruit.entity;

public class Delivery {
    private Integer did;
    private Integer useid;
    private Integer infoid;
    private Integer reid;
    private Integer destate;
    private String uploadresume;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getUseid() {
        return useid;
    }

    public void setUseid(Integer useid) {
        this.useid = useid;
    }

    public Integer getInfoid() {
        return infoid;
    }

    public void setInfoid(Integer infoid) {
        this.infoid = infoid;
    }

    public Integer getReid() {
        return reid;
    }

    public void setReid(Integer reid) {
        this.reid = reid;
    }

    public Integer getDestate() {
        return destate;
    }

    public void setDestate(Integer destate) {
        this.destate = destate;
    }

    public String getUploadresume() {
        return uploadresume;
    }

    public void setUploadresume(String uploadresume) {
        this.uploadresume = uploadresume;
    }
}
