package com.example.intent

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Ánh xạ các View trên giao diện activity_second.xml
        val tvDisplay = findViewById<TextView>(R.id.tvDisplay)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val bundle = intent.extras
        if (bundle != null) {
            val name = bundle.getString("EXTRA_NAME") ?: ""


            tvDisplay.text = "Họ tên: $name\n"
        }
        btnBack.setOnClickListener {
            finish()
        }
    }
}