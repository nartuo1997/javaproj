package com.project.application.service.serviceImpl;

import com.project.application.entity.ProjectColumns;
import com.project.application.repository.ProjectColumnsRepository;
import com.project.application.service.ProjectColumnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectColumnsServiceImpl implements ProjectColumnsService {
    @Autowired
    ProjectColumnsRepository projectColumnsRepository;

    @Override
    public ProjectColumns add(ProjectColumns columnToAdd) {
        return projectColumnsRepository.save(columnToAdd);
    }
    @Override
    public void deleteById(Integer columnId) {
        projectColumnsRepository.deleteById(columnId);
    }
    @Override
    public ProjectColumns updateProjectColumns(ProjectColumns column) {
        return projectColumnsRepository.save(column);
    }

}
