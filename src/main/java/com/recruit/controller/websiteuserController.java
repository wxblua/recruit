package com.recruit.controller;

import com.recruit.entity.websiteuser;
import com.recruit.service.websiteuserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("login")
public class websiteuserController {

    @Resource
    private websiteuserService webservice;

    //登录
    @RequestMapping("login")
    public @ResponseBody
    boolean  login(String wname, String wpwd, HttpServletRequest request){
        List<Map<String,Object>> list=webservice.login(wname,wpwd);
        if(list.size()>0){
            request.getSession().setAttribute("backlogin",list);
            return true;
        }
        return false;
    }

    @RequestMapping("queryback")
    public @ResponseBody
    Object querylogin(HttpServletRequest request){
        return request.getSession().getAttribute("backlogin");
    }

    //修改密码
    @RequestMapping("updateweb")
    public @ResponseBody
    String updateweb(String wpwd ,String wid,HttpServletRequest request){
        if(webservice.updatewebsite(wpwd,wid)>0){
            request.getSession().invalidate();//销毁session
            return "true";
        }
        return "false";
    }

    //查询所有
    @RequestMapping("queryall")
    public @ResponseBody Integer queryalll(){
        Integer num=webservice.queryall();
        return num;
    }

    //查询
    @RequestMapping("queryselect")
    public @ResponseBody Integer queryselects(){
        List<Map<String,Object>> list=webservice.queryselect();
        SimpleDateFormat format=new SimpleDateFormat("YYYY-MM-dd");
        String time=format.format(new Date());
        Integer sub=Integer.parseInt(time.substring(8,10));
        int count=0;
        for (int i=0;i<list.size();i++){
            Integer createtime=Integer.parseInt(list.get(i).get("createtime").toString().substring(8,10));
            if (createtime.equals(sub)){
                count++;
            }
        }
        return count;
    }

}