package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    private lateinit var button1:Button
    private lateinit var button2:Button
    private lateinit var button3:Button
    private lateinit var button4:Button
    private lateinit var button5:Button
    private lateinit var button6:Button
    private lateinit var button7:Button
    private lateinit var button8:Button
    private lateinit var button9:Button
    private lateinit var backbut:Button
    private lateinit var resbutton:Button
    private lateinit var complres:Button
    private lateinit var scoree1:TextView
    private lateinit var scoree2:TextView
    private lateinit var play1:TextView
    private lateinit var play2:TextView

    private var activePlayer = 1
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()
    private var firstplayerScore = ArrayList<Int>()
    private var secondplayerScore = ArrayList<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val playerr1 = intent.extras?.getString("NAME1")
        val playerr2 = intent.extras?.getString("NAME2")
        play1 = findViewById(R.id.textView2)
        play2 = findViewById(R.id.textView5)

        play1.text = playerr1
        play2.text = playerr2
        if (play1.text.isEmpty()) {
            play1.text = "Motamashe 1"
        }
        if (play2.text.isEmpty()) {
            play2.text = "Motamashe 2"
        }


        init()
    }
    private fun init(){



        button1=findViewById(R.id.button)
        button2=findViewById(R.id.button2)
        button3=findViewById(R.id.button3)
        button4=findViewById(R.id.button4)
        button5=findViewById(R.id.button5)
        button6=findViewById(R.id.button6)
        button7=findViewById(R.id.button7)
        button8=findViewById(R.id.button8)
        button9=findViewById(R.id.button9)
        backbut=findViewById(R.id.button11)
        resbutton=findViewById(R.id.buttonReset)
        complres=findViewById(R.id.complreset)
        scoree1=findViewById(R.id.textView3)
        scoree2=findViewById(R.id.textView4)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        resbutton.setOnClickListener(this)
        complres.setOnClickListener(this)
        backbut.setOnClickListener(this)
    }
    override fun onClick(clickedView: View){
        if(clickedView is Button){
            var buttonNumber = 0
            when(clickedView.id){
                R.id.button -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
                R.id.buttonReset -> buttonNumber = 0
                R.id.complreset -> buttonNumber = -1
                R.id.button11 -> buttonNumber = -2
            }
            if (buttonNumber > 0){
                playGame(clickedView, buttonNumber)
            }else if(buttonNumber == 0){
                button1.text=""
                button2.text=""
                button3.text=""
                button4.text=""
                button5.text=""
                button6.text=""
                button7.text=""
                button8.text=""
                button9.text=""
                button1.isEnabled=true
                button2.isEnabled=true
                button3.isEnabled=true
                button4.isEnabled=true
                button5.isEnabled=true
                button6.isEnabled=true
                button7.isEnabled=true
                button8.isEnabled=true
                button9.isEnabled=true
                firstPlayer.clear()
                secondPlayer.clear()
                activePlayer = 1
            }
            if(buttonNumber == -1){
                button1.text=""
                button2.text=""
                button3.text=""
                button4.text=""
                button5.text=""
                button6.text=""
                button7.text=""
                button8.text=""
                button9.text=""
                button1.isEnabled=true
                button2.isEnabled=true
                button3.isEnabled=true
                button4.isEnabled=true
                button5.isEnabled=true
                button6.isEnabled=true
                button7.isEnabled=true
                button8.isEnabled=true
                button9.isEnabled=true
                firstPlayer.clear()
                secondPlayer.clear()
                activePlayer = 1
                firstplayerScore.clear()
                secondplayerScore.clear()
                scoree1.text = "0"
                scoree2.text = "0"
            }
            if (buttonNumber == -2){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
    private fun playGame(clickedView: Button, buttonNumber: Int){
        if(activePlayer == 1){
            activePlayer = 2
            clickedView.text = "X"
            firstPlayer.add(buttonNumber)
        }else if(activePlayer == 2){
            activePlayer = 1
            clickedView.text = "O"
            secondPlayer.add(buttonNumber)
        }
        clickedView.isEnabled=false
        check()
    }
    private fun check(){
        firstplayerScore.add(0)
        secondplayerScore.add(0)
        var finalscore1 = firstplayerScore
        var finalscore2 = secondplayerScore
        var winnerPlayer = 0
        if(firstPlayer.contains(1)&&firstPlayer.contains(2)&&firstPlayer.contains(3)){
            winnerPlayer = 1
        }
        if(firstPlayer.contains(4)&&firstPlayer.contains(5)&&firstPlayer.contains(6)){
            winnerPlayer = 1
        }
        if(firstPlayer.contains(7)&&firstPlayer.contains(8)&&firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if(firstPlayer.contains(1)&&firstPlayer.contains(4)&&firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if(firstPlayer.contains(2)&&firstPlayer.contains(5)&&firstPlayer.contains(8)){
            winnerPlayer = 1
        }
        if(firstPlayer.contains(3)&&firstPlayer.contains(6)&&firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if(firstPlayer.contains(1)&&firstPlayer.contains(5)&&firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if(firstPlayer.contains(3)&&firstPlayer.contains(5)&&firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if(secondPlayer.contains(1)&&secondPlayer.contains(2)&&secondPlayer.contains(3)){
            winnerPlayer = 2
        }
        if(secondPlayer.contains(4)&&secondPlayer.contains(5)&&secondPlayer.contains(6)){
            winnerPlayer = 2
        }
        if(secondPlayer.contains(7)&&secondPlayer.contains(8)&&secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if(secondPlayer.contains(1)&&secondPlayer.contains(4)&&secondPlayer.contains(7)){
            winnerPlayer = 2
        }
        if(secondPlayer.contains(2)&&secondPlayer.contains(5)&&secondPlayer.contains(8)){
            winnerPlayer = 2
        }
        if(secondPlayer.contains(3)&&secondPlayer.contains(6)&&secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if(secondPlayer.contains(1)&&secondPlayer.contains(5)&&secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if(secondPlayer.contains(3)&&secondPlayer.contains(5)&&secondPlayer.contains(7)){
            winnerPlayer = 2
        }
        if(winnerPlayer == 1){
            Toast.makeText(this,"პირველმა მოთამაშემ მოიგო", Toast.LENGTH_SHORT).show()
            finalscore1[0]+=1
            scoree1.text = finalscore1[0].toString()
        }
        if(winnerPlayer == 2){
            Toast.makeText(this,"მეორე მოთამაშემ მოიგო", Toast.LENGTH_SHORT).show()
            finalscore2[0]+=1
            scoree2.text = finalscore2[0].toString()
        }
        if(winnerPlayer != 0){
            button1.isEnabled=false
            button2.isEnabled=false
            button3.isEnabled=false
            button4.isEnabled=false
            button5.isEnabled=false
            button6.isEnabled=false
            button7.isEnabled=false
            button8.isEnabled=false
            button9.isEnabled=false
        }
        if(firstPlayer.size + secondPlayer.size == 9 && winnerPlayer == 0){
            Toast.makeText(this,"ფრეა!", Toast.LENGTH_SHORT).show()
        }
    }
}