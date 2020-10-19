package com.example.innorussian.phrases
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.innorussian.R

class PhrasesParentAdapter(private val parents: List<PhrasesParentModel>) : RecyclerView.Adapter<PhrasesParentAdapter.ViewHolder>(){
    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): PhrasesParentAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.phrases_parent,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return parents.size
    }

    override fun onBindViewHolder(holder: ViewHolder,
                                  position: Int) {
        val parent = parents[position]

        holder.englishView.text = parent.english
        holder.russianView.text = parent.russian
        holder.transcView.text = parent.transc

        val childLayoutManager = LinearLayoutManager(holder.recyclerView.context, RecyclerView.VERTICAL, false)
        childLayoutManager.initialPrefetchItemCount = 4
        holder.recyclerView.apply {
            layoutManager = childLayoutManager
            adapter = PhrasesChildAdapter(parent.children)
            setRecycledViewPool(viewPool)
        }

        val isExpandable : Boolean = parents[position].isExpandable()
        holder.expandableLayout.visibility = if (isExpandable) View.VISIBLE else View.GONE

        holder.linearLayout.setOnClickListener {
            val parent = parents[position]
            parent.expandable = !parent.isExpandable()
            notifyItemChanged(position)
        }


    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val recyclerView : RecyclerView = itemView.findViewById(R.id.phrases_examples_layout)

        var englishView : TextView = itemView.findViewById(R.id.phrases_english)
        var russianView : TextView = itemView.findViewById(R.id.phrases_russian)
        var transcView : TextView = itemView.findViewById(R.id.phrases_transcription)

        var linearLayout: LinearLayout = itemView.findViewById(R.id.phrases_linear_layout)
        var expandableLayout : RelativeLayout = itemView.findViewById(R.id.phrases_expandable_layout)
    }

}