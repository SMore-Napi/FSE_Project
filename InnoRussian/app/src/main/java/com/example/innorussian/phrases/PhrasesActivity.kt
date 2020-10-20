package com.example.innorussian.phrases

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

class PhrasesActivity() : AppCompatActivity(){
    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.phrases_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val topicName: String? = intent.getStringExtra("topic")

        var list : List<PhrasesParentModel> = TopicsDataFactory.education.phrases

        for (topic in TopicsDataFactory.getTopics()){
            if (topic.nameOfTopic == topicName){
                list = topic.phrases
            }
        }

        initRecycler(list)
    }

    private fun initRecycler(list : List<PhrasesParentModel>){
        recyclerView = phrases_rv!!
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@PhrasesActivity,
                RecyclerView.VERTICAL, false)
            adapter = PhrasesParentAdapter(list)
            setHasFixedSize(true)
        }

    }



    /*override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS){
            val result = mTTs!!.isLanguageAvailable(Locale("ru"))
            Log.d("TTS", "ok");
        } else {
            Log.d("TTS", "error");
        }
    }

    private fun speakOut(text: String){
        mTTs!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }*/
}
