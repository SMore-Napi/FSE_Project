package com.example.innorussian.phrases

class PhrasesParentModel (
    val english : String,
    val russian : String,
    val transc: String,
    val children : List<PhrasesChildModel>,
    var expandable : Boolean = false
){
    fun isExpandable() : Boolean{
        return expandable
    }

    fun setExpandable(expandable: Boolean) : Void?{
        this.expandable = expandable
        return null
    }

}