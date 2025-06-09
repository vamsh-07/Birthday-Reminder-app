// data/AppDatabase.kt
package com.example.birthdayreminder.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.birthdayreminder.data.model.Birthday

@Database(entities = [Birthday::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun birthdayDao(): BirthdayDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "birthday_db"
                ).allowMainThreadQueries().build()
            }
            return INSTANCE!!
        }
    }
}
