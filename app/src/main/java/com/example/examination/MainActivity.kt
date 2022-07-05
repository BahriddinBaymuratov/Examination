package com.example.examination

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examination.databinding.ActivityMainBinding
import com.example.examination.manager.MySharedPreferences
import com.example.examination.util.Constants

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mySharedPreferences: MySharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mySharedPreferences = MySharedPreferences(this)

        val email = mySharedPreferences.getData(Constants.EMAIL)
        val pass = mySharedPreferences.getData(Constants.PASS)

        binding.textView.text = email
        binding.textView2.text = pass


        binding.btnOut.setOnClickListener {
            mySharedPreferences.clear()
            finish()
        }
    }
}