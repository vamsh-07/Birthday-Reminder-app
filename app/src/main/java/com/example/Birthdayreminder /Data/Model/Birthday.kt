// model/Birthday.kt
package com.example.birthdayreminder.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "birthday")
data class Birthday(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val date: String,
    val phone: String?,
    val email: String?
)
