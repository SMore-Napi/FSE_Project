package com.example.innorussian.home_fragment.phrasebook.topic.phrases

import com.example.innorussian.home_fragment.phrasebook.topic.phrases.PhrasesParentDataFactory.PARENT_1
import com.example.innorussian.home_fragment.phrasebook.topic.phrases.PhrasesParentDataFactory.PARENT_2
import com.example.innorussian.home_fragment.phrasebook.topic.phrases.PhrasesParentDataFactory.PARENT_3
import com.example.innorussian.home_fragment.phrasebook.topic.phrases.PhrasesParentDataFactory.PARENT_4
import com.example.innorussian.home_fragment.phrasebook.topic.phrases.PhrasesParentDataFactory.PARENT_5
import com.example.innorussian.home_fragment.phrasebook.topic.phrases.PhrasesParentDataFactory.PARENT_6
import com.example.innorussian.home_fragment.phrasebook.topic.phrases.PhrasesParentDataFactory.PARENT_7
import com.example.innorussian.home_fragment.phrasebook.topic.phrases.PhrasesParentDataFactory.PARENT_8
import com.example.innorussian.home_fragment.phrasebook.topic.phrases.PhrasesParentDataFactory.PARENT_9

object TopicsDataFactory {
    val education: TopicModel = TopicModel("Education", arrayListOf(PARENT_1,
        PARENT_2,
        PARENT_3,
        PARENT_4,
        PARENT_5,
        PARENT_6,
        PARENT_7,
        PARENT_8,
        PARENT_9,
        PhrasesParentDataFactory.PARENT_10,
        PhrasesParentDataFactory.PARENT_11,
        PhrasesParentDataFactory.PARENT_12,
        PhrasesParentDataFactory.PARENT_13,
        PhrasesParentDataFactory.PARENT_14,
        PhrasesParentDataFactory.PARENT_15,
        PhrasesParentDataFactory.PARENT_16,
        PhrasesParentDataFactory.PARENT_17,
        PhrasesParentDataFactory.PARENT_18,
        PhrasesParentDataFactory.PARENT_19,
        PhrasesParentDataFactory.PARENT_20,
        PhrasesParentDataFactory.PARENT_21,
        PhrasesParentDataFactory.PARENT_22
    ))
    val schoolSupplies: TopicModel =
        TopicModel("School Supplies", arrayListOf(
            PhrasesParentDataFactory.PARENT2_1,
            PhrasesParentDataFactory.PARENT2_2,
            PhrasesParentDataFactory.PARENT2_3,
            PhrasesParentDataFactory.PARENT2_4,
            PhrasesParentDataFactory.PARENT2_5,
            PhrasesParentDataFactory.PARENT2_6,
            PhrasesParentDataFactory.PARENT2_7,
            PhrasesParentDataFactory.PARENT2_8,
            PhrasesParentDataFactory.PARENT2_9,
            PhrasesParentDataFactory.PARENT2_10,
            PhrasesParentDataFactory.PARENT2_11,
            PhrasesParentDataFactory.PARENT2_12,
            PhrasesParentDataFactory.PARENT2_13,
            PhrasesParentDataFactory.PARENT2_14
        ))
    val theBuildingInside: TopicModel =
        TopicModel("The Building Inside", arrayListOf(
            PhrasesParentDataFactory.PARENT1_1,
            PhrasesParentDataFactory.PARENT1_2,
            PhrasesParentDataFactory.PARENT1_3,
            PhrasesParentDataFactory.PARENT1_4,
            PhrasesParentDataFactory.PARENT1_5,
            PhrasesParentDataFactory.PARENT1_6,
            PhrasesParentDataFactory.PARENT1_7,
            PhrasesParentDataFactory.PARENT1_8,
            PhrasesParentDataFactory.PARENT1_9,
            PhrasesParentDataFactory.PARENT1_10,
            PhrasesParentDataFactory.PARENT1_11
        ))

    val Supermarket:TopicModel = TopicModel ("Supermarket", arrayListOf())

    private var favorites: TopicModel = TopicModel("Favorites", arrayListOf())

    private val topics = arrayOf(education, schoolSupplies, theBuildingInside, favorites, Supermarket)

    fun getTopics(): Array<TopicModel> {
        return topics
    }

    fun addParent(
        nameOfTopic: String,
        english: String,
        russian: String,
        transcription: String,
        phrases: List<PhrasesChildModel>
    ) {
        for (topic in topics) {
            if (topic.nameOfTopic == nameOfTopic) {

                for (phrase in phrases) {
                    PhrasesChildDataFactory.addChild(phrase)
                }

                val parent = PhrasesParentModel(english, russian, transcription, phrases)

                PhrasesParentDataFactory.addParent(parent)

                topic.phrases.add(parent)
                break
            }
        }
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