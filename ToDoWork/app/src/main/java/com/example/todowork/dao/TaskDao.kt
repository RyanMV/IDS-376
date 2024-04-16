package com.example.todowork.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todowork.entities.TaskEntity

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks WHERE status = 1")
    fun getAllTasks(): List<TaskEntity>

    @Query("SELECT * FROM tasks WHERE id = :taskId")
    fun getTaskById(taskId: Int): TaskEntity?

    @Insert
    fun insertTask(task: TaskEntity)

    @Update
    fun updateTask(task: TaskEntity)
}