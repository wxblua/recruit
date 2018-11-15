package com.recruit.service;

import com.recruit.dao.RecruitmentDao;
import com.recruit.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class RecruitmentService {
    @Resource
    RecruitmentDao recruitmentDao;

    /*查询招聘信息*/
    public List<Map<String,Object>> queryAllRecruitment(Integer epid){
        return recruitmentDao.queryAllRecruitment(epid);
    }
    /*一个公司只显示一个职位*/
    public List<Map<String,Object>> searchrecruit(){
        return recruitmentDao.searchrecruit();
    }
    /*根据id查询企业的信息*/
    public List<Map<String,Object>> queryepid(Integer epid,Integer infoid){
        return recruitmentDao.queryepid(epid,infoid);
    }
    /*查询该公司的所有职位*/
    public List<Map<String,Object>> queryAllposition(Integer epid){
        return recruitmentDao.queryAllposition(epid);
    }
    /*新增招聘信息*/
    public boolean addRecruitment(Recruitment recruitment){
        return recruitmentDao.addRecruitment(recruitment);
    }
    /*根据epid查询公司的信息*/
    public List<Map<String,Object>> queryAllenterprise(Integer epid){
        return recruitmentDao.queryAllenterprise(epid);
    }
    /*查询职位类别表*/
    public List<Jobcategory> queryjobcategory(){
        return recruitmentDao.queryjobcategory();
    }
    /*查询月薪范围*/
    public List<Srange> querysrange(){
        return recruitmentDao.querysrange();
    }
    /*查询工作年限*/
    public List<Yearsworking> queryyearsworking(){
        return recruitmentDao.queryyearsworking();
    }
    /*查询公司福利*/
    public List<Cpwelfare> querycpwelfare(){
        return recruitmentDao.querycpwelfare();
    }
    /*学历*/
    public List<Education> queryeducation(){
        return recruitmentDao.queryeducation();
    }
    /*删除职位*/
    public Integer delrecruitment(Integer infoid){
        return recruitmentDao.delrecruitment(infoid);
    }

    //自动补全
    public List<Map<String,Object>> queryall(String introduction){
        return recruitmentDao.queryall(introduction);
    }

    /**
     * 按名称查询招聘信息
     * @param name
     * @return
     */
    public List<Map<String,Object>> queryAllRecruitmentByName(String name){
        return recruitmentDao.queryAllRecruitmentByName(name);
    }

}
