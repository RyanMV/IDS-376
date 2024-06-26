package com.example.todowork.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todowork.model.TaskEntity


@Database(entities = [TaskEntity::class], version = 1)
abstract class TaskDatabase : RoomDatabase(){
    abstract fun getTaskDao(): TaskDao

    companion object{
        @Volatile
        private var instance: TaskDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?:
        synchronized(LOCK){
            instance?:
            createDatabase(context).also{
                instance = it
            }
        }

        private fun createDatabase(context:Context) = Room.databaseBuilder(context.applicationContext, TaskDatabase::class.java,"task_db").build()
    }
}