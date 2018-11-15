package com.recruit.controller;

import com.recruit.entity.Resume;
import com.recruit.service.*;
import com.recruit.util.DownUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("res")
public class UploadWordController {

    @Resource
    UserService userService;
    @Resource
    IntentionService intentionService;
    @Resource
    ResumeService resumeService;
    @Resource
    WorkexperienceService workexperienceService;
    @Resource
    ProjectperienceServiec projectperienceServiec;
    @Resource
    BackeducationService backeducationService;
    @Resource
    private OtherService otherservice;

    @RequestMapping(value = "/service")
    protected void service(Integer reid, HttpServletRequest request, HttpServletResponse response, HttpSession session)throws ServletException, IOException {
        String email=(String)session.getAttribute("email");
        int score=0;
        if(email != null){
            List<Map<String,Object>> list0=userService.major(email);
            score=Integer.parseInt(list0.get(0).get("useid").toString());
        }
        List<Resume> list1=resumeService.query(score);
        String rename=list1.get(0).getRename();
        String resex=list1.get(0).getResex();
        Integer reage=list1.get(0).getReage();
        String rexperience=list1.get(0).getRexperience();
        String rephone=list1.get(0).getRephone();
        String remail=list1.get(0).getRemail();
        String jobhunter=list1.get(0).getJobhunter();
        List<Map<String, Object>> list=intentionService.query(reid);
        String inpositionid=(String)list.get(0).get("inpositionid");
        String inworknature=(String)list.get(0).get("inworknature");
        String insalary=(String)list.get(0).get("insalary");
        String inworkaddress=(String)list.get(0).get("inworkaddress");
        List<Map<String, Object>> worklist=workexperienceService.query(reid);
        String wpcompanyname=(String)worklist.get(0).get("wpcompanyname");
        String wpinposition=(String)worklist.get(0).get("wpinposition");
        Date wpstarttime=(Date)worklist.get(0).get("wpstarttime");
        Date wpstopetime=(Date)worklist.get(0).get("wpstopetime");
        List<Map<String,Object>> prjlist=projectperienceServiec.query(reid);
        String pjname=(String)prjlist.get(0).get("pjname");
        String pjresponsibility=(String)prjlist.get(0).get("pjresponsibility");
        Date pjstarttime=(Date)prjlist.get(0).get("pjstarttime");
        Date pjstopetime=(Date)prjlist.get(0).get("pjstopetime");
        String pjdescribe=(String)prjlist.get(0).get("pjdescribe");
        List<Map<String,Object>> bjlist=backeducationService.queryBackeducation(reid);
        String bename=(String)bjlist.get(0).get("bename");
        String beducation=(String)bjlist.get(0).get("beducation");
        String bemajorname=(String)bjlist.get(0).get("bemajorname");
        Date bestarttime=(Date)bjlist.get(0).get("bestarttime");
        Date bestopetime=(Date)bjlist.get(0).get("bestopetime");
        List<Map<String,Object>> otherlist=otherservice.queryother(reid);
        String language=(String)otherlist.get(0).get("language");
        String insteringandspeak=(String)otherlist.get(0).get("insteringandspeak");
        String literacy=(String)otherlist.get(0).get("literacy");
        String assessment=(String)otherlist.get(0).get("assessment");
        /**/
        request.setCharacterEncoding("utf-8");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rename",rename);
        map.put("resex",resex);
        map.put("reage",reage);
        map.put("rexperience",rexperience);
        map.put("rephone",rephone);
        map.put("remail",remail);
        map.put("jobhunter",jobhunter);
        /**/
        map.put("inpositionid",inpositionid);
        map.put("inworknature",inworknature);
        map.put("insalary",insalary);
        map.put("inworkaddress",inworkaddress);
        /**/
        map.put("wpcompanyname",wpcompanyname);
        map.put("wpinposition",wpinposition);
        map.put("wpstarttime",wpstarttime);
        map.put("wpstopetime",wpstopetime);
        /**/
        map.put("pjname",pjname);
        map.put("pjresponsibility",pjresponsibility);
        map.put("pjstarttime",pjstarttime);
        map.put("pjstopetime",pjstopetime);
        map.put("pjdescribe",pjdescribe);
        /**/
        map.put("bename",bename);
        map.put("beducation",beducation);
        map.put("bemajorname",bemajorname);
        map.put("bestarttime",bestarttime);
        map.put("bestopetime",bestopetime);
        /**/
        map.put("language",language);
        map.put("insteringandspeak",insteringandspeak);
        map.put("literacy",literacy);
        map.put("assessment",assessment);
        // 提示：在调用工具类生成Word文档之前应当检查所有字段是否完整
        // 否则Freemarker的模板殷勤在处理时可能会因为找不到值而报错 这里暂时忽略这个步骤了
        File file = null;
        InputStream fin = null;
        ServletOutputStream out = null;
        try {
            // 调用工具类WordGenerator的createDoc方法生成Word文档
            file = DownUtil.createDoc(map, "resume");
            fin = new FileInputStream(file);

            response.setCharacterEncoding("utf-8");
            response.setContentType("application/msword");
            // 设置浏览器以下载的方式处理该文件默认名为resume.doc
            response.addHeader("Content-Disposition","attachment;filename=resume.doc");

            out = response.getOutputStream();
            byte[] buffer = new byte[512]; // 缓冲区
            int bytesToRead = -1;
            // 通过循环将读入的Word文件的内容输出到浏览器中
            while ((bytesToRead = fin.read(buffer)) != -1) {
                out.write(buffer, 0, bytesToRead);
            }
        } finally {
            if (fin != null)
                fin.close();
            if (out != null)
                out.close();
            if (file != null)
                file.delete(); // 删除临时文件
        }
    }
}
