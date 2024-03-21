package ru.trofimov.bookshare.service;

public interface EmailService {

    void sendEmailToUser(String userEmail, String subject, String body);
}
