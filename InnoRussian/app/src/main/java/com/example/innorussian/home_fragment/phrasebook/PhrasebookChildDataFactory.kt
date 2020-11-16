package com.example.innorussian.home_fragment.phrasebook

object PhrasebookChildDataFactory{
    val education : PhrasebookChildModel =
        PhrasebookChildModel("Education")
    val schoolSupplies : PhrasebookChildModel =
        PhrasebookChildModel("School Supplies")
    val theBuildingInside : PhrasebookChildModel =
        PhrasebookChildModel("The Building Inside")

    val room : PhrasebookChildModel =
        PhrasebookChildModel("Room")
    val kitchen : PhrasebookChildModel =
        PhrasebookChildModel("Kitchen")
    val bedroom : PhrasebookChildModel =
        PhrasebookChildModel("Bedroom")
    val bathroom : PhrasebookChildModel =
        PhrasebookChildModel("Bathroom")
    val hallway : PhrasebookChildModel =
        PhrasebookChildModel("Hallway")

    val topic1 : PhrasebookChildModel =
        PhrasebookChildModel("Topic 1")
    val topic2 : PhrasebookChildModel =
        PhrasebookChildModel(" Topic 2")

    private val children = mutableListOf(
        education,
        schoolSupplies,
        theBuildingInside,
        room,
        kitchen,
        bedroom,
        bathroom,
        hallway,
        topic1,
        topic2
    )

    fun getChildren() : List<PhrasebookChildModel>{
        return children
    }
}