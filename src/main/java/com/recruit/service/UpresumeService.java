package com.recruit.service;

import com.recruit.dao.UpresumeDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UpresumeService {
    @Resource
    UpresumeDao upresumeDao;

    public Integer add(String reupload){
        return  upresumeDao.add(reupload);
    }
}
