package com.example.innorussian.home_fragment.phrasebook.topic.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.innorussian.R

class InfoFragment : Fragment() {
    private var topicName: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_info, container, false)

        topicName = this.arguments?.getString("topic")

        return view
    }
}