package com.example.employeeinfor_2415141122115

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tìm đúng id của button trong activity_main.xml
        val btnGoToEdit = findViewById<Button>(R.id.btnGoToSecond)

        btnGoToEdit.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("EXTRA_EMPLOYEE_ID", "NV2415115")
                putExtra("EXTRA_EMPLOYEE_NAME", "Nguyễn Thị Thục Quyên")
                putExtra("EXTRA_EMPLOYEE_SALARY", 15500000.0)
                putExtra("EXTRA_IS_ACTIVE", true)
            }
            startActivity(intent)
        }
    }
}