package com.example.baitaplab3
//Làm bài tập 4
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var btnEdit: Button

    private val editProfileLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val updatedName = data?.getStringExtra("EXTRA_NEW_NAME")
            if (!updatedName.isNullOrEmpty()) {
                tvName.text = updatedName
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvName = findViewById(R.id.tvName)
        btnEdit = findViewById(R.id.btnEdit)

        btnEdit.setOnClickListener {
            val currentName = tvName.text.toString()

            val intent = Intent(this, EditActivity::class.java).apply {
                putExtra("EXTRA_CURRENT_NAME", if (currentName == "Chưa có thông tin") "" else currentName)
            }

            editProfileLauncher.launch(intent)
        }
    }
}