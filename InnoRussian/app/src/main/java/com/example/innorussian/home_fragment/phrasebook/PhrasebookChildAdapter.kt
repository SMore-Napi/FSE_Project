package com.example.innorussian.home_fragment.phrasebook

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.innorussian.R
import com.example.innorussian.home_fragment.phrasebook.topic.TopicActivity
import com.example.innorussian.home_fragment.phrasebook.topic.phrases.TopicsDataFactory

class PhrasebookChildAdapter(private val children: List<PhrasebookChildModel>) :
    RecyclerView.Adapter<PhrasebookChildAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.phrasebook_child, parent, false)
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
        holder.topicView.text = child.NameOfTopic
        if (position == (getItemCount() - 1)) holder.lineView.layoutParams.height = 0
        else holder.lineView.layoutParams.height = 2

        holder.itemView.setOnClickListener {
            for (topic in TopicsDataFactory.getTopics()) {
                if (topic.nameOfTopic == child.NameOfTopic) {
                    //val intent = Intent(holder.itemView.context, PhrasesActivity()::class.java)
                    val intent = Intent(holder.itemView.context, TopicActivity()::class.java)
                    intent.putExtra("topic", topic.nameOfTopic)
                    startActivity(holder.itemView.context, intent, null)
                    break
                }
            }
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val topicView: TextView = itemView.findViewById(R.id.phrasebook_name_of_topic)
        val lineView: View = itemView.findViewById(R.id.phrasebook_ch_line)
    }
}
