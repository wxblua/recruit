package com.recruit.service;

import com.recruit.dao.ComplainDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ComplainService {

    @Resource
    private ComplainDao comdao;

    //查询投诉
    public List<Map<String,Object>> querycomplain(){
        return comdao.querycomplatin();
    }

    //删除投诉
    public int delcomplatin(Integer cid){
        return comdao.delcomplatin(cid);
    }

}
