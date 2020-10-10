package com.example.innorussian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tests.*

class TestsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tests)

        quiz_button.setOnClickListener {
            val quizIntent = Intent(this, DailyQuizActivity::class.java)
            startActivityForResult(quizIntent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) return
        when (requestCode) {
            1 -> {
                val result = data.getSerializableExtra("quizResult")
                val quizResultIntent = Intent(this, DailyQuizResultActivity::class.java)
                quizResultIntent.putExtra("quizResult", result)
                startActivity(quizResultIntent)
            }
        }
    }
}