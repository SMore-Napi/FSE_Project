package com.example.innorussian.learn_fragment.learn

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.innorussian.R
import com.example.innorussian.learn_fragment.learn_topics.LearnTopicsActivity


class LearnChildAdapter(private val children: List<LearnChildModel>)
    : RecyclerView.Adapter<LearnChildAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {

        val v =  LayoutInflater.from(parent.context)
            .inflate(R.layout.learn_child,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return children.size
    }

    override fun onBindViewHolder(holder: ViewHolder,
                                  position: Int) {
        val child = children[position]
        holder.topicView.text = child.NameOfTopic
        if (position == (getItemCount() - 1)) holder.lineView.layoutParams.height = 0
        else holder.lineView.layoutParams.height = 2

        holder.itemView.setOnClickListener(View.OnClickListener {
            val intent = Intent(holder.itemView.context, LearnTopicsActivity()::class.java)
            startActivity(holder.itemView.context, intent, null)
        })
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val topicView : TextView = itemView.findViewById(R.id.learn_name_of_topic)
        val lineView : View = itemView.findViewById(R.id.learn_ch_line)
    }
}
