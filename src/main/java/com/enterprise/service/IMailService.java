package com.enterprise.service;

public interface IMailService {
    String sendEmail(String to,String text,String subject);
}
