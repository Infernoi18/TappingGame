package com.example.game1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val p1 = intent.getIntExtra("p1", 0)
        val p2 = intent.getIntExtra("p2", 0)
        val winner = intent.getStringExtra("winner")

        val txtP1 = findViewById<TextView>(R.id.txt_p1)
        val txtP2 = findViewById<TextView>(R.id.txt_p2)
        val txtWinner = findViewById<TextView>(R.id.txt_winner)
        val btnPlayAgain = findViewById<Button>(R.id.btn_play_again)
        val btnLeaderboard = findViewById<Button>(R.id.btn_leaderboard)

        btnLeaderboard.setOnClickListener {
            val intent = Intent(this, LeaderboardActivity::class.java)
            startActivity(intent)
        }
        txtP1.text = "Player 1 Score: $p1"
        txtP2.text = "Player 2 Score: $p2"
        txtWinner.text = winner

        btnPlayAgain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}