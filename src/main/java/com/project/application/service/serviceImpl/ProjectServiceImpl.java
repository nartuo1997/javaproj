package com.project.application.service.serviceImpl;

import com.project.application.entity.Project;
import com.project.application.entity.User;
import com.project.application.service.ProjectService;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Override
    public Boolean addProject(Project project, User user){
        if(project != null && user != null)
            return true;
        return false;
    }
}
