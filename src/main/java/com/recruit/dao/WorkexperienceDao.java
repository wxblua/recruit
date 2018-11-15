package com.recruit.dao;

import com.recruit.entity.Workexperience;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface WorkexperienceDao {

    @Select("select * from workexperience where reid=#{reid}") List<Map<String,Object>> query(Integer id);

    @Update("update workexperience set wpcompanyname=#{param1},wpinposition=#{param2},wpstarttime=#{param3},wpstopetime=#{param4} where reid=1")
    int  workexperienceUpdate(String wpcompanyname, String wpinposition, Date wpstarttime, Date wpstopetime, Integer id);

    /*添加工作经历*/
    @Insert("insert into workexperience(wpcompanyname,wpinposition,wpstarttime,wpstopetime,wpworkdescribe,reid) values(#{param1},#{param2},#{param3},#{param4},#{param5},#{param6})")
    public Integer addworkperi(String wpcompanyname, String wpinposition, Date wpstarttime, Date wpstopetime, String wpworkdescribe, Integer id);
    /*删除工作经历*/
    @Delete("delete from workexperience where wpid=#{wpid}")
    public Integer delworkperi(Integer wpid);
}
