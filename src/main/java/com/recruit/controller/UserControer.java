package com.recruit.controller;

import com.recruit.service.UserService;
import com.recruit.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
@SessionAttributes("email")
public class UserControer {

    @Autowired
    UserService use;

    /**
     * 使用邮箱注册 把账号保存的session中
     * @param email
     * @param password
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("logAdd")
    @ResponseBody
    public String logadd(String email, String password, Model model, HttpSession session){
        String score="2";
        if(use.query(email).size() == 0) {
            try {
                EmailUtil.EmailHtml(email);
                use.save(email, password);
                session.setAttribute("email", email);
                score = "1";
            } catch (Exception e) {
                score = "2";
                e.printStackTrace();
            }
        }else{
            score="3";
        }
        return score;
    }

    /**
     * 用户登录,登录成功保存Session
     * @param email
     * @param pwd
     * @return
     */
    @RequestMapping("log")
    @ResponseBody
    public boolean log(String email, String pwd, HttpSession session, Model model){
        boolean ble=false;
        if(use.log(email, pwd).size() == 1){
            session.setAttribute("email",email);
            ble=true;
        }
        return ble;
    }

    /**
     * 返回Session中的值
     * @param session
     * @return
     */
    @RequestMapping("share")
    @ResponseBody
    public String share(HttpSession session){
        String email=(String)session.getAttribute("email");
        return email;
    }

    @RequestMapping("query")
    public @ResponseBody List<Map<String,Object>> queryuser(Model m){
        List<Map<String,Object>> list=use.queryuser();
        m.addAttribute("list",list);
        return list;
    }

}
