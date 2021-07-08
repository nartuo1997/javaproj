package com.project.application.service;

import com.project.application.entity.Project;
import com.project.application.entity.Resources;

public interface ResourcesService {
    Resources get(Integer resourceId);
    public void add(Resources resources);
}
