package com.example.innorussian.phrasebook

import com.example.innorussian.phrasebook.PhrasebookChildDataFactory.bathroom
import com.example.innorussian.phrasebook.PhrasebookChildDataFactory.bedroom
import com.example.innorussian.phrasebook.PhrasebookChildDataFactory.education
import com.example.innorussian.phrasebook.PhrasebookChildDataFactory.hallway
import com.example.innorussian.phrasebook.PhrasebookChildDataFactory.kitchen
import com.example.innorussian.phrasebook.PhrasebookChildDataFactory.room
import com.example.innorussian.phrasebook.PhrasebookChildDataFactory.schoolSupplies
import com.example.innorussian.phrasebook.PhrasebookChildDataFactory.theBuildingInside
import com.example.innorussian.phrasebook.PhrasebookChildDataFactory.topic1
import com.example.innorussian.phrasebook.PhrasebookChildDataFactory.topic2
import com.example.innorussian.R

object PhrasebookParentDataFactory{
    private val parent1 : PhrasebookParentModel =
        PhrasebookParentModel(
            R.drawable.iu,
            "University",
            listOf(education, schoolSupplies, theBuildingInside)
        )
    private val parent2 : PhrasebookParentModel =
        PhrasebookParentModel(
            R.drawable.dorms,
            "Dormitories",
            listOf(room, kitchen, bedroom, bathroom, hallway)
        )
    private val parent3 : PhrasebookParentModel =
        PhrasebookParentModel(
            R.drawable.pyatyorochka,
            "Supermarket",
            listOf(topic1)
        )
    private val parent4 : PhrasebookParentModel =
        PhrasebookParentModel(
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

    fun getParents(m : Int) : List<PhrasebookParentModel>{
        return parents
    }
}