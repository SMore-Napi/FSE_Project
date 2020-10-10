package com.example.innorussian

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_phrasebook.*

class PhrasebookFragment : Fragment(R.layout.fragment_phrasebook) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val phrasesArray: ArrayList<String> = getPhrases()

        val adapter = activity?.let {
            ArrayAdapter<String>(
                it, android.R.layout.simple_list_item_1, phrasesArray
            )
        }
        phrases.adapter = adapter
    }

    private fun getPhrases(): ArrayList<String> {
        val phrasesArray: ArrayList<String> = ArrayList()
        phrasesArray.add("Привет Hello")
        phrasesArray.add("Как дела? How are you?")
        phrasesArray.add("Как погода? How is the weather?")
        phrasesArray.add("АЗАЗА")


        return phrasesArray
    }
}