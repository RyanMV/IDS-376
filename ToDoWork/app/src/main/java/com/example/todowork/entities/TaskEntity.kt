package com.example.todowork.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val dueDate: String,
    val priority: Priority,
    val isCompleted: Boolean,
    val assignTo: Int,
    val state: State
)
