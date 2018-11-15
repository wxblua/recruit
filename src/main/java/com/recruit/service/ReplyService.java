package com.recruit.service;

import com.recruit.dao.ReplyDao;
import com.recruit.entity.Reply;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ReplyService {

    @Resource
    private ReplyDao replyDao;

    //回复投诉
    public int addreply(Reply reply){
        return replyDao.addreply(reply);
    }

    //查询投诉
    public List<Map<String,Object>> queryreply(Integer useid){
        return replyDao.queryreply(useid);
    }

    //更新状态
    public int updatereply(Integer rid){
        return replyDao.updatereply(rid);
    }

}
