package com.tejatummalapalli.instateam.web.controller;

import com.tejatummalapalli.instateam.model.Collaborator;
import com.tejatummalapalli.instateam.model.Role;
import com.tejatummalapalli.instateam.service.CollaboratorService;
import com.tejatummalapalli.instateam.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CollaboratorController {

    @Autowired
    CollaboratorService collaboratorService;

    @Autowired
    RoleService roleService;

    @RequestMapping("/collaborators")
    public String getAllCollaborators(Model model){
        //For Object Binding
        Collaborator collaborator = new Collaborator();
        model.addAttribute("collaborator",collaborator);
        List<Collaborator> collaborators = collaboratorService.getAllCollaborators();
        model.addAttribute("collaborators",collaborators);
        List<Role> allRoles = roleService.getAllRoles();
        model.addAttribute("allRoles",allRoles);
        return "collaborators";
    }

    @RequestMapping(value = "/add-collaborator",method = RequestMethod.POST)
    public String addCollaborator(@ModelAttribute Collaborator collborator, Model model){
        collaboratorService.addCollaborator(collborator);
        return "redirect:/collaborators";
    }
}
