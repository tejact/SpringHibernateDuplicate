package com.tejatummalapalli.instateam.web.controller;

import com.tejatummalapalli.instateam.model.Collaborator;
import com.tejatummalapalli.instateam.model.Role;
import com.tejatummalapalli.instateam.service.CollaboratorService;
import com.tejatummalapalli.instateam.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping("/roles")
    public String getAllRoles(Model model){
        Role role = new Role();
        model.addAttribute("role",role);
        List<Role> allRoles = roleService.getAllRoles();
        model.addAttribute("allRoles",allRoles);
        return "roles";
    }

    @RequestMapping(value = "/add-role", method = RequestMethod.POST)
    public String addRole (Role role, Model model) {
        roleService.addRole(role);
        return "redirect:/roles";
    }
}
