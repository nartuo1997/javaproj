package com.project.application.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Resources implements Serializable {
    @Id
    @GeneratedValue
    private int resourceId; // Pk

    @ManyToOne
    ProjectResources resources;     // project resource table

    @ManyToOne
    ResourcesDetails resourceDetails;   // resource details table


    LocalDate timeCreated;
    LocalDate lastUpdated;

    public Resources() {};   // default constructor

    public Resources(int resourceId, LocalDate timeCreated, LocalDate lastUpdated) {
        this.resourceId = resourceId;
        this.timeCreated = timeCreated;
        this.lastUpdated = lastUpdated;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
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

    @Override
    public String toString() {
        return "Resource{" +
                "resourceId=" + resourceId +
                ", timeCreated=" + timeCreated +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
