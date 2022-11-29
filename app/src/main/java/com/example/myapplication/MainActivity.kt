package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.MainActivity2

class MainActivity : AppCompatActivity() {
    private lateinit var letsplaybtn : Button
    private lateinit var ratebutton : Button
    private lateinit var player1 : EditText
    private lateinit var player2 : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        letsplaybtn = findViewById<Button>(R.id.letsplaybtn)
        ratebutton = findViewById<Button>(R.id.ratebutton)
        player1 = findViewById<EditText>(R.id.player1)
        player2 = findViewById<EditText>(R.id.player2)

        letsplaybtn.setOnClickListener {
            val playern1 = player1.text.toString()
            val playern2 = player2.text.toString()
            val intent = Intent(this,MainActivity2::class.java)
            intent.putExtra("NAME1",playern1)
            intent.putExtra("NAME2",playern2)
            startActivity(intent)
        }
        ratebutton.setOnClickListener {
            val playern1 = player1.text.toString()
            val playern2 = player2.text.toString()
            val intent = Intent(this,MainActivity3::class.java)
            intent.putExtra("NAME1",playern1)
            intent.putExtra("NAME2",playern2)
            startActivity(intent)
        }
}
    }