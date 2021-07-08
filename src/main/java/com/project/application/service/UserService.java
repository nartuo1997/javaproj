package com.project.application.service;

import com.project.application.entity.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);
    public List<User> getAllUser();
    public User getUserById(Integer id);

    public User findUsername(String username);
    public void deleteById(Integer id);
    public User updateUser(User user);
}
