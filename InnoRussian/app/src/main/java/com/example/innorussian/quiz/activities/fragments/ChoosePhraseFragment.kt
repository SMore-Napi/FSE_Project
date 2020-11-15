package com.example.innorussian.quiz.activities.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.os.Handler
import android.widget.TextView
import androidx.core.view.get
import com.example.innorussian.R
import com.example.innorussian.quiz.activities.ActivityFragmentsCommunicator
import com.example.innorussian.quiz.logic.Constants
import kotlinx.android.synthetic.main.fragment_choose_phrase.view.*
import kotlinx.android.synthetic.main.fragment_remember_phrase.view.btnPronunciation
import kotlinx.android.synthetic.main.fragment_remember_phrase.view.spelling

class ChoosePhraseFragment : Fragment(R.layout.fragment_choose_phrase) {
    private lateinit var communicator: ActivityFragmentsCommunicator
    private val constants = Constants()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        communicator = activity as ActivityFragmentsCommunicator

        val translation = this.arguments?.getString(constants.translation)
        val possibleTranslations =
            this.arguments?.getStringArrayList(constants.possibleTranslations) as ArrayList<String>

        val view = inflater.inflate(R.layout.fragment_choose_phrase, container, false)
        view.spelling.text = this.arguments?.getString(constants.spelling)
        view.btnPronunciation.text = this.arguments?.getString(constants.transcription)
        view.options.adapter = activity?.let {
            ArrayAdapter<String>(
                it,
                android.R.layout.simple_list_item_1,
                possibleTranslations
            )
        }

        var isClicked = false
        view.options.setOnItemClickListener { _, v, _, _ ->
            if (!isClicked) {
                if ((v as TextView).text == translation) {
                    isClicked = true
                    v.setBackgroundColor(constants.colorCorrectAnswer)

                    val handler = Handler()
                    handler.postDelayed(
                        {
                            communicator.goToNextStep(1)
                        },
                        constants.longDelay
                    )
                } else {
                    isClicked = true
                    v.setBackgroundColor(constants.colorIncorrectAnswer)
                    view.options[possibleTranslations.indexOf(translation)].setBackgroundColor(
                        constants.colorCorrectAnswer
                    )

                    val handler = Handler()
                    handler.postDelayed(
                        {
                            communicator.goToNextStep(0)
                        },
                        constants.longDelay
                    )
                }
            }
        }

        return view
    }
}