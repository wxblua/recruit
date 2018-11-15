package com.recruit.dao;

import com.recruit.entity.Delivery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DeliveryDao {

    @Select("select * from delivery where useid=#{useid} and infoid=#{infoid}")
    public List<Map<String,Object>> querydelivery(Integer useid, Integer infoid);

    @Insert("insert into delivery(useid,infoid) values(#{useid},#{infoid})")
    public int adddelivery(Delivery delivery);

}
