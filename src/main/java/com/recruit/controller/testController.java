package com.recruit.controller;

import com.recruit.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class testController {

    @Resource
    TestService testService;

    @RequestMapping("query")
    @ResponseBody
    public List<Map<String,Object>> query(){
        return testService.query();
    }

    @RequestMapping("test1")
    @ResponseBody
    public List<Map<String,Object>> test1(){
        return testService.test1();
    }
    @RequestMapping("test2")
    @ResponseBody
    public List<Map<String,Object>> test2(){
        return testService.test2();
    }
    @RequestMapping("test3")
    @ResponseBody
    public List<Map<String,Object>> test3(){
        return testService.test3();
    }
}
