package com.example.saida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class care_and_healty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_care_and_healty)
        val button = findViewById<Button>(R.id.cat1)
        button.setOnClickListener {
            startActivity(Intent(this, care_and_healty2::class.java))
        }

        val btn_profil= findViewById<Button>(R.id.btnProfil)
        btn_profil.setOnClickListener {
            startActivity(Intent(this, opsi_profile::class.java))

        }

        val btn_home= findViewById<Button>(R.id.btnHome)
        btn_home.setOnClickListener {
            startActivity(Intent(this, menu::class.java))

        }

        val btn_search= findViewById<Button>(R.id.btnSearch)
        btn_search.setOnClickListener {
            startActivity(Intent(this, Find::class.java))

        }
    }
}