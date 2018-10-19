package com.emusicstore.service.impl;

import com.emusicstore.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;


@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private MailSender mailSender;

    public void sendEmail(String to, String from, String sub, String msgBody){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(sub);
        message.setText(msgBody);
        mailSender.send(message);
    }

    public SimpleMailMessage prepEmail(String to, String from, String sub, String msg) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(sub);
        message.setText(msg);
        return message;
    }
}

