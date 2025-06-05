package com.example.utsandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter untuk RecyclerView yang menampilkan daftar testimoni
class TestimoniAdapter(private val testimoniList: List<Testimoni>) :
    RecyclerView.Adapter<TestimoniAdapter.TestimoniViewHolder>() {

    // Inner class untuk menampung View dari setiap item testimoni
    class TestimoniViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvContent: TextView = itemView.findViewById(R.id.tv_testimoni_content)
        val tvAuthor: TextView = itemView.findViewById(R.id.tv_testimoni_author)
    }

    // Dipanggil saat RecyclerView membutuhkan ViewHolder baru
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestimoniViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_testimoni, parent, false)
        return TestimoniViewHolder(view)
    }

    // Dipanggil untuk menampilkan data pada posisi tertentu di ViewHolder
    override fun onBindViewHolder(holder: TestimoniViewHolder, position: Int) {
        val testimoni = testimoniList[position]
        holder.tvContent.text = testimoni.content
        holder.tvAuthor.text = testimoni.author
    }

    // Mengembalikan jumlah total item dalam dataset
    override fun getItemCount(): Int {
        return testimoniList.size
    }
}