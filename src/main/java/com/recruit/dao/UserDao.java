package com.recruit.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {

    /**
     * 用户注册
     * @param uemail
     * @param upwd
     * @return
     */
    @Insert("insert into user(usemail,usepwd,useimage) values(#{param1},#{param2},'default.jpg')")
    int save(String uemail, String upwd);


    /**
     * 修改状态，完成验证
     * @param state
     * @param uemail
     * @return
     */
    @Update("update user set usestate=#{param1} where usemail=#{param2}")
    int update(String state, String uemail);


    /**
     * 查询改邮件是否注册
     * @param email
     * @return
     */
    @Select("select * from user where usemail=#{param1}")
    List<Map<String,Object>> query(String email);

    /**
     * 用户登录
     * @param email
     * @param pwd
     * @return
     */
    @Select("select * from user where usemail=#{param1} and usepwd=#{param2} and usestate=1")
    List<Map<String,Object>> log(String email, String pwd);


    @Select("select * from user where usemail=#{param1}")
    List<Map<String,Object>> major(String email);

    /*郭大侠*/
    @Select("select * from user")
    public List<Map<String,Object>> queryuser();
}
