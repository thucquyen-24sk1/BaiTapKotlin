package com.example.lec3_miniproj

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.lec3_miniproj.databinding.ActivityMainBinding
import com.example.lec3_miniproj.Model.Student
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var student = Student("2415141122115", "Nguyễn Thị Thục Quyên", "24SK1", "quyen@ute.udn.vn", 3.8)

    // 1. Launcher chỉnh sửa hồ sơ
    private val editLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { res ->
        if (res.resultCode == Activity.RESULT_OK) {
            val updated = res.data?.getSerializableExtra("UPDATED") as? Student
            updated?.let {
                student = it
                bindData(student)
                Toast.makeText(this, "Đã lưu thông tin mới thành công!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // 2. Launcher chọn ảnh Gallery
    private val galleryLauncher: ActivityResultLauncher<String> = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            binding.imgAvatar.setImageURI(it)
            Toast.makeText(this, "Đã đổi avatar thành công!", Toast.LENGTH_SHORT).show()
        }
    }

    private val cameraLauncher: ActivityResultLauncher<String> = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            Toast.makeText(this, "Đã cấp quyền Camera thành công!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Bạn đã từ chối quyền Camera!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindData(student)

        // Sự kiện nút Chỉnh sửa hồ sơ (Explicit Intent + Result API)
        binding.btnEditProfile.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java).apply {
                putExtra("STUDENT", student)
            }
            editLauncher.launch(intent)
        }

        // Sự kiện đổi Avatar (GetContent Contract)
        binding.btnChangeAvatar.setOnClickListener {
            galleryLauncher.launch("image/*")
        }

        // Sự kiện gọi điện thoại (Implicit Intent ACTION_DIAL)
        binding.btnCallHotline.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:0905123456")
            }
            startActivity(dialIntent)
        }

        // Sự kiện xin quyền Camera (RequestPermission Contract)
        binding.btnRequestCamera.setOnClickListener {
            cameraLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    private fun bindData(s: Student) {
        binding.tvName.text = s.name
        binding.tvDetails.text = "MSSV: ${s.id} - Lớp: ${s.className}"
        binding.tvGpaBadge.text = "GPA: ${s.gpa}"
    }
}