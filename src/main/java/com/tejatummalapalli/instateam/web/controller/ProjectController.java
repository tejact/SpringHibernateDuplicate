package com.tejatummalapalli.instateam.web.controller;

import com.tejatummalapalli.instateam.model.Collaborator;
import com.tejatummalapalli.instateam.model.Project;
import com.tejatummalapalli.instateam.model.Role;
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
import java.util.Map;

@Controller
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @Autowired
    RoleService roleService;


    @RequestMapping(value={"","/","/projects","index"})
    public String listProjects(Model model) {
        List<Project> projects= projectService.findAll();
        model.addAttribute("projects",projects);
        return "index";
    }

    @RequestMapping(value = "/save-project", method = RequestMethod.POST)
    public String saveProject(@ModelAttribute Project project,Model model){
        projectService.saveProject(project);
        return "redirect:/projects";
    }


    @RequestMapping("/projects/{slug}")
     public String getProjectFromSlug(@PathVariable String slug, Model model){
        Project project = projectService.findProjectBySlug(slug);
        model.addAttribute("project",project);
        Map<Role,List<Collaborator>> roleCollaboratorMap = projectService.getRoleWithCollaborator(project);
        model.addAttribute("roleCollaboratorMap",roleCollaboratorMap);
        return "project_detail";
    }

    @RequestMapping("/edit-project/{slug}")
    public String editProjectFromSlug(@PathVariable String slug,Model model) {
        Project project = projectService.findProjectBySlug(slug);
        List<Role> allRoles = roleService.getAllRoles();
        model.addAttribute("project",project);
        model.addAttribute("allRoles",allRoles);
        return "edit_project";
    }

    @RequestMapping("/edit-collaborators/{slug}")
    public String editCollborators(@PathVariable String slug,Model model) {
        Project project = projectService.findProjectBySlug(slug);
        model.addAttribute("project",project);

        Map<Role, List<Collaborator>> rolesWithCollaborators = projectService.getRoleWithCollaborator(project);
        model.addAttribute("allRolesWithCollaborators",rolesWithCollaborators);
        return "project_collaborators";
    }




}
