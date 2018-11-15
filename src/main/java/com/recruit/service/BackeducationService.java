package com.recruit.service;

import com.recruit.dao.BackeducationDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BackeducationService {

    @Resource
    BackeducationDao backeducationDao;

    public List<Map<String,Object>> queryBackeducation(Integer reid){
        return backeducationDao.queryBackeducation(reid);
    }
    public Integer addBackeducation(String bename, String beducation, String bemajorname, Date bestarttime, Date bestopetime, Integer reid){
        return backeducationDao.addBackeducation(bename,beducation,bemajorname,bestarttime,bestopetime,reid);
    }
    public Integer delBackeducation(Integer beid){
        return backeducationDao.delBackeducation(beid);
    }
}
