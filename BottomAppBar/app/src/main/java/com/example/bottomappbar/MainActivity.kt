package com.example.bottomappbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.ActionMenuView

import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomAppBar = findViewById<BottomAppBar>(R.id.bottomAppBar)
        bottomAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    Snackbar.make(bottomAppBar, "Home item clicked", Snackbar.LENGTH_LONG).show()
                    true
                }

                else -> false
            }
        }

        val additionalMenu = findViewById<ActionMenuView>(R.id.additionalMenu)
        menuInflater.inflate(R.menu.bottom_nav_menu_left, additionalMenu.menu)
        additionalMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.exit -> {
                    Snackbar.make(additionalMenu, "Exit item clicked", Snackbar.LENGTH_LONG).show()
                    true
                }

                else -> false
            }
        }
    }
}