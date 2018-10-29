package com.recruit.controller;

import com.recruit.entity.*;
import com.recruit.service.EnterpriseUservice;
import com.recruit.service.RecruitmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/recruitment")
public class RecruitmentController {

    @Resource
    RecruitmentService recruitmentService;

    @Resource
    EnterpriseUservice enterpriseUservice;


    /*查询招聘信息*/
    @RequestMapping("queryAllRecruitment")
    @ResponseBody
    public List<Map<String,Object>> queryAllRecruitment(HttpSession session){
        String emails=(String) session.getAttribute("list");
        int score=0;
        if(emails != null){
            List<Map<String,Object>> list1=enterpriseUservice.searchById(emails);
            score=Integer.parseInt(list1.get(0).get("epid").toString());
        }
        return recruitmentService.queryAllRecruitment(score);
    }
    /*一个公司只显示一个职位*/
    @RequestMapping("searchrecruit")
    @ResponseBody
    public List<Map<String,Object>> searchrecruit(){
        return recruitmentService.searchrecruit();
    }
    /*新增招聘信息*/
    @RequestMapping("addRecruitment")
    @ResponseBody
    public boolean addRecruitment(@RequestBody Recruitment recruitment, HttpSession session){
        String address=recruitment.getProvince1()+","+recruitment.getCity()+","+recruitment.getDistrictl();
        String emails=(String) session.getAttribute("list");
        int score=0;
        if(emails != null){
            List<Map<String,Object>> list1=enterpriseUservice.searchById(emails);
            score=Integer.parseInt(list1.get(0).get("epid").toString());
        }
        recruitment.setWorkaddress(address);
        recruitment.setEpid(score);

        return recruitmentService.addRecruitment(recruitment);
    }

    /*查询职位类别表*/
    @RequestMapping("queryjobcategory")
    @ResponseBody
    public List<Jobcategory> queryjobcategory(){
        return recruitmentService.queryjobcategory();
    }
    /*查询月薪范围*/
    @RequestMapping("querysrange")
    @ResponseBody
    public List<Srange> querysrange(){
        return recruitmentService.querysrange();
    }
    /*查询工作年限*/
    @RequestMapping("queryyearsworking")
    @ResponseBody
    public List<Yearsworking> queryyearsworking(){
        return recruitmentService.queryyearsworking();
    }
    /*查询公司福利*/
    @RequestMapping("querycpwelfare")
    @ResponseBody
    public List<Cpwelfare> querycpwelfare(){
        return recruitmentService.querycpwelfare();
    }
    /*学历*/
    @RequestMapping("queryeducation")
    @ResponseBody
    public List<Education> queryeducation(){
        return recruitmentService.queryeducation();
    }
    @RequestMapping("delrecruitment")
    @ResponseBody
    public Integer delrecruitment(Integer infoid){
        return recruitmentService.delrecruitment(infoid);
    }
}
