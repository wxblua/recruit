package com.recruit.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface IntentionDao {

    @Select("select * from intention where reid=#{param1}")
    List<Map<String,Object>> query(Integer id);

    @Update("update intention set inpositionid=#{param1},inworkaddress=#{param2},inworknature=#{param3},insalary=#{param4} where reid=#{param5}")
    int IntentionUPdate(String inpositionid, String inworkaddress, String inworknature, String insalary, Integer id);

}
