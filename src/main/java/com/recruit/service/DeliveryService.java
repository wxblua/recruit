package com.recruit.service;

import com.recruit.dao.DeliveryDao;
import com.recruit.entity.Delivery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class DeliveryService {

    @Resource
    private DeliveryDao deliveryDao;

    //投递
    public List<Map<String,Object>> querydelivery(Integer useid, Integer infoid){
        return deliveryDao.querydelivery(useid,infoid);
    }

    //添加
    public int adddelivery(Delivery delivery){
        return deliveryDao.adddelivery(delivery);
    }

}
