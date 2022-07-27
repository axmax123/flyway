package com.example.demo.controller;

import com.example.demo.model.ProjectDetail;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class ProjectdetailController {

    @Autowired
    private ProjectService projectService;

    // display list of Projects
    @GetMapping("/")
    public String viewHomePage(Model model) {
    return findPaginated(1,"timeStart","asc",model);
    }

    @GetMapping("/showNewProjectForm")
    public String showNewProjectForm(Model model) {
        // create model attribute to bind form data
        ProjectDetail projectDetail = new ProjectDetail();
        model.addAttribute("projectDetail", projectDetail);
        return "new_project";
    }
    @PostMapping("/saveProject")
    public String saveProject(@ModelAttribute("Project") ProjectDetail projectDetail) {
        // save Project to database
        projectService.saveProject(projectDetail);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {

        // get Project from the service
        ProjectDetail projectDetail = projectService.getProjectById(id);

        // set Project as a model attribute to pre-populate the form
        model.addAttribute("projectDetail", projectDetail);
        return "update_project";
    }

    @GetMapping("/deleteProject/{id}")
    public String deleteProject(@PathVariable (value = "id") long id) {

        // call delete Project method
        this.projectService.deleteProjectById(id);
        return "redirect:/";
    }


    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo", required = false) int pageNo,
                                @RequestParam(value = "sortField",required = false) String sortField,
                                @RequestParam(value = "sortDir",required = false) String sortDir,
                                Model model) {
        int pageSize = 5;
        Page<ProjectDetail> page = projectService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<ProjectDetail> listProjects = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("listProjects", listProjects);
        return "index";
    }
}
