package com.project.application.service;

import com.project.application.entity.Project;
import com.project.application.entity.User;

public interface ProjectService {
    public Boolean checkProject(Project project, User user);

    public Project get(Integer projectId);

    public void delete(Project projectToDelete);

    public void add(Project project);

//    boolean checkProject(Project projectToAdd, User user);
}