package com.vignesh.harrypotterquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private var tvResult:TextView? = null
    private var tvCongratulations:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        tvResult = findViewById(R.id.tvResult)
        tvCongratulations = findViewById(R.id.tvCongratulations)
        val intent = intent
        val score = intent.getStringExtra("SCORE")
        val name : String?= intent.getStringExtra("USER_NAME").toString()
        Log.i("RESULTACTVITIY",name.toString())
        tvCongratulations?.text = "Congratulations $name!"
        tvResult?.text = "You have scored $score points"
    }
}