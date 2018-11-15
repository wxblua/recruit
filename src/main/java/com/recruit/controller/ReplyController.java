package com.recruit.controller;

import com.recruit.entity.Reply;
import com.recruit.service.ReplyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("rep")
public class ReplyController {

    @Resource
    private ReplyService replyService;

    //回复投诉
    @RequestMapping("addrep")
    public@ResponseBody
    Integer addreply(Reply reply){
        return replyService.addreply(reply);
    }

    //查询投诉
    @RequestMapping("queryrep")
    public@ResponseBody List<Map<String,Object>> queryreply(HttpSession session, HttpServletRequest request){
        List<Map<String,Object>> list=replyService.queryreply((Integer) request.getSession().getAttribute("userid"));
        return list;
    }

    //更新状态
    @RequestMapping("updaterep")
    public@ResponseBody Integer updatestate(Integer rstate){
        return replyService.updatereply(rstate);
    }

}
