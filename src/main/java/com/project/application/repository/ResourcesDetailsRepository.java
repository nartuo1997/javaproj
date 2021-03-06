package com.project.application.repository;

import com.project.application.entity.ResourcesDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourcesDetailsRepository extends JpaRepository<ResourcesDetails, Integer> {
}
