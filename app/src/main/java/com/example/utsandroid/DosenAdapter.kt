package com.example.utsandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DosenAdapter(private val dosenList: List<Dosen>) :
    RecyclerView.Adapter<DosenAdapter.DosenViewHolder>() {

    inner class DosenViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.imageDosen)
        val nama: TextView = view.findViewById(R.id.namaDosen)
        val pendidikan: TextView = view.findViewById(R.id.pendidikanDosen)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DosenViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dosen, parent, false)
        return DosenViewHolder(view)
    }

    override fun onBindViewHolder(holder: DosenViewHolder, position: Int) {
        val dosen = dosenList[position]
        holder.nama.text = dosen.nama
        holder.pendidikan.text = dosen.pendidikan
        holder.image.setImageResource(dosen.imageResId)
    }

    override fun getItemCount(): Int = dosenList.size
}
