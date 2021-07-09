package com.project.application.service;

import com.project.application.entity.ProjectColumns;
import com.project.application.repository.ProjectColumnsRepository;

public interface ProjectColumnsService {
    public void deleteById(Integer columnId);
    public ProjectColumns updateProjectColumns(ProjectColumns column);
    public ProjectColumns add(ProjectColumns columnToAdd);
}
