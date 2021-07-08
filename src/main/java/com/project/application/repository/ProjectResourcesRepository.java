package com.project.application.repository;

import com.project.application.entity.ProjectResources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectResourcesRepository extends JpaRepository<ProjectResources, Integer> {
}
