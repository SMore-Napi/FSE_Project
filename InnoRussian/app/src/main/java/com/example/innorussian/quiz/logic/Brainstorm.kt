package com.example.innorussian.quiz.logic

class Brainstorm(words: ArrayList<Word>) {

    private var wordsSet: ArrayList<Word> = ArrayList(words)
    private val quizProgress: HashMap<String, ArrayList<Int>> = HashMap()
    lateinit var quizResult: HashMap<String, Int>

    private var firstTry = true
    private var stageNumber = 0
    private var stepNumber = 0
    private val stageCount = 3

    init {
        for (word in wordsSet) {
            quizProgress[word.spelling] = ArrayList(stageCount)
            for (i in 0 until stageCount) {
                quizProgress[word.spelling]?.add(0)
            }
        }
    }

    fun goToNextStep(result: Int): Boolean {

        quizProgress[wordsSet[stepNumber].spelling]?.set(stageNumber, result)

        when {
            stepNumber < wordsSet.size - 1 -> {
                stepNumber++
                if (quizProgress[wordsSet[stepNumber].spelling]?.get(stageNumber) == 1) {
                    goToNextStep(1)
                } else {
                    return true
                }
            }
            stageNumber < stageCount - 1 -> {
                stageNumber++
                stepNumber = 0
                if (quizProgress[wordsSet[stepNumber].spelling]?.get(stageNumber) == 1) {
                    goToNextStep(1)
                } else {
                    return true
                }
            }
            else -> {
                if (firstTry) {
                    quizResult = calculateQuizResult(quizProgress)
                }
                firstTry = false

                if (!isEverythingCompleted(quizProgress)) {
                    stageNumber = 0
                    stepNumber = 0
                    goToNextStep(1)
                } else {
                    return false
                }
            }
        }

        return !isEverythingCompleted(quizProgress)
    }

    private fun calculateQuizResult(quizProgress: HashMap<String, ArrayList<Int>>): HashMap<String, Int> {
        val quizResult: HashMap<String, Int> = HashMap()
        for (word in quizProgress.keys) {
            quizResult[word] = 1
        }

        for (word in quizProgress.entries) {
            for (stage in word.value) {
                if (stage == 0) {
                    quizResult[word.key] = 0
                    break
                }
            }
        }

        return quizResult
    }

    private fun isEverythingCompleted(quizProgress: HashMap<String, ArrayList<Int>>): Boolean {
        for (word in quizProgress.entries) {
            for (stage in word.value) {
                if (stage == 0) {
                    return false
                }
            }
        }
        return true
    }

    fun getStageNumber(): Int {
        return stageNumber
    }

    fun getProgressBarValue(): Int {
        var current = 0
        for (word in quizProgress.entries) {
            for (stage in word.value) {
                current += stage
            }
        }
        val total = wordsSet.size * stageCount
        return current * 100 / total
    }

    fun getSpelling(): String {
        return wordsSet[stepNumber].spelling
    }

    fun getTranslation(): String {
        return wordsSet[stepNumber].translation
    }

    fun getTranscription(): String {
        return wordsSet[stepNumber].transcription
    }

    fun getPossibleTranslations(): ArrayList<String> {
        return wordsSet[stepNumber].possibleTranslations
    }
}