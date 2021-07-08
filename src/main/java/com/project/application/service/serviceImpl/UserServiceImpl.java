package com.project.application.service.serviceImpl;

import com.project.application.entity.User;
import com.project.application.repository.UserRepository;
import com.project.application.service.UserService;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public User addUser(User user) {
        //encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));   // encode password
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> user = new ArrayList<>();
        userRepository.findAll().forEach(user::add);

        return user;
    }
    @Override
    public User getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Override
    public User findUsername(String username){
       return userRepository.findByUsername(username).orElse(null);

    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }


}
