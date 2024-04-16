package com.example.todowork.models

class User(
    val id: Int,
    var username: String,
    var email: String,
    var password: String,
    var tasks: MutableList<Task> = mutableListOf()
) {

    fun addTask(task: Task) {
        tasks.add(task)
    }

    fun removeTask(task: Task) {
        tasks.remove(task)
    }
    fun getAllTasks(): List<Task> {
        return tasks.toList()
    }

    fun getCompletedTasks(): List<Task> {
        return tasks.filter { it.isCompleted }
    }

    fun getPendingTasks(): List<Task> {
        return tasks.filter { !it.isCompleted }
    }

    fun hasPendingTasks(): Boolean {
        return tasks.any { !it.isCompleted }
    }

}