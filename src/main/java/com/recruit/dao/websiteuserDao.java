package com.recruit.dao;

import com.recruit.entity.websiteuser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface websiteuserDao {

    @Select("select * from websiteuser where wname=#{param1} and wpwd=#{param2}")
    public List<Map<String,Object>> login(String wname, String wpwd);    //登录

    @Select("select * from websiteuser where wid=#{wid}")
    public List<Map<String,Object>> querybyid(Integer wid);     //按编号查询

    @Update("update websiteuser set wpwd=#{param1} where wid=#{param2}")
    public int updatewebsite(String wpwd, String wid);     //修改密码

    @Select("select count(*) from websiteuser")
    public Integer queryall();     //查询所有

    @Select("select * from websiteuser")
    public List<Map<String,Object>> queryselect();  //查询

}
