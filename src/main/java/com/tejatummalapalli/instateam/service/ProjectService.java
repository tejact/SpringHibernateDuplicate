package com.tejatummalapalli.instateam.service;

import com.tejatummalapalli.instateam.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface ProjectService {
    List<Project> findAll();
}
