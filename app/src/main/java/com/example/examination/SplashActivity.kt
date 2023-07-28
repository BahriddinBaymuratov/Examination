package com.example.examination

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import com.example.examination.manager.MySharedPreferences
import com.example.examination.util.Constants.EMAIL
import com.example.examination.util.Constants.PASS

class SplashActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var sharedPreferences: MySharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

        sharedPreferences = MySharedPreferences(this)
        val email = sharedPreferences.getData(EMAIL)
        val pass = sharedPreferences.getData(PASS)
        intent(email, pass)

        anim()
    }

    private fun intent(email: String?, pass: String?) {
        object : CountDownTimer(2000, 1000) {
            override fun onTick(p0: Long) {
                Toast.makeText(this@SplashActivity, "$email $pass", Toast.LENGTH_SHORT).show()
            }

            override fun onFinish() {
                if (email == null && pass == null) {
                    Intent(this@SplashActivity, LoginActivity::class.java).also {
                        startActivity(it)
                        finish()
                    }
                } else {
                    Intent(this@SplashActivity, MainActivity::class.java).also {
                        startActivity(it)
                        finish()
                    }
                }
            }
        }.start()
    }


    private fun anim() {
        textView = findViewById(R.id.textSplash)
        val bounce: Animation = AnimationUtils.loadAnimation(this, R.anim.bounce)
        textView.startAnimation(bounce)
    }
}