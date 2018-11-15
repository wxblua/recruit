package com.recruit.dao;

import com.recruit.entity.Collections;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface CollectionDao {
    @Insert("insert into collection(infoid,useid) values(#{infoid},#{useid})")
    public int addcollection(Collections collection);    //收藏职位

    @Select("select co.coid,recr.infoid,job.jobcgname,recr.introduction,recr.jobnature,recr.workaddress,sr.salaryrange,ye.ywrange,educ.educationname,recr.rnumbers,recr.cpwelfareid,recr.stcontent,recr.ricontent,recr.restate,recr.epid,recr.fbtime,ep.cyaddress,ep.epname,ep.originator,ep.epemail,ep.epphone,cpt.ctypename,csl.cpcalename from recruitment recr \n" +
            "left join jobcategory job on recr.jobcgid=job.jobcgid \n" +
            "left join srange sr on recr.srangeid=sr.srangeid \n" +
            "left join yearsworking ye on recr.ywrangeid=ye.ywrangeid \n" +
            "left join education educ on recr.educationid=educ.educationid \n" +
            "left join enterprise ep on recr.epid=ep.epid \n" +
            "left join companytype cpt on ep.ctypeid=cpt.ctypeid \n" +
            "left join companyscale csl on ep.cpcaleid=csl.cpcaleid \n" +
            "join collection co on recr.infoid=co.infoid\n" +
            "WHERE co.useid=#{param1}\n" +
            "GROUP BY epid")
    public List<Map<String,Object>> querycollection(Object coid);  //查询职位

    @Delete("delete from collection where coid=#{coid}")
    public int delcollection(Integer coid);     //取消收藏

    @Select("select * from collection where infoid=#{param1} and useid=#{param2}")
    public List<Map<String,Object>> selectcoll(Integer infoid, Object useid);    //判断是否已收藏

}