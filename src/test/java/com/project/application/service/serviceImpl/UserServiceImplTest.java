package com.project.application.service.serviceImpl;

import com.project.application.entity.Role;
import com.project.application.entity.User;

import com.project.application.repository.UserRepository;
import com.project.application.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {}

    @Test
    public void addUser() {
        User user = new User();
        user.setUser_name("Cris");
        user.setPassword("123");
        user.setTitle("student");
        user.setTimeCreate(LocalDate.of(2021, 07, 02));
        user.setLastUpdate(LocalDate.now());
//        user.setRole(Role.ADMIN);

        User test = userService.addUser(user);
//        User test = userRepository.save(user);
        Assert.assertNotEquals(null, test);

    }

    @Test
    void getAllUser() {
        List<User> test = new ArrayList<>();

        test = userService.getAllUser();
        System.out.println(test);

    }

    @Test
    void getUserById() {
        User user = userService.getUserById(1);
        System.out.println(user);
    }
}