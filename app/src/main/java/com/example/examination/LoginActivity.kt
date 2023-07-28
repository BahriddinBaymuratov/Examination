package com.example.examination

import android.content.Intent
import android.content.Intent.*
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.Toast
import com.example.examination.databinding.ActivityLoginBinding
import com.example.examination.manager.MySharedPreferences

class LoginActivity : AppCompatActivity() {
    private lateinit var mySharedPreferences: MySharedPreferences
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mySharedPreferences = MySharedPreferences(this)

        binding.btnSingIn.setOnClickListener {
            val email = binding.editEmail.text.toString().trim()
            val pass = binding.editPass.text.toString().trim()

            mySharedPreferences.saveData(email, pass)
            if (email.isNotBlank() && pass.isNotBlank()) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
                Toast.makeText(this, "SuccessFully", Toast.LENGTH_SHORT).show()
            }
        }

        binding.textSignIn.setOnClickListener {
            startActivity(Intent(this, CreateActivity::class.java))
        }
        binding.btnSms.setOnClickListener {
            val intent = Intent(ACTION_VIEW, Uri.parse("sms:"))
            startActivity(intent)
        }
        binding.btnPhone.setOnClickListener {
            val intent = Intent(ACTION_DIAL, Uri.parse("tel:"))
            startActivity(intent)
        }
        binding.btnGoogle.setOnClickListener {
            val intent = Intent(ACTION_VIEW, Uri.parse("https://google.com/"))
            startActivity(intent)
        }
    }
}
