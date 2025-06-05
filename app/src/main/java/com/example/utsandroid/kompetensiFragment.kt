package com.example.utsandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.cardview.widget.CardView
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import android.widget.TextView
import android.widget.ImageView
import android.graphics.Rect
import android.view.animation.AnimationUtils
import android.widget.ScrollView

//import untuk isi content
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.BulletSpan
import android.graphics.text.LineBreaker

class kompetensiFragment : Fragment() {

    private lateinit var panel1: LinearLayout
    private lateinit var content1: LinearLayout
    private lateinit var panel2: LinearLayout
    private lateinit var content2: LinearLayout
    private lateinit var panel3: LinearLayout
    private lateinit var content3: LinearLayout
    private lateinit var panel1Title: TextView
    private lateinit var panel2Title: TextView
    private lateinit var panel3Title: TextView
    private lateinit var panel1Icon: ImageView
    private lateinit var panel2Icon: ImageView
    private lateinit var panel3Icon: ImageView
    private var isPanel1Expanded = false
    private var isPanel2Expanded = false
    private var isPanel3Expanded = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_kompetensi, container, false)
    }
    override fun onResume() {
        super.onResume()
        animatedViews.clear()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        panel1 = view.findViewById(R.id.panel1)
        content1 = view.findViewById(R.id.content1)
        panel2 = view.findViewById(R.id.panel2)
        content2 = view.findViewById(R.id.content2)
        panel3 = view.findViewById(R.id.panel3)
        content3 = view.findViewById(R.id.content3)
        panel1Title = view.findViewById(R.id.panel1Title)
        panel2Title = view.findViewById(R.id.panel2Title)
        panel3Title = view.findViewById(R.id.panel3Title)
        panel1Icon = view.findViewById(R.id.panel1Icon)
        panel2Icon = view.findViewById(R.id.panel2Icon)
        panel3Icon = view.findViewById(R.id.panel3Icon)

        val scrollView = view.findViewById<ScrollView>(R.id.scrollview) // Pastikan kamu beri ID di XML
        val card1 = view.findViewById<CardView>(R.id.cardTopik1)
        val card2 = view.findViewById<CardView>(R.id.cardTopik2)
        val card3 = view.findViewById<CardView>(R.id.cardTopik3)
        val card4 = view.findViewById<CardView>(R.id.cardTopik4)
        val card5 = view.findViewById<CardView>(R.id.cardTopik5)
        val card6 = view.findViewById<CardView>(R.id.cardTopik6)
        val card7 = view.findViewById<CardView>(R.id.cardTopik7)
        val card8 = view.findViewById<CardView>(R.id.cardTopik8)

        val cards = listOf(card1, card2, card3, card4, card5, card6, card7, card8)
        val anim = AnimationUtils.loadAnimation(requireContext(), R.anim.bounce)

//        scrollView.viewTreeObserver.addOnScrollChangedListener {
//            for (card in cards) {
//                if (isViewVisible(card, scrollView) && !animatedViews.contains(card)) {
//                    card.startAnimation(anim)
//                    animatedViews.add(card)
//                }
//            }
//        }

        scrollView.viewTreeObserver.addOnScrollChangedListener {
            cards.forEachIndexed { index, card ->
                if (isViewVisible(card, scrollView) && !animatedViews.contains(card)) {
                    val anim = AnimationUtils.loadAnimation(requireContext(), R.anim.bounce)
                    anim.startOffset = (index * 300).toLong()  // Delay bertambah 300ms tiap card
                    card.startAnimation(anim)
                    animatedViews.add(card)
                }
            }
        }

        // isi konten 1
        val bulletTexts = listOf(
            "Mampu merencanakan dan menganalisis kebutuhan perangkat lunak.",
            "Mampu mendesain perangkat lunak sesuai dengan hasil perencanaan dan analisis.",
            "Mampu membuat perangkat lunak berbasis web.",
            "Mampu membuat perangkat lunak berbasis mobile (android/ios).",
            "Mampu membuat perangkat lunak berbasis desktop.",
            "Mampu mendesain dan mengimplementasikan database.",
            "Mampu mendesain UI/UX perangkat lunak.",
            "Mampu mengimplementasikan konsep-konsep keamanan komputer, jaringan, dan perangkat lunak.",
            "Mampu melakukan pengujian sistem pada perangkat lunak.",
            "Mampu mengelola suatu projek perangkat lunak.",
            "Mampu mengimplementasikan konsep jaringan komputer dan cloud computing.",
            "Mampu mengimplementasikan algoritma untuk sistem cerdas."
        )

        val spannable = SpannableStringBuilder()
        for (text in bulletTexts) {
            val bulletPoint = BulletSpan(10)
            val start = spannable.length
            spannable.append(text).append("\n\n")
            spannable.setSpan(bulletPoint, start, spannable.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        val textView = view.findViewById<TextView>(R.id.txt_kompetensi)
        textView.text = spannable
        textView.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD

        // isi konten 2
        val bulletTexts2 = listOf(
            "Mampu melakukan presentasi menggunakan bahasa Indonesia dan bahasa inggris dengan baik dan benar.",
            "Mampu berperilaku baik, sopan, dan santun dalam ucapan dan tindakan.",
            "Mampu menyajikan ide dan gagasan baik secara lisan ataupun tulisan."
        )

        val spannable2 = SpannableStringBuilder()
        for (text in bulletTexts2) {
            val bulletPoint = BulletSpan(10)
            val start = spannable2.length
            spannable2.append(text).append("\n\n")
            spannable2.setSpan(bulletPoint, start, spannable2.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        val textView2 = view.findViewById<TextView>(R.id.txt_pendukung)
        textView2.text = spannable2
        textView2.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD

        // isi konten 3
        val bulletTexts3 = listOf(
            "Mampu berwirausaha dalam bidang teknologi rekayasa perangkat lunak.",
            "Memiliki rasa kepedulian dan kepekaan terhadap lingkungan sekitar.",
            "Memiliki kedisiplinan dan rasa tanggung jawab yang tinggi."
        )

        val spannable3 = SpannableStringBuilder()
        for (text in bulletTexts3) {
            val bulletPoint = BulletSpan(10)
            val start = spannable3.length
            spannable3.append(text).append("\n\n")
            spannable3.setSpan(bulletPoint, start, spannable3.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        val textView3 = view.findViewById<TextView>(R.id.txt_lainnya)
        textView3.text = spannable3
        textView3.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD

        panel1.setOnClickListener { toggleAccordion(1) }
        panel2.setOnClickListener { toggleAccordion(2) }
        panel3.setOnClickListener { toggleAccordion(3) }
    }

    //    untuk deteksi card view
    private val animatedViews = mutableSetOf<View>()
    private fun isViewVisible(view: View, scrollView: ScrollView): Boolean {
        val scrollBounds = Rect()
        scrollView.getHitRect(scrollBounds)
        return view.getLocalVisibleRect(scrollBounds)
    }

    private fun expandView(view: View) {
        view.visibility = View.VISIBLE
        view.alpha = 0f
        view.animate()
            .alpha(1f)
            .setDuration(300)
            .start()
    }

    private fun collapseView(view: View) {
        view.animate()
            .alpha(0f)
            .setDuration(200)
            .withEndAction {
                view.visibility = View.GONE
            }
            .start()
    }

    private fun toggleAccordion(panelNumber: Int) {
        val ctx = requireContext()
        if (panelNumber == 1) {
            if (isPanel1Expanded) {
                collapseView(content1)
                panel1.setBackgroundColor(ContextCompat.getColor(ctx, R.color.gray))
                panel1Title.setTextColor(ContextCompat.getColor(ctx, R.color.black2))
                panel1Icon.setImageResource(R.drawable.logo_plus)
                isPanel1Expanded = false
            } else {
                expandView(content1)
                collapseView(content2)
                collapseView(content3)

                panel1.setBackgroundColor(ContextCompat.getColor(ctx, R.color.green))
                panel2.setBackgroundColor(ContextCompat.getColor(ctx, R.color.gray))
                panel3.setBackgroundColor(ContextCompat.getColor(ctx, R.color.gray))

                panel1Icon.setImageResource(R.drawable.logo_min)
                panel2Icon.setImageResource(R.drawable.logo_plus)
                panel3Icon.setImageResource(R.drawable.logo_plus)

                panel1Title.setTextColor(ContextCompat.getColor(ctx, R.color.white))
                panel2Title.setTextColor(ContextCompat.getColor(ctx, R.color.black2))
                panel3Title.setTextColor(ContextCompat.getColor(ctx, R.color.black2))

                isPanel1Expanded = true
                isPanel2Expanded = false
                isPanel3Expanded = false
            }
        } else if (panelNumber == 2) {
            if (isPanel2Expanded) {
                collapseView(content2)
                panel2.setBackgroundColor(ContextCompat.getColor(ctx, R.color.gray))
                panel2Title.setTextColor(ContextCompat.getColor(ctx, R.color.black2))
                panel2Icon.setImageResource(R.drawable.logo_plus)
                isPanel2Expanded = false
            } else {
                collapseView(content1)
                expandView(content2)
                collapseView(content3)

                panel2.setBackgroundColor(ContextCompat.getColor(ctx, R.color.green))
                panel1.setBackgroundColor(ContextCompat.getColor(ctx, R.color.gray))
                panel3.setBackgroundColor(ContextCompat.getColor(ctx, R.color.gray))

                panel1Icon.setImageResource(R.drawable.logo_plus)
                panel2Icon.setImageResource(R.drawable.logo_min)
                panel3Icon.setImageResource(R.drawable.logo_plus)

                panel1Title.setTextColor(ContextCompat.getColor(ctx, R.color.black2))
                panel2Title.setTextColor(ContextCompat.getColor(ctx, R.color.white))
                panel3Title.setTextColor(ContextCompat.getColor(ctx, R.color.black2))

                isPanel2Expanded = true
                isPanel1Expanded = false
                isPanel3Expanded = false
            }
        } else if (panelNumber == 3) {
            if (isPanel3Expanded) {
                collapseView(content3)
                panel3.setBackgroundColor(ContextCompat.getColor(ctx, R.color.gray))
                panel3Title.setTextColor(ContextCompat.getColor(ctx, R.color.black2))
                panel3Icon.setImageResource(R.drawable.logo_plus)
                isPanel3Expanded = false
            } else {
                collapseView(content1)
                collapseView(content2)
                expandView(content3)

                panel3.setBackgroundColor(ContextCompat.getColor(ctx, R.color.green))
                panel1.setBackgroundColor(ContextCompat.getColor(ctx, R.color.gray))
                panel2.setBackgroundColor(ContextCompat.getColor(ctx, R.color.gray))

                panel1Icon.setImageResource(R.drawable.logo_plus)
                panel2Icon.setImageResource(R.drawable.logo_plus)
                panel3Icon.setImageResource(R.drawable.logo_min)

                panel1Title.setTextColor(ContextCompat.getColor(ctx, R.color.black2))
                panel2Title.setTextColor(ContextCompat.getColor(ctx, R.color.black2))
                panel3Title.setTextColor(ContextCompat.getColor(ctx, android.R.color.white))

                isPanel3Expanded = true
                isPanel1Expanded = false
                isPanel2Expanded = false
            }
        }
    }
}
