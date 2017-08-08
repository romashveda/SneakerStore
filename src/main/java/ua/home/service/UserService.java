package ua.home.service;

import ua.home.entity.User;

import java.util.List;


public interface UserService extends GeneralService<User>{
    void add(User user);
    void edit(User user);
    User findOne(int id);
    List<User> findAll();
    User findByUsername(String username);
}
