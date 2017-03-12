package com.tejatummalapalli.instateam.service;

import com.tejatummalapalli.instateam.dao.ProjectDao;
import com.tejatummalapalli.instateam.model.Collaborator;
import com.tejatummalapalli.instateam.model.Project;
import com.tejatummalapalli.instateam.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectDao projectDao;


    @Override
    public List<Project> findAll() {
        return projectDao.findAll();
    }

    @Override
    public void saveProject(Project project) {
        projectDao.saveProject(project);
    }

    @Override
    public Project findProjectBySlug(String slug) {
        return projectDao.findProjectBySlug(slug);
    }

    @Override
    public Map<Role, Collaborator> getRoleWithCollaborator(Project project) {
        Map<Role,Collaborator> roleWithCollaborator = new HashMap<>();
        List<Role> roles = project.getRoles();
        List<Collaborator> collaborators = project.getCollaborators();
        //Todo: Handle nulls here. What if there is no collab for a particular role
        for(Role role : roles) {
            for(Collaborator collaborator : collaborators) {
                if(collaborator.getRole().equals(role)) {
                    roleWithCollaborator.put(role,collaborator);
                }
            }
        }
        return roleWithCollaborator;
    }
}
