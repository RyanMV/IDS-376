package com.example.todowork.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todowork.model.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE status = 1")
    fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM users WHERE id = :userId AND status = 1")
    fun getUserById(userId: Int): UserEntity?

    @Insert
    fun insertUser(user: UserEntity)

    @Update
    fun updateUser(user: UserEntity)
}