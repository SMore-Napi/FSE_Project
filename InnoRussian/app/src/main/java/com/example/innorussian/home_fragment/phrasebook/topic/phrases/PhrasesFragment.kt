package com.example.innorussian.home_fragment.phrasebook.topic.phrases

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.innorussian.R
import kotlinx.android.synthetic.main.phrases_main.*

class PhrasesFragment : Fragment(R.layout.phrases_main) {
    lateinit var recyclerView: RecyclerView
    lateinit var topicName: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
                this.context,
                RecyclerView.VERTICAL, false
            )
            adapter = PhrasesParentAdapter(list)
            setHasFixedSize(true)
        }

    }

    fun setTopic(topic: String){
        this.topicName = topic;
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
