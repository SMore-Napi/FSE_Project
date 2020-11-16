package com.example.innorussian.learn_fragment.quiz.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.innorussian.R
import com.example.innorussian.learn_fragment.quiz.logic.Brainstorm
import com.example.innorussian.learn_fragment.quiz.logic.Constants
import com.example.innorussian.learn_fragment.quiz.logic.Dictionary
import com.example.innorussian.learn_fragment.quiz.activities.fragments.ChoosePhraseFragment
import com.example.innorussian.learn_fragment.quiz.activities.fragments.FormPhraseFragment
import com.example.innorussian.learn_fragment.quiz.activities.fragments.RememberPhraseFragment
import kotlinx.android.synthetic.main.activity_infinite_practice.*

class InfinitePracticeActivity : AppCompatActivity(), ActivityFragmentsCommunicator {

    private val constants = Constants()
    private val dictionary = Dictionary()

    private lateinit var brainstorm: Brainstorm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infinite_practice)

        finish_practice_button.setOnClickListener {
            finish()
        }

        brainstorm = Brainstorm(dictionary.getWordsForInfinitePractice(4, 3))
        updateStage(brainstorm)
    }

    private fun finishQuiz() {

        val studiedWordsList: ArrayList<String> = ArrayList()
        val repeatWordsList: ArrayList<String> = ArrayList()
        for (word in brainstorm.quizResult.entries) {
            if (word.value == 1) {
                studiedWordsList.add(word.key)
            } else {
                repeatWordsList.add(word.key)
            }
        }

        dictionary.updateWords(studiedWordsList, repeatWordsList)

        brainstorm = Brainstorm(dictionary.getWordsForInfinitePractice(4, 3))
        updateStage(brainstorm)
    }

    override fun goToNextStep(result: Int) {
        if (brainstorm.goToNextStep(result)) {
            updateStage(brainstorm)
        } else {
            val handler = Handler()
            handler.postDelayed(
                {
                    finishQuiz()
                },
                constants.shortDelay
            )
        }
    }

    private fun updateStage(brainstorm: Brainstorm) {

        when (brainstorm.getStageNumber()) {
            0 -> {
                val spelling = brainstorm.getSpelling()
                val translation = brainstorm.getTranslation()
                val transcription = brainstorm.getTranscription()

                val bundle = Bundle()
                bundle.putString(constants.spelling, spelling)
                bundle.putString(constants.translation, translation)
                bundle.putString(constants.transcription, transcription)

                val rememberPhraseFragment = RememberPhraseFragment()
                rememberPhraseFragment.arguments = bundle
                this.supportFragmentManager.beginTransaction()
                    .replace(R.id.flFragment, rememberPhraseFragment)
                    .commit()
            }

            1 -> {
                val spelling = brainstorm.getSpelling()
                val translation = brainstorm.getTranslation()
                val transcription = brainstorm.getTranscription()

                val possibleTranslations: ArrayList<String> =
                    ArrayList(brainstorm.getPossibleTranslations())
                possibleTranslations.add(brainstorm.getTranslation())
                possibleTranslations.shuffle()

                val bundle = Bundle()
                bundle.putString(constants.spelling, spelling)
                bundle.putString(constants.translation, translation)
                bundle.putString(constants.transcription, transcription)
                bundle.putStringArrayList(constants.possibleTranslations, possibleTranslations)

                val choosePhraseFragment = ChoosePhraseFragment()
                choosePhraseFragment.arguments = bundle
                this.supportFragmentManager.beginTransaction()
                    .replace(R.id.flFragment, choosePhraseFragment)
                    .commit()
            }

            2 -> {
                val spelling = brainstorm.getSpelling()
                val translation = brainstorm.getTranslation()
                val letters: ArrayList<String> =
                    ArrayList(brainstorm.getSpelling().length)

                for (i in brainstorm.getSpelling()) {
                    letters.add(i.toLowerCase().toString())
                }
                letters.shuffle()

                val bundle = Bundle()
                bundle.putString(constants.spelling, spelling)
                bundle.putString(constants.translation, translation)
                bundle.putStringArrayList(constants.letters, letters)

                val formPhraseFragment = FormPhraseFragment()
                formPhraseFragment.arguments = bundle
                this.supportFragmentManager.beginTransaction()
                    .replace(R.id.flFragment, formPhraseFragment)
                    .commit()
            }
        }
    }
}