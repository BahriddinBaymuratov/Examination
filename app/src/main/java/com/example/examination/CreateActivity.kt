package com.example.examination

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.examination.databinding.ActivityCreateBinding
import com.example.examination.manager.MySharedPreferences

class CreateActivity : AppCompatActivity() {
    private val binding by lazy { ActivityCreateBinding.inflate(layoutInflater) }
    private lateinit var sharedPref: MySharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        sharedPref = MySharedPreferences(this)
        saveData()
    }

    private fun saveData() {
        binding.btnSingIn.setOnClickListener {
            val email = binding.editEmail.text.toString().trim()
            val pass = binding.editPass.text.toString().trim()
            val conPass = binding.conPass.text.toString().trim()

            if (email.isNotBlank() && pass.isNotBlank() && pass == conPass) {
                sharedPref.saveData(email, pass)
                Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Enter data !!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}