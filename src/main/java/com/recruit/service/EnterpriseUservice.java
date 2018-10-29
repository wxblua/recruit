package com.recruit.service;

import com.recruit.dao.EnterpriseDao;
import com.recruit.entity.Companyscale;
import com.recruit.entity.Companytype;
import com.recruit.entity.Enterprise;
import com.recruit.entity.Industrytype;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class EnterpriseUservice {

    @Resource
    EnterpriseDao enterpriseDao;

    public List<Map<String,Object>> searchById(String email){
        return enterpriseDao.searchById(email);
    }

    public List<Enterprise> eplogin(String epemail, String eppwd){
        return enterpriseDao.eplogin(epemail,eppwd);
    }
    /*修改公司基本信息*/
    public Integer updateepinfo2(Enterprise enterprise){
        return enterpriseDao.updateepinfo2(enterprise);
    }
    /*查询企业账户信息*/
    public List<Enterprise> queryAllEnterprise(Integer epid){
        return enterpriseDao.queryAllEnterprise(epid);
    }
    /*注册企业用户*/
    public boolean addepinfo(Enterprise enterprise){
        return enterpriseDao.addepinfo(enterprise);
    }
    /*完善企业用户注册信息*/
    public Integer updateepinfo(Enterprise enterprise){
        return enterpriseDao.updateepinfo(enterprise);
    }
    /*上传公司证书*/
    public Integer updateUpload(String companyimage,Integer epid){
        return enterpriseDao.updateUpload(companyimage,epid);
    }
    /*查询公司类型*/
    public List<Companytype> queryCompanytype(){
        return enterpriseDao.queryCompanytype();
    }
    /*查询行业类型*/
    public List<Industrytype> queryIndustrytype(){
        return enterpriseDao.queryIndustrytype();
    }
    /*查询公司规模*/
    public List<Companyscale> queryCompanyscale(){
        return enterpriseDao.queryCompanyscale();
    }
    /*修改个人资格认证*/
    public Integer updateEpstate(Integer epid){
        return enterpriseDao.updateEpstate(epid);
    }

    //查询企业用户
    public List<Map<String,Object>> queryenterprise() {
        return enterpriseDao.queryenterprise();
    }
}
