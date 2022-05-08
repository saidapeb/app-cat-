package com.example.saida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.saida.model.Users
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import org.w3c.dom.Text

class profile : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var firebaseUser: FirebaseUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        auth = FirebaseAuth.getInstance()
        firebaseUser = FirebaseAuth.getInstance().currentUser!!
        userInfo()
        val txt = this.findViewById<TextView>(R.id.editprofile)
        txt.setOnClickListener {
            startActivity(Intent(this, edit_profile::class.java))
        }
        val buttonback = this.findViewById<ImageView>(R.id.back)
        buttonback.setOnClickListener {
            startActivity(Intent(this, opsi_profile::class.java))
        }
        val edit = this.findViewById<TextView>(R.id.editprofile)
        edit.setOnClickListener {
            startActivity(Intent(this, edit_profile::class.java))
        }
//        val buttonout = findViewById<Button>(R.id.btn_logout)
//        buttonout.setOnClickListener {
//            auth.signOut()
//            Toast.makeText(this, "Succesfully log out.", Toast.LENGTH_LONG).show()
//            val intent = Intent(this@profile, com.example.saida.MainActivity::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
//            startActivity(intent)
//        }
    }
    private fun userInfo(){
        val userRef = FirebaseDatabase.getInstance().getReference().child("USERS").child(firebaseUser.uid)
        userRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    val user = snapshot.getValue<Users>(Users::class.java)
                    val changeusername = findViewById<EditText>(R.id.fn)
                    val changeemail = findViewById<EditText>(R.id.email)
                    val textView11 = findViewById<EditText>(R.id.number)
                    val textView15 = findViewById<EditText>(R.id.ttl)

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