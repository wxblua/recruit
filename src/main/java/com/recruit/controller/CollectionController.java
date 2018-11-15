package com.recruit.controller;

import com.recruit.entity.Collections;
import com.recruit.service.CollectionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("coll")
public class CollectionController {

    @Resource
    private CollectionService collectionService;

    //查询职位
    @RequestMapping("querycoll")
    public@ResponseBody
    List<Map<String,Object>> querycollection(HttpServletRequest request){
        Object ob=request.getSession().getAttribute("userid");
        List<Map<String,Object>> list=collectionService.querycollection(ob);
        return list;
    }

    //收藏职位
    @RequestMapping("addcoll")
    public@ResponseBody boolean addcollection(Collections collection, HttpServletRequest request){
        Object ob=request.getSession().getAttribute("userid");
        collection.setUseid(ob);
        if (collectionService.selectcoll(collection.getInfoid(),collection.getUseid()).size()>0){
                return false;
        } else{
            if(collectionService.addcollection(collection)>0){
                return true;
            }else{
                return false;
            }
        }
    }

    //取消收藏
    @RequestMapping("delcoll")
    public@ResponseBody boolean delcollection(Integer coid){
        if(collectionService.delcollection(coid)>0){
            return true;
        }
        return false;
    }

}
