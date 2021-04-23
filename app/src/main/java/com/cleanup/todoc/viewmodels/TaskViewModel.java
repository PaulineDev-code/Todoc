package com.cleanup.todoc.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.repositories.ProjectDataRepository;
import com.cleanup.todoc.repositories.TaskDataRepository;

import java.util.List;
import java.util.concurrent.Executor;

public class TaskViewModel extends ViewModel {

    // REPOSITORIES
    private final TaskDataRepository taskDataSource;
    private final ProjectDataRepository projectDataSource;
    private final Executor executor;

    // DATA
    public TaskViewModel(TaskDataRepository taskDataSource, ProjectDataRepository projectDataSource, Executor executor) {
        this.taskDataSource = taskDataSource;
        this.projectDataSource = projectDataSource;
        this.executor = executor;
    }


    // -------------
    // FOR PROJECT
    // -------------
    public LiveData<List<Project>> getProjectList(){
        return projectDataSource.getProjectList();
    }

    public LiveData<Project> getProject(long projectId) { return projectDataSource.getProject(projectId);  }

    // -------------
    // FOR ITEM
    // -------------
    public LiveData<List<Task>> getTasks() {
        return taskDataSource.getTasks();
    }

    public void createTask(final Task task) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                taskDataSource.createTask(task);
            }
        });
    }

    public void deleteTask(final long taskId) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                taskDataSource.deleteTask(taskId);
            }
        });
    }

    public void updateTask(final Task task) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                taskDataSource.updateTask(task);
            }
        });
    }
}

