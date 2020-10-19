package com.example.innorussian.phrases

import com.example.innorussian.phrases.PhrasesParentDataFactory.PARENT_1
import com.example.innorussian.phrases.PhrasesParentDataFactory.PARENT_2
import com.example.innorussian.phrases.PhrasesParentDataFactory.PARENT_3
import com.example.innorussian.phrases.PhrasesParentDataFactory.PARENT_4
import com.example.innorussian.phrases.PhrasesParentDataFactory.PARENT_5
import com.example.innorussian.phrases.PhrasesParentDataFactory.PARENT_6
import com.example.innorussian.phrases.PhrasesParentDataFactory.PARENT_7
import com.example.innorussian.phrases.PhrasesParentDataFactory.PARENT_8

object TopicsDataFactory{
    val education : TopicModel = TopicModel ("Education", mutableListOf(PARENT_1, PARENT_2, PARENT_3))
    val schoolSupplies : TopicModel = TopicModel("School Supplies", mutableListOf(PARENT_4, PARENT_5, PARENT_6))
    val theBuildingInside : TopicModel = TopicModel("The Building Inside", mutableListOf(PARENT_7, PARENT_8))

    private val topics = arrayOf(education, schoolSupplies, theBuildingInside)

    fun getTopics() : Array<TopicModel>{
        return topics
    }
}