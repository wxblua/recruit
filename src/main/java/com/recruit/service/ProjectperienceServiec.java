package com.recruit.service;

import com.recruit.dao.ProjectperienceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProjectperienceServiec {

    @Autowired
    ProjectperienceDao projectperienceDao;

    public List<Map<String,Object>> query(Integer id){
        return projectperienceDao.query(id);
    }

    public int projectperienceUpdate(String pjname,String pjdescribe,String pjstarttime,String pjstopetime,String pjresponsibility,Integer id){
        return projectperienceDao.projectperienceUpdate(pjname,pjdescribe,pjstarttime,pjstopetime,pjresponsibility,id);
    }

}
