package com.example.innorussian.phrases

import com.example.innorussian.phrases.PhrasesChildDataFactory.CHILD_1
import com.example.innorussian.phrases.PhrasesChildDataFactory.CHILD_10
import com.example.innorussian.phrases.PhrasesChildDataFactory.CHILD_11
import com.example.innorussian.phrases.PhrasesChildDataFactory.CHILD_12
import com.example.innorussian.phrases.PhrasesChildDataFactory.CHILD_2
import com.example.innorussian.phrases.PhrasesChildDataFactory.CHILD_3
import com.example.innorussian.phrases.PhrasesChildDataFactory.CHILD_4
import com.example.innorussian.phrases.PhrasesChildDataFactory.CHILD_5
import com.example.innorussian.phrases.PhrasesChildDataFactory.CHILD_6
import com.example.innorussian.phrases.PhrasesChildDataFactory.CHILD_7
import com.example.innorussian.phrases.PhrasesChildDataFactory.CHILD_8
import com.example.innorussian.phrases.PhrasesChildDataFactory.CHILD_9

object PhrasesParentDataFactory{
    val PARENT_1 : PhrasesParentModel = PhrasesParentModel("auditorium", "аудитория", "[auditpriya]", listOf(CHILD_1))
    val PARENT_2 : PhrasesParentModel = PhrasesParentModel("canteen", "столовая", "[stolovaya]", listOf(CHILD_2))
    val PARENT_3 : PhrasesParentModel = PhrasesParentModel("class", "занятие", "[zanyatiye]", listOf(CHILD_3, CHILD_4))

    val PARENT_4 : PhrasesParentModel = PhrasesParentModel("board", "доска", "[doska]", listOf(CHILD_5))
    val PARENT_5 : PhrasesParentModel = PhrasesParentModel("copybook", "тетрадь", "[tetrad']", listOf(CHILD_6))
    val PARENT_6 : PhrasesParentModel = PhrasesParentModel("textbook", "учебгик", "[uchebnik]", listOf(CHILD_7, CHILD_8))

    val PARENT_7 : PhrasesParentModel = PhrasesParentModel("entrance", "вход", "[vhod]", listOf(CHILD_9, CHILD_10))
    val PARENT_8 : PhrasesParentModel = PhrasesParentModel("exit", "выход", "[vyhod]", listOf(CHILD_11, CHILD_12))

    private val parents = mutableListOf(PARENT_1, PARENT_2, PARENT_3, PARENT_4, PARENT_5, PARENT_6, PARENT_7, PARENT_8)

    fun getParents() : List<PhrasesParentModel>{
        return parents
    }
}