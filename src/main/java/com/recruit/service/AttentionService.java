package com.recruit.service;

import com.recruit.dao.AttentionDao;
import com.recruit.entity.Attention;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AttentionService {

    @Resource
    private AttentionDao attentionDao;

    //关注公司
    public int addattention(Attention attention){
        return attentionDao.addattention(attention);
    }

    //查询公司
    public List<Map<String,Object>> queryattention(Object atid){
        return attentionDao.queryattention(atid);
    }

    //取消关注
    public int delattention(Integer atid){
        return attentionDao.delattention(atid);
    }

    //判断该公司是否已关注
    public List<Map<String,Object>> selectatten(Integer epid,Object useid){
        return attentionDao.selectatten(epid,useid);
    }


}
