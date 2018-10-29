package com.recruit.controller;

import com.recruit.entity.Resume;
import com.recruit.service.ResumeService;
import com.recruit.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("resume")
@SessionAttributes("email")
public class ResumeController {

    @Resource
    ResumeService resumeService;
    @Resource
    UserService userService;

    /**
     * 查看简历的基本信息
     * @param session
     * @return
     */
    @RequestMapping("query")
    public List<Resume> query(HttpSession session){
        String email=(String)session.getAttribute("email");
        int score=0;
        if(email != null){
            List<Map<String,Object>> list=userService.major(email);
            score=Integer.parseInt(list.get(0).get("useid").toString());
        }
        List<Resume> list=resumeService.query(score);
        return list;
    }

    /**
     * 获取Session查询id,修改简历信息
     * @param name
     * @param session
     * @return
     */
    @RequestMapping("name")
    public boolean name(String name, HttpSession session){
        boolean selp=false;
        String email=(String)session.getAttribute("email");
        int score=0;
        if(email != null){
            List<Map<String,Object>> list=userService.major(email);
            score=Integer.parseInt(list.get(0).get("useid").toString());
        }
        if(email != null){
            if(name != "" && name != null){
                if(resumeService.name(name,score) > 0){
                    selp=true;
                }
            }
        }else{
            return false;
        }
        return selp;
    }

    /**
     * 修改基本信息
     * @param name
     * @param sex
     * @param status
     * @param highestEducation
     * @param workYear
     * @param phone
     * @param email
     * @param session
     * @return
     */
    @RequestMapping("updatebasicinfo")
    public boolean updatebasicinfo(String name,String sex,String status,String highestEducation,String workYear,String phone,String email,HttpSession session) {
        String emailinfo=(String)session.getAttribute("email");
        int score=0;
        if(email != null){
            List<Map<String,Object>> list=userService.major(emailinfo);
            score=Integer.parseInt(list.get(0).get("useid").toString());
        }
        if(emailinfo != null){
            resumeService.basic(name,sex,status,highestEducation,workYear,phone,email,score);
            return true;
        }else{
            return false;
        }
    }

    /**
     * 修改头像,上传文件
     * @param file
     * @return
     */
    @RequestMapping("fileUpdate")
    public Object fileUpdate(@RequestParam MultipartFile[] headPic, HttpServletRequest request, HttpSession session, String file) throws  Exception{
        String email=(String)session.getAttribute("email");
        int score=0;
        if(email != null){
            List<Map<String,Object>> list=userService.major(email);
            score=Integer.parseInt(list.get(0).get("useid").toString());
        }
        boolean judge=false;
        String name=null;
        for(MultipartFile ss : headPic) {
            name = ss.getOriginalFilename();
            if (!name.equals("")) {
                String sss = request.getServletContext().getRealPath("reception/style/img") + "/" + name;
                File file1 = new File(sss);
                ss.transferTo(file1);
                String  namess=sss.substring(sss.indexOf("img"));
                resumeService.picture("style/"+namess,score);
                judge=true;
            }
        }
        return judge;
    }



}
