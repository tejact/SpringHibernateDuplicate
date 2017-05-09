package com.tejatummalapalli.instateam.service;

import com.tejatummalapalli.instateam.dao.CollaboratorDao;
import com.tejatummalapalli.instateam.model.Collaborator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaboratorServiceImpl implements CollaboratorService {
    @Autowired
    CollaboratorDao  collaboratorDao;

    @Override
    public List<Collaborator> getAllCollaborators() {
        List<Collaborator> collaborators = collaboratorDao.getAllCollaborators();
        return collaborators;
    }

    @Override
    public void addCollaborator(Collaborator collborator) {
        collaboratorDao.addCollaborator(collborator);
    }
}
