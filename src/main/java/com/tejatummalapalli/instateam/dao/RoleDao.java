package com.tejatummalapalli.instateam.dao;

import com.tejatummalapalli.instateam.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getAllRoles();
    void addRole(Role role);
}
