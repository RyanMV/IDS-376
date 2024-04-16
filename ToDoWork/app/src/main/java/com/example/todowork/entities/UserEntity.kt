package com.example.todowork.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val username: String,
    val email: String,
    val password: String
)
