package com.project.application.service.serviceImpl;

import com.project.application.entity.Project;
import com.project.application.entity.Resources;
import com.project.application.repository.ResourcesRepository;
import com.project.application.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResourcesServiceImpl implements ResourcesService {
    @Autowired
    ResourcesRepository resourcesRepository;

    @Override
    public Resources get(Integer resourceId) {
        Optional<Resources> resources = resourcesRepository.findById(resourceId);
        return resources.get();
    }

    @Override
    public void add(Resources resources) {
        resourcesRepository.save(resources);
    }
}