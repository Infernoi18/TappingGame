package com.example.game1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LeaderboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leaderboard)

        val txtP1Wins = findViewById<TextView>(R.id.txt_p1wins)
        val txtP2Wins = findViewById<TextView>(R.id.txt_p2wins)

        val prefs = getSharedPreferences("game_data", MODE_PRIVATE)

        val p1wins = prefs.getInt("p1wins", 0)
        val p2wins = prefs.getInt("p2wins", 0)

        txtP1Wins.text = "Player 1 Wins: $p1wins"
        txtP2Wins.text = "Player 2 Wins: $p2wins"
    }
}