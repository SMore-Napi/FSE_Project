package com.example.innorussian.quiz

class Word(
    val spelling: String,
    val translation: String,
    val transcription: String,
    var possibleTranslations: ArrayList<String> = ArrayList(),
    var dateLastAccess: Long = 0,
    var studyCounter: Int = 0
)