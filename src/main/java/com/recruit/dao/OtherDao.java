package com.recruit.dao;

import com.recruit.entity.Other;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface OtherDao {

    @Select("select * from other where reid=#{reid}")
    public List<Map<String,Object>> queryother(Integer reid);

    @Insert("insert into other(language,insteringandspeak,literacy,assessment,reid) values(#{param1},#{param2},#{param3},#{param4},#{param5})")
    public Integer addother(String language,String insteringandspeak,String literacy,String myRemark,Integer reid);

    @Update("update other set language=#{language} where otherid=#{otherid}")
    public int updateother(Other other);

    @Delete("delete from other where otherid=#{otherid}")
    public int delother(Integer otherid);


}
