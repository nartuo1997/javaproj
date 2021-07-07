package com.project.application.repository;

import com.project.application.entity.Resources;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourcesRepository extends JpaRepository<Resources, Integer> {
}
