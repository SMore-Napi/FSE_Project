package com.example.innorussian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_daily_quiz_result.*

class DailyQuizResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_quiz_result)

        button.setOnClickListener {
            finish()
        }
    }
}