package com.recruit.controller;

import com.recruit.entity.Attention;
import com.recruit.service.AttentionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("atten")
public class AttentionController {

    @Resource
    private AttentionService attentionService;

    //关注公司
    @RequestMapping("addatten")
    public@ResponseBody
    boolean addattention(Attention attention, HttpServletRequest request){
        Object ob=request.getSession().getAttribute("userid");
        attention.setUseid(ob);
        if (attentionService.selectatten(attention.getEpid(),attention.getUseid()).size()>0){
            return false;
        }else {
            if (attentionService.addattention(attention)>0){
                return true;
            }else{
                return false;
            }
        }
    }

    //取消关注
    @RequestMapping("delatten")
    public@ResponseBody boolean delattention(Integer atid){
        if(attentionService.delattention(atid)>0){
            return true;
        }
        return false;
    }

    //查询公司
    @RequestMapping("queryatten")
    public@ResponseBody List<Map<String,Object>> queryattention( HttpServletRequest request){
        Object ob=request.getSession().getAttribute("userid");
        return attentionService.queryattention(ob);
    }
}