package com.project.application.entity;


import jdk.jfr.Timestamp;
import org.hibernate.annotations.UpdateTimestamp;
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

    @ManyToOne(targetEntity = Project.class, cascade = CascadeType.REMOVE)

    private Project project;

    @Column(unique = true)
    private String username;
    private String password;

    private String title;

    @Column(name ="role")
//    @Enumerated(EnumType.STRING)
    private String role;

    @Transient
    private String token;

    @UpdateTimestamp
    private LocalDate timeCreate;

    @UpdateTimestamp
    private LocalDate lastUpdate;



    public User() {}    // default constructor


    public User(Project project, String username, String password, String title, String role, String token, LocalDate timeCreate, LocalDate lastUpdate) {
        this.project = project;
        this.username = username;
        this.password = password;
        this.title = title;
        this.role = role;
        this.token = token;
        this.timeCreate = timeCreate;
        this.lastUpdate = lastUpdate;
    }   // constructor

    // getter - setter method

    public Integer getUserId() {return this.userId;}

    public String getUserName() {
        return username;
    }

    public void setUser_name(String user_name) {
        this.username = user_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
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
                ", userName='" + username + '\'' +
                ", password='" + password + '\'' +
                ", title='" + title + '\'' +
                ", role=" + role +
                ", token='" + token + '\'' +
                ", timeCreate=" + timeCreate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }


}
