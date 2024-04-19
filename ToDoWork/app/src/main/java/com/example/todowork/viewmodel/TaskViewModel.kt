package com.example.todowork.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.todowork.model.TaskEntity
import com.example.todowork.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel(app: Application, private val taskRepository: TaskRepository): AndroidViewModel(app) {
    fun addTask(task:TaskEntity) = viewModelScope.launch { taskRepository.insertTask(task) }
    fun update(task:TaskEntity) = viewModelScope.launch { taskRepository.updateTask(task) }
    fun getAllTask() = taskRepository.getAllTasks()

    fun getTaskById(query: String?) = taskRepository.getTaskById(query)

}