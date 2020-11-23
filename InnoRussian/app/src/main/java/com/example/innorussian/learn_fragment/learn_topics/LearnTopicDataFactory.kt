package com.example.innorussian.learn_fragment.learn_topics

object LearnTopicsDataFactory{
    val alphabet : LearnTopicModel = LearnTopicModel ("The Russian Alphabet")
    val time : LearnTopicModel = LearnTopicModel("Digits And Time")
    val colors_shapes : LearnTopicModel = LearnTopicModel("ColorsAndShapes")

    private val topics = arrayOf(alphabet, time, colors_shapes)

    fun getTopics() : Array<LearnTopicModel>{
        return topics
    }
}