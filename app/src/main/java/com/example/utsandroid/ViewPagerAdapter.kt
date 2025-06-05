package com.example.utsandroid

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    private val fragments = listOf(
        HomeFragment(),
        DosenFragment(),
        kompetensiFragment(),
        FasilitasFragment()
    )
    override fun getItemCount() = fragments.size
    override fun createFragment(position: Int) = fragments[position]
}
