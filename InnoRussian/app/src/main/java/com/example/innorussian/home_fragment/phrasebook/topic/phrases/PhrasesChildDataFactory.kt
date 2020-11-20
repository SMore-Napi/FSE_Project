package com.example.innorussian.home_fragment.phrasebook.topic.phrases

object PhrasesChildDataFactory {
    val CHILD_1: PhrasesChildModel = PhrasesChildModel(
        "Where is the auditorium? The auditorium is...",
        "Где находится аудитория? Аудитория находится..."
    )
    val CHILD_2: PhrasesChildModel = PhrasesChildModel(
        "Where is the canteen? The canteen is...",
        "Где находится столовая? Столовая находится..."
    )
    val CHILD_3: PhrasesChildModel = PhrasesChildModel(
        "What classes do we have today? Today, we have...",
        "Какие у нас сегодня занятия? Сегодня у нас..."
    )
    val CHILD_4: PhrasesChildModel = PhrasesChildModel(
        "How many classes do we have today? Today, we have...",
        "Сколько у нас сегодня занятий? Сегодня у нас..."
    )

    val CHILD_5: PhrasesChildModel = PhrasesChildModel(
        "What is written on the board?",
        "Что написано на доске?"
    )
    val CHILD_6: PhrasesChildModel = PhrasesChildModel(
        "To sign a copybook",
        "Подписать тетрадь"
    )
    val CHILD_7: PhrasesChildModel = PhrasesChildModel(
        "To download a textbook",
        "Скачать учебник"
    )
    val CHILD_8: PhrasesChildModel = PhrasesChildModel(
        "To find a textbook in the library",
        "Найти учебник в библиотеке"
    )

    val CHILD_9: PhrasesChildModel = PhrasesChildModel(
        "Where is the entrance?",
        "Где вход?"
    )
    val CHILD_10: PhrasesChildModel = PhrasesChildModel(
        "At the entrance",
        "У входа"
    )
    val CHILD_11: PhrasesChildModel = PhrasesChildModel(
        "Where is the exit?",
        "Где выход?"
    )
    val CHILD_12: PhrasesChildModel = PhrasesChildModel(
        "At the exit",
        "У выхода"
    )

    private val children = mutableListOf(CHILD_1, CHILD_2, CHILD_3, CHILD_4)

    fun getChildren(): List<PhrasesChildModel> {
        return children
    }

    fun addChild(child: PhrasesChildModel) {
        children.add(child)
    }
}