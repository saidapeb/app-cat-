package com.example.saida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val button = findViewById<Button>(R.id.btn_care)
        button.setOnClickListener {
            startActivity(Intent(this, care_and_healty::class.java))
            finish()

            setContentView(R.layout.activity_menu)
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

        val btn_eat= findViewById<Button>(R.id.btn_eat)
        btn_eat.setOnClickListener {
            startActivity(Intent(this, info_eat::class.java))
        }

        val faqbt= findViewById<ImageView>(R.id.faq)
        faqbt.setOnClickListener {
            startActivity(Intent(this, Faq::class.java))
        }

    }
}