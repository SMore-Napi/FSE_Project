package com.example.innorussian.learn_fragment.learn

class LearnParentModel (
    val drawableID : Int,
    val nameOfSection : String,
    val children : List<LearnChildModel>,
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