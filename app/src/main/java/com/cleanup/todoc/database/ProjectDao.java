package com.cleanup.todoc.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

import java.util.List;

@Dao
public interface ProjectDao {

    @Query("SELECT * From Project")
    LiveData<List<Project>> getProjectList();

    @Query("SELECT * FROM Project WHERE id = :projectId")
    LiveData<Project> getProject(long projectId);

    @Insert
    long[] insertAllProjects(Project[] projects);

    @Insert
    long insertProject(Project project);

    @Update
    int updateProject(Project project);

    @Query("DELETE FROM Project where id = :projectId")
    int deleteProject(long projectId);
}
