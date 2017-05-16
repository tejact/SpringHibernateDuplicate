package com.tejatummalapalli.instateam.service;

import com.tejatummalapalli.instateam.model.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAll();
    void saveProject(Project project);
    Project findProjectBySlug(String slug);
}
