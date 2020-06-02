package com.roof.roofs

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.roof.roofs.ui.addRoof.AddRoof
import com.roof.roofs.ui.roofList.RoofList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pageAdapter = ScreenSliderPageAdapter(this)
        viewPager.adapter = pageAdapter

        TabLayoutMediator(tab_layout, viewPager) {
            tab, position ->
            tab.text = when(position) {
                0 -> getString(R.string.add_roof)
                1 -> getString(R.string.list_foof)
                else -> getString(R.string.list_foof)
            }
        }.attach()
    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    private inner class ScreenSliderPageAdapter(fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {

        override fun getItemCount() = 2

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> AddRoof.newInstance()
                1 -> RoofList.newInstance()
                else -> RoofList.newInstance()
            }
        }
    }
}