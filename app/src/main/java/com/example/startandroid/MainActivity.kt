package com.example.startandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val countText: TextView = findViewById(R.id.text_view)
        val toastButton: Button = findViewById(R.id.toast_button)
        val countButton: Button = findViewById(R.id.count_button)
        val randomButton: Button = findViewById(R.id.random_button)

        toastButton.setOnClickListener {
            Toast.makeText(this, "Hello, Toast!", Toast.LENGTH_SHORT).show()
        }
        countButton.setOnClickListener {
            var count = countText.text.toString().toInt()
            count++
            countText.text = count.toString()
        }
        randomButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val count = countText.text.toString().toInt()
            intent.putExtra("totalCount", count)
            startActivity(intent)
        }


    }
}