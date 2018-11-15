package com.recruit.dao;

import com.recruit.entity.Blacklist;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface BlacklistDao {

    @Insert("insert into blacklist(epid,useid) values(#{epid},#{useid})")
    public int addblacklist(Blacklist blacklist);   //添加黑名单

    @Select("select bl.bid,recr.infoid,job.jobcgname,recr.introduction,recr.jobnature,recr.workaddress,sr.salaryrange,ye.ywrange,educ.educationname,recr.rnumbers,recr.cpwelfareid,recr.stcontent,recr.ricontent,recr.restate,recr.epid,recr.fbtime,ep.cyaddress,ep.epname,ep.originator,ep.epemail,ep.epphone,cpt.ctypename,csl.cpcalename from recruitment recr \n" +
            "join jobcategory job on recr.jobcgid=job.jobcgid \n" +
            "join srange sr on recr.srangeid=sr.srangeid \n" +
            "join yearsworking ye on recr.ywrangeid=ye.ywrangeid \n" +
            "join education educ on recr.educationid=educ.educationid \n" +
            "join enterprise ep on recr.epid=ep.epid \n" +
            "join companytype cpt on ep.ctypeid=cpt.ctypeid \n" +
            "join companyscale csl on ep.cpcaleid=csl.cpcaleid \n" +
            "join blacklist bl on ep.epid=bl.epid where bl.useid=#{param1}\n" +
            "GROUP BY epid")
    public List<Map<String,Object>> queryblacklist(Object useid);   //查询黑名单

    @Delete("delete from blacklist where bid=#{bid}")
    public int delblacklist(Integer bid);       //取消加入黑名单

    @Select("select * from blacklist where epid=#{param1} and useid=#{param2}")
    public List<Map<String,Object>> selectlacklist(Integer epid, Object useid);  //判断该公司是否已加入黑名单

}