package com.hrmoller.inputdbapp.entities

import android.icu.text.CaseMap.Title
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class InputEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    val title: String?,
    val body: String?
) {
}