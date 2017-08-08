package ua.home.service;


import ua.home.entity.User;

public interface MailService {
    void send(User user);
}
