package com.recruit.dao;

import com.recruit.entity.Resume;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ResumeDao {

    /**
     * 查询简历的基本信息
     * @param id
     * @return
     */
    @Select("select * from resume where userid=#{param1} and restate=1")
    List<Resume> query(Integer id);

    /**
     * 修改姓名
     * @param name
     * @param id
     * @return
     */
    @Update("update resume set resume.rename=#{param1} where userid=#{param2} and restate=1")
    int name(String name, Integer id);

    /**
     * 修改简历的基本信息
     * @param name
     * @param sex
     * @param status
     * @param highestEducation
     * @param workYear
     * @param phone
     * @param email
     * @param id
     * @return
     */
    @Update("update resume set resume.rename=#{param1},resume.resex=#{param2},resume.jobhunter=#{param3},resume.dwelladdress=#{param4},resume.rexperience=#{param5},resume.rephone=#{param6},resume.remail=#{param7} where userid=#{param8} and restate=1")
    int basic(String name, String sex, String status, String highestEducation, String workYear, String phone, String email, Integer id);

    /**
     * 修改头像
     * @param File
     * @param id
     * @return
     */
    @Update("update resume set reimage=#{param1} where userid=#{param2} and restate=1")
    int picture(String File, Integer id);
/*
    *
     * 添加简历的基本信息
     * @param resume
     * @return
    @Insert("insert into resume value(#{},#{},#{},#{})")
    int basicSave(Resume resume);*/


}
