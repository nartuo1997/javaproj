package com.project.application.controller;

import com.project.application.entity.Role;
import com.project.application.entity.User;
import com.project.application.security.AuthenticationRequest;
import com.project.application.security.AuthenticationResponse;
import com.project.application.security.JwtUtil;
import com.project.application.service.MyUserDetailsService;
import com.project.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin(origins ="*")
public class userController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public String userPage() {
        return "<h2>You have reached user's page!</h2>";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt= jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }


    @GetMapping("/usr/{userId}")
    public ResponseEntity<?> findUserById(@PathVariable final Integer userId) {
        User user = userService.getUserById(userId);
        System.out.println(user);
        if(user == null) {
            return new ResponseEntity<>("The user is not found", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/usr/getall")
    public ResponseEntity<?> getAllUser(){
        List<User> list = userService.getAllUser();
        System.out.println(list);

        if(list.size() < 1) {
            return new ResponseEntity<>("There is no user in the database", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/usr/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.findUsername(user.getUserName()) != null) {
            return new ResponseEntity<>("User is already existed in the database", HttpStatus.CONFLICT);
        }

//        user.setRole(Role.ADMIN);
// q
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @PutMapping("admin/update")
    public ResponseEntity<?> update(@RequestBody User user) {
//        user = userService.getUserById(userId);
        if(user.getUserId() == null) {
            return new ResponseEntity<>("{The user is not found}", HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }





//    @DeleteMapping("delete/{userId}")
//    public ResponseEntity<?> delete(@PathVariable final Integer userId) {
//        userService.deleteById(userId);
//        if(user == null) {
//            return new ResponseEntity<>("{The user is not found}", HttpStatus.BAD_REQUEST);
//        }
//
//
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }

    @DeleteMapping("admin/delete/{userId}")
    public void delete(@PathVariable final Integer userId) {
        userService.deleteById(userId);
    }





}
// postman for testing