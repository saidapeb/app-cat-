package com.example.saida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class lupaemail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lupaemail)
        val btn_login = this.findViewById<TextView>(R.id.txtlogin)
        btn_login.setOnClickListener {
            startActivity(Intent(this, login::class.java))
        }
        val reset = this.findViewById<Button>(R.id.reset)
        reset.setOnClickListener {
            startActivity(Intent(this, lupa::class.java))
        }
    }
}