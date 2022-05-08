package com.example.saida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class splash_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation)
        val middleAnimation = AnimationUtils.loadAnimation(this,R.anim.middle_animation)
        val bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation)

        val topTextView:TextView = findViewById(R.id.TopTextView)
        topTextView.startAnimation(topAnimation)
        val middleTextView:TextView = findViewById(R.id.MiddleTextView)
        middleTextView.startAnimation(middleAnimation)
        val bottomImageView:ImageView = findViewById(R.id.BottomTextView)
        bottomImageView.startAnimation(bottomAnimation)

        val splashScreenTimeOut = 3000
        val homeIntent = Intent(this@splash_screen, login::class.java)

        Handler().postDelayed({
            startActivity(homeIntent)
            finish()
        }, splashScreenTimeOut.toLong())
    }
}