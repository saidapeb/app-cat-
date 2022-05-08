package com.example.saida

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class register : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    lateinit var ref: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = FirebaseAuth.getInstance()
        ref= FirebaseDatabase.getInstance().getReference("USERS")
        val button = findViewById<Button>(R.id.register)
        button.setOnClickListener {
            val fn = findViewById<EditText>(R.id.username_input)
            val email = findViewById<EditText>(R.id.email)
            val number = findViewById<EditText>(R.id.number)
            val ttl = findViewById<TextView>(R.id.ttl)
            val password = findViewById<EditText>(R.id.password)
            val spassword = findViewById<EditText>(R.id.spassword)
            if(fn.text.toString().isEmpty()){
                fn.error = "Tolong masukkan fullname"
                fn.requestFocus()
            }
            if(email.text.toString().isEmpty()){
                email.error = "Tolong masukkan email"
                email.requestFocus()
            }
            if(number.text.toString().isEmpty()){
                number.error = "Tolong masukkan number"
                number.requestFocus()
            }
            if(password.text.toString().isEmpty()){
                password.error = "Tolong masukkan password"
                password.requestFocus()
            }
            if(spassword.text.toString().isEmpty()){
                spassword.error = "Tolong masukkan konfirmasi password"
                spassword.requestFocus()
            }
            if(fn.text.toString().isNotEmpty() && email.text.toString().isNotEmpty() && number.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()){
                registerUser( fn.text.toString(),email.text.toString(), number.text.toString(),ttl.text.toString(),password.text.toString())
            }
        }
        val txt = this.findViewById<TextView>(R.id.txtlogin)
        txt.setOnClickListener {
            startActivity(Intent(this, login::class.java))
        }
    }
    private fun registerUser(fn: String,email: String, number: String, ttl: String, password: String){
        val progressDialog = ProgressDialog(this@register)
        progressDialog.setTitle("Register User")
        progressDialog.setMessage("Please Wait")
        progressDialog.setCanceledOnTouchOutside(false)
        progressDialog.show()
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    saveUser(fn,email,number,ttl,password,progressDialog)
                }
                else{
                    val message = it.exception!!.toString()
                    Toast.makeText(this, "Error : $message", Toast.LENGTH_SHORT).show()
                    progressDialog.dismiss()
                }
            }
    }

    private fun saveUser(fn: String,email: String,number: String,ttl: String,password: String,progressDialog: ProgressDialog){
        val currentUserId = auth.currentUser!!.uid
        ref = FirebaseDatabase.getInstance().reference.child("USERS")
        val userMap = HashMap<String,Any>()
        userMap["id"] = currentUserId
        userMap["fn"] = fn
        userMap["email"] = email
        userMap["number"] = number
        userMap["ttl"] = ttl
        userMap["password"] = password

        ref.child(currentUserId).setValue(userMap).addOnCompleteListener{
            if(it.isSuccessful){
                progressDialog.dismiss()
                Toast.makeText(this, "Register berhasil", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@register, login::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
            else{
                val message = it.exception!!.toString()
                Toast.makeText(this, "Error : $message", Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()
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