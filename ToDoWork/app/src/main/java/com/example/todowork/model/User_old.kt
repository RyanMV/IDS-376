package com.example.todowork.model
class User_old(
    val id: Int,
    var username: String,
    var email: String,
    var password: String,
    var tasks: MutableList<TaskEntity> = mutableListOf()
) {
    fun addTask(task: TaskEntity) {
        tasks.add(task)
    }
    fun removeTask(task: TaskEntity) {
        tasks.remove(task)
    }
    fun getAllTasks(): List<TaskEntity> {
        return tasks.toList()
    }
    fun getCompletedTasks(): List<TaskEntity> {
        return tasks.filter { it.isCompleted }
    }
    fun getPendingTasks(): List<TaskEntity> {
        return tasks.filter { !it.isCompleted }
    }
    fun hasPendingTasks(): Boolean {
        return tasks.any { !it.isCompleted }
    }

}