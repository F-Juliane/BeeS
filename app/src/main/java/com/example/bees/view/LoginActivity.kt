package com.example.bees.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.bees.R
import com.example.bees.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.buttonLogin.setOnClickListener(this)
        binding.buttonRegister.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_login){
            startActivity(Intent(this, MainActivity::class.java))
        } else if (view.id == R.id.button_register){
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}