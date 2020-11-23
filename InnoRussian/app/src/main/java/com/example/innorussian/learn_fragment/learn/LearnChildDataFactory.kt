package com.example.innorussian.learn_fragment.learn

object LearnChildDataFactory{
    val alphabet : LearnChildModel =
        LearnChildModel("The Russian Alphabet")
    val reading_rules : LearnChildModel =
        LearnChildModel("The Main Reading Rules")

    val digits : LearnChildModel =
        LearnChildModel("Digits")
    val numeral : LearnChildModel =
        LearnChildModel("Numeral")
    val time : LearnChildModel =
        LearnChildModel("Time and Date")
    val seasons : LearnChildModel =
        LearnChildModel("Weeks, Months, Seasons")

    val colors : LearnChildModel =
        LearnChildModel("Colors")
    val shapes : LearnChildModel =
        LearnChildModel("Shapes")

    private val children = mutableListOf(
        alphabet,
        reading_rules,
        digits,
        numeral,
        time,
        seasons,
        colors,
        shapes
    )

    fun getChildren() : List<LearnChildModel>{
        return children
    }
}