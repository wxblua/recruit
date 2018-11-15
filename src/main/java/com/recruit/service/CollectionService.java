package com.recruit.service;

import com.recruit.dao.CollectionDao;
import com.recruit.entity.Collections;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CollectionService {

    @Resource
    private CollectionDao collectionDao;

    //收藏职位
    public int addcollection(Collections collection){
        return collectionDao.addcollection(collection);
    }

    //查询职位
    public List<Map<String,Object>> querycollection(Object coid){
        return collectionDao.querycollection(coid);
    }

    //取消收藏
    public int delcollection(Integer coid){
        return collectionDao.delcollection(coid);
    }

    //判断是否已收藏
    public List<Map<String,Object>> selectcoll(Integer infoid,Object useid){
        return  collectionDao.selectcoll(infoid,useid);
    }

}
