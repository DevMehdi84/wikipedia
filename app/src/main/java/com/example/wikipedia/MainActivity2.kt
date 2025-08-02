package com.example.wikipedia

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wikipedia.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        setSupportActionBar(binding.toolabarmain2)
        window.statusBarColor = ContextCompat.getColor(this, R.color.md_theme_primary)

        binding.collpsingMain.setExpandedTitleColor(
            ContextCompat.getColor(this , android.R.color.transparent)
        )
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        //set a color back botton
        binding.toolabarmain2.navigationIcon?.setTint(ContextCompat.getColor(this, R.color.md_theme_surfaceContainerLow))


    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home){
            onBackPressed()
        }

      return true
    }
}