package com.example.mylogin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signin)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnLogin = findViewById<Button>(R.id.btn_login)
        val btnSign = findViewById<Button>(R.id.btn_sign)
        val etId = findViewById<EditText>(R.id.et_id)
        val etPw = findViewById<EditText>(R.id.et_pw)

        val upid = intent.getStringExtra("upid")
        etId.setText(upid)
        val uppw = intent.getStringExtra("uppw")
        etPw.setText(uppw)

        btnLogin.setOnClickListener {

            val Emptyid = etId.text.toString().isEmpty()
            val EmptyPw = etPw.text.toString().isEmpty()

            if (EmptyPw || Emptyid) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()

            } else {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                intent.putExtra("아이디:", etId.text.toString())
                startActivity(intent)
            }
        }
        btnSign.setOnClickListener {
            val intent = Intent(this, SingUpActivity::class.java)
            startActivity(intent)

        }
    }
}