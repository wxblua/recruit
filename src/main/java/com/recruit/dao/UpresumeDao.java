package com.recruit.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UpresumeDao {

    @Insert("Insert into upresume(uploadresume) values(#{uploadresume})")
    public Integer add(String reupload);
}
