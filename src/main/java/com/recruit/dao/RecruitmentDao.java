package com.recruit.dao;

import com.recruit.entity.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface RecruitmentDao {

    /*insert into recruitment(jobcgid,introduction,jobnature,workaddress,srangeid,ywrangeid,educationid,stcontent,ricontent,rnumbers,cpwelfareid,epid,restate)
values(1,'销售经理',1,'河南省,驻马店市,西平县',5,4,2,'岗位职责','任职要求',1,1,1,1)*/
    /*添加招聘信息*/
    @Insert("insert into recruitment(jobcgid,introduction,jobnature,workaddress,srangeid,ywrangeid,educationid,rnumbers,cpwelfareid,epid,restate,fbtime) " +
            "values(#{jobcgid},#{introduction},#{jobnature},#{workaddress},#{srangeid},#{ywrangeid},#{educationid},#{rnumbers},#{cpwelfareid},#{epid},1,NOW())")
    public boolean addRecruitment(Recruitment recruitment);
    /*select recr.infoid 招聘编号,job.jobcgname 职位类别,recr.introduction 职位名称,recr.jobnature 工作性质,recr.workaddress 工作地址,sr.salaryrange 薪资,ye.ywrange 年限,educ.educationname 学历,recr.rnumbers 招聘人数,cp.cpwelfarename 公司福利,recr.stcontent 岗位职责,recr.ricontent 任职要求,recr.restate 招聘状态,recr.epid 企业用户
    from recruitment recr
    left join jobcategory job on recr.jobcgid=job.jobcgid
    left join srange sr on recr.srangeid=sr.srangeid
    left join yearsworking ye on recr.ywrangeid=ye.ywrangeid
    left join education educ on recr.educationid=educ.educationid
    left join cpwelfare cp on recr.cpwelfareid=cp.cpwelfareid*/
    /*查询招聘信息*/
    @Select("select recr.infoid,job.jobcgname,recr.introduction,recr.jobnature,recr.workaddress,sr.salaryrange,ye.ywrange,educ.educationname,recr.rnumbers,recr.cpwelfareid,recr.stcontent,recr.ricontent,recr.restate,recr.epid from recruitment recr " +
            "left join jobcategory job on recr.jobcgid=job.jobcgid " +
            "left join srange sr on recr.srangeid=sr.srangeid " +
            "left join yearsworking ye on recr.ywrangeid=ye.ywrangeid " +
            "left join education educ on recr.educationid=educ.educationid " +
            "where recr.epid=#{param1}")
    public List<Map<String,Object>> queryAllRecruitment(Integer epid);

    /*一个公司只显示一个职位*/
    @Select("select recr.infoid,job.jobcgname,recr.introduction,recr.jobnature,recr.workaddress,sr.salaryrange,ye.ywrange,educ.educationname,recr.rnumbers,recr.cpwelfareid,recr.stcontent,recr.ricontent,recr.restate,recr.epid,recr.fbtime,ep.cyaddress,ep.epname,ep.originator,ep.epemail,ep.epphone,cpt.ctypename,csl.cpcalename from recruitment recr " +
            "left join jobcategory job on recr.jobcgid=job.jobcgid " +
            "left join srange sr on recr.srangeid=sr.srangeid " +
            "left join yearsworking ye on recr.ywrangeid=ye.ywrangeid " +
            "left join education educ on recr.educationid=educ.educationid " +
            "left join enterprise ep on recr.epid=ep.epid " +
            "left join companytype cpt on ep.ctypeid=cpt.ctypeid " +
            "left join companyscale csl on ep.cpcaleid=csl.cpcaleid GROUP BY epid")
    public List<Map<String,Object>> searchrecruit();

    /*根据id查询企业的信息*/
    @Select("select recr.infoid,job.jobcgname,recr.introduction,recr.jobnature,recr.workaddress,sr.salaryrange,ye.ywrange,educ.educationname,recr.rnumbers,recr.cpwelfareid,recr.stcontent,recr.ricontent,recr.restate,recr.epid,recr.fbtime,ep.cyaddress,ep.epname,ep.originator,ep.epemail,ep.epphone,cpt.ctypename,csl.cpcalename from recruitment recr " +
            "left join jobcategory job on recr.jobcgid=job.jobcgid " +
            "left join srange sr on recr.srangeid=sr.srangeid " +
            "left join yearsworking ye on recr.ywrangeid=ye.ywrangeid " +
            "left join education educ on recr.educationid=educ.educationid " +
            "left join enterprise ep on recr.epid=ep.epid " +
            "left join companytype cpt on ep.ctypeid=cpt.ctypeid " +
            "left join companyscale csl on ep.cpcaleid=csl.cpcaleid where recr.epid=#{param1} and recr.infoid=#{param2}")
    public List<Map<String,Object>> queryepid(Integer epid,Integer infoid);

    /*查询该公司的所有职位*/
    @Select("select recr.infoid,job.jobcgname,recr.introduction,recr.jobnature,recr.workaddress,sr.salaryrange,ye.ywrange,educ.educationname,recr.rnumbers,recr.cpwelfareid,recr.stcontent,recr.ricontent,recr.restate,recr.epid,recr.fbtime,ep.cyaddress,ep.epname,ep.originator,ep.epemail,ep.epphone,cpt.ctypename,csl.cpcalename from recruitment recr " +
            "left join jobcategory job on recr.jobcgid=job.jobcgid " +
            "left join srange sr on recr.srangeid=sr.srangeid " +
            "left join yearsworking ye on recr.ywrangeid=ye.ywrangeid " +
            "left join education educ on recr.educationid=educ.educationid " +
            "left join enterprise ep on recr.epid=ep.epid " +
            "left join companytype cpt on ep.ctypeid=cpt.ctypeid " +
            "left join companyscale csl on ep.cpcaleid=csl.cpcaleid where recr.epid=#{epid}")
    public List<Map<String,Object>> queryAllposition(Integer epid);

    /*根据epid查询公司的信息*/
    @Select("select recr.infoid,job.jobcgname,recr.introduction,recr.jobnature,recr.workaddress,sr.salaryrange,ye.ywrange,educ.educationname,recr.rnumbers,recr.cpwelfareid,recr.stcontent,recr.ricontent,recr.restate,recr.epid,recr.fbtime,ep.cyaddress,ep.epname,ep.originator,ep.epemail,ep.epphone,cpt.ctypename,csl.cpcalename,ep.synopsis,ep.epimage from recruitment recr\n" +
            "left join jobcategory job on recr.jobcgid=job.jobcgid\n" +
            "left join srange sr on recr.srangeid=sr.srangeid\n" +
            "left join yearsworking ye on recr.ywrangeid=ye.ywrangeid\n" +
            "left join education educ on recr.educationid=educ.educationid\n" +
            "left join enterprise ep on recr.epid=ep.epid\n" +
            "left join companytype cpt on ep.ctypeid=cpt.ctypeid\n" +
            "left join companyscale csl on ep.cpcaleid=csl.cpcaleid where ep.epid=#{epid} GROUP BY ep.epid")
    public List<Map<String,Object>> queryAllenterprise(Integer epid);

    /*查询职位类别表*/
    @Select("select * from jobcategory")
    public List<Jobcategory> queryjobcategory();
    /*查询月薪范围*/
    @Select("select * from srange")
    public List<Srange> querysrange();
    /*查询工作年限*/
    @Select("select * from yearsworking")
    public List<Yearsworking> queryyearsworking();
    /*查询公司福利*/
    @Select("select * from cpwelfare")
    public List<Cpwelfare> querycpwelfare();
    /*学历*/
    @Select("select * from education")
    public List<Education> queryeducation();
    /*删除职位*/
    @Delete("delete from recruitment where infoid=#{infoid}")
    public Integer delrecruitment(Integer infoid);

    //自动补全
    @Select("select recr.infoid,job.jobcgname,recr.introduction,recr.jobnature,recr.workaddress,sr.salaryrange,ye.ywrange,educ.educationname,recr.rnumbers,recr.cpwelfareid,recr.stcontent,recr.ricontent,recr.restate,recr.epid,recr.fbtime,ep.cyaddress,ep.epname,ep.originator,ep.epemail,ep.epphone,cpt.ctypename,csl.cpcalename from recruitment recr \n" +
            "left join jobcategory job on recr.jobcgid=job.jobcgid \n" +
            "left join srange sr on recr.srangeid=sr.srangeid \n" +
            "left join yearsworking ye on recr.ywrangeid=ye.ywrangeid \n" +
            "left join education educ on recr.educationid=educ.educationid \n" +
            "left join enterprise ep on recr.epid=ep.epid \n" +
            "left join companytype cpt on ep.ctypeid=cpt.ctypeid \n" +
            "left join companyscale csl on ep.cpcaleid=csl.cpcaleid \n" +
            "where recr.introduction like  concat('%',#{param1},'%')\n" +
            "GROUP BY epid")
    public List<Map<String,Object>> queryall(String introduction);

    /**
     * 按名称查询招聘信息
     * @param name
     * @return
     */
    @Select("select recr.infoid,job.jobcgname,recr.introduction,recr.jobnature,recr.workaddress,sr.salaryrange,ye.ywrange,educ.educationname,recr.rnumbers,recr.cpwelfareid,recr.stcontent,recr.ricontent,recr.restate,recr.epid,recr.fbtime,ep.cyaddress,ep.epname,ep.originator,ep.epemail,ep.epphone,cpt.ctypename,csl.cpcalename from recruitment recr " +
            "left join jobcategory job on recr.jobcgid=job.jobcgid " +
            "left join srange sr on recr.srangeid=sr.srangeid " +
            "left join yearsworking ye on recr.ywrangeid=ye.ywrangeid " +
            "left join education educ on recr.educationid=educ.educationid " +
            "left join enterprise ep on recr.epid=ep.epid " +
            "left join companytype cpt on ep.ctypeid=cpt.ctypeid " +
            "left join companyscale csl on ep.cpcaleid=csl.cpcaleid where recr.introduction like concat('%',#{param1},'%')  GROUP BY epid")
    public List<Map<String,Object>> queryAllRecruitmentByName(String name);
}


