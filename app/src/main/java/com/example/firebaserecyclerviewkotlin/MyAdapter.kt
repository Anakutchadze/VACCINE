package com.example.firebaserecyclerviewkotlin
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class MyAdapter(private val list: List<User>) : RecyclerView.Adapter<MyAdapter.PersonViewHolder>() {

    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Manufacturer : TextView
        val Country : TextView
        val Doses : TextView
        val Photos : ImageView

        init {
            Manufacturer = itemView.findViewById(R.id.manufacturer)
            Country = itemView.findViewById(R.id.country)
            Doses = itemView.findViewById(R.id.doses)
            Photos = itemView.findViewById(R.id.photo)

        }

        fun data(user: User) {
            Glide.with(itemView.context).load(user.photovac).into(Photos)
            Manufacturer.text = user.manufacturer
            Country.text= user.country
            Doses.text= user.doses

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return PersonViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val country = list[position]
        holder.data(country)

    }

    override fun getItemCount() = list.size
}