package com.example.saida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        val button = findViewById<Button>(R.id.btn_login)
        button.setOnClickListener {
            val email = findViewById<EditText>(R.id.email)
            val password = findViewById<EditText>(R.id.pass)
            if(email.text.toString().isEmpty()){
                email.error = "Tolong masukkan email"
                email.requestFocus()
            }
            if(password.text.toString().isEmpty() || password.text.toString().length < 6){
                password.error = "Tolong masukkan password"
                password.requestFocus()
            }

            loginUser(email.text.toString(), password.text.toString())
        }

        val txt = this.findViewById<TextView>(R.id.txtregister)
        txt.setOnClickListener {
            startActivity(Intent(this, register::class.java))
        }
        val txt2 = this.findViewById<TextView>(R.id.txtforgot)
        txt2.setOnClickListener {
            startActivity(Intent(this, lupaemail::class.java))
        }

    }
    private fun loginUser(email: String, password: String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){ login->
                if (login.isSuccessful){
                    Toast.makeText(this, "Successfully logged in", Toast.LENGTH_LONG).show()
                    val intent = Intent(this@login, com.example.saida.menu::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, login.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
    }
    override fun onStart() {
        super.onStart()
        if (auth.currentUser !=null){
            startActivity(Intent(this, menu::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            })
        }
    }
}