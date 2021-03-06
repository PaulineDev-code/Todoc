package com.cleanup.todoc.repositories;

import android.arch.lifecycle.LiveData;

import com.cleanup.todoc.database.ProjectDao;
import com.cleanup.todoc.database.TaskDao;
import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

import java.util.List;

public class TaskDataRepository {
    private final TaskDao taskDao;

    public TaskDataRepository(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    // --- GET ---
    public LiveData<Task> getTask (long taskId) { return this.taskDao.getTask(taskId); }
    public LiveData<List<Task>> getTasks () { return this.taskDao.getTasks(); }

    // --- CREATE ---
    public void createTask(Task task){ taskDao.insertTask(task); }

    // --- DELETE ---
    public void deleteTask(long taskId){ taskDao.deleteTask(taskId); }

    // --- UPDATE ---
    public void updateTask(Task task){ taskDao.updateTask(task); }

}
