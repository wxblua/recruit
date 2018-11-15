package com.recruit.controller;

import com.recruit.service.UpresumeService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("upresume")
public class UpresumeController {

    @Resource
    UpresumeService upresumeService;

    @RequestMapping("add")
    @ResponseBody
    public boolean add(@RequestParam MultipartFile file, HttpServletRequest request)throws Exception{
        String names=file.getOriginalFilename();
        //使用UUID给图片重命名，并去掉四个“-”
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        //获取文件的扩展名
        String ext = FilenameUtils.getExtension(file.getOriginalFilename());
        //设置图片上传路径
        String url = request.getSession().getServletContext().getRealPath("reception/image/"+name+"."+ext);
        //以绝对路径保存重名命后的图片
        String filename=url.substring(url.indexOf("image"));
        File saveFile=new File(url);
        file.transferTo(saveFile);

        if(upresumeService.add(filename)>0){
            return true;
        }else{
            return false;
        }
    }
}
