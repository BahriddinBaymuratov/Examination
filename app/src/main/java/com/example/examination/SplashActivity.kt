package com.example.examination

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.example.examination.manager.MySharedPreferences
import com.example.examination.util.Constants.EMAIL

class SplashActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var sharedPreferences: MySharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        sharedPreferences = MySharedPreferences(this)
        val email = sharedPreferences.getData(EMAIL)
        intent(email)

        anim()

    }
    private fun intent(email: String?){
        object :CountDownTimer(2000, 1000){
            override fun onTick(p0: Long) {}

            override fun onFinish() {
                if (email == null){
                    Intent(this@SplashActivity, LoginActivity::class.java).also {
                        startActivity(it)
                        finish()
                    }
                } else {
                    Intent(this@SplashActivity,MainActivity::class.java).also {
                        startActivity(it)
                        finish()
                    }
                }
            }

        }.start()
    }





    private fun anim(){
        textView = findViewById(R.id.textSplash)
        val bounce: Animation = AnimationUtils.loadAnimation(this,R.anim.bounce)
        textView.startAnimation(bounce)
    }


}