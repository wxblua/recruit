package com.recruit.controller;

import com.recruit.entity.Other;
import com.recruit.service.OtherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/other")
public class OtherController {

   @Resource
    private OtherService otherservice;

   @RequestMapping("queryother")
   @ResponseBody
   public List<Map<String,Object>> queryother(Integer reid){
       List<Map<String,Object>> list=otherservice.queryother(reid);
       return list;
   }

    @RequestMapping("addother")
    @ResponseBody
    public Integer addother(String language,String insteringandspeak,String literacy,String myRemark,Integer reid){
        String assessment=myRemark;
        return otherservice.addother(language,insteringandspeak,literacy,assessment,reid);
    }

    //删除
    @RequestMapping("delother")
    @ResponseBody
    public boolean delother(Integer otherid){
        if(otherservice.delother(otherid)>0){
            return true;
        }
        return false;
    }

    //修改
    @RequestMapping("updateother")
    @ResponseBody
    public boolean updateother(Other other){
        if (otherservice.updateother(other)>0){
            return true;
        }
        return false;
    }
}
