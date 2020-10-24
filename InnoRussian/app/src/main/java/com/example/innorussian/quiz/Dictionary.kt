package com.example.innorussian.quiz

import kotlin.math.max

class Dictionary {
    private var dictionary: ArrayList<Word> = ArrayList()

    init {
        dictionary.add(Word("аудитория", "audience", "auditoriya"))
        dictionary.add(Word("столовая", "canteen", "stolovaya"))
        dictionary.add(Word("занятие", "class", "zanyatiye"))
        dictionary.add(Word("лекция", "lecture", "lektsiya"))
        dictionary.add(Word("лектор", "lecturer", "lektor"))
        dictionary.add(Word("профессор", "professor", "professor"))
        dictionary.add(Word("учитель", "teacher", "uchitel"))
        dictionary.add(Word("ассистент", "assistant", "assistent"))
        dictionary.add(Word("курс", "course", "kurs"))
        dictionary.add(Word("декан", "dean", "dekan"))
        dictionary.add(Word("отделение", "department", "otdeleniye"))
        dictionary.add(Word("диплом", "diploma", "diplom"))
        dictionary.add(Word("экзамен", "exam", "ekzamen"))
        dictionary.add(Word("финальные экзамены", "finals", "finalnye ekzameny"))
        dictionary.add(Word("группа", "group", "gruppa"))
        dictionary.add(Word("общежитие", "dormitory", "obshchezhitiye"))
        dictionary.add(Word("кампус", "campus", "kampus"))
        dictionary.add(Word("студент", "student", "student"))
        dictionary.add(Word("семестр", "semester", "semestr"))
        dictionary.add(Word("тест", "test", "test"))
        dictionary.add(Word("пересдача", "retake", "peresdacha"))
    }

    fun getWordsForStudyQuiz(countWords: Int, countPossibleTranslations: Int): ArrayList<Word> {
        dictionary.sortBy { word: Word -> word.dateLastAccess }

        val possibleTranslations: ArrayList<String> =
            ArrayList(countPossibleTranslations * countWords)

        val listOfWords: ArrayList<Word> = ArrayList(countWords)
        for (i in 0 until countWords) {
            listOfWords.add(dictionary[i])
            possibleTranslations.add(dictionary[i].translation)
        }

        var repeatShuffling = true
        while (repeatShuffling) {
            repeatShuffling = false
            possibleTranslations.shuffle()
            for (i in 0 until listOfWords.size) {
                if (listOfWords[i].translation == possibleTranslations[i]) {
                    repeatShuffling = true
                    break
                }
            }
        }
        for (i in 0 until countWords) {
            listOfWords[i].possibleTranslations.add(possibleTranslations[i])
        }
        possibleTranslations.clear()

        var i = countWords
        while (possibleTranslations.size < (countPossibleTranslations - 1) * countWords) {
            possibleTranslations.add(dictionary[i++].translation)
        }
        possibleTranslations.shuffle()
        for (words in listOfWords) {
            val wordCandidates: ArrayList<String> = ArrayList(countPossibleTranslations)
            for (translation in possibleTranslations) {
                if (wordCandidates.size < countPossibleTranslations - 1) {
                    if (!words.possibleTranslations.contains(translation)) {
                        wordCandidates.add(translation)
                    }
                } else {
                    break
                }
            }

            words.possibleTranslations.addAll(wordCandidates)
            possibleTranslations.removeAll(wordCandidates)
        }

        listOfWords.shuffle()
        for (word in listOfWords) {
            word.possibleTranslations.shuffle()
        }

        return listOfWords
    }

    fun getWordsForInfinitePractice(
        countWords: Int,
        countPossibleTranslations: Int
    ): ArrayList<Word> {
        dictionary.sortBy { word: Word -> word.studyCounter }

        var start = 0

        val possibleTranslations: ArrayList<String> =
            ArrayList(countPossibleTranslations * countWords)

        val listOfWords: ArrayList<Word> = ArrayList(countWords)
        for (i in start until (countWords + start)) {
            listOfWords.add(dictionary[i])
            possibleTranslations.add(dictionary[i].translation)
        }


        var repeatShuffling = true
        while (repeatShuffling) {
            repeatShuffling = false
            possibleTranslations.shuffle()
            for (i in 0 until listOfWords.size) {
                if (listOfWords[i].translation == possibleTranslations[i]) {
                    repeatShuffling = true
                    break
                }
            }
        }
        for (i in 0 until countWords) {
            listOfWords[i].possibleTranslations.add(possibleTranslations[i])
        }
        possibleTranslations.clear()

        var i = countWords + start
        while (possibleTranslations.size < (countPossibleTranslations - 1) * countWords) {
            possibleTranslations.add(dictionary[i++].translation)
        }
        possibleTranslations.shuffle()
        for (words in listOfWords) {
            val wordCandidates: ArrayList<String> = ArrayList(countPossibleTranslations)
            for (translation in possibleTranslations) {
                if (wordCandidates.size < countPossibleTranslations - 1) {
                    if (!words.possibleTranslations.contains(translation)) {
                        wordCandidates.add(translation)
                    }
                } else {
                    break
                }
            }

            words.possibleTranslations.addAll(wordCandidates)
            possibleTranslations.removeAll(wordCandidates)
        }

        listOfWords.shuffle()
        for (word in listOfWords) {
            word.possibleTranslations.shuffle()
        }

        return listOfWords
    }

    fun updateStudiedWords(studiedWords: ArrayList<String>) {
        for (studiedWord in studiedWords) {
            for (word in dictionary) {
                if (word.spelling == studiedWord) {
                    word.studyCounter++
                    word.dateLastAccess = System.currentTimeMillis()
                    break
                }
            }
        }
    }

    fun updateRepeatWords(repeatWords: ArrayList<String>) {
        for (studiedWord in repeatWords) {
            for (word in dictionary) {
                if (word.spelling == studiedWord) {
                    word.studyCounter = max(0, word.studyCounter - 1)
                    word.dateLastAccess = System.currentTimeMillis()
                    break
                }
            }
        }
    }
}