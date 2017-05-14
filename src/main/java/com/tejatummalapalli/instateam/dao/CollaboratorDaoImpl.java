package com.tejatummalapalli.instateam.dao;

import com.tejatummalapalli.instateam.model.Collaborator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    @Override
    public void addCollaborator(Collaborator collborator) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(collborator);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Collaborator findById(int id) {
        // Open a session
        Session session = sessionFactory.openSession();

        // Find a role by id
        Collaborator collaborator = session.get(Collaborator.class, id);

        // Close session
        session.close();
        return collaborator;
    }
}
