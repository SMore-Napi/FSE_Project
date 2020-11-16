package com.example.innorussian.learn_fragment.quiz.logic

class Word(
    val id: Long,
    val spelling: String,
    val translation: String,
    val transcription: String,
    var possibleTranslations: ArrayList<String> = ArrayList(),
    var totalSuccesses: Int = 0,
    var lastAttempts: Int = 0,
    var numberAttempts: Int = 0,
    var lastTimeAccess: Long = 0,
    var rating: Double = 0.0
)