package com.recruit.dao;

import com.recruit.entity.Reply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReplyDao {

    @Insert("insert into reply(rcontents,rtime,cid,rstate) values(#{rcontents},NOW(),#{cid},1)")
    public int addreply(Reply reply);       //回复投诉

    @Select("select r.rid,r.rcontents,r.rtime from reply r inner join complain c on c.cid=r.cid\r" +
            "inner join user u on u.useid=c.useid where u.useid=#{param1} and r.rstate=1")
    public List<Map<String,Object>> queryreply(Integer useid);      //查询投诉

    @Update("update from reply set rstate=0 where rid=#{param1}")
    public int updatereply(Integer rid);   //更新状态

}
