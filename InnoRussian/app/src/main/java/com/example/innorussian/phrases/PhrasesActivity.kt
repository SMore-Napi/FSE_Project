package com.example.innorussian.phrases

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.innorussian.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.phrases_main.*

class PhrasesActivity() : AppCompatActivity() {
    
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
}