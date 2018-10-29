package com.recruit.service;

import com.recruit.dao.IntentionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IntentionService {

    @Autowired
    IntentionDao intentionDao;

    public List<Map<String,Object>> query(Integer id){
        return intentionDao.query(id);
    }

    public int IntentionUPdate(String inpositionid, String inworkaddress, String inworknature, String insalary,Integer id){
        return intentionDao.IntentionUPdate(inpositionid,inworkaddress,inworknature,insalary,id);
    }
}
