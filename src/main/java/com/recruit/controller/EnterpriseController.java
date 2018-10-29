package com.recruit.controller;

import com.recruit.entity.Companyscale;
import com.recruit.entity.Companytype;
import com.recruit.entity.Enterprise;
import com.recruit.entity.Industrytype;
import com.recruit.service.EnterpriseUservice;
import com.recruit.util.SmsVerification;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Resource
    EnterpriseUservice enterpriseUservice;

    @RequestMapping("searchFile")
    @ResponseBody
    public String searchFile(HttpSession session){
        String emails=(String) session.getAttribute("list");
        String score=null;
        if(emails != null){
            List<Map<String,Object>> list1=enterpriseUservice.searchById(emails);
            score=list1.get(0).get("companyimage").toString();
        }
        return score;
    }

    @RequestMapping("eplogin")
    @ResponseBody
    public boolean eplogin(String epemail, String eppwd, HttpServletRequest request){
        List<Enterprise> list=enterpriseUservice.eplogin(epemail,eppwd);
        HttpSession session=request.getSession();
        session.setAttribute("list",list.get(0).getEpemail());
        if(list.size()>0){
            return true;
        }else{
            return false;
        }
    }

    /*退出登陆销毁session*/
    @RequestMapping("session")
    public String session(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.invalidate();
        System.out.println("已销毁");
        return "reception/login2";
    }

    /*从session中读取用户的邮箱*/
    @RequestMapping("showeplogin")
    @ResponseBody
    public String showeplogin(HttpSession session){
        String epemail=(String)session.getAttribute("list");
        return epemail;
    }
    @RequestMapping("updateepinfo2")
    @ResponseBody
    public Integer updateepinfo2(Enterprise enterprise){
        return enterpriseUservice.updateepinfo2(enterprise);
    }
    /*查询企业账户信息*/
    @RequestMapping("queryAllEnterprise")
    @ResponseBody
    public List<Enterprise> queryAllEnterprise(HttpSession session){

        String emails=(String) session.getAttribute("list");
        int score=0;
        if(emails != null){
            List<Map<String,Object>> list1=enterpriseUservice.searchById(emails);
            score=Integer.parseInt(list1.get(0).get("epid").toString());
        }
        return enterpriseUservice.queryAllEnterprise(score);
    }
    /*注册企业用户*/
    @RequestMapping("addepinfo")
    @ResponseBody
    public boolean addepinfo(Enterprise enterprise){
        return enterpriseUservice.addepinfo(enterprise);
    }
    /*完善企业用户注册信息*/
    @RequestMapping("updateepinfo")
    @ResponseBody
    public boolean updateepinfo(@RequestBody Enterprise enterprise){
        if(enterpriseUservice.updateepinfo(enterprise)>0){
            return true;
        }else{
            return false;
        }
    }
    /*上传公司证书*/
    @RequestMapping("updateUpload")
    @ResponseBody
    public boolean updateUpload(@RequestParam MultipartFile file,HttpServletRequest request,HttpSession session) throws Exception{
        String emails=(String) session.getAttribute("list");
        int score=0;
        if(emails != null){
            List<Map<String,Object>> list1=enterpriseUservice.searchById(emails);
            score=Integer.parseInt(list1.get(0).get("epid").toString());
        }
        String names=file.getOriginalFilename();
        //使用UUID给图片重命名，并去掉四个“-”
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        //获取文件的扩展名
        String ext = FilenameUtils.getExtension(file.getOriginalFilename());
        //设置图片上传路径
        String url = request.getSession().getServletContext().getRealPath("backstageone/upload/"+name+"."+ext);
        //以绝对路径保存重名命后的图片
        String filename=url.substring(url.indexOf("upload"));
        File saveFile=new File(url);
        file.transferTo(saveFile);
       //把图片存储路径保存到数据库
        if(enterpriseUservice.updateUpload(filename,score)>0){
           return true;
        }else{
            return false;
        }

    }
    /*手机验证*/
    @RequestMapping("epphones")
    @ResponseBody
    public int epphones(String epphone){
        SmsVerification sms=new SmsVerification();
        return sms.getVerificationCode(epphone);
    }
    /*查询公司类型*/
    @RequestMapping("queryCompanytype")
    @ResponseBody
    public List<Companytype> queryCompanytype(){
        return enterpriseUservice.queryCompanytype();
    }
    /*查询行业类型*/
    @RequestMapping("queryIndustrytype")
    @ResponseBody
    public List<Industrytype> queryIndustrytype(){
        return enterpriseUservice.queryIndustrytype();
    }
    /*查询公司规模*/
    @RequestMapping("queryCompanyscale")
    @ResponseBody
    public List<Companyscale> queryCompanyscale(){
        return enterpriseUservice.queryCompanyscale();
    }
    /*修改个人资格认证*/
    @RequestMapping("updateEpstate")
    @ResponseBody
    public Integer updateEpstate(Integer epid){
        return enterpriseUservice.updateEpstate(epid);
    }



    @RequestMapping("queryent")
    public @ResponseBody
    List<Map<String,Object>> queryentprise(Model m){
        List<Map<String,Object>> list=enterpriseUservice.queryenterprise();
        m.addAttribute("list",list);
        return list;
    }
}
