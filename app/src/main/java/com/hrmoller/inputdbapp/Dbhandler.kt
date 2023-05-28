package com.hrmoller.inputdbapp

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.versionedparcelable.ParcelField
import com.hrmoller.inputdbapp.daos.InputDao
import com.hrmoller.inputdbapp.entities.InputEntity


@Database(entities = [InputEntity::class], version = 1)
abstract class Dbhandler: RoomDatabase() {
    abstract fun inputDao(): InputDao
}

