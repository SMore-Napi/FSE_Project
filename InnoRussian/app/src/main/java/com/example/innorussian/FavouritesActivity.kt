package com.example.innorussian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_favourites.*

class FavouritesActivity : AppCompatActivity() {
    private var phrasesArray: ArrayList<Phrases> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourites)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        search_favourites.queryHint = "Search for phrase or word"

        phrasesArray = getPhrasesArray()
        val previewPhrasesArray: ArrayList<String> = getPhrasesPreviewArray()

        val adapter =
            ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                previewPhrasesArray
            )


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

                    val phraseIntent = Intent(this, PhraseActivity::class.java)
                    phraseIntent.putExtra("word", phraseToShow.word)
                    phraseIntent.putExtra("transcription", phraseToShow.transcription)
                    phraseIntent.putExtra("translation", phraseToShow.translation)
                    startActivity(phraseIntent)

                }
            }
        }
    }

    private fun getPhrasesArray(): ArrayList<Phrases> {

        val w1 = Phrases("аудидория", "auditorium", "auditoriya")
        val w2 = Phrases("аудитория", "audience", "auditoriya")
        val w3 = Phrases("столовая", "canteen", "stolovaya")
        val w4 = Phrases("занятие", "class", "zanyatiye")
        val w5 = Phrases("лекция", "lecture", "lektsiya")
        val w6 = Phrases("лектор", "lecturer", "lektor")
        val w7 = Phrases("профессор", "professor", "professor")
        val w8 = Phrases("учитель", "teacher", "uchitel")
        val w9 = Phrases("ассистент", "assistant", "assistent")
        val w10 = Phrases("курс", "course", "kurs")
        val w11 = Phrases("декан", "dean", "dekan")
        val w12 = Phrases("отделение", "department", "otdeleniye")
        val w13 = Phrases("диплом", "diploma", "diplom")
        val w14 = Phrases("экзамен", "exam", "ekzamen")
        val w15 = Phrases("финальные экзамены", "finals", "finalnye ekzameny")
        val w16 = Phrases("группа", "group", "gruppa")
        val w17 = Phrases("общежитие", "dormitory", "obshchezhitiye")
        val w18 = Phrases("кампус", "campus", "kampus")
        val w19 = Phrases("студент", "student", "student")
        val w20 = Phrases("семестр", "semester", "semestr")
        val w21 = Phrases("тест", "test", "test")
        val w22 = Phrases("пересдача", "retake", "peresdacha")

        return arrayListOf(
            w1,
            w2,
            w3,
            w4,
            w5,
            w6,
            w7,
            w8,
            w9,
            w10,
            w11,
            w12,
            w13,
            w14,
            w15,
            w16,
            w17,
            w18,
            w19,
            w20,
            w21,
            w22
        )
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