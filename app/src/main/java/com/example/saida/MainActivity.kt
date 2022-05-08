package com.example.saida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()
        val bck = findViewById<ImageView>(R.id.back)
        bck.setOnClickListener {
            startActivity(Intent(this, menu::class.java))
        }

//        val button = findViewById<Button>(R.id.btnregist)
//        button.setOnClickListener {
//            startActivity(Intent(this, register::class.java))
//
//        }

//        val btn_masuk = findViewById<Button>(R.id.btnlogin)
//        btn_masuk.setOnClickListener {
//            startActivity(Intent(this, login::class.java))
//        }
    }

}