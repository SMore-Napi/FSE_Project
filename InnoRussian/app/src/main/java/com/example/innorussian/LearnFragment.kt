package com.example.innorussian

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_learn.*

class LearnFragment : Fragment(R.layout.fragment_learn) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        quiz_button.setOnClickListener {
            val quizIntent = Intent(activity, DailyQuizActivity::class.java)
            startActivityForResult(quizIntent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) return
        when (requestCode) {
            1 -> {
                val result = data.getSerializableExtra("quizResult")
                val quizResultIntent = Intent(activity, DailyQuizResultActivity::class.java)
                quizResultIntent.putExtra("quizResult", result)
                startActivity(quizResultIntent)
            }
        }
    }
}