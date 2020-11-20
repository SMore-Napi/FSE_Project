package com.example.innorussian.home_fragment.phrasebook.topic

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.innorussian.R
import com.example.innorussian.home_fragment.phrasebook.topic.phrases.PhrasesChildModel
import com.example.innorussian.home_fragment.phrasebook.topic.phrases.TopicsDataFactory
import kotlinx.android.synthetic.main.activity_add_new_word.*
import java.util.*


class AddNewWord : AppCompatActivity() {
    private var topicName: String? = null

    private var phrasesList: ArrayList<String>? = null
    private var adapter: ArrayAdapter<String>? = null
    private lateinit var phrases: ArrayList<PhrasesChildModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_word)

        topicName = intent.getStringExtra("topic")

        phrases = ArrayList()
        phrasesList = ArrayList()
        adapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, phrasesList!!
        )
        list_view.adapter = adapter

        btn_save.setOnClickListener {
            save()
        }

        add_phrase.setOnClickListener {
            addNewPhrase()
        }
    }

    private fun save() {
        if (topicName != null) {
            val english = word_english.text.toString()
            val russian = word_russian.text.toString()
            val transcription = word_transcription.text.toString()

            if (english.isNotEmpty() && russian.isNotEmpty() && transcription.isNotEmpty()) {
                TopicsDataFactory.addParent(
                    topicName.toString(),
                    english,
                    russian,
                    transcription,
                    phrases
                )

                finish()
            } else {
                Toast.makeText(this, "Fill all fields!", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun addNewPhrase() {
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        val english = EditText(this)
        english.hint = "English"
        layout.addView(english)

        val translation = EditText(this)
        translation.hint = "Translation"
        layout.addView(translation)

        val dialog = AlertDialog.Builder(this)
            .setTitle("Add new phrase")
            .setView(layout)
            .setPositiveButton("Add") { _, _ ->
                addPhrase(english.text.toString(), translation.text.toString())
            }
            .setNegativeButton("Cancel", null)
            .create()

        dialog.show()

        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.WHITE)
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.WHITE)
    }

    private fun addPhrase(english: String, translation: String) {
        phrases.add(PhrasesChildModel(english, translation))
        phrasesList!!.add(english)
        adapter!!.notifyDataSetChanged()
    }
}