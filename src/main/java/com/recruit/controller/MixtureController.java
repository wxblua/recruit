package com.recruit.controller;


import com.recruit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 混合Controller
 * 不加窄话的
 */

@Controller
public class MixtureController {

    @Autowired
    UserService use;

    /**
     * 注册时修改用户状态，完成注册验证
     * @param
     * @return
     */
    @RequestMapping("logUp")
    public String logUp(String email){
        String  score="login";
        if(email != null){
            use.update("1",email);
        }
        return score;
    }

}
