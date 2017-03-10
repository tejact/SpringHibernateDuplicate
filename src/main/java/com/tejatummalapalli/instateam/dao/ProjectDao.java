package com.tejatummalapalli.instateam.dao;

import com.tejatummalapalli.instateam.model.Project;

import java.util.List;

public interface ProjectDao {
    List<Project> findAll();
}
