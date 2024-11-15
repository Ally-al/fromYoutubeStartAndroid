package com.example.startandroid

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random
import kotlin.random.nextInt

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        showRandomNumber()
    }

    private fun showRandomNumber() {
        val heading: TextView = findViewById(R.id.text_view_label)
        val randomNum: TextView = findViewById(R.id.text_view_random)

        val count = intent.getIntExtra("totalCount", 0)
        val random = Random.nextInt(0..count)
        randomNum.text = random.toString()
        heading.text = getString(R.string.random_heading, count)
    }
}
