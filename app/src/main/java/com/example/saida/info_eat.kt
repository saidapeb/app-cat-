package com.example.saida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class info_eat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_eat)
        val button = findViewById<ImageView>(R.id.back)
        button.setOnClickListener {
            startActivity(Intent(this, menu::class.java))
        }
    }
}