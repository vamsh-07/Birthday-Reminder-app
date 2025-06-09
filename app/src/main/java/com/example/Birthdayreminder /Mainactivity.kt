// MainActivity.kt
package com.example.birthdayreminder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.birthdayreminder.data.AppDatabase
import com.example.birthdayreminder.data.model.Birthday
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = AppDatabase.getDatabase(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = BirthdayAdapter(db.birthdayDao().getAll())

        addBirthdayButton.setOnClickListener {
            val name = nameInput.text.toString()
            val date = dateInput.text.toString()
            val phone = phoneInput.text.toString()
            val email = emailInput.text.toString()

            val birthday = Birthday(name = name, date = date, phone = phone, email = email)
            db.birthdayDao().insert(birthday)

            recyclerView.adapter = BirthdayAdapter(db.birthdayDao().getAll())
        }
    }
}
