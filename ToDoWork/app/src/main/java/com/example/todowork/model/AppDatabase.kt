package com.example.todowork.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todowork.database.TaskDao
import com.example.todowork.database.UserDao

@Database(entities = [UserEntity::class, TaskEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun taskDao(): TaskDao
}