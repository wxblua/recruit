package com.recruit.service;

import com.recruit.dao.OtherDao;
import com.recruit.entity.Other;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class OtherService {
    @Resource
    private OtherDao otherdao;

    public List<Map<String,Object>> queryother(Integer reid){
        return otherdao.queryother(reid);
    }

    public int addother(String language,String insteringandspeak,String literacy,String myRemark,Integer reid){
        return otherdao.addother(language,insteringandspeak,literacy,myRemark,reid);
    }

    public int delother(Integer otherid){
        return otherdao.delother(otherid);
    }

    public int updateother(Other other){
        return otherdao.updateother(other);
    }
}
