package com.tejatummalapalli.instateam.service;

import com.tejatummalapalli.instateam.model.Collaborator;
import com.tejatummalapalli.instateam.model.Project;
import com.tejatummalapalli.instateam.model.Role;

import java.util.List;
import java.util.Map;

public interface ProjectService {
    List<Project> findAll();
    void saveProject(Project project);
    Project findProjectBySlug(String slug);
    Map<Role, List<Collaborator>> getRoleWithCollaborator(Project project);
}
