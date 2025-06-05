package com.example.utsandroid

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView

class DosenFragment : Fragment() {


    private val dataSemester = mapOf(
        1 to listOf(
            MataKuliah(1, "Aljabar Linear", 2, 2),
            MataKuliah(2, "Bahasa Inggris", 2, 2),
            MataKuliah(3, "Kewarganegaraan", 2, 2),
            MataKuliah(4, "Pancasila", 2, 2),
            MataKuliah(5, "Pengantar UI/UX", 1, 1),
            MataKuliah(6, "Praktikum UI/UX", 2, 6),
            MataKuliah(7, "Pemrograman Dasar", 1, 1),
            MataKuliah(8, "Praktikum Pemrograman Dasar", 2, 6),
            MataKuliah(9, "Workshop Perangkat Lunak Aplikasi", 3, 9),
            MataKuliah(10, "Workshop Sistem Operasi", 2, 6)
        ),
        2 to listOf(
            MataKuliah(1, "Bahasa Inggris 2", 2, 2),
            MataKuliah(2, "Kalkulus", 2, 2),
            MataKuliah(3, "Komunikasi Data & Jaringan Komputer", 1, 1),
            MataKuliah(4, "Pengantar Rekayasa Perangkat Lunak", 2, 2),
            MataKuliah(5, "Praktikum Komunikasi Data & Jaringan Komputer", 2, 6),
            MataKuliah(6, "Praktikum Sistem Basis Data", 2, 6),
            MataKuliah(7, "Praktikum Struktur Data dan Algoritma", 2, 6),
            MataKuliah(8, "Sistem Basis Data", 1, 1),
            MataKuliah(9, "Struktur Data da Algoritma", 1, 1),
            MataKuliah(10, "Teknik Presentasi", 2, 2),
            MataKuliah(11, "Workshop Pemrograman Web 1", 3, 9)
        ),
        3 to listOf(
            MataKuliah(1, "Agama", 2, 2),
            MataKuliah(2, "Analisis & Desain Perangkat Lunak", 1, 1),
            MataKuliah(3, "Bahasa Inggris 3", 2, 2),
            MataKuliah(4, "Dasar Keamanan Komputer", 2, 2),
            MataKuliah(5, "Matematika Diskrit", 2, 6),
            MataKuliah(6, "Pemrograman Berorientasi Objek", 1, 1),
            MataKuliah(7, "Praktikum Analisis & Desain Perangkat Lunak", 2, 6),
            MataKuliah(8, "Praktikum Dasar Keamanan Komputer", 1, 3),
            MataKuliah(9, "Praktikum Pemrograman Berorientasi Objek", 2, 6),
            MataKuliah(10, "Workshop Pemrograman Visual", 2, 6),
            MataKuliah(11, "Workshop Pemrograman Web 2", 3, 9)
        ),
        4 to listOf(
            MataKuliah(1, "Bahasa Indonesia", 2, 2),
            MataKuliah(2, "Bahasa Inggris 4", 2, 2),
            MataKuliah(3, "Etika Profesi", 2, 2),
            MataKuliah(4, "Pengantar Manufaktur Tekstil", 1, 1),
            MataKuliah(5, "Workshop Cloud Computing", 2, 6),
            MataKuliah(6, "Workshop Keamanan Basis Data", 2, 6),
            MataKuliah(7, "Workshop Pemrograman Android 1", 3, 9),
            MataKuliah(8, "Workshop Pemrograman Web 3", 3, 9)
        ),
        5 to listOf(
            MataKuliah(1, "Bahasa Inggris 5", 2, 2),
            MataKuliah(2, "Metodologi Penelitian", 2, 2),
            MataKuliah(3, "Manajemen Kearsipan", 2, 2),
            MataKuliah(4, "Pengujian Perangkat Lunak", 2, 2),
            MataKuliah(5, "Projek Manufaktur Tekstil", 1, 3),
            MataKuliah(6, "Statistik", 3, 3),
            MataKuliah(7, "Workshop Keamanan Perangkat Lunak", 2, 6),
            MataKuliah(8, "Workshop Pemrograman Android 2", 3, 9),
            MataKuliah(9, "Workshop Pemrograman Web 4", 3, 9)
        ),
        6 to listOf(
            MataKuliah(1, "Data Mining", 1, 1),
            MataKuliah(2, "Enterprise Resource Planning", 1, 1),
            MataKuliah(3, "Praktikum Data Mining", 2, 6),
            MataKuliah(4, "Praktikum Enterprise Resource Planning", 2, 6),
            MataKuliah(5, "Tugas Akhir 1", 4, 12),
            MataKuliah(6, "Workshop Pemrograman IOS", 2, 6),
            MataKuliah(7, "Workshop Sistem Terdistribusi", 2, 6)
        ),
        7 to listOf(
            MataKuliah(1, "Manajemen Proyek", 5, 13),
            MataKuliah(2, "Technopreuneur", 2, 2),
            MataKuliah(3, "Tugas Akhir 2", 8, 24)
        ),
        8 to listOf(
            MataKuliah(1, "Internship / Magang Industri", 20, 60)
        )
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dosen, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerDosen)



