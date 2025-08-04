package com.example.wikipedia

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.wikipedia.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

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

                    //Open an activity
                    val intent = Intent( this, translateActivity::class.java)
                    startActivity(intent)

                }
                R.id.menu_photographer ->{

                    //load fragment
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.add(R.id.Frame_main_container , Fragment_Photographer())
                    transaction.addToBackStack(null)
                    transaction.commit()

                    //close drawer
                    binding.dravermain.closeDrawer(GravityCompat.START)


                }

                R.id.menu_video_maker ->{
                    binding.dravermain.closeDrawer(GravityCompat.START)

                    val snackbar = Snackbar
                        .make( binding.root ,"No Internet!" , Snackbar.LENGTH_INDEFINITE)
                        .setAction("Retry"){
                            Toast.makeText(this, "checking network", Toast.LENGTH_SHORT).show()
                        }
                        .setActionTextColor( ContextCompat.getColor(this , R.color.md_theme_surface) )
                        .setBackgroundTint(ContextCompat.getColor(this , R.color.md_theme_primary))
                        .show()
                }

                R.id.menu_wikimedia ->{
                    binding.dravermain.closeDrawer(GravityCompat.START)

                    openWebsite("https://www.wikimedia.org/")
                }
                R.id.openWikipedia ->{
                    binding.dravermain.closeDrawer(GravityCompat.START)
                   openWebsite("https://en.wikipedia.org/wiki/Main_Page")
                }


            }
            true
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        //check menu item off
        binding.navmain.menu.getItem(1).isChecked = false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {


        menuInflater.inflate(R.menu.menu_main , menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

       when(item.itemId){
           R.id.menu_exit ->{
               onBackPressed()
           }
       }

        return true
    }

    fun openWebsite(url : String){

        val intent = Intent(Intent.ACTION_VIEW , Uri.parse(url))
        startActivity(intent)

    }
}