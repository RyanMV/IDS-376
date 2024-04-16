package com.example.todowork.models

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todowork.dao.TaskDao
import com.example.todowork.dao.UserDao
import com.example.todowork.entities.TaskEntity
import com.example.todowork.entities.UserEntity

@Database(entities = [UserEntity::class, TaskEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun taskDao(): TaskDao
}