package com.tejatummalapalli.instateam.service;

import com.tejatummalapalli.instateam.model.Role;

import java.util.List;

public interface RoleService {
    List<Role>  getAllRoles();
    void addRole(Role role);
}
