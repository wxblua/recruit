package com.recruit.controller;

import com.recruit.entity.Advertising;
import com.recruit.service.AdvertisingService;
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
@RequestMapping("adver")
public class AdvertisingController {

    @Resource
    private AdvertisingService adverservice;

    //查询广告
    @RequestMapping("queryadv")
    public @ResponseBody
    List<Map<String,Object>> queryadvsing(){
        List<Map<String,Object>> list=adverservice.queryadver();
        return list;
    }

    //添加广告
    @RequestMapping("addadv")
    public String addadvising(String atitle,Integer positionid,@RequestParam("aimage") MultipartFile aimage, HttpServletRequest request){
        if(!aimage.isEmpty()){
            try {
                String upload=request.getSession().getServletContext().getRealPath("webback/uploadimg/")+"images";
                File f=new File(upload);
                String name=aimage.getOriginalFilename();
                String uuids=UUID.randomUUID().toString()+name.substring(name.lastIndexOf("."));
                System.out.println(uuids);
                File ser=new File(upload+uuids);
                aimage.transferTo(ser);
                Advertising a=new Advertising();
                System.out.print(uuids);
                a.setAtitle(atitle);
                a.setPositionid(positionid);
                a.setAimage(uuids);
                if(adverservice.addadv(a)>0){
                    return "redirect:/webback/queryadvertising.html";
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return "error";
    }

    //删除
    @RequestMapping("deladv")
    public@ResponseBody boolean deladvertising(Integer aid){
        if(adverservice.deladv(aid)>0){
            return true;
        }
        return false;
    }

    //按编号查询
    @RequestMapping("queryadvid")
    public@ResponseBody List<Map<String,Object>> querybyid(Integer aid){
        List<Map<String,Object>> list=adverservice.querybyid(aid);
        return list;
    }

    //修改
    @RequestMapping("updateadv")
    public@ResponseBody boolean updateadvertising(Advertising advertising){
        if (adverservice.updateadv(advertising)>0){
            return true;
        }
        return false;
    }

}
