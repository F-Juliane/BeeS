package com.example.bees.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.bees.R
import com.example.bees.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.imageAdd.setOnClickListener(this)
        binding.imageSearch.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.image_add){
            startActivity(Intent(this, AddProductActivity::class.java))
        } else if (view.id == R.id.image_search){
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}