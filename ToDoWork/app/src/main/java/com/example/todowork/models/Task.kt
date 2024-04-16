package com.example.todowork.models

class Task(
    val id: Int,
    var title: String,
    var description: String,
    var dueDate: String,
    var priority: Priority,
    var isCompleted: Boolean,
    var assignTo: Int,
    var state: State
) {

    fun markAsCompleted() {
        isCompleted = true
    }

    fun updateTask(title: String, description: String, dueDate: String, priority: Priority, state: State) {
        this.title = title
        this.description = description
        this.dueDate = dueDate
        this.priority = priority
        this.state = state
    }

    override fun toString(): String {
        return "Task(id=$id, title='$title', description='$description', dueDate='$dueDate', priority=$priority, isCompleted=$isCompleted, state=$state)"
    }

    fun changePriority(newPriority: Priority) {
        priority = newPriority
    }

    fun isOverdue(currentDate: String): Boolean {
        // Pendiente
        return dueDate < currentDate
    }

    fun clone(): Task {
        return Task(id, title, description, dueDate, priority, isCompleted, assignTo, state)
    }
}

enum class Priority {
    LOW, MEDIUM, HIGH
}

enum class State {
    TODO, IN_PROGRESS, Q_A, DONE
}