package com.recruit.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProjectperienceDao {

    @Select("select * from projectperience where reid=#{param1}") List<Map<String,Object>> query(Integer id);

    @Update("update projectperience set pjname=#{param1},pjdescribe=#{param2},pjstarttime=#{param3},pjstopetime=#{param4},pjresponsibility=#{param5} where  reid=#{param6}")
    int projectperienceUpdate(String pjname, String pjdescribe, String pjstarttime, String pjstopetime, String pjresponsibility, Integer id);
}
