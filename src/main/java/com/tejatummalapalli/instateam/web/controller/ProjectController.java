package com.tejatummalapalli.instateam.web.controller;

import com.tejatummalapalli.instateam.model.Project;
import com.tejatummalapalli.instateam.model.Role;
import com.tejatummalapalli.instateam.service.CollaboratorService;
import com.tejatummalapalli.instateam.service.ProjectService;
import com.tejatummalapalli.instateam.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @Autowired
    RoleService roleService;
    @Autowired
    CollaboratorService collaboratorService;


    @RequestMapping(value={"","/","/projects","index"})
    public String listProjects(Model model) {
        List<Project> projects= projectService.findAll();
        model.addAttribute("projects",projects);
        return "index";
    }

    //Project Details Page
    @RequestMapping("/projects/{slug}")
     public String getProjectFromSlug(@PathVariable String slug, Model model){
        Project project = projectService.findProjectBySlug(slug);
        model.addAttribute("project",project);
        return "project_detail";
    }

    @RequestMapping("/edit-project/{slug}")
    public String editProjectFromSlug(@PathVariable String slug,Model model) {
        Project project = projectService.findProjectBySlug(slug);
        List<Role> allRoles = roleService.getAllRoles();
        //Two objects are added to the model
        model.addAttribute("project",project);
        model.addAttribute("allRoles",allRoles);
        return "edit_project";
    }

    @RequestMapping(value = "/save-project", method = RequestMethod.POST)
    public String saveProject(@ModelAttribute Project project, Model model){
        projectService.saveProject(project);
        return "redirect:/projects";
    }

    @RequestMapping("/edit-collaborators/{slug}")
    public String editCollborators(@PathVariable String slug,Model model) {
        Project project = projectService.findProjectBySlug(slug);
        model.addAttribute("project",project);

        model.addAttribute("allRoles",project.getRoles());
        model.addAttribute("allCollabs",collaboratorService.getAllCollaborators());

        return "project_collaborators";
    }


    @RequestMapping(value = "/save-collaborators", method = RequestMethod.POST)
    public String saveProjectCollaborators(@ModelAttribute Project project, Model model){
        projectService.saveProject(project);
        return "redirect:/projects";
    }


}
