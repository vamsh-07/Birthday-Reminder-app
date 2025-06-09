// data/BirthdayDao.kt
package com.example.birthdayreminder.data

import androidx.room.*
import com.example.birthdayreminder.data.model.Birthday

@Dao
interface BirthdayDao {
    @Query("SELECT * FROM birthday ORDER BY date")
    fun getAll(): List<Birthday>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(birthday: Birthday)

    @Delete
    fun delete(birthday: Birthday)
}
