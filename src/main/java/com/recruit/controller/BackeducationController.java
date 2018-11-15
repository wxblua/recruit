package com.recruit.controller;

import com.recruit.service.BackeducationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/backeducation")
public class BackeducationController {

    @Resource
    BackeducationService backeducationService;

    @RequestMapping("queryBackeducation")
    public List<Map<String,Object>> queryBackeducation(Integer reid){
        return backeducationService.queryBackeducation(reid);
    }
    @RequestMapping("addBackeducation")
    public boolean addBackeducation(String schoolName,String education,String professional,String startYear,String endYear,Integer reid)throws Exception{
        boolean fig=false;
        String bename=schoolName;
        String beducation=education;
        String bemajorname=professional;
        String Year="";
        String Year1="";
        Date date=null;
        Date date1=null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        if(startYear != null){
            Year=startYear+"-01-01";
        }
        if(endYear != null){
            Year1=endYear+"-01-01";
        }
        if(backeducationService.addBackeducation(bename,beducation,bemajorname,date=sdf.parse(Year),date1=sdf.parse(Year1),reid)>0){
            fig=true;
        }
        return fig;
    }
    @RequestMapping("delBackeducation")
    public Integer delBackeducation(Integer beid){
        return backeducationService.delBackeducation(beid);
    }
}
