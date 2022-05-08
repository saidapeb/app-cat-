package com.example.saida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class about_us : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        val button = findViewById<ImageView>(R.id.back)
        button.setOnClickListener {
            startActivity(Intent(this, menu::class.java))
        }

    }
}