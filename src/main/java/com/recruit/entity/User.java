package com.recruit.entity;

import java.util.Date;

public class User {

   private Integer useid;        //编号
   private String usemail;      //用户的邮箱
   private String usepwd;        //密码
   private String usestate;    //用户状态 1,正常  2,禁用
   private Date usecreatetime;   //用户创建时间
   private Date useupdatetime;   //用户最近的修改自己账号时间
   private String useimage;       //用户的头像
    private String useattention;  //关注公司
    private String useblock;        //1，拉黑   2 ,正常

    public Integer getUseid() {
        return useid;
    }

    public void setUseid(Integer useid) {
        this.useid = useid;
    }

    public String getUsemail() {
        return usemail;
    }

    public void setUsemail(String usemail) {
        this.usemail = usemail;
    }

    public String getUsepwd() {
        return usepwd;
    }

    public void setUsepwd(String usepwd) {
        this.usepwd = usepwd;
    }

    public String getUsestate() {
        return usestate;
    }

    public void setUsestate(String usestate) {
        this.usestate = usestate;
    }

    public Date getUsecreatetime() {
        return usecreatetime;
    }

    public void setUsecreatetime(Date usecreatetime) {
        this.usecreatetime = usecreatetime;
    }

    public Date getUseupdatetime() {
        return useupdatetime;
    }

    public void setUseupdatetime(Date useupdatetime) {
        this.useupdatetime = useupdatetime;
    }

    public String getUseimage() {
        return useimage;
    }

    public void setUseimage(String useimage) {
        this.useimage = useimage;
    }

    public String getUseattention() {
        return useattention;
    }

    public void setUseattention(String useattention) {
        this.useattention = useattention;
    }

    public String getUseblock() {
        return useblock;
    }

    public void setUseblock(String useblock) {
        this.useblock = useblock;
    }
}