        val dosenList = listOf(
            Dosen("Musawarman, S.Kom, M.M.S.I.", "[S1 – Institut Pertanian Bogor]\n[S2 – Universitas Gunadarma, Jakarta]", R.drawable.pak_musa),
            Dosen("Muhammad Nugraha, S.T., M.Eng", "[S1 – Universitas Ahmad Dahlan Yogyakarta]\n[S2 – Chonnam National University, Korea Selatan]", R.drawable.pak_nugraha),
            Dosen("Ricak Agus Setiawan, S.T., M.SI.", "[S1 – STMIK Bandung]\n[S2 – STMIK Putera Batam]", R.drawable.pak_ricak),
            Dosen("Halimil Fathi, S.Kom, M.Kom", "[S1 – STT Wastu Kancana Purwakarta]\n[S2 – STMIK LIKMI Bandung]", R.drawable.pak_halimil),
            Dosen("Widya Andayani Rahayu, S.Pd., M.Pd.", "[S1 – STKIP Subang]\n[S2 – Universitas Indraprasta PGRI]", R.drawable.bu_widya),
            Dosen("Heti Mulyani, S.T., M.Kom", "[S1 – STMIK Bandung]\n[S2 – Institut Pertanian Bogor]", R.drawable.bu_heti),
            Dosen("Sukrina Herman, S.Kom, M.Kom", "[S1 – Telkom University]\n[S2 – STIMIK LIKMI Bandung]", R.drawable.bu_rina),

            )

        val adapter = DosenAdapter(dosenList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        LinearSnapHelper().attachToRecyclerView(recyclerView)

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val centerX = recyclerView.width / 2
                for (i in 0 until recyclerView.childCount) {
                    val child = recyclerView.getChildAt(i)
                    val childCenterX = (child.left + child.right) / 2
                    val distanceFromCenter = Math.abs(centerX - childCenterX)
                    val maxScale = 1.10f // Semakin besar, semakin menonjol
                    val minScale = 0.65f // Ukuran minimum item di pinggir
                    val scaleFactor = 1 - (distanceFromCenter.toFloat() / recyclerView.width)
                    val scale = minScale + (scaleFactor * (maxScale - minScale)).coerceAtLeast(0f)

                    child.scaleX = scale
                    child.scaleY = scale

                    if (distanceFromCenter < child.width / 2) {
                        // Fokus item (tengah)
                        child.setBackgroundResource(R.drawable.bg_dosen_selected)
                        child.elevation = 16f
                    } else {
                        // Bukan fokus item
                        child.setBackgroundResource(R.drawable.bg_dosen_default)
                        child.elevation = 4f
                    }
                }
            }
        })
        // accordion Kurikulum di dalam DosenFragment
        val accordionContainer = view.findViewById<LinearLayout>(R.id.accordionContainer)

        for (semester in 1..dataSemester.size) {
            val accordionView = inflater.inflate(R.layout.item_semester, accordionContainer, false)

            val headerLayout = accordionView.findViewById<LinearLayout>(R.id.headerLayout)
            val titleText = accordionView.findViewById<TextView>(R.id.titleText)
            val arrowIcon = accordionView.findViewById<ImageView>(R.id.arrowIcon)
            val tableLayout = accordionView.findViewById<TableLayout>(R.id.tableLayout)

            titleText.text = "Semester $semester"

            val mataKuliahList = dataSemester[semester] ?: emptyList()
            fillTable(tableLayout, mataKuliahList)

            headerLayout.setOnClickListener {
                if (tableLayout.visibility == View.GONE) {
                    tableLayout.visibility = View.VISIBLE
                    arrowIcon.setImageResource(R.drawable.ic_arrow_up)
                } else {
                    tableLayout.visibility = View.GONE
                    arrowIcon.setImageResource(R.drawable.ic_arrow_down)
                }
            }

            accordionContainer.addView(accordionView)
        }

        return view
    }

    private fun fillTable(tableLayout: TableLayout, mataKuliahList: List<MataKuliah>) {
        tableLayout.removeAllViews()

        val weights = listOf(1f, 4f, 1f, 1f) // Kolom Mata Kuliah lebih lebar

        // Header Row
        val headerRow = TableRow(requireContext())
        headerRow.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.darker_gray))
        val headers = listOf("No", "Mata Kuliah", "SKS", "Jam")
        headers.forEachIndexed { index, text ->
            val params = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, weights[index])
            val tv = TextView(requireContext()).apply {
                this.text = text
                setTypeface(null, Typeface.BOLD)
                setPadding(8, 8, 8, 8)
                layoutParams = params
            }
            headerRow.addView(tv)
        }
        tableLayout.addView(headerRow)

        // Data Rows
        var totalSKS = 0
        var totalJam = 0
        mataKuliahList.forEach { mk ->
            val row = TableRow(requireContext())
            val values = listOf(mk.no.toString(), mk.nama, mk.sks.toString(), mk.jam.toString())
            values.forEachIndexed { index, text ->
                val params = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, weights[index])
                val tv = TextView(requireContext()).apply {
                    this.text = text
                    setPadding(8, 8, 8, 8)
                    layoutParams = params
                    if (index == 1) { // Kolom "Mata Kuliah"
                        setSingleLine(false)
                        maxLines = 3
                    } else {
                        setSingleLine(true)
                    }
                }
                row.addView(tv)
            }
            tableLayout.addView(row)
            totalSKS += mk.sks
            totalJam += mk.jam
        }

        // Total Row
        val totalRow = TableRow(requireContext())
        totalRow.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.darker_gray))
        val totals = listOf("", "Total", totalSKS.toString(), totalJam.toString())
        totals.forEachIndexed { index, text ->
            val params = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, weights[index])
            val tv = TextView(requireContext()).apply {
                this.text = text
                setTypeface(null, Typeface.BOLD)
                setPadding(8, 8, 8, 8)
                layoutParams = params
            }
            totalRow.addView(tv)
        }
        tableLayout.addView(totalRow)
    }

}
