package com.recruit.service;

import com.recruit.dao.WorkexperienceDao;
import com.recruit.entity.Workexperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class WorkexperienceService {

    @Autowired
    WorkexperienceDao workexperienceDao;

    public List<Map<String,Object>> query(Integer id){
        return workexperienceDao.query(id);
    }

    public int workexperienceUpdate(String wpcompanyname, String wpinposition, Date wpstarttime, Date wpstopetime, Integer id){
        return workexperienceDao.workexperienceUpdate(wpcompanyname,wpinposition,wpstarttime,wpstopetime,id);
    }
    /*添加工作经历*/
    public Integer addworkperi(String wpcompanyname, String wpinposition, Date wpstarttime, Date wpstopetime, String wpworkdescribe, Integer id){
        return workexperienceDao.addworkperi(wpcompanyname,wpinposition,wpstarttime,wpstopetime,wpworkdescribe,id);
    }
    /*删除工作经历*/
    public Integer delworkperi(Integer wpid){
        return workexperienceDao.delworkperi(wpid);
    }

}
