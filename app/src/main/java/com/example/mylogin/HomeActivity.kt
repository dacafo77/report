package com.example.mylogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val randomimg = findViewById<ImageView>(R.id.logo)
        when(Random.nextInt(1, 4)){
            1 -> randomimg.setImageResource(R.drawable.logo)
            2 -> randomimg.setImageResource(R.drawable.welcome)
            3 -> randomimg.setImageResource(R.drawable.logo2)
        }




        val signinId = intent.getStringExtra("아이디:")

        val textView = findViewById<TextView>(R.id.tv_id)
        textView.text = "아이디 : $signinId"

        val btnClose = findViewById<Button>(R.id.btn_close)

        btnClose.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}