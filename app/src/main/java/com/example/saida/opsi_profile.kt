package com.example.saida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class opsi_profile : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var firebaseUser: FirebaseUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        firebaseUser = FirebaseAuth.getInstance().currentUser!!
        setContentView(R.layout.activity_opsi_profile)
        val button = findViewById<Button>(R.id.btnPengguna)
        button.setOnClickListener {
            startActivity(Intent(this, profile::class.java))
        }

        val button2 = findViewById<Button>(R.id.btnKucing)
        button2.setOnClickListener {
            startActivity(Intent(this, profilkucing::class.java))
        }

        val button3 = findViewById<Button>(R.id.btnGanti)
        button3.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        val button4 = findViewById<Button>(R.id.btnAbout)
        button4.setOnClickListener {
            startActivity(Intent(this, about_us::class.java))
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
        val buttonout = findViewById<Button>(R.id.logout)
        buttonout.setOnClickListener {
            auth.signOut()
            Toast.makeText(this, "Succesfully log out.", Toast.LENGTH_LONG).show()
            val intent = Intent(this@opsi_profile, com.example.saida.login::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }
}