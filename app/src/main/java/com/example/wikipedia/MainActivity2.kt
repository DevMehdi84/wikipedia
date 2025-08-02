package com.example.wikipedia

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.ActivityMain2Binding
import com.example.wikipedia.fragment.SEND_DATA_TO_ACTIVITY

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

        val dataPost = intent.getParcelableExtra<ItemPost>(SEND_DATA_TO_ACTIVITY)
        if (dataPost != null){
            
            showData(dataPost)
            
        }

    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home){
            onBackPressed()
        }

      return true
    }


    private fun showData(itemPost: ItemPost) {

        val glide = Glide
            .with(this)
            .load(itemPost.imgUrl)
            .load(binding.imgMain2)

        binding.txtMain2Title.text = itemPost.txtTitle
        binding.txtMain2Subtitle.text = itemPost.txtSubtitle
        binding.txtMain2Text.text = itemPost.txtDetail


    }

}