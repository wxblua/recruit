package com.recruit.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ComplainDao {

    @Select("select * from complain")
    public List<Map<String,Object>> querycomplatin();   //查询投诉

    @Delete("delete from complain where cid=#{cid}")
    public int delcomplatin(Integer cid);   //删除

}
