package com.recruit.service;

import com.recruit.dao.ResumeDao;
import com.recruit.entity.Resume;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResumeService {

    @Resource
    ResumeDao resumeDao;

    public List<Resume> query(Integer id){
      return resumeDao.query(id);
    }

    public int name(String name,Integer id){
        return resumeDao.name(name,id);
    }

    public int basic(String name,String sex,String status,String highestEducation,String workYear,String phone,String email,Integer id){
        return resumeDao.basic(name,sex,status,highestEducation,workYear,phone,email,id);
    }

    public int picture(String File,Integer id){
        return resumeDao.picture(File,id);
    }
}
