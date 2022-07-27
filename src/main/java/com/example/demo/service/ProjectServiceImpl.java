package com.example.demo.service;

import com.example.demo.model.ProjectDetail;
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

    @Override
    public List<ProjectDetail>getAllProjectdetail() {
        return projectRepositoty.findAll();
    }

    @Override
    public void saveProject(ProjectDetail projectDetail) {
this.projectRepositoty.save(projectDetail);
    }

    @Override
    public ProjectDetail getProjectById(long id) {
        Optional<ProjectDetail> optional =projectRepositoty.findById(id);
         ProjectDetail projectDetail =null;
        if (optional.isPresent()){  projectDetail =optional.get();
    }else {
    throw new RuntimeException("không tìm thấy id" +id);

    }return projectDetail;
    }

    @Override
    public void deleteProjectById(long id) {
    this.projectRepositoty.deleteById(id);
    }

    @Override
    public Page<ProjectDetail> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return projectRepositoty.findAll(pageable);
    }
}
