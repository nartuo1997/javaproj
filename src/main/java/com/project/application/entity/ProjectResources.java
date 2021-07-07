package com.project.application.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProjectResources implements Serializable {
    @Id
    @GeneratedValue

    private int recordId;

    @OneToMany(mappedBy = "projectResrc")
    List<Project> project = new ArrayList<>();      // projectId in project table

    private LocalDate dateTime;
    private int projectId;

    @OneToMany(mappedBy = "resources")
    List<Resources> resource = new ArrayList<>();    // Resource table
    private int resourceId;

    public ProjectResources() {}    // default constructor

    public ProjectResources(int recordId, LocalDate dateTime, int projectId, int resourceId) {
        this.recordId = recordId;
        this.dateTime = dateTime;
        this.projectId = projectId;
        this.resourceId = resourceId;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        return "ProjectResources{" +
                "recordId=" + recordId +
                ", dateTime=" + dateTime +
                ", projectId=" + projectId +
                ", resourceId=" + resourceId +
                '}';
    }
}
