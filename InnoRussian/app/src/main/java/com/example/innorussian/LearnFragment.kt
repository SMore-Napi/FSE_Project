package com.example.innorussian

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.innorussian.quiz.activities.DailyQuizResultActivity
import com.example.innorussian.learn.LearnParentAdapter
import com.example.innorussian.learn.LearnParentDataFactory
import com.example.innorussian.quiz.logic.Constants
import com.example.innorussian.quiz.logic.Dictionary
import com.example.innorussian.quiz.activities.InfinitePracticeActivity
import com.example.innorussian.quiz.activities.StudyQuizActivity
import kotlinx.android.synthetic.main.fragment_learn.*

class LearnFragment : Fragment(R.layout.fragment_learn) {
    private val constants = Constants()
    private val dictionary = Dictionary()
    lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        start_study_quiz_button.setOnClickListener {
            startStudyQuiz()
        }

        start_infinite_practice_button.setOnClickListener {
            startInfinitePractice()
        }

        initRecycler()
    }

    private fun initRecycler() {
        recyclerView = learn_rv!!

        recyclerView.apply {
            layoutManager = LinearLayoutManager(
                context,
                RecyclerView.VERTICAL, false
            )
            adapter = LearnParentAdapter(
                LearnParentDataFactory.getParents(40)
            )
            setHasFixedSize(true)
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

                dictionary.updateWords(studiedWordsList, repeatWordsList)

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