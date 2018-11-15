package com.recruit.dao;

import com.recruit.entity.Complain;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

    @Insert("insert into complain(ccontents,cimage,ctime,useid) values(#{ccontents},#{cimage},NOW(),#{useid})")
    public int addcomplain(Complain complain);  //添加投诉

}
