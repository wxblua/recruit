package com.recruit.dao;

import com.recruit.entity.Workexperience;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface WorkexperienceDao {

    @Select("select * from workexperience where reid=1") List<Map<String,Object>> query(Integer id);

    @Update("update workexperience set wpcompanyname=#{param1},wpinposition=#{param2},wpstarttime=#{param3},wpstopetime=#{param4} where reid=1")
    int  workexperienceUpdate(String wpcompanyname, String wpinposition, Date wpstarttime, Date wpstopetime, Integer id);

    /*添加工作经历*/
    @Insert("insert into workexperience(wpcompanyname,wpinposition,wpstarttime,wpstopetime,wpworkdescribe,reid) values(#{wpcompanyname},#{wpinposition},#{wpstarttime},#{wpstopetime},#{wpworkdescribe},#{reid})")
    public Integer addworkperi(Workexperience workexperience);
}
