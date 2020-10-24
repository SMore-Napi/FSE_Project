package com.example.innorussian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_phrase.*

class PhraseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phrase)

        spelling.text = this.intent.getStringExtra("word")
        transcription.text = this.intent.getStringExtra("transcription")
        translation.text = this.intent.getStringExtra("translation")

        back_button.setOnClickListener {
            finish()
        }
    }
}