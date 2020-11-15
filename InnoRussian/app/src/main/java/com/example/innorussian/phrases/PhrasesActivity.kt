package com.example.innorussian.phrases

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.innorussian.QRCodeImageActivity
import com.example.innorussian.R
import com.example.innorussian.quiz.activities.DailyQuizResultActivity
import kotlinx.android.synthetic.main.phrases_main.*

class PhrasesActivity() : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    private var topicName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.phrases_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        topicName = intent.getStringExtra("topic")

        var list: List<PhrasesParentModel> = TopicsDataFactory.education.phrases

        for (topic in TopicsDataFactory.getTopics()) {
            if (topic.nameOfTopic == topicName) {
                list = topic.phrases
            }
        }

        btn_qr_code.setOnClickListener {
            val qrCodeActivity = Intent(this, QRCodeImageActivity::class.java)
            qrCodeActivity.putExtra("topic", topicName)
            startActivity(qrCodeActivity)
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
