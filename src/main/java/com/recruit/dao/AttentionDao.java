package com.recruit.dao;

import com.recruit.entity.Attention;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface AttentionDao {

    @Insert("insert into attention(epid,useid) values(#{epid},#{useid})")
    public int addattention(Attention attention);   //关注公司

    @Select("select att.atid,recr.infoid,job.jobcgname,recr.introduction,recr.jobnature,recr.workaddress,sr.salaryrange,ye.ywrange,educ.educationname,recr.rnumbers,recr.cpwelfareid,recr.stcontent,recr.ricontent,recr.restate,recr.epid,recr.fbtime,ep.cyaddress,ep.epname,ep.originator,ep.epemail,ep.epphone,cpt.ctypename,csl.cpcalename from recruitment recr \n" +
            "left join jobcategory job on recr.jobcgid=job.jobcgid \n" +
            "left join srange sr on recr.srangeid=sr.srangeid \n" +
            "left join yearsworking ye on recr.ywrangeid=ye.ywrangeid \n" +
            "left join education educ on recr.educationid=educ.educationid \n" +
            "left join enterprise ep on recr.epid=ep.epid \n" +
            "left join companytype cpt on ep.ctypeid=cpt.ctypeid \n" +
            "left join Attention att on att.epid=ep.epid\n" +
            "left join companyscale csl on ep.cpcaleid=csl.cpcaleid \n" +
            "WHERE att.useid=#{param1} GROUP BY epid")
    public List<Map<String,Object>> queryattention(Object atid);    //查询公司

    @Delete("delete from attention where atid=#{atid}")
    public int delattention(Integer atid);         //取消关注

    @Select("select * from attention where epid=#{param1} and useid=#{param2}")
    public List<Map<String,Object>> selectatten(Integer epid, Object useid);      //判断该公司是否已关注

}
