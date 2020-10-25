package com.example.innorussian.learn_topics

import com.example.innorussian.phrases.PhrasesParentDataFactory.PARENT_1
import com.example.innorussian.phrases.PhrasesParentDataFactory.PARENT_2
import com.example.innorussian.phrases.PhrasesParentDataFactory.PARENT_3
import com.example.innorussian.phrases.PhrasesParentDataFactory.PARENT_4
import com.example.innorussian.phrases.PhrasesParentDataFactory.PARENT_5
import com.example.innorussian.phrases.PhrasesParentDataFactory.PARENT_6
import com.example.innorussian.phrases.PhrasesParentDataFactory.PARENT_7
import com.example.innorussian.phrases.PhrasesParentDataFactory.PARENT_8

object LearnTopicsDataFactory{
    val alphabet : LearnTopicModel = LearnTopicModel ("The Russian Alphabet")
    val time : LearnTopicModel = LearnTopicModel("Digits And Time")
    val colors_shapes : LearnTopicModel = LearnTopicModel("ColorsAndShapes")

    private val topics = arrayOf(alphabet, time, colors_shapes)

    fun getTopics() : Array<LearnTopicModel>{
        return topics
    }
}