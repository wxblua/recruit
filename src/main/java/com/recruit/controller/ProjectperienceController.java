package com.recruit.controller;


import com.recruit.service.ProjectperienceServiec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("projectperience")
public class ProjectperienceController {


    @Autowired
    ProjectperienceServiec projectperienceServiec;


    @RequestMapping("query")
    public List query(Integer reid){
        List<Map<String,Object>> list=projectperienceServiec.query(reid);
        return list;
    }

    @RequestMapping("projectperienceUpdate")
    public boolean projectperienceUpdate(){
        return true;
    }

    @RequestMapping("addprojectperi")
    public boolean addprojectperi(String projectRemark,String pjname,String startYear,String startMonth,String endYear,String endMonth, String pjresponsibility, Integer reid)throws Exception{
        String pjdescribe=projectRemark;
        boolean fig=false;
        String Year="";
        String Month="";
        Date date=null;
        Date date1=null;
        SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-mm-dd");
        if(startYear != null  && startMonth != null){
            Year=startYear+"-"+startMonth+"-01";
        }
        if(endYear.equals("至今")){
            Month=sdf.format(new Date());
        }else if(endYear != null  && endMonth != null){
            Month=endYear+"-"+endMonth+"-01";
        }

        if(projectperienceServiec.addprojectperi(pjname,date=sdf.parse(Year),date1=sdf.parse(Month),pjdescribe,pjresponsibility,reid)>0){
            fig=true;
        }
        return fig;
    }

    @RequestMapping("delprojectperi")
    public Integer delprojectperi(Integer pjid){
        return projectperienceServiec.delprojectperi(pjid);
    }
}
