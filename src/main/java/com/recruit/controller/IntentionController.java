package com.recruit.controller;

import com.recruit.service.IntentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("Intention")
public class IntentionController {

    @Autowired
    IntentionService intentionService;

    @RequestMapping("query")
    public List<Map<String, Object>> query(HttpSession session){
        List<Map<String, Object>> list=intentionService.query(1);
        return list;
    }

    @RequestMapping("IntentionUPdate")
    public boolean IntentionUPdate(String city,String positionType,String positionName,String salarys,HttpSession session){
        boolean fig=false;
        if(intentionService.IntentionUPdate(positionName,city,positionType,salarys,1) > 0) {
            fig=true;
        }
        return fig;
    }

}
