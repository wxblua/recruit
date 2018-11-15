package com.recruit.controller;

import com.recruit.entity.Complain;
import com.recruit.service.ComplainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("complain")
public class ComplainController {

    @Resource
    private ComplainService comservice;

    //查询投诉
    @RequestMapping("querycom")
    public@ResponseBody
    List<Map<String,Object>> querycomp(){
        List<Map<String,Object>> list=comservice.querycomplain();
        return list;
    }

    //删除投诉
    @RequestMapping("delcom")
    public@ResponseBody boolean delcomp(Integer cid){
        if (comservice.delcomplatin(cid)>0){
            return true;
        }
        return false;
    }


    //添加投诉
    @RequestMapping("addcom")
    @ResponseBody
    public String addcomplain(String ccontents, String ctime, @RequestParam("cimage") MultipartFile cimage, HttpServletRequest request){
        if(!cimage.isEmpty()){
            try {
                String upload=request.getSession().getServletContext().getRealPath("reception/image/")+"image";
                File f=new File(upload);
                String name=cimage.getOriginalFilename();
                String uuids= UUID.randomUUID().toString()+name.substring(name.lastIndexOf("."));
                System.out.println(uuids);
                File ser=new File(upload+uuids);
                cimage.transferTo(ser);
                Complain c=new Complain();
                c.setUseid((Integer)request.getSession().getAttribute("userid"));
                System.out.println(uuids);
                c.setCcontents(ccontents);
                c.setCimage(uuids);
                if(comservice.addcomplain(c)>0){
                    return "true";
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return "false";
    }
}
