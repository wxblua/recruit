package com.recruit.controller;


import com.recruit.service.ProjectperienceServiec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("projectperience")
public class ProjectperienceController {


    @Autowired
    ProjectperienceServiec projectperienceServiec;


    @RequestMapping("query")
    public List query(){
        List<Map<String,Object>> list=projectperienceServiec.query(1);
        return list;
    }

    @RequestMapping("projectperienceUpdate")
    public boolean projectperienceUpdate(){

        return true;
    }
}
