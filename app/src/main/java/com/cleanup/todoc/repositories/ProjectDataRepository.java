package com.cleanup.todoc.repositories;

import android.arch.lifecycle.LiveData;

import com.cleanup.todoc.database.ProjectDao;
import com.cleanup.todoc.model.Project;

import java.util.List;

public class ProjectDataRepository {
    private final ProjectDao projectDao;

    public ProjectDataRepository(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    // --- GET ALL ---
    public LiveData<List<Project>> getProjectList(){ return this.projectDao.getProjectList(); }

    // --- GET ONE ---
    public LiveData<Project> getProject (long projectId) { return this.projectDao.getProject(projectId); }

    // --- CREATE ---
    public void createProject(Project project){ projectDao.insertProject(project); }

    // --- DELETE ---
    public void deleteProject(long projectId){ projectDao.deleteProject(projectId); }

    // --- UPDATE ---
    public void updateProject(Project project){ projectDao.updateProject(project); }
}
