package com.recruit.service;

import com.recruit.dao.ResumeDao;
import com.recruit.entity.Resume;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    public List<Map<String,Object>> queryResume(Integer epid){
        return resumeDao.queryResume(epid);
    }

    public List<Map<String,Object>> queryBackResume(Integer userid){
        return resumeDao.queryBackResume(userid);
    }

    public List<Map<String,Object>> queryById(Integer reid){
        return resumeDao.queryById(reid);
    }

    public Integer updateResume(Integer reid){
        return resumeDao.updateResume(reid);
    }
    public Integer updateviewed(Integer reid){
        return resumeDao.updateviewed(reid);
    }
    public Integer updatanotice(Integer reid){
        return resumeDao.updatanotice(reid);
    }
    public Integer inappropriate(Integer reid){ return resumeDao.inappropriate(reid); }

    public List<Map<String,Object>> test(){
        return resumeDao.test();
    }

    //申请职位
    public int addresume(Resume resume){
        return resumeDao.addresume(resume);
    }

    //通过用户查看是否有简历
    public List<Map<String,Object>> querybyuid(Integer userid){
        return resumeDao.querybyuid(userid);
    }
}
