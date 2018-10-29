package com.recruit.controller;

import com.recruit.service.ComplainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("complain")
public class ComplainController {

    @Resource
    private ComplainService comservice;

    //查询投诉
    @RequestMapping("querycom")
    public@ResponseBody
    List<Map<String,Object>> querycomp(){
        List<Map<String,Object>> list=comservice.querycomplain();
        return list;
    }

    //删除投诉
    @RequestMapping("delcom")
    public@ResponseBody boolean delcomp(Integer cid){
        if (comservice.delcomplatin(cid)>0){
            return true;
        }
        return false;
    }

}
