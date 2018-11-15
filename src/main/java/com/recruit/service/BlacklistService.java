package com.recruit.service;

import com.recruit.dao.BlacklistDao;
import com.recruit.entity.Blacklist;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BlacklistService {

    @Resource
    private BlacklistDao blacklistDao;

    //添加黑名单
    public int addblacklist(Blacklist blacklist){
        return blacklistDao.addblacklist(blacklist);
    }

    //查询黑名单
    public List<Map<String,Object>> queryblacklist(Object useid){
        return blacklistDao.queryblacklist(useid);
    }

   //取消加入黑名单
   public int delblacklist(Integer bid){
       return blacklistDao.delblacklist(bid);
   }

   //判断该公司是否已加入黑名单
   public List<Map<String,Object>> selectlacklist(Integer epid, Object useid){
       return blacklistDao.selectlacklist(epid,useid);
   }

}
