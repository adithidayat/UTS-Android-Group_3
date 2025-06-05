package com.example.utsandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

// Konstruktor ImageAdapter menerima List<Int> yang merupakan resource ID dari gambar-gambar
class ImageAdapter(private val imageResIds: List<Int>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    // Inner class untuk menampung View dari setiap item dalam RecyclerView
    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Menginisialisasi ImageView dari layout item_image.xml
        val imageView: ImageView = itemView.findViewById(R.id.iv_gallery_item)
    }

    // Metode ini dipanggil ketika RecyclerView membutuhkan ViewHolder baru
    // Ini akan meng-inflate layout item_image.xml untuk setiap item gambar
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    // Metode ini dipanggil untuk mengisi data ke dalam ViewHolder pada posisi tertentu
    // Mengatur gambar ke ImageView menggunakan resource ID yang sesuai
    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.imageView.setImageResource(imageResIds[position])
    }

    // Metode ini mengembalikan jumlah total item dalam dataset
    override fun getItemCount(): Int {
        return imageResIds.size
    }
}