package com.example.wikipedia

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.wikipedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarmain)
        window.statusBarColor = ContextCompat.getColor(this, R.color.md_theme_primary)

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.dravermain,
            binding.toolbarmain,
            R.string.open_Drawer,
            R.string.close_Drawer
        )
        binding.dravermain.addDrawerListener( actionBarDrawerToggle )
        actionBarDrawerToggle.syncState()

        binding.navmain.setNavigationItemSelectedListener {
            when(it.itemId){

                R.id.menu_writer ->{

                }

                R.id.menu_Translator ->{


                }
                R.id.menu_photographer ->{

                }

                R.id.menu_video_maker ->{

                }

                R.id.menu_wikimedia ->{

                }
                R.id.openWikipedia ->{

                }


            }
            true
        }

    }
}