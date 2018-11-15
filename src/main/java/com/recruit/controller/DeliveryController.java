package com.recruit.controller;

import com.recruit.entity.Delivery;
import com.recruit.service.DeliveryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("liver")
public class DeliveryController {

    @Resource
    private DeliveryService deliveryService;

    //查询
    @RequestMapping("querydelivery")
    public@ResponseBody
    List<Map<String,Object>> querydelivery(Integer infoid, HttpServletRequest request){
        List<Map<String,Object>> list=deliveryService.querydelivery((Integer) request.getSession().getAttribute("userid"),infoid);
        return list;
    }

    //添加
    @RequestMapping("adddelivery")
    public@ResponseBody Integer adddelivery(Delivery delivery,HttpServletRequest request){
        delivery.setUseid((Integer) request.getSession().getAttribute("userid"));
        System.out.println(delivery);
        return deliveryService.adddelivery(delivery);
    }

}
