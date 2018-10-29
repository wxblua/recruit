package com.recruit.util;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

@Component
public class EmailUtil {

    private static JavaMailSenderImpl javaMailSenderImpl;
    private static Properties properties;
    private static SimpleMailMessage simpleMailMessage;
    private static BodyPart bodyPart;

    private static String usename="1285735464@qq.com";
    private static String password="iuaflayjwuwjhbib";


    static {
        javaMailSenderImpl=new JavaMailSenderImpl();
        javaMailSenderImpl.setHost("smtp.qq.com");
        javaMailSenderImpl.setUsername(usename);
        javaMailSenderImpl.setPassword(password);

        properties=new Properties();
        properties.put("mail.smtq.auth","true");
        javaMailSenderImpl.setJavaMailProperties(properties);
    }

    //纯文本的邮件
    public static void EmailText(String to){
        simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom(usename);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject("这是邮件标题");
        simpleMailMessage.setText("这是一封邮件");
        javaMailSenderImpl.send(simpleMailMessage);
    }

    //HTML格式邮件
    public static void EmailHtml(String to) throws Exception{
        //使用JavaMail的MimeMessage，支付更加复杂的邮件格式和内容
        MimeMessage msg = javaMailSenderImpl.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg,true,"utf-8");
        helper.setTo(to);
        helper.setFrom(usename);
        helper.setSubject("欢迎注册XX招聘网");
        helper.setText("<body>" +
                "<h2 style='color: red'>您在XX注册账号请点击<a href='http://localhost:8080/recruit/logUp?email="+to+"'>http://localhost:8080/recruit/logUp?email="+to+"</a>完成功验证</h2>" +
                "</body>",true);
        javaMailSenderImpl.send(msg);
    }

    //带图片格式邮件
    public static void EmailImg(String to){

    }
}
