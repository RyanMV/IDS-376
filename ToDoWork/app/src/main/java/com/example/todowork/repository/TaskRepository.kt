package com.example.todowork.repository

import com.example.todowork.database.TaskDatabase
import com.example.todowork.model.TaskEntity

class TaskRepository(private val db: TaskDatabase) {
    fun insertTask(task:TaskEntity) = db.getTaskDao().insertTask(task)
    fun updateTask(task:TaskEntity) = db.getTaskDao().insertTask(task)
    fun getAllTasks() = db.getTaskDao().getAllTasks()

    fun getTaskById(query: String?) = db.getTaskDao().getTaskById(query)
}