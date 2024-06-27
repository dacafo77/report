package com.example.mylogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SingUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sing_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnSingup = findViewById<Button>(R.id.btn_signup)
        val etName = findViewById<EditText>(R.id.et_name)
        val etId = findViewById<EditText>(R.id.et_id)
        val etPw = findViewById<EditText>(R.id.et_pw)


        btnSingup.setOnClickListener {

            val EmptyId = etName.text.toString().isEmpty()
            val EmptyPw = etPw.text.toString().isEmpty()
            val EmptyName = etId.text.toString().isEmpty()

            if (EmptyPw || EmptyId || EmptyName) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("upid",etId.text.toString())
                intent.putExtra("uppw",etPw.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}