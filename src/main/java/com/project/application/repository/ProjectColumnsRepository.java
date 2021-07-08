package com.project.application.repository;

import com.project.application.entity.ProjectColumns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectColumnsRepository extends JpaRepository<ProjectColumns, Integer> {

}
