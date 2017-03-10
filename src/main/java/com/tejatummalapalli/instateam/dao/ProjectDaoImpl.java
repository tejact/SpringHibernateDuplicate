package com.tejatummalapalli.instateam.dao;


import com.tejatummalapalli.instateam.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDaoImpl implements ProjectDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Project> findAll() {
        //TODO : Get all Projects
        Session session = sessionFactory.openSession();
        List<Project> projects = session.createCriteria(Project.class).list();
        return projects;
    }
}
