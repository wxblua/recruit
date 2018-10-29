package com.recruit.dao;

import com.recruit.entity.Advertising;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdvertisingDao {

    //查询广告
    @Select("select * from advertising")
    public List<Map<String,Object>> queryadver();

    //添加广告
    @Insert("insert into advertising(atitle,aimage,createtime,updatetime,positionid) values(#{atitle},#{aimage},NOW(),NOW(),#{positionid})")
    public int addadv(Advertising adver);

    //删除广告
    @Delete("delete from advertising where aid=#{aid}")
    public int deladv(Integer aid);

    //按编号查询
    @Select("select * from advertising where aid=#{aid}")
    public List<Map<String,Object>> querybyid(Integer aid);

    //修改广告
    @Update("update advertising set atitle=#{atitle} where aid=#{aid}")
    public int updateadv(Advertising advertising);

}
