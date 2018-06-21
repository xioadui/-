package com.enterprise.service.serviceImpl;

import com.enterprise.service.IMailService;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

/**
 * 发送邮件，当管理员不通过注册或者供需的时候，发送邮件通知用户
 */
@Service
public class MailServiceImpl implements IMailService {
    /**
     * @param to 目标用户的邮箱
     * @param text 内容
     * @param subject 主题
     * @return 返回是否发送成功
     */
    @Override
    public String sendEmail(String to, String text,String subject) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setText(text);
        message.setSubject(subject);
        message.setFrom("gdcjdxis@163.com");
        mailSender().send(message);
        return "success";
    }
    @Bean
    public JavaMailSenderImpl mailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.163.com");
        mailSender.setUsername("gdcjdxis@163.com");
        mailSender.setPassword("is123456");
        return mailSender;
    }
}
