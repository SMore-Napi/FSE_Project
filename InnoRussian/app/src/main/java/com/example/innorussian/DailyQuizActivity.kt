package com.example.innorussian

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_daily_quiz.*


class DailyQuizActivity : AppCompatActivity() {

    private lateinit var wordsSet: ArrayList<Word>
    private val result: HashMap<String, Int> = HashMap()

    private var stageNumber = 1
    private var wordIndex = 0
    private val lastStageNumber = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_quiz)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initialization()
    }

    private fun initialization() {
        wordsSet = getWordsForQuiz()

        stageNumber = 1
        wordIndex = 0

        setStage(1)
        updateStage(1)
    }

    private fun getWordsForQuiz(): ArrayList<Word> {
        val possibleTranslations1: ArrayList<String> =
            arrayListOf("Auditorium", "Lecturer", "Professor")
        val possibleTranslations2: ArrayList<String> =
            arrayListOf("Teacher", "Course", "Dean")
        val possibleTranslations3: ArrayList<String> =
            arrayListOf("Department", "Diploma", "Exam")
        val possibleTranslations4: ArrayList<String> =
            arrayListOf("Finals", "Group", "Dormitory")

        val w1 = Word("аудитория", "Audience", "auditoriya", possibleTranslations1)
        val w2 = Word("столовая", "Canteen", "stolovaya", possibleTranslations2)
        val w3 = Word("занятие", "Class", "zanyatiye", possibleTranslations3)
        val w4 = Word("лекция", "Lecture", "lektsiya", possibleTranslations4)

        return arrayListOf(w1, w2, w3, w4)
    }

    private fun finishQuiz() {
        val intentResult = Intent()
        intentResult.putExtra("quizResult", result)
        setResult(1, intentResult)
        finish()
    }

    private fun goToNextStep() {

        when {
            wordIndex < wordsSet.size - 1 -> {
                wordIndex++
                updateProgressBar()
                updateStage(stageNumber)
            }
            stageNumber < lastStageNumber -> {
                stageNumber++
                wordIndex = 0
                updateProgressBar()

                setStage(stageNumber)
                updateStage(stageNumber)
            }
            else -> {
                stageNumber++
                wordIndex = 0
                updateProgressBar()

                val handler = Handler()
                handler.postDelayed(
                    {
                        finishQuiz()
                    },
                    500
                )
            }
        }
    }

    private fun updateProgressBar() {
        val current = (wordIndex + (stageNumber - 1) * wordsSet.size)
        val total = (wordsSet.size * 3)
        progress_bar.progress = current * 100 / total
    }

    private fun setStage(stage: Int) {
        when (stage) {
            1 -> {
                spelling.isVisible = true
                translation.isVisible = true
                transcription.isVisible = true
                options.isVisible = false
                letters_gridview.isVisible = false

                button_next.isVisible = true
                button_next.text = "Got it"
                button_next.setOnClickListener {
                    goToNextStep()
                }
            }

            2 -> {
                spelling.isVisible = true
                translation.isVisible = false
                transcription.isVisible = true
                options.isVisible = true
                letters_gridview.isVisible = false
                button_next.isVisible = false
            }

            3 -> {
                spelling.isVisible = true
                translation.isVisible = true
                transcription.isVisible = false
                options.isVisible = false
                letters_gridview.isVisible = true
                button_next.isVisible = false
            }
        }
    }

    private fun updateStage(stage: Int) {
        when (stage) {
            1 -> {
                updateStage1()
            }

            2 -> {
                updateStage2()
            }

            3 -> {
                updateStage3()
            }
        }
    }

    private fun updateStage1() {
        spelling.text = wordsSet[wordIndex].word
        translation.text = wordsSet[wordIndex].translation
        transcription.text = wordsSet[wordIndex].transcription
    }

    private fun updateStage2() {
        spelling.text = wordsSet[wordIndex].word
        transcription.text = wordsSet[wordIndex].transcription

        val possibleTranslations: ArrayList<String> =
            ArrayList(wordsSet[wordIndex].possibleTranslations)
        possibleTranslations.add(wordsSet[wordIndex].translation)
        possibleTranslations.shuffle()

        val adapter =
            ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                possibleTranslations
            )
        options.adapter = adapter

        var isClicked = false
        options.setOnItemClickListener { parent, view, position, id ->
            if (!isClicked) {
                if ((view as TextView).text == wordsSet[wordIndex].translation) {
                    view.setBackgroundColor(Color.GREEN)
                    isClicked = true

                    val handler = Handler()
                    handler.postDelayed(
                        {
                            goToNextStep()
                        },
                        1000
                    )
                } else {
                    view.setBackgroundColor(Color.RED)
                    isClicked = true

                    val handler = Handler()
                    handler.postDelayed(
                        {
                            goToNextStep()
                        },
                        1000
                    )
                }
            }
        }
    }

    private fun updateStage3() {
        spelling.text = ""
        translation.text = wordsSet[wordIndex].translation

        val letters: ArrayList<Char> = ArrayList(wordsSet[wordIndex].word.length)
        for (i in wordsSet[wordIndex].word) {
            letters.add(i.toLowerCase())
        }

        letters.shuffle()

        val adapter =
            ArrayAdapter<Char>(
                this,
                android.R.layout.simple_list_item_1,
                letters
            )
        letters_gridview.adapter = adapter


        val string = wordsSet[wordIndex].word
        var index = 0

        letters_gridview.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->

                if ((view as TextView).text[0] == string[index]) {
                    spelling.text = spelling.text.toString().plus(string[index].toString())
                    letters.remove(string[index])
                    index++
                    adapter.notifyDataSetChanged()

                    if (index == string.length) {
                        goToNextStep()
                    }

                } else {
                    val initialBackground = view.background
                    view.setBackgroundColor(Color.RED)

                    val handler = Handler()
                    handler.postDelayed(
                        {
                            view.background = initialBackground
                        },
                        500
                    )
                }
            }
    }

    class Word(
        val word: String,
        val translation: String,
        val transcription: String,
        val possibleTranslations: ArrayList<String>
    )
}

