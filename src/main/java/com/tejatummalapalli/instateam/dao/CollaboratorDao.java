package com.tejatummalapalli.instateam.dao;

import com.tejatummalapalli.instateam.model.Collaborator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

public interface CollaboratorDao {
        List<Collaborator> getAllCollaborators();
}
