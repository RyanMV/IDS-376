package com.example.todowork.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.todowork.model.TaskEntity

@Dao
interface TaskDao {
    @Query("SELECT * FROM tb_task WHERE state = 1")
    fun getAllTasks(): LiveData<List<TaskEntity>>

    @Query("SELECT * FROM tb_task WHERE id LIKE :taskId")
    fun getTaskById(taskId: String?): LiveData<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy. REPLACE)
    fun insertTask(task: TaskEntity)

    @Update
    fun updateTask(task: TaskEntity)
}