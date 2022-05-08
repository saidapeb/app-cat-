package com.example.saida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class profilkucing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profilkucing)
        val buttonback = this.findViewById<ImageView>(R.id.back)
        buttonback.setOnClickListener {
            startActivity(Intent(this, opsi_profile::class.java))
        }
    }
}