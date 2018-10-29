package com.recruit.controller;

import com.recruit.entity.Workexperience;
import com.recruit.service.WorkexperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("workexperience")
public class WorkexperienceController {

    @Autowired
    WorkexperienceService workexperienceService;

    @RequestMapping("query")
    public List<Map<String,Object>> query(HttpSession session){
        List<Map<String, Object>> list=workexperienceService.query(1);
        return list;
    }

    @RequestMapping("workexperienceUpdate")
    public boolean workexperienceUpdate(String name,String positionName,String startYear,String startMonth,String endYear,String endMonth,HttpSession session)throws Exception{
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
        if (workexperienceService.workexperienceUpdate(name,positionName,date=sdf.parse(Year),date1=sdf.parse(Month),1) > 0 ){
            fig=true;
        }
        return fig;
    }

    /*添加工作经历*/
    @RequestMapping("addworkperi")
    public Integer addworkperi(Workexperience workexperience){
        return workexperienceService.addworkperi(workexperience);
    }

}
