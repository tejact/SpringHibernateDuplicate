package com.tejatummalapalli.instateam.dao;

import com.tejatummalapalli.instateam.model.Collaborator;

import java.util.List;

public interface CollaboratorDao {
        List<Collaborator> getAllCollaborators();

    void addCollaborator(Collaborator collborator);

    Collaborator findById(int id);
}
