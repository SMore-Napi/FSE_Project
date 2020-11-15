package com.example.innorussian.quiz.activities.fragments

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import com.example.innorussian.R
import com.example.innorussian.quiz.activities.ActivityFragmentsCommunicator
import com.example.innorussian.quiz.logic.Constants
import kotlinx.android.synthetic.main.fragment_remember_phrase.view.*

class RememberPhraseFragment : Fragment(R.layout.fragment_remember_phrase) {
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

        val view = inflater.inflate(R.layout.fragment_remember_phrase, container, false)
        view.spelling.text = this.arguments?.getString(constants.spelling)
        view.translation.text = this.arguments?.getString(constants.translation)
        view.btnPronunciation.text = this.arguments?.getString(constants.transcription)
        view.btnNextPhrase.setOnClickListener {
            communicator.goToNextStep(1)
        }

        return view
    }
}