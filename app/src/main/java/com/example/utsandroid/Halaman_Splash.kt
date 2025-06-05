package com.example.utsandroid

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Halaman_Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_halaman_splash)
        val logo = findViewById<ImageView>(R.id.logoImageView)

        // Load animasi dari XML
        val anim = AnimationUtils.loadAnimation(this, R.anim.splash_anim)

        // Jalankan animasi pada ImageView
        logo.startAnimation(anim)

        // Pindah ke MainActivity setelah 2 detik
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, Halaman_Utama::class.java))
            finish()
        }, 2000) // Durasi splash screen 2 detik
    }
}