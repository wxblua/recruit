package com.recruit.service;

import com.recruit.dao.TestDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class TestService {
    @Resource
    TestDao testDao;

    public List<Map<String,Object>> query(Integer id1){
        return testDao.query(id1);
    }

    public List<Map<String,Object>> test1(){
        return testDao.test1();
    }
    public List<Map<String,Object>> test2(Integer id1){
        return testDao.test2(id1);
    }
    public List<Map<String,Object>> test3(Integer id2){
        return testDao.test3(id2);
    }
    public List<Map<String,Object>> test4(Integer id1){
        return testDao.test4(id1);
    }
    public List<Map<String,Object>> test5(Integer id1){
        return testDao.test5(id1);
    }
}
