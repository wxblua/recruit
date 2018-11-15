package com.recruit.controller;

import com.recruit.entity.Resume;
import com.recruit.service.EnterpriseUservice;
import com.recruit.service.ResumeService;
import com.recruit.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("resume")
@SessionAttributes("email")
public class ResumeController {

    @Resource
    ResumeService resumeService;
    @Resource
    UserService userService;
    @Resource
    EnterpriseUservice enterpriseUservice;

    /**
     * 查看简历的基本信息
     * @param session
     * @return
     */
    @RequestMapping("query")
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
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

    @RequestMapping("queryResume")
    @ResponseBody
    public List<Map<String,Object>> queryResume(HttpSession session){

        String emails=(String) session.getAttribute("list");
        int score=0;
        if(emails != null){
            List<Map<String,Object>> list1=enterpriseUservice.searchById(emails);
            score=Integer.parseInt(list1.get(0).get("epid").toString());
        }
        return resumeService.queryResume(score);
    }

    @RequestMapping("queryBackResume")
    @ResponseBody
    public List<Map<String,Object>> queryBackResume(HttpSession session,Integer userid){
        String email=(String)session.getAttribute("email");
        int score=0;
        if(email != null){
            List<Map<String,Object>> list=userService.major(email);
            score=Integer.parseInt(list.get(0).get("useid").toString());
        }
        return resumeService.queryBackResume(score);
    }

    @RequestMapping("queryById")
    public String queryById(Model model, Integer reid){
        System.out.println(reid);
        List<Map<String,Object>> list=resumeService.queryById(reid);
        model.addAttribute("list",list);
        System.out.println(list);
        return "backstageone/resume-queryall";
    }

    @RequestMapping("updateResume")
    @ResponseBody
    public Integer updateResume(Integer reid){
        return resumeService.updateResume(reid);
    }
    @RequestMapping("updateviewed")
    @ResponseBody
    public Integer updateviewed(Integer reid){
        return resumeService.updateviewed(reid);
    }
    @RequestMapping("updatanotice")
    @ResponseBody
    public Integer updatanotice(Integer reid){
        return resumeService.updatanotice(reid);
    }
    @RequestMapping("inappropriate")
    public Integer inappropriate(Integer reid){ return resumeService.inappropriate(reid); }

    @RequestMapping("test")
    public List<Map<String,Object>> test(){
        System.out.println(1);
        return resumeService.test();
    }

    //申请职位
    @RequestMapping("addresu")
    public String addresume(Resume resume,@RequestParam("reimages") MultipartFile reimages, HttpServletRequest request){

        if (!reimages.isEmpty()){
            try {
                String upload=request.getSession().getServletContext().getRealPath("reception/image");
                File f=new File(upload);
                String name=reimages.getOriginalFilename();
                String uuids= UUID.randomUUID().toString()+name.substring(name.lastIndexOf("."));
                File ser=new File(upload+uuids);
                reimages.transferTo(ser);
                resume.setReimage(uuids);
                resume.setRestate(0);
                resume.setUserid((Integer) request.getSession().getAttribute("userid"));
                // resume.setReid(6);
                System.out.println(resume);
                if(resumeService.addresume(resume)>0){
                    return "true";
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return "false";
    }

    //通过用户查看是否有简历
    @RequestMapping("selectresume")
    public@ResponseBody List<Map<String,Object>> queryresume(HttpServletRequest request){
        List<Map<String,Object>> list=resumeService.querybyuid((Integer) request.getSession().getAttribute("userid"));
        return list;
    }
}
