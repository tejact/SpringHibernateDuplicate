package com.tejatummalapalli.instateam.dao;
import com.tejatummalapalli.instateam.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
        session.close();
        return projects;
    }

    @Override
    public void saveProject(Project project) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(project);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    //Todo: Dont throw null here. Instead throw an exception
    public Project findProjectBySlug(String slug) {
        Session session = sessionFactory.openSession();

        //Todo: Modify this criteria query!
        List<Project> projects = session.createCriteria(Project.class)
                                .add(Restrictions.eq("slug",slug)).list();

        if(projects.isEmpty()) {
            return null;
        }
        else {
            return projects.get(0);
        }
    }
}
