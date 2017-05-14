package com.tejatummalapalli.instateam;

import com.tejatummalapalli.instateam.dao.CollaboratorDao;
import com.tejatummalapalli.instateam.dao.ProjectDao;
import com.tejatummalapalli.instateam.dao.RoleDao;
import com.tejatummalapalli.instateam.model.Collaborator;
import com.tejatummalapalli.instateam.model.Project;
import com.tejatummalapalli.instateam.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    RoleDao roleDao;
    @Autowired
    ProjectDao projectDao;
    @Autowired
    CollaboratorDao collaboratorDao;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 1; i <= 5; i++) {

            // save roles
            Role role = new Role();
            role.setName("role " + i);
            roleDao.addRole(role);

            // save collaborators with one role each
            Collaborator collaborator = new Collaborator();
            collaborator.setName("collaborator " + i);
            collaborator.setRole(
                    roleDao.findById(i)
            );
            collaboratorDao.addCollaborator(collaborator);

            // save projects with one role one collaborator each
            Project project = new Project();
            project.setName("project " + i);
            project.setDescription("description " + i);
            project.setStatus("status " + i);

            project.addRole(
                    roleDao.findById(i)
            );

            project.addCollaborator(
                    collaboratorDao.findById(i)
            );

            projectDao.saveProject(project);
        }
    }
}
