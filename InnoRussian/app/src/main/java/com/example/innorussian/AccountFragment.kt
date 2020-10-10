package com.example.innorussian

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : Fragment(R.layout.fragment_account){
    private var phrasesArray: ArrayList<Phrases> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        phrasesArray = getPhrasesArray()
        val previewPhrasesArray: ArrayList<String> = getPhrasesPreviewArray()

        val adapter = activity?.let {
            ArrayAdapter<String>(
                it, android.R.layout.simple_list_item_1, previewPhrasesArray
            )
        }
        phrases.adapter = adapter

        phrases.setOnItemClickListener { parent, view, position, id ->

            for (currentPhrase in previewPhrasesArray) {
                if ((view as TextView).text == currentPhrase) {

                    val string = currentPhrase.split(" / ")
                    var phraseToShow = Phrases("", "", "")

                    for (i in phrasesArray) {
                        if (i.word == string[0]) {
                            phraseToShow = Phrases(i.word, i.translation, i.transcription)
                            break
                        }
                    }

                    val phraseIntent = Intent(activity, PhraseActivity::class.java)
                    phraseIntent.putExtra("word", phraseToShow.word)
                    phraseIntent.putExtra("transcription", phraseToShow.transcription)
                    phraseIntent.putExtra("translation", phraseToShow.translation)
                    startActivity(phraseIntent)

                }
            }
        }
    }

    private fun getPhrasesArray(): ArrayList<Phrases> {

        val w1 = Phrases("Привет", "Hello", "auditoriya")
        val w2 = Phrases("Как дела?", "How are you?", "stolovaya")
        val w3 = Phrases("Как погода?", "How is the weather?", "zanyatiye")
        val w4 = Phrases("АЗАЗА", "AZAZA", "AZAZA")


        return arrayListOf(w1, w2, w3, w4)
    }

    private fun getPhrasesPreviewArray(): ArrayList<String> {
        val previewPhrasesArray: ArrayList<String> = ArrayList()
        for (phrase in phrasesArray) {
            previewPhrasesArray.add(phrase.word.plus(" / ").plus(phrase.translation))

        }

        return previewPhrasesArray
    }

    class Phrases(
        val word: String,
        val translation: String,
        val transcription: String
    )
}