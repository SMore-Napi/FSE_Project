package com.example.innorussian.learn_topics

import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.innorussian.R
import kotlinx.android.synthetic.main.activity_daily_quiz_result.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.phrases_main.*
import kotlinx.android.synthetic.main.phrases_parent.*
import kotlinx.android.synthetic.main.phrases_parent.view.*
import java.util.*

class LearnTopicsActivity() : AppCompatActivity(){
    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn_topic_main)
    }
}
