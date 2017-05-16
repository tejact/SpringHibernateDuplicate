package com.tejatummalapalli.instateam.service;

import com.tejatummalapalli.instateam.dao.CollaboratorDao;
import com.tejatummalapalli.instateam.dao.ProjectDao;
import com.tejatummalapalli.instateam.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectDao projectDao;
    @Autowired
    CollaboratorDao collaboratorDao;


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
}
