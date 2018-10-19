package com.emusicstore.service;

import org.springframework.mail.SimpleMailMessage;

public interface MailService {

    void sendEmail(String to, String from, String sub, String msg);
    SimpleMailMessage prepEmail(String to, String from, String sub, String msg);
}
