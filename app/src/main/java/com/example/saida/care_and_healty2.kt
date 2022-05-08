package com.example.saida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class care_and_healty2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_care_and_healty2)
        val button = findViewById<ImageView>(R.id.back)
        button.setOnClickListener {
            startActivity(Intent(this, care_and_healty::class.java))
        }
    }
}