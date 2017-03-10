package com.tejatummalapalli.instateam.web.controller;

import com.tejatummalapalli.instateam.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping("/projects")
    public String listProjects(Model model) {
        //TODO : Get all Projects
        Session session = sessionFactory.openSession();
        List<Project> projects = session.createCriteria(Project.class).list();
        model.addAttribute("projects",projects);
        return "index";
    }
}
