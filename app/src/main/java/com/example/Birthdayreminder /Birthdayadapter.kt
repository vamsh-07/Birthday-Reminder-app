// BirthdayAdapter.kt
package com.example.birthdayreminder

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.birthdayreminder.data.model.Birthday
import kotlinx.android.synthetic.main.birthday_item.view.*

class BirthdayAdapter(private val list: List<Birthday>) : RecyclerView.Adapter<BirthdayAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(birthday: Birthday) {
            itemView.nameText.text = birthday.name
            itemView.dateText.text = birthday.date

            itemView.sendWishButton.setOnClickListener {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("smsto:${birthday.phone ?: ""}")
                    putExtra("sms_body", "Happy Birthday ${birthday.name}!")
                }
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.birthday_item, parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }
}
