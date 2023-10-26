package com.example.bottomappbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.bottomappbar.adapter.PagerAdapter
import com.example.bottomappbar.transformer.DepthPageTransformer
import com.example.bottomappbar.transformer.ZoomOutPageTransformer
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
        viewPager2.setPageTransformer(DepthPageTransformer())
        viewPager2.adapter = PagerAdapter(supportFragmentManager, lifecycle)
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> bottomNavigationView.menu.findItem(R.id.call_nav).isChecked = true
                    1 -> bottomNavigationView.menu.findItem(R.id.home_nav).isChecked = true
                }
            }
        })

        bottomNavigationView.background = null
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.call_nav -> {
                    viewPager2.currentItem = 0
                    return@setOnItemSelectedListener true
                }

                R.id.home_nav -> {
                    viewPager2.currentItem = 1
                    return@setOnItemSelectedListener true
                }

                else -> false
            }
        }
    }
}