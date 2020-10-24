package com.example.innorussian

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.innorussian.quiz.Constants
import com.example.innorussian.quiz.Dictionary
import com.example.innorussian.quiz.InfinitePracticeActivity
import com.example.innorussian.quiz.StudyQuizActivity
import kotlinx.android.synthetic.main.fragment_learn.*

class LearnFragment : Fragment(R.layout.fragment_learn) {
    private val constants = Constants()
    private val dictionary = Dictionary()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        start_study_quiz_button.setOnClickListener {
            startStudyQuiz()
        }

        start_infinite_practice_button.setOnClickListener {
            startInfinitePractice()
        }
    }

    private fun startStudyQuiz() {
        val intent = Intent(activity, StudyQuizActivity::class.java)
        startActivityForResult(intent, 2)
    }

    private fun startInfinitePractice() {
        val intent = Intent(activity, InfinitePracticeActivity::class.java)
        startActivityForResult(intent, 4)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) return
        when (requestCode) {
            2 -> {
                val quizResult =
                    data.getSerializableExtra(constants.studyQuizResult) as HashMap<String, Int>

                val studiedWordsList: ArrayList<String> = ArrayList()
                val repeatWordsList: ArrayList<String> = ArrayList()
                for (word in quizResult.entries) {
                    if (word.value == 1) {
                        studiedWordsList.add(word.key)
                    } else {
                        repeatWordsList.add(word.key)
                    }
                }
                val xp = studiedWordsList.size * 4

                dictionary.updateStudiedWords(studiedWordsList)
                dictionary.updateRepeatWords(repeatWordsList)

                val quizResultIntent = Intent(activity, DailyQuizResultActivity::class.java)
                quizResultIntent.putExtra("studiedWordsList", studiedWordsList)
                quizResultIntent.putExtra("repeatWordsList", repeatWordsList)
                quizResultIntent.putExtra("xp", xp)
                startActivityForResult(quizResultIntent, 3)
            }
            3 -> {
                when (data.getIntExtra("exit", 1)) {
                    0 -> {
                        startStudyQuiz()
                    }
                }
            }
        }
    }
}