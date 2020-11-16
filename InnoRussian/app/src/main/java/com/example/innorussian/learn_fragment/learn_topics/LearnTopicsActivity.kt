package com.example.innorussian.learn_fragment.learn_topics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.innorussian.R

class LearnTopicsActivity() : AppCompatActivity(){
    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn_topic_main)
    }
}
