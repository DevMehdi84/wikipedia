package com.example.wikipedia

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.wikipedia.databinding.ActivityMainBinding
import com.example.wikipedia.fragment.Fragment_Explore
import com.example.wikipedia.fragment.Fragment_Profile
import com.example.wikipedia.fragment.Fragment_Trend

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


        firtRun()

        binding.bottomNavmain.setOnItemSelectedListener {

            when(it.itemId){
                R.id.menu_Explore ->{

                    replaceFragment(Fragment_Explore())

                }
                R.id.menu_Trend ->{

                    replaceFragment(Fragment_Trend())

                }
                R.id.menu_Profile ->{

                    replaceFragment(Fragment_Profile())

                }


            }
            true
        }

    }

    fun replaceFragment(fragment: Fragment){

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace( R.id.frame_main_container , fragment)
        transaction.commit()

    }

    fun firtRun(){

        //set on explore and firstRun
        replaceFragment(Fragment_Explore())
        binding.bottomNavmain.selectedItemId = R.id.menu_Explore

    }

}