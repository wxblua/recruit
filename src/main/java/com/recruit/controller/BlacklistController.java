package com.recruit.controller;

import com.recruit.entity.Blacklist;
import com.recruit.service.BlacklistService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("blist")
public class BlacklistController {

    @Resource
    private BlacklistService blacklistService;

    //加入黑名单
    @RequestMapping("addblist")
    public@ResponseBody
    boolean addblacklist(Blacklist blacklist, HttpServletRequest request){
        Object ob=request.getSession().getAttribute("userid");
        blacklist.setUseid(ob);
        if (blacklistService.selectlacklist(blacklist.getEpid(),blacklist.getUseid()).size()>0){
            return false;
        }else{
            if (blacklistService.addblacklist(blacklist)>0){
                return true;
            }else {
                return false;
            }
        }
    }

    //取消屏蔽
    @RequestMapping("delblist")
    public@ResponseBody boolean delblacklist(Integer bid){
        if(blacklistService.delblacklist(bid)>0){
            return true;
        }
        return false;
    }

    //查询屏蔽的公司
    @RequestMapping("queryblist")
    public@ResponseBody List<Map<String,Object>> queryblacklist(HttpServletRequest request){
        Object ob=request.getSession().getAttribute("userid");
        return blacklistService.queryblacklist(ob);
    }

}
