package com.example.drawerlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDrawerLayout = findViewById<DrawerLayout>(R.id.myDrawerLayout)
        val myDrawerNavView = findViewById<NavigationView>(R.id.myDrawerNavView)

        toggle = ActionBarDrawerToggle(this, myDrawerLayout, 0, 0)
        myDrawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        myDrawerNavView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.sent -> {
                    //Intent
                    myDrawerLayout.closeDrawers()
                    true
                }

                else -> false
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}