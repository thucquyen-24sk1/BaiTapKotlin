package com.example.employeeinfor_2415141122115
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val empId = intent.getStringExtra("EXTRA_EMPLOYEE_ID") ?: "Chưa có"
        val empName = intent.getStringExtra("EXTRA_EMPLOYEE_NAME") ?: ""
        val empSalary = intent.getDoubleExtra("EXTRA_EMPLOYEE_SALARY", 0.0)
        val isActive = intent.getBooleanExtra("EXTRA_IS_ACTIVE", false)

    }
}