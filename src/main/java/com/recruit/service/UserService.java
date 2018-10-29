package com.recruit.service;

import com.recruit.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserDao user;

    public  int save(String uemail,String upwd){
        return user.save(uemail,upwd);
    }

    public  int update(String state,String uemail){
        return user.update(state,uemail);
    }

    public List<Map<String,Object>> query(String email){
        return user.query(email);
    }

    public List<Map<String,Object>> log(String email,String pwd){
        return user.log(email,pwd);
    }

    public List<Map<String,Object>> major(String email){
        return user.major(email);
    }

    public List<Map<String,Object>> queryuser(){
        return user.queryuser();
    }
}
