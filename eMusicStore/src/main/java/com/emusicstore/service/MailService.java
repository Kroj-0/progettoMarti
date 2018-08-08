package com.emusicstore.service;

public interface MailService {

    void sendEmail(String to, String from, String sub, String msg);
}
