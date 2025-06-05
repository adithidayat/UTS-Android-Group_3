package com.example.utsandroid

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2

class Halaman_Utama : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var menuHome: LinearLayout
    private lateinit var menuDosen: LinearLayout
    private lateinit var menuKompetensi: LinearLayout
    private lateinit var menuFasilitas: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_utama)

        viewPager = findViewById(R.id.viewPager2)
        menuHome = findViewById(R.id.menu_home)
        menuDosen = findViewById(R.id.menu_dosen)
        menuKompetensi = findViewById(R.id.menu_kompetensi)
        menuFasilitas = findViewById(R.id.menu_fasilitas)

        viewPager.adapter = ViewPagerAdapter(this)

        // Klik bottom nav untuk pindah halaman
        menuHome.setOnClickListener { viewPager.currentItem = 0 }
        menuDosen.setOnClickListener { viewPager.currentItem = 1 }
        menuKompetensi.setOnClickListener { viewPager.currentItem = 2 }
        menuFasilitas.setOnClickListener { viewPager.currentItem = 3 }

        // Update UI bottom nav saat swipe page
        viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                updateBottomNav(position)
            }
        })

        // Inisialisasi highlight menu bottom nav
        updateBottomNav(0)
    }

    private fun updateBottomNav(position: Int) {
        val selectedColor = Color.parseColor("#4CAF50")
        val defaultColor = Color.parseColor("#000000")

        val iconRes = listOf(
            R.drawable.home to R.drawable.home_hijau,
            R.drawable.dosen to R.drawable.dosen_hijau,
            R.drawable.kompetensi to R.drawable.kompetensi_hijau,
            R.drawable.fasilitas to R.drawable.fasilitas_hijau
        )

        val menuLayouts = listOf(menuHome, menuDosen, menuKompetensi, menuFasilitas)

        for ((index, layout) in menuLayouts.withIndex()) {
            val imageView = layout.getChildAt(0) as ImageView
            val textView = layout.getChildAt(1) as TextView

            imageView.setImageResource(if (index == position) iconRes[index].second else iconRes[index].first)
            textView.setTextColor(if (index == position) selectedColor else defaultColor)
        }
    }

}