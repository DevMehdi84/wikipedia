package com.example.wikipedia

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.wikipedia.databinding.ActivityTranslateBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class translateActivity : AppCompatActivity() {
    lateinit var binding: ActivityTranslateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTranslateBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        setSupportActionBar(binding.toolbartanslate)
        window.statusBarColor = ContextCompat.getColor(this, R.color.md_theme_primary)


        val glide =   Glide
            .with(this)
            .load(R.drawable.img_translatore)
            .transform(RoundedCornersTransformation(32 , 8))
            .into(binding.imgTranslate)

    }


}