package com.example.demo.service;

import com.example.demo.model.ProjectDetail;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProjectService {
    List<ProjectDetail>getAllProjectdetail();
    void saveProject(ProjectDetail projectDetail);
    ProjectDetail getProjectById(long id);
    void deleteProjectById(long id);
    Page<ProjectDetail> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
