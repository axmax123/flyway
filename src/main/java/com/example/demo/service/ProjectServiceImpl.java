package com.example.demo.service;

import com.example.demo.model.Project;
import com.example.demo.repository.ProjectRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepositoty projectRepositoty;

    public ProjectServiceImpl(ProjectRepositoty projectRepositoty) {
        this.projectRepositoty = projectRepositoty;
    }

    @Override
    public List<Project> getAllProject() {
        return projectRepositoty.findAll();
    }

    @Override
    public void saveProject(Project projectDetail) {
this.projectRepositoty.save(projectDetail);
    }

    @Override
    public Project getProjectById(long id) {
        Optional<Project> optional =projectRepositoty.findById(id);
         Project project;
        if (optional.isPresent()){  project =optional.get();
    }else {
    throw new RuntimeException("can not found id" +id);

    }return project;
    }

    @Override
    public void deleteProjectById(long id) {
    this.projectRepositoty.deleteById(id);
    }

    @Override
    public Page<Project> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return projectRepositoty.findAll(pageable);
    }
}
