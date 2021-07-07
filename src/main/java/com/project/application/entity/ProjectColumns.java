package com.project.application.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


// enumerator
enum type {
    number,
    text,
    formula
}
@Entity

public class ProjectColumns implements Serializable {
    @Id
    @GeneratedValue
    private int projectId;


    @OneToMany(mappedBy = "projectColumns")
    List<Project> projectList = new ArrayList<>();

    private int columnId;
    private String columnName;
    private String formulaText;
    private enum type {};

    public ProjectColumns() {} // default constructor

    public ProjectColumns(int columnId, String columnName, String formulaText) {
        this.columnId = columnId;
        this.columnName = columnName;
        this.formulaText = formulaText;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getColumnId() {
        return columnId;
    }

    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getFormulaText() {
        return formulaText;
    }

    public void setFormulaText(String formulaText) {
        this.formulaText = formulaText;
    }

    @Override
    public String toString() {
        return "ProjectColumns{" +
                "projectId=" + projectId +
                ", columnId=" + columnId +
                ", columnName='" + columnName + '\'' +
                ", formulaText='" + formulaText + '\'' +
                '}';
    }
}
