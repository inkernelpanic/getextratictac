package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var play1:TextView
        lateinit var play2:TextView
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val playerr1 = intent.extras?.getString("NAME1")
        val playerr2 = intent.extras?.getString("NAME2")
        play1 = findViewById(R.id.textviewpg3_1)
        play2 = findViewById(R.id.textviewpage3_2)

        play1.text = playerr1
        play2.text = playerr2
        if (play1.text.isEmpty()){
            play1.text="Motamashe 1"
        }
        if(play2.text.isEmpty()){
            play2.text = "Motamashe 2"
        }
        findViewById<Button>(R.id.button14).setOnClickListener{
            startActivity(Intent(this, MainActivity2::class.java))
        }
        findViewById<Button>(R.id.button12).setOnClickListener{
            Toast.makeText(this, "მადლობა!", Toast.LENGTH_SHORT).show()
        }
    }
}