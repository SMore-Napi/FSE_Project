package com.example.innorussian.home_fragment.phrasebook.topic.phrases

import com.example.innorussian.home_fragment.phrasebook.topic.phrases.PhrasesParentDataFactory.PARENT_1
import com.example.innorussian.home_fragment.phrasebook.topic.phrases.PhrasesParentDataFactory.PARENT_2
import com.example.innorussian.home_fragment.phrasebook.topic.phrases.PhrasesParentDataFactory.PARENT_3
import com.example.innorussian.home_fragment.phrasebook.topic.phrases.PhrasesParentDataFactory.PARENT_4
import com.example.innorussian.home_fragment.phrasebook.topic.phrases.PhrasesParentDataFactory.PARENT_5
import com.example.innorussian.home_fragment.phrasebook.topic.phrases.PhrasesParentDataFactory.PARENT_6
import com.example.innorussian.home_fragment.phrasebook.topic.phrases.PhrasesParentDataFactory.PARENT_7
import com.example.innorussian.home_fragment.phrasebook.topic.phrases.PhrasesParentDataFactory.PARENT_8

object TopicsDataFactory {
    val education: TopicModel = TopicModel("Education", arrayListOf(PARENT_1, PARENT_2, PARENT_3))
    val schoolSupplies: TopicModel =
        TopicModel("School Supplies", arrayListOf(PARENT_4, PARENT_5, PARENT_6))
    val theBuildingInside: TopicModel =
        TopicModel("The Building Inside", arrayListOf(PARENT_7, PARENT_8))
    private var favorites: TopicModel = TopicModel("Favorites", arrayListOf())

    private val topics = arrayOf(education, schoolSupplies, theBuildingInside, favorites)

    fun getTopics(): Array<TopicModel> {
        return topics
    }

    fun addToFavorites(phrase: PhrasesParentModel) {
        favorites.phrases.add(phrase)
    }

    fun removeFromFavorites(phrase: PhrasesParentModel) {
        favorites.phrases.remove(phrase)
    }

    fun containsTopic(topicName: String): Boolean {
        for (topic in topics) {
            if (topic.nameOfTopic == topicName) {
                return true
            }
        }
        return false
    }
}