package com.recruit.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
    	//这里可以做查询数据库数据业务逻辑
    	//以下是测试数据，不连接数据库
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("name", "张三");
        dataMap.put("phone", ":133333333333");
        dataMap.put("address", ":郑州市二七区");
        dataMap.put("age", ":25");
        dataMap.put("sex", ":女");
        dataMap.put("money", ":1.5W");
        dataMap.put("type", ":在职");
        dataMap.put("java", ":精通Java语言 SQL调优");
        
        //列表数据封装
        List<String> list1 = new ArrayList<String>();
        list1.add("itema");
        list1.add("itemb");
        list1.add("itemc");

        dataMap.put("list1", list1);

        DocumentHandler mdoc = new DocumentHandler();
        //下载地址，以下地址是Mac电脑使用地址，如Windows F:/
        mdoc.createDoc(dataMap, "D:/"+dataMap.get("name")+".doc");
    }

}
