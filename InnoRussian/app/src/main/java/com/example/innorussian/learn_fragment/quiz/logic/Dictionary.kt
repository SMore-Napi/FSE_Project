package com.example.innorussian.learn_fragment.quiz.logic

class Dictionary {
    private var dictionary: ArrayList<Word> = ArrayList()

    private val c1: Double = 10.0
    private val c2: Double = 20.0
    private val c3: Double = 1.0 / (1000 * 86400)
    private val numberLastAttempts: Int = 10

    init {
        getWords()
    }

    private fun getWords() {
        dictionary.add(Word(0, "аудитория", "audience", "auditoriya"))
        dictionary.add(Word(1, "столовая", "canteen", "stolovaya"))
        dictionary.add(Word(2, "занятие", "class", "zanyatiye"))
        dictionary.add(Word(3, "лекция", "lecture", "lektsiya"))
        dictionary.add(Word(4, "лектор", "lecturer", "lektor"))
        dictionary.add(Word(5, "профессор", "professor", "professor"))
        dictionary.add(Word(6, "учитель", "teacher", "uchitel"))
        dictionary.add(Word(7, "ассистент", "assistant", "assistent"))
        dictionary.add(Word(8, "курс", "course", "kurs"))
        dictionary.add(Word(9, "декан", "dean", "dekan"))
        dictionary.add(Word(10, "отделение", "department", "otdeleniye"))
        dictionary.add(Word(11, "диплом", "diploma", "diplom"))
        dictionary.add(Word(12, "экзамен", "exam", "ekzamen"))
        dictionary.add(Word(13, "финальные экзамены", "finals", "finalnye ekzameny"))
        dictionary.add(Word(14, "группа", "group", "gruppa"))
        dictionary.add(Word(15, "общежитие", "dormitory", "obshchezhitiye"))
        dictionary.add(Word(16, "кампус", "campus", "kampus"))
        dictionary.add(Word(17, "студент", "student", "student"))
        dictionary.add(Word(18, "семестр", "semester", "semestr"))
        dictionary.add(Word(19, "тест", "test", "test"))
        dictionary.add(Word(20, "пересдача", "retake", "peresdacha"))
    }

    private fun calculateRatingForWords() {
        //Rating = C1 * (1 - Total_successes / Number_attempts) + C2 * (current_time - Last_time_access) + C3 * (1 - Last_attempts / n_attempts)
        val currentTime = System.currentTimeMillis()
        for (word in dictionary) {
            word.rating = 0.0

            if (word.numberAttempts != 0) {
                word.rating += c1 * (1.0 - word.totalSuccesses.toDouble() / word.numberAttempts)
            } else {
                word.rating += c1
            }

            if (word.lastTimeAccess != 0L) {
                word.rating += c2 * (currentTime - word.lastTimeAccess)
            }

            if (getNumberLastSuccesses(word.lastAttempts) != 0) {
                word.rating += c3 * (1.0 - getNumberLastSuccesses(word.lastAttempts).toDouble() / numberLastAttempts)
            } else {
                word.rating += c3
            }

        }
    }

    fun getWordsForStudyQuiz(countWords: Int, countPossibleTranslations: Int): ArrayList<Word> {

        calculateRatingForWords()
        dictionary.sortByDescending { word: Word -> word.rating }

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
        calculateRatingForWords()
        dictionary.sortBy { word: Word -> word.rating }

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

    fun updateWords(studiedWords: ArrayList<String>, repeatWords: ArrayList<String>) {
        updateStudiedWords(studiedWords)
        updateRepeatWords(repeatWords)
    }

    private fun updateStudiedWords(studiedWords: ArrayList<String>) {
        val currentTime = System.currentTimeMillis()
        val updatedWords: ArrayList<Word> = ArrayList()

        for (word in dictionary) {
            for (studiedWord in studiedWords) {
                if (word.spelling == studiedWord) {
                    word.totalSuccesses++
                    word.lastAttempts = updateLastAttempts(word.lastAttempts, 1)
                    word.numberAttempts++
                    word.lastTimeAccess = currentTime

                    updatedWords.add(word)
                    break
                }
            }
        }
        updateDataBase(updatedWords)
    }

    private fun updateRepeatWords(repeatWords: ArrayList<String>) {
        val currentTime = System.currentTimeMillis()
        val updatedWords: ArrayList<Word> = ArrayList()

        for (word in dictionary) {
            for (studiedWord in repeatWords) {
                if (word.spelling == studiedWord) {
                    word.lastAttempts = updateLastAttempts(word.lastAttempts, 0)
                    word.numberAttempts++
                    word.lastTimeAccess = currentTime

                    updatedWords.add(word)
                    break
                }
            }
        }
        updateDataBase(updatedWords)
    }

    private fun updateDataBase(updatedWords: ArrayList<Word>) {
        for (word in updatedWords) {
            //todo update word values
        }
    }

    private fun getNumberLastSuccesses(lastAttempts: Int): Int {
        var successes = 0
        for (symbol in Integer.toBinaryString(lastAttempts)) {
            if (symbol == '1') {
                successes++
            }
        }
        return successes
    }

    private fun updateLastAttempts(lastAttempts: Int, attempt: Int): Int {
        var mask = 0
        for (i in 1..numberLastAttempts) {
            mask = mask shl 1
            mask = mask or 1
        }

        return ((lastAttempts shl 1) or attempt) and mask
    }
}