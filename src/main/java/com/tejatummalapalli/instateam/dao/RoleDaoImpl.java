package com.tejatummalapalli.instateam.dao;

import com.tejatummalapalli.instateam.model.Project;
import com.tejatummalapalli.instateam.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Role> getAllRoles() {
        Session session = sessionFactory.openSession();
        List<Role> roles = session.createCriteria(Role.class).list();
        session.close();
        return roles;
    }

    @Override
    public void addRole(Role role) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(role);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Role findById(int id) {
        // Open a session
        Session session = sessionFactory.openSession();

        // Find a role by id
        Role role = session.get(Role.class, id);

        // Close session
        session.close();
        return role;
    }

}
