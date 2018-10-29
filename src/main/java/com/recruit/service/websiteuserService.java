package com.recruit.service;

import com.recruit.dao.websiteuserDao;
import com.recruit.entity.websiteuser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class websiteuserService {

    @Resource
    private websiteuserDao webdao;

    //登录
    public List<Map<String,Object>> login(String wname,String wpwd){
        return webdao.login(wname,wpwd);
    }

    //按编号查询
    public List<Map<String,Object>> querybyid(Integer wid){
        return webdao.querybyid(wid);
    }

    //修改密码
    public int updatewebsite(String wpwd ,String wid){
        return webdao.updatewebsite(wpwd , wid);
    }

    //查询所有
    public Integer queryall(){
        return webdao.queryall();
    }

    //查询
    public List<Map<String,Object>> queryselect(){
        return webdao.queryselect();
    }

}
