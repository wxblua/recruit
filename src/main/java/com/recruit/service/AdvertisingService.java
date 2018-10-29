package com.recruit.service;

import com.recruit.dao.AdvertisingDao;
import com.recruit.entity.Advertising;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AdvertisingService {

    @Resource
    private AdvertisingDao adverdao;

    //查询广告
    public List<Map<String,Object>> queryadver(){
        return adverdao.queryadver();
    }

    //添加广告
    public int addadv(Advertising adver){
        return adverdao.addadv(adver);
    }

    //删除广告
    public int deladv(Integer aid){
        return adverdao.deladv(aid);
    }

    //按编号查询广告
    public List<Map<String,Object>> querybyid(Integer aid){
        return adverdao.querybyid(aid);
    }

    //修改广告
    public int updateadv(Advertising advertising){
        return adverdao.updateadv(advertising);
    }

}
