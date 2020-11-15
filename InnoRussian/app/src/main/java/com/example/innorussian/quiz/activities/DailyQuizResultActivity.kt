package com.example.innorussian.quiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.innorussian.R
import kotlinx.android.synthetic.main.activity_daily_quiz_result.*

class DailyQuizResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_quiz_result)

        val xp: Int = intent.getIntExtra("xp", 0)
        val studiedWordsList: ArrayList<String> =
            intent.getStringArrayListExtra("studiedWordsList") as ArrayList<String>
        val repeatWordsList: ArrayList<String> =
            intent.getStringArrayListExtra("repeatWordsList") as ArrayList<String>

        tv_xp.text = "+ ${xp}xp"
        tv_studied_words.text = studiedWordsList.size.toString().plus(" words studied")
        tv_repeat_words.text = repeatWordsList.size.toString().plus(" words to repeat")

        btnFinish.setOnClickListener {
            val intent = Intent()
            intent.putExtra("exit", 1)
            setResult(3, intent)
            finish()
        }

        btnRepeat.setOnClickListener {
            val intent = Intent()
            intent.putExtra("exit", 0)
            setResult(3, intent)
            finish()
        }
    }
}
