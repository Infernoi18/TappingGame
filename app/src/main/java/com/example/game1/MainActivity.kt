package com.example.game1

import android.os.Bundle
import android.content.Intent
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

var pscore1: Int = 0
var pscore2: Int = 0
var isGameOn: Boolean = false
var winner: String = ""

class MainActivity : AppCompatActivity() {

    var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val score1 = findViewById<TextView>(R.id.txt_player1)
        val score2 = findViewById<TextView>(R.id.txt_player2)
        val timerText = findViewById<TextView>(R.id.txt_timer)

        val btn1 = findViewById<Button>(R.id.button1)
        val btn2 = findViewById<Button>(R.id.button2)
        val btnStart = findViewById<Button>(R.id.btn_start)

        btn1.isEnabled = false
        btn2.isEnabled = false

        btn1.setOnClickListener {
            if (isGameOn) {
                pscore1++
                score1.text = "Player 1 Score: $pscore1"
            }
        }

        btn2.setOnClickListener {
            if (isGameOn) {
                pscore2++
                score2.text = "Player 2 Score: $pscore2"
            }
        }

        btnStart.setOnClickListener {

            if (!isGameOn) {
                isGameOn = true
                btn1.isEnabled = true
                btn2.isEnabled = true
                btnStart.text = "Stop"

                pscore1 = 0
                pscore2 = 0
                score1.text = "Player 1 Score: 0"
                score2.text = "Player 2 Score: 0"

                timer = object : CountDownTimer(10000, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        timerText.text = (millisUntilFinished / 1000).toString()
                    }

                    override fun onFinish() {
                        endGame(btn1, btn2, btnStart, timerText)
                    }
                }.start()

            } else {
                timer?.cancel()
                endGame(btn1, btn2, btnStart, timerText)
            }
        }
    }

    private fun endGame(
        btn1: Button,
        btn2: Button,
        btnStart: Button,
        timerText: TextView
    ) {
        isGameOn = false
        btn1.isEnabled = false
        btn2.isEnabled = false
        btnStart.text = "Start Game"
        timerText.text = "0"

        winner = if (pscore1 > pscore2) {
            "Player 1 Wins!"
        } else if (pscore2 > pscore1) {
            "Player 2 Wins!"
        } else {
            "It's a Draw!"
        }

        val intent = Intent(this, StartActivity::class.java)
        intent.putExtra("p1", pscore1)
        intent.putExtra("p2", pscore2)
        intent.putExtra("winner", winner)
        startActivity(intent)
    }
}