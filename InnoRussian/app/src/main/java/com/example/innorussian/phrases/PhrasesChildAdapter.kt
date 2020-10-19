package com.example.innorussian.phrases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.innorussian.R
import kotlinx.android.synthetic.main.activity_main.*

class PhrasesChildAdapter(private val children : List<PhrasesChildModel>)
    : RecyclerView.Adapter<PhrasesChildAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.phrases_child, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return children.size
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val child = children[position]
        holder.exampleView.text = ((position + 1).toString() + ". " + child.example)
        holder.transView.text = child.tranls
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val exampleView: TextView = itemView.findViewById(R.id.phrases_example)
        val transView: TextView = itemView.findViewById(R.id.phrases_translation)
    }
}
