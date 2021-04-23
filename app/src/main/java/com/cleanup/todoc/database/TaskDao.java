package com.cleanup.todoc.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cleanup.todoc.model.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM Task")
    LiveData<List<Task>> getTasks();

    @Query("SELECT * FROM Task WHERE id = :taskId")
    LiveData<Task> getTask(long taskId);

    @Insert
    void insertTask(Task task);

    @Update
    void updateTask(Task task);

    @Query("DELETE FROM Task where id = :taskId")
    void deleteTask(long taskId);

}
