package com.cleanup.todoc.database;

import com.cleanup.todoc.model.Project;

import java.util.List;

public interface ProjectsCallback {
   List<Project> callback(List<Project> projects);
}
