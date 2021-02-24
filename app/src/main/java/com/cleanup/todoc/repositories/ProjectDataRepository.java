package com.cleanup.todoc.repositories;

import android.arch.lifecycle.LiveData;

import com.cleanup.todoc.database.ProjectDao;
import com.cleanup.todoc.model.Project;

public class ProjectDataRepository {
    private final ProjectDao projectDao;

    public ProjectDataRepository(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    // --- GET ---
    public LiveData<Project> getProject (long projectId) { return this.projectDao.getProject(projectId); }

    // --- CREATE ---
    public void createProject(Project project){ projectDao.insertProject(project); }

    // --- DELETE ---
    public void deleteProject(long projectId){ projectDao.deleteProject(projectId); }

    // --- UPDATE ---
    public void updateProject(Project project){ projectDao.updateProject(project); }
}
