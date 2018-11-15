package com.recruit.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruit.util.DownUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
 
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
@Controller
@RequestMapping("/dos")
public class download{

	
	@RequestMapping(value = "/service")
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		System.out.println("进来了");
			request.setCharacterEncoding("utf-8");
			String name="王五";
		        Map<String, Object> map = new HashMap<String, Object>();  
				/* Enumeration<String> paramNames = req.getParameterNames();
		        // 通过循环将表单参数放入键值对映射中  
		        while (paramNames.hasMoreElements()) {  
		            String key = paramNames.nextElement();  
		            String value = req.getParameter(key);  
		            map.put(key, value);  
		        }*/  
		        map.put("name", name);
		        map.put("phone", ":133333333333");
		        map.put("address", ":郑州市二七区");
		        map.put("age", ":25");
		        map.put("sex", ":女");
		        map.put("money", ":1.5W");
		        map.put("type", ":在职");
		        map.put("java", ":精通Java语言 SQL调优"); 
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
