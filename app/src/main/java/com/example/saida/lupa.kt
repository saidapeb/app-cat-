package com.example.saida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class lupa : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    lateinit var ref: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lupa)
        auth = FirebaseAuth.getInstance()
        ref= FirebaseDatabase.getInstance().getReference("USERS")
        val reset2 = this.findViewById<TextView>(R.id.resetpw)
        reset2.setOnClickListener {
            startActivity(Intent(this, login::class.java))
        }

//        val button= findViewById<Button>(R.id.daftar)
//        button.setOnClickListener {
//            val fn = findViewById<EditText>(R.id.editTextTextPersonName5)
//            val email = findViewById<EditText>(R.id.editTextTextPersonName4)
//            val intansi = findViewById<EditText>(R.id.editTextTextPersonName3)
//            val team = findViewById<EditText>(R.id.editTextTextPersonName2)
//            val notelp = findViewById<EditText>(R.id.editTextTextPersonName)
//            val iot = findViewById<RadioButton>(R.id.iot)
//            val plc = findViewById<RadioButton>(R.id.plc)
//            val rmi = findViewById<RadioButton>(R.id.rmi)
//            val lomba = findViewById<TextView>(R.id.txtLomba)
//            val setuju = findViewById<CheckBox>(R.id.tvSetuju2)
//            if(fn.text.toString().isEmpty()){
//                fn.error = "Tolong masukkan fullname"
//                fn.requestFocus()
//            }
//            if(iot.isChecked()){
//                lomba.text = iot.text.toString()
//            }
//            if(plc.isChecked()){
//                lomba.text = plc.text.toString()
//            }
//            if(rmi.isChecked()){
//                lomba.text = rmi.text.toString()
//            }
//            if(intansi.text.toString().isEmpty()){
//                intansi.error = "Tolong masukkan instansi"
//                intansi.requestFocus()
//            }
//            if(email.text.toString().isEmpty()){
//                email.error = "Tolong masukkan email"
//                email.requestFocus()
//            }
//            if(notelp.text.toString().isEmpty()){
//                notelp.error = "Tolong masukkan number"
//                notelp.requestFocus()
//            }
//            if(team.text.toString().isEmpty()){
//                team.error = "Tolong masukkan team"
//                team.requestFocus()
//            }
//            if(!setuju.isChecked()){
//                setuju.error = "Centang Setuju Jika Ingin Daftar"
//                setuju.requestFocus()
//            }
//            if(setuju.isChecked()){
//                registerUser(email.text.toString(), fn.text.toString(), notelp.text.toString(), intansi.text.toString(), team.text.toString(), lomba.text.toString())
//            }
//        }
//    }
//    private fun registerUser(email: String,fn: String,notelp: String,intansi: String,team: String,lomba: String){
//        val currentUserId = auth.currentUser!!.uid
//        ref = FirebaseDatabase.getInstance().reference.child("USERS")
//        val userMap = HashMap<String,Any>()
//        userMap["id"] = currentUserId
//        userMap["fn"] = fn
//        userMap["email"] = email
//        userMap["notelp"] = notelp
//        userMap["intansi"] = intansi
//        userMap["team"] = team
//        userMap["lomba"] = lomba
//
//        ref.child(currentUserId).setValue(userMap).addOnCompleteListener{
//            if(it.isSuccessful){
//                Toast.makeText(this, "Register berhasil", Toast.LENGTH_SHORT).show()
//                val intent = Intent(this@lupa, menu::class.java)
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
//                startActivity(intent)
//            }
//            else{
//                val message = it.exception!!.toString()
//                Toast.makeText(this, "Error : $message", Toast.LENGTH_SHORT).show()
//            }
//        }


    }
}