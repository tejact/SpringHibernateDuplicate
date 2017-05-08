package com.tejatummalapalli.instateam.dao;

import com.tejatummalapalli.instateam.model.Collaborator;
import com.tejatummalapalli.instateam.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;

@Repository
public class CollaboratorDaoImpl implements CollaboratorDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Collaborator> getAllCollaborators() {
        //TODO : Get all Projects
        Session session = sessionFactory.openSession();
        List<Collaborator>  collaborators = session.createCriteria(Collaborator.class).list();
        session.close();
        return collaborators;
    }
}
