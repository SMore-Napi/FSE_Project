package com.example.innorussian.home_fragment.phrasebook.topic.phrases

class PhrasesParentModel(
    val english: String,
    val russian: String,
    val transc: String,
    val children: List<PhrasesChildModel>,
    var expandable: Boolean = false,
    var isFavorite: Boolean = false
) {
    fun isExpandable(): Boolean {
        return expandable
    }

    fun setExpandable(expandable: Boolean): Void? {
        this.expandable = expandable
        return null
    }

}