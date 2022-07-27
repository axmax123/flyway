package com.example.demo.repository;

import com.example.demo.model.ProjectDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepositoty extends JpaRepository<ProjectDetail, Long> {
}
