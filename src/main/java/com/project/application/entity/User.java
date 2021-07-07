package com.project.application.entity;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer userId;

    @ManyToOne
    private Project project;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;
    private String password;

    private String title;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Transient
    private String token;

    @CreatedDate
    private LocalDate timeCreate;

    @LastModifiedDate
    private LocalDate lastUpdate;



    public User() {}    // default constructor

    public User(Project project, String userName, String password, String title, Role role, String token, LocalDate timeCreate, LocalDate lastUpdate) {
        this.project = project;
        this.userName = userName;
        this.password = password;
        this.title = title;
        this.role = role;
        this.token = token;
        this.timeCreate = timeCreate;
        this.lastUpdate = lastUpdate;
    }   // constructor

    // getter - setter method

    public String getUserName() {
        return userName;
    }

    public void setUser_name(String user_name) {
        this.userName = user_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDate getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(LocalDate timeCreate) {
        this.timeCreate = timeCreate;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken(String token) { return this.token;}

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", project=" + project +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", title='" + title + '\'' +
                ", role=" + role +
                ", token='" + token + '\'' +
                ", timeCreate=" + timeCreate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }


}
