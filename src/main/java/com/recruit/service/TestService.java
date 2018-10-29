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

    public List<Map<String,Object>> query(){
        return testDao.query();
    }

    public List<Map<String,Object>> test1(){
        return testDao.test1();
    }
    public List<Map<String,Object>> test2(){
        return testDao.test2();
    }
    public List<Map<String,Object>> test3(){
        return testDao.test3();
    }
}
