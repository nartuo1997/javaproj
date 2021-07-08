package com.project.application.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project implements Serializable {
    @Id
    @GeneratedValue
    private int projectId;

    @ManyToOne
    ProjectColumns projectColumns; // ProjectColumns table

    @ManyToOne
    ProjectResources projectResrc; // ProjectResource table

    private LocalDate timeCreate;
    private String owner;
    private String projectName;



    @OneToMany(mappedBy="project")
    private List<User> owners = new ArrayList<User>();

    public Project() {} // default constructor

    public Project(LocalDate timeCreate, String owner, String projectName) {
        this.timeCreate = timeCreate;
        this.owner = owner;
        this.projectName = projectName;
    }   // constructor

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public LocalDate getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(LocalDate timeCreate) {
        this.timeCreate = timeCreate;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", timeCreate=" + timeCreate +
                ", owner='" + owner + '\'' +
                '}';
    }
}
