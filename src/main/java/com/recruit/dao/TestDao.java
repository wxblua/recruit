package com.recruit.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestDao {

    @Select("select t1.id1,t1.name1,t2.name2,t3.name3 from test1 t1\n" +
            "left join test2 t2 on t1.id1=t2.id1\n" +
            "left join test3 t3 on t2.id2=t3.id2 where t1.id1=#{id1}")
    public List<Map<String,Object>> query(Integer id1);

    @Select("select * from test1")
    public List<Map<String,Object>> test1();
    @Select("select * from test2 where id1=#{id1}")
    public List<Map<String,Object>> test2(Integer id1);
    @Select("select * from test3 where id2=#{id2}")
    public List<Map<String,Object>> test3(Integer id2);
    @Select("select * from test2 t2 left join test3 t3 on t2.id2=t3.id2 where t2.id1=#{id1}")
    public List<Map<String,Object>> test5(Integer id1);


    @Select("select * from test1 where id1=#{id1}")
    public List<Map<String,Object>> test4(Integer id1);

}
