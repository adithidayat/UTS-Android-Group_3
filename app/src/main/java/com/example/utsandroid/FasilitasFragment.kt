package com.example.utsandroid

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

class FasilitasFragment : Fragment() {

    // Mendeklarasikan variabel untuk komponen UI dengan lateinit
    // lateinit memberitahu Kotlin bahwa variabel ini akan diinisialisasi sebelum digunakan
    private lateinit var barChartGaji: BarChart
    private lateinit var recyclerViewImages: RecyclerView
    private lateinit var imageAdapter: ImageAdapter

    // Deklarasi untuk RecyclerView Testimoni dan adapternya
    private lateinit var recyclerViewTestimoni: RecyclerView
    private lateinit var testimoniAdapter: TestimoniAdapter

    // Menghubungkan Fragment ini dengan layout XML: fragment_fasilitas.xml
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fasilitas, container, false)
    }

    override fun onResume() {
        super.onResume()

        // Jalankan ulang animasi chart
        barChartGaji.animateY(1500)

    }


    // Menginisialisasi variabel UI setelah layout di-inflate
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Menginisialisasi variabel UI dengan menemukan View berdasarkan ID dari layout XML
        barChartGaji = view.findViewById(R.id.bar_chart_gaji)
        recyclerViewImages = view.findViewById(R.id.recycler_view_images)
        recyclerViewTestimoni = view.findViewById(R.id.recycler_view_testimoni)

        // Memanggil fungsi-fungsi setup untuk mengkonfigurasi masing-masing komponen
        setupBarChart()
        setupRecyclerView()
        setupTestimoniRecyclerView()
    }

    // Fungsi untuk mengkonfigurasi Bar Chart
    private fun setupBarChart() {
        // Membuat data entry untuk Bar Chart (gaji dalam juta IDR)
        val entries = ArrayList<BarEntry>().apply {
            // BarEntry(posisi_X, nilai_Y)
            add(BarEntry(0f, 28f)) // Front End Dev (9jt - 28jt) - pakai float (f)
            add(BarEntry(1f, 35f)) // IT Manager (20jt - 35jt)
            add(BarEntry(2f, 41f)) // UI/UX (8.8jt - 41jt)
            add(BarEntry(3f, 30f)) // Back End Dev (13jt - 30jt)
        }

        // Membuat DataSet dari data entry
        val dataSet = BarDataSet(entries, "Gaji Tertinggi (Juta IDR)").apply {
            setColors(Color.parseColor("#21825C")) // Mengatur warna bar menjadi hijau
            setValueTextColor(Color.BLACK) // Warna teks nilai di atas bar
            setValueTextSize(10f) // Ukuran teks nilai
            setDrawValues(true) // Menampilkan nilai di atas bar
        }

        // Membuat objek BarData dari DataSet
        val barData = BarData(dataSet).apply {
            barWidth = 0.6f // Mengatur lebar bar
        }

        // Mengkonfigurasi BarChart secara keseluruhan
        barChartGaji.apply {
            data = barData // Mengatur data chart
            setFitBars(true) // Memastikan bar pas di dalam view
            setNoDataText("Tidak ada data chart") // Pesan jika tidak ada data

            // Konfigurasi Chart Umum
            description.isEnabled = false // Sembunyikan deskripsi default
            setTouchEnabled(false) // Nonaktifkan interaksi sentuh (zoom, geser)
            setDrawGridBackground(false) // Sembunyikan latar belakang grid

            // Konfigurasi X-Axis (Sumbu Horizontal - Label Pekerjaan)
            xAxis.apply {
                position = XAxis.XAxisPosition.BOTTOM // Label di bagian bawah chart
                setDrawGridLines(false) // Sembunyikan garis grid vertikal
                setDrawAxisLine(true) // Tampilkan garis sumbu X
                textColor = Color.BLACK
                textSize = 10f
                labelCount = entries.size // Jumlah label sesuai jumlah bar
                granularity = 1f // Interval antar label (penting untuk IndexAxisValueFormatter)
                labelRotationAngle = -45f // Putar label untuk menghindari tumpang tindih
                // Menggunakan IndexAxisValueFormatter untuk label kustom di sumbu X
                valueFormatter = IndexAxisValueFormatter(
                    arrayOf(
                        "Front End Dev",
                        "IT Manager",
                        "UI/UX",
                        "Back End Dev"
                    )
                )
            }

            // Konfigurasi Y-Axis Kiri (Sumbu Vertikal - Gaji)
            axisLeft.apply {
                setDrawGridLines(false) // Sembunyikan garis grid horizontal
                axisMinimum = 0f // Mulai sumbu Y dari 0
                textColor = Color.BLACK
                textSize = 10f
            }
            axisRight.isEnabled = false // Sembunyikan Y-axis kanan

            // Konfigurasi Legenda Chart
            legend.apply {
                isEnabled = true // Tampilkan legenda
                textColor = Color.BLACK
                textSize = 12f
                formSize = 10f // Ukuran bentuk di legenda
            }

            // Animasi Chart
            animateY(1500) // Animasi bar naik dari bawah selama 1.5 detik
            invalidate() // Refresh chart untuk menampilkan semua perubahan
        }
    }

    // Fungsi untuk mengkonfigurasi RecyclerView (Galeri Gambar)
    private fun setupRecyclerView() {
        // Daftar ID resource gambar yang akan ditampilkan.
        // Pastikan gambar-gambar ini ada di folder res/drawable proyekmu.
        val imageResIds = listOf(
            R.drawable.ruangkelas_1,
            R.drawable.ruangkelas_2,
            R.drawable.ruangkelas_33,
            R.drawable.ruangkelas_4
        )

        // Mengatur LayoutManager untuk RecyclerView.
        // GridLayoutManager(context, jumlah_kolom) akan menampilkan item dalam grid 2 kolom.
        recyclerViewImages.layoutManager = GridLayoutManager(context, 2)

        // Membuat instance ImageAdapter dengan daftar ID gambar
        imageAdapter = ImageAdapter(imageResIds)

        // Mengatur adapter ke RecyclerView
        recyclerViewImages.adapter = imageAdapter
    }

    private fun setupTestimoniRecyclerView() {
        val testimoniList = listOf(
            Testimoni(
                "Pengalaman saya selama kuliah di PEI saya mendapatkan ilmu yang saya sukai, seperti mendesain aplikasi dan pemrograman. Dengan metode pembelajaran yang lebih banyak praktek membuat saya tidak bosan belajar dikelas.",
                "Dina Armei - TRPL '21"
            ),
            Testimoni(
                "Saya senang kuliah di PEI karena fasilitas lab disini sangat lengkap sehingga proses pembelajaran dapat dilakukan dengan maksimal.",
                "Muhammad Daris - TRPL '21"
            ),
            Testimoni(
                "Saya sangat senang kuliah PEI karena dosen-nya baik dan selalu membantu saya ketika menghadapi kesulitan dalam pembelajaran. Selain itu dosennya juga sangat berkompeten dalam bidangnya masing-masing",
                "Annisa Zachry - TRPL '20"
            )

        )

        // Mengatur LayoutManager menjadi LinearLayoutManager dengan orientasi horizontal
        recyclerViewTestimoni.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // Membuat instance TestimoniAdapter
        testimoniAdapter = TestimoniAdapter(testimoniList)

        // Mengatur adapter ke RecyclerView
        recyclerViewTestimoni.adapter = testimoniAdapter
    }
}
