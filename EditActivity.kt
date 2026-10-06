package com.example.baitaplab3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val etName = findViewById<EditText>(R.id.etName)
        val btnSave = findViewById<Button>(R.id.btnSave)

        val currentName = intent.getStringExtra("EXTRA_CURRENT_NAME")
        if (!currentName.isNullOrEmpty()) {
            etName.setText(currentName)
        }

        btnSave.setOnClickListener {
            val newName = etName.text.toString().trim()

            val resultIntent = Intent().apply {
                putExtra("EXTRA_NEW_NAME", newName)
            }
            setResult(Activity.RESULT_OK, resultIntent)

            finish()
        }
    }
}