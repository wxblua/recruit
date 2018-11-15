package com.recruit.dao;

import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface ProjectperienceDao {

    @Select("select * from projectperience where reid=#{reid}")List<Map<String,Object>> query(Integer id);

    @Update("update projectperience set pjname=#{param1},pjdescribe=#{param2},pjstarttime=#{param3},pjstopetime=#{param4},pjresponsibility=#{param5} where  reid=#{param6}")
    int projectperienceUpdate(String pjname, String pjdescribe, String pjstarttime, String pjstopetime, String pjresponsibility, Integer id);

    /*添加项目经验*/
    @Insert("insert into projectperience(pjname,pjstarttime,pjstopetime,pjdescribe,pjresponsibility,reid) values(#{param1},#{param2},#{param3},#{param4},#{param5},#{param6})")
    public Integer addprojectperi(String pjname, Date pjstarttime, Date pjstopetime, String pjdescribe, String pjresponsibility, Integer id);

    @Delete("delete from projectperience where pjid=#{pjid}")
    public Integer delprojectperi(Integer pjid);

}
