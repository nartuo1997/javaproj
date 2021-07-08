package com.project.application.service;

import com.project.application.entity.Project;
import com.project.application.entity.User;

public interface ProjectService {
    public Boolean addProject(Project project, User user);
}
