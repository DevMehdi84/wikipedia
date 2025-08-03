package com.example.wikipedia

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import cn.pedant.SweetAlert.SweetAlertDialog
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
                    binding.dravermain.closeDrawer(GravityCompat.START)

                    val dialog = SweetAlertDialog(this , SweetAlertDialog.SUCCESS_TYPE)
                        dialog.titleText = "alert"
                        dialog.confirmText = "confirm"
                        dialog.cancelText = "Cancle"
                        dialog.contentText = "Wanna be a Writer?"
                        dialog.setCancelClickListener {
                        dialog.dismiss()
                    }
                        dialog.setConfirmClickListener {

                        dialog.dismiss()


                    }
                    dialog.show()
                }


                R.id.menu_Translator ->{
                    binding.dravermain.closeDrawer(GravityCompat.START)

                }
                R.id.menu_photographer ->{
                    binding.dravermain.closeDrawer(GravityCompat.START)
                }

                R.id.menu_video_maker ->{
                    binding.dravermain.closeDrawer(GravityCompat.START)
                }

                R.id.menu_wikimedia ->{
                    binding.dravermain.closeDrawer(GravityCompat.START)
                }
                R.id.openWikipedia ->{
                    binding.dravermain.closeDrawer(GravityCompat.START)
                }


            }
            true
        }

    }
}