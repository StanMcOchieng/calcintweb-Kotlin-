package com.example.calcintweb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var calc:Button
    lateinit var intent:Button
    lateinit var web:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calc = findViewById(R.id.calc)
        intent = findViewById(R.id.intent)
        web = findViewById(R.id.webb)

        // functionality
        calc.setOnClickListener {
            val intent = Intent(this,ActivityCalculator::class.java)
            startActivity(intent)
        }
        web.setOnClickListener {
            val intent = Intent(this,WebActivity::class.java)
            startActivity(intent)
        }
        intent.setOnClickListener {
            val intent = Intent(this,IntentActivity::class.java)
            startActivity(intent)
        }

    }
}