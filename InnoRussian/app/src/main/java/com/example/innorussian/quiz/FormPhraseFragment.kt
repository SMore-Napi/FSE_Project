package com.example.innorussian.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.os.Handler
import android.widget.AdapterView
import android.widget.TextView
import com.example.innorussian.R
import kotlinx.android.synthetic.main.fragment_form_phrase.view.*

class FormPhraseFragment : Fragment(R.layout.fragment_form_phrase) {
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

        val spelling = this.arguments?.getString(constants.spelling)
        val letters = this.arguments?.getStringArrayList(constants.letters) as ArrayList<String>
        val adapter = activity?.let {
            ArrayAdapter<String>(
                it,
                android.R.layout.simple_list_item_1,
                letters
            )
        }

        val view = inflater.inflate(R.layout.fragment_form_phrase, container, false)
        view.letters_gridview.adapter = adapter
        view.translation.text = this.arguments?.getString(constants.translation)

        var index = 0
        var countIncorrectAnswers = 0
        view.letters_gridview.onItemClickListener =
            AdapterView.OnItemClickListener { _, v, position, _ ->
                if ((v as TextView).text != " " && spelling != null) {
                    if (v.text[0] == spelling[index]) {
                        if (index == 0) {
                            view.spelling.text = ""
                        }
                        view.spelling.text =
                            view.spelling.text.toString().plus(spelling[index].toString())

                        if (letters[position] == v.text) {
                            letters[position] = " "
                        } else {
                            letters[letters.indexOf(spelling[index].toString())] = " "
                        }

                        index++
                        adapter?.notifyDataSetChanged()

                        if (index == spelling.length) {
                            if (countIncorrectAnswers < 3) {
                                communicator.goToNextStep(1)
                            } else {
                                communicator.goToNextStep(0)
                            }
                        }
                    } else {
                        countIncorrectAnswers++

                        val initialBackground = v.background
                        v.setBackgroundColor(constants.colorIncorrectAnswer)

                        val handler = Handler()
                        handler.postDelayed(
                            {
                                v.background = initialBackground
                            },
                            constants.shortDelay
                        )
                    }
                }
            }

        return view
    }
}