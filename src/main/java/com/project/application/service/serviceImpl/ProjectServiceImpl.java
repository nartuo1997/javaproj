package com.project.application.service.serviceImpl;

import com.project.application.entity.Project;
import com.project.application.entity.ProjectResources;
import com.project.application.entity.User;
import com.project.application.repository.ProjectRepository;
import com.project.application.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Boolean checkProject(Project project, User user){
        if(project != null && user != null)
            return true;
        return false;
    }

    @Override
    public Project get(Integer projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        return project.get();
    }

    @Override
    public void delete(Project projectToDelete) {
        projectRepository.delete(projectToDelete);
    }

    @Override
    public void add(Project project) {
        projectRepository.save(project);
    }
}