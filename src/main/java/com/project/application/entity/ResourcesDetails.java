package com.project.application.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ResourcesDetails {
    @Id
    @GeneratedValue
    private int recordId;

    @OneToMany(mappedBy = "resourceDetails")
    List<Resources> resourceList = new ArrayList<>();


    private LocalDate timeCreated;
    private LocalDate lastUpdated;
    private int resourceId;
    private int columnValue;
    private int columnId;

    public ResourcesDetails() {};

    public ResourcesDetails(LocalDate timeCreated, LocalDate lastUpdated, int resourceId, int columnValue, int columnId) {
        this.timeCreated = timeCreated;
        this.lastUpdated = lastUpdated;
        this.resourceId = resourceId;
        this.columnValue = columnValue;
        this.columnId = columnId;
    }



    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public LocalDate getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDate timeCreated) {
        this.timeCreated = timeCreated;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(int columnValue) {
        this.columnValue = columnValue;
    }

    public int getColumnId() {
        return columnId;
    }

    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }

    @Override
    public String toString() {
        return "ResourcesDetails{" +
                "recordId=" + recordId +
                ", timeCreated=" + timeCreated +
                ", lastUpdated=" + lastUpdated +
                ", resourceId=" + resourceId +
                ", columnValue=" + columnValue +
                ", columnId=" + columnId +
                '}';
    }
}
