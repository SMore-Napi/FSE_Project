package com.example.innorussian.learn

import com.example.innorussian.R
import com.example.innorussian.learn.LearnChildDataFactory.alphabet
import com.example.innorussian.learn.LearnChildDataFactory.colors
import com.example.innorussian.learn.LearnChildDataFactory.digits
import com.example.innorussian.learn.LearnChildDataFactory.numeral
import com.example.innorussian.learn.LearnChildDataFactory.reading_rules
import com.example.innorussian.learn.LearnChildDataFactory.seasons
import com.example.innorussian.learn.LearnChildDataFactory.shapes
import com.example.innorussian.learn.LearnChildDataFactory.time

object LearnParentDataFactory{
    private val parent1 : LearnParentModel =
        LearnParentModel(
            R.drawable.alphabet,
            "The Russian Alphabet",
            listOf(alphabet, reading_rules)
        )
    private val parent2 : LearnParentModel =
        LearnParentModel(
            R.drawable.time,
            "Digits and Time",
            listOf(digits, numeral, time, seasons)
        )
    private val parent3 : LearnParentModel =
        LearnParentModel(
            R.drawable.colors_shapes,
            "Colors and Shapes",
            listOf(colors, shapes)
        )

    private val parents = mutableListOf(
        parent1,
        parent2,
        parent3
    )

    fun getParents(m : Int) : List<LearnParentModel>{
        return parents
    }
}