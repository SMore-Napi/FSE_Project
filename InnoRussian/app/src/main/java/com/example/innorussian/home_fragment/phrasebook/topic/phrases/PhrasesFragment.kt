package com.example.innorussian.home_fragment.phrasebook.topic.phrases

import android.content.Intent
import com.example.innorussian.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_phrases.view.*

class PhrasesFragment : Fragment() {
    private var topicName: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_phrases, container, false)

        topicName = this.arguments?.getString("topic")

        view.btn_phrases.setOnClickListener {
            val infoIntent = Intent(activity, PhrasesActivity::class.java)
            infoIntent.putExtra("topic", topicName)
            startActivity(infoIntent)
        }

        return view
    }
}
