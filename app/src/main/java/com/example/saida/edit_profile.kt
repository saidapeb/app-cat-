package com.example.saida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.saida.model.Users
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*

class edit_profile : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var firebaseUser: FirebaseUser
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        auth = FirebaseAuth.getInstance()
        firebaseUser = FirebaseAuth.getInstance().currentUser!!
        userInfo()

        val button = findViewById<Button>(R.id.btn_save)
        button.setOnClickListener {
            val username = findViewById<EditText>(R.id.textviewnama2)
            val email = findViewById<EditText>(R.id.textviewemail2)
            val notelp = findViewById<EditText>(R.id.textviewmobile2)
            val ttl = findViewById<EditText>(R.id.editTextTextPassword)
            val fn = username.text.toString()
            val changeemail = email.text.toString()
            val textView11 = notelp.text.toString()
            val textView15 = ttl.text.toString()
            updateData(fn,changeemail,textView11,textView15)

        }
        val buttoncancle = findViewById<Button>(R.id.btn_cancel)
        buttoncancle.setOnClickListener {
            startActivity(Intent(this, profile::class.java))

        }
    }

    private fun updateData(fn: String, changeemail: String, textView11: String, textView15: String) {

        database = FirebaseDatabase.getInstance().getReference("USERS")
        val user = mapOf<String,String>(
            "fn" to fn,
            "email" to changeemail,
            "number" to textView11,
            "ttl" to textView15
        )
        database.child(firebaseUser.uid).updateChildren(user).addOnSuccessListener {
            Toast.makeText(this@edit_profile, "Saved changes.", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, menu::class.java))
        }.addOnFailureListener {
            Toast.makeText(this@edit_profile, "Gagal.", Toast.LENGTH_LONG).show()
        }
    }

    private fun userInfo() {
        val userRef =
            FirebaseDatabase.getInstance().getReference().child("USERS").child(firebaseUser.uid)
        userRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val user = snapshot.getValue<Users>(Users::class.java)
                    val changeusername = findViewById<EditText>(R.id.textviewnama2)
                    val changeemail = findViewById<EditText>(R.id.textviewemail2)
                    val textView11 = findViewById<EditText>(R.id.textviewmobile2)
                    val textView15 = findViewById<EditText>(R.id.editTextTextPassword)

                    changeusername.setText(user!!.fn)
                    changeemail.setText(firebaseUser.email)
                    textView11.setText(user!!.number)
                    textView15.setText(user!!.ttl)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}