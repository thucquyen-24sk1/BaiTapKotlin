package com.example.intent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGoToSecond = findViewById<Button>(R.id.btnGoToSecond)

        btnGoToSecond.setOnClickListener {
            // 1. Tạo một Bundle để chứa dữ liệu
            val bundle = Bundle().apply {
                putString("EXTRA_NAME", "Nguyễn Thị Thục Quyên")
            }
            // 2. Khởi tạo Explicit Intent sang SecondActivity
            val intent = Intent(this, SecondActivity::class.java).apply {
                // Đưa Bundle vào Intent qua putExtras
                putExtras(bundle)
            }

            // 3. Chuyển màn hình
            startActivity(intent)
        }
    }
}