package com.example.innorussian.home_fragment.phrasebook

import com.example.innorussian.home_fragment.phrasebook.PhrasebookChildDataFactory.bathroom
import com.example.innorussian.home_fragment.phrasebook.PhrasebookChildDataFactory.bedroom
import com.example.innorussian.home_fragment.phrasebook.PhrasebookChildDataFactory.education
import com.example.innorussian.home_fragment.phrasebook.PhrasebookChildDataFactory.hallway
import com.example.innorussian.home_fragment.phrasebook.PhrasebookChildDataFactory.kitchen
import com.example.innorussian.home_fragment.phrasebook.PhrasebookChildDataFactory.room
import com.example.innorussian.home_fragment.phrasebook.PhrasebookChildDataFactory.schoolSupplies
import com.example.innorussian.home_fragment.phrasebook.PhrasebookChildDataFactory.theBuildingInside
import com.example.innorussian.home_fragment.phrasebook.PhrasebookChildDataFactory.topic1
import com.example.innorussian.home_fragment.phrasebook.PhrasebookChildDataFactory.topic2
import com.example.innorussian.R

object ParentDataFactory{
    private val parent1 : ParentModel =
        ParentModel(
            R.drawable.iu,
            "University",
            listOf(education, schoolSupplies, theBuildingInside)
        )
    private val parent2 : ParentModel =
        ParentModel(
            R.drawable.dorms,
            "Dormitories",
            listOf(room, kitchen, bedroom, bathroom, hallway)
        )
    private val parent3 : ParentModel =
        ParentModel(
            R.drawable.pyatyorochka,
            "Supermarket",
            listOf(topic1)
        )
    private val parent4 : ParentModel =
        ParentModel(
            R.drawable.sports_complex,
            "SportComplex",
            listOf(topic1, topic2)
        )

    private val parents = mutableListOf(
        parent1,
        parent2,
        parent3,
        parent4
    )

    fun getParents(m : Int) : List<ParentModel>{
        return parents
    }
}