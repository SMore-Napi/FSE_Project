package com.example.innorussian.home_fragment.phrasebook.topic

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.innorussian.home_fragment.phrasebook.topic.info.InfoFragment
import com.example.innorussian.home_fragment.phrasebook.topic.phrases.PhrasesFragment

@Suppress("DEPRECATION")
internal class TabLayoutAdapter(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int,
    var topicName: String
) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                val bundle = Bundle()
                bundle.putString("topic", topicName)
                val infoFragment = InfoFragment()
                infoFragment.arguments = bundle
                infoFragment
            }
            1 -> {
                val bundle = Bundle()
                bundle.putString("topic", topicName)
                val phraseFragment = PhrasesFragment()
                phraseFragment.arguments = bundle
                phraseFragment
            }
            else -> getItem(position)
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}