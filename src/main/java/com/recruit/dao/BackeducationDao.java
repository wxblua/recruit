package com.recruit.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface BackeducationDao {

    @Select("select back.beid,back.bename,back.beducation,back.bemajorname,back.bestarttime,back.bestopetime,back.reid from backeducation back where back.reid=#{beid}")
    public List<Map<String,Object>> queryBackeducation(Integer reid);

    @Insert("insert into backeducation(bename,beducation,bemajorname,bestarttime,bestopetime,reid) values(#{param1},#{param2},#{param3},#{param4},#{param5},#{param6})")
    public Integer addBackeducation(String bename, String beducation, String bemajorname, Date bestarttime, Date bestopetime, Integer reid);

    @Delete("delete from backeducation where beid=#{beid}")
    public Integer delBackeducation(Integer beid);
}
