package com.hrmoller.inputdbapp.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.hrmoller.inputdbapp.entities.InputEntity

@Dao
interface InputDao {
    @Insert
    suspend fun insertAll(vararg inputEntities: InputEntity)

    @Delete
    suspend fun delete(inputEntity: InputEntity)

    @Query("SELECT * FROM inputEntity")
    suspend fun getAll(): List<InputEntity>

    @Query("SELECT * FROM inputEntity WHERE id=:userId")
    suspend fun getById(userId: Int): InputEntity
}