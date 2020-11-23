package com.example.innorussian.home_fragment.phrasebook.topic.phrases

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.innorussian.R
import kotlinx.android.synthetic.main.phrases_main.*

class PhrasesActivity() : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.phrases_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val topicName = intent.getStringExtra("topic")

        var list: List<PhrasesParentModel> = TopicsDataFactory.education.phrases

        for (topic in TopicsDataFactory.getTopics()) {
            if (topic.nameOfTopic == topicName) {
                list = topic.phrases
            }
        }

        initRecycler(list)
    }

    override fun onPause() {
        super.onPause()
        for (phrase in PhrasesParentDataFactory.getParents()) {
            phrase.expandable = false
        }
    }

    private fun initRecycler(list: List<PhrasesParentModel>) {
        recyclerView = phrases_rv!!
        recyclerView.apply {
            layoutManager = LinearLayoutManager(
                this@PhrasesActivity,
                RecyclerView.VERTICAL, false
            )
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
