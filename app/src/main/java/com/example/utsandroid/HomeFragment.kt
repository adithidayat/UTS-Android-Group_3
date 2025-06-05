package com.example.utsandroid

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {
    private lateinit var scrollView: ScrollView
    private lateinit var row1: LinearLayout
    private lateinit var row2: LinearLayout
    private lateinit var row3: LinearLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        scrollView = view.findViewById(R.id.scrollView) // Pastikan ScrollView ada id scrollView
        row1 = view.findViewById(R.id.row1)
        row2 = view.findViewById(R.id.row2)
        row3 = view.findViewById(R.id.row3)

        scrollView.viewTreeObserver.addOnScrollChangedListener {
            checkAndAnimate(row1, 0)
            checkAndAnimate(row2, 300)
            checkAndAnimate(row3, 600)
        }

        return view
    }
    override fun onResume() {
        super.onResume()
        row1.visibility = View.INVISIBLE
        row2.visibility = View.INVISIBLE
        row3.visibility = View.INVISIBLE
    }

    private fun checkAndAnimate(view: View, delay: Long) {
        if (view.visibility == View.VISIBLE) return

        val scrollBounds = Rect()
        scrollView.getHitRect(scrollBounds)
        if (view.getLocalVisibleRect(scrollBounds)) {
            val fadeIn = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)
            fadeIn.startOffset = delay  // kasih delay langsung di kode
            view.startAnimation(fadeIn)
            view.visibility = View.VISIBLE
        }
    }


}