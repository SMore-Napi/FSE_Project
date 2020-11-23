package com.example.innorussian.home_fragment.phrasebook.topic.phrases

import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.innorussian.R
import java.util.*


class PhrasesParentAdapter(private val parents: List<PhrasesParentModel>) :
    RecyclerView.Adapter<PhrasesParentAdapter.ViewHolder>(), TextToSpeech.OnInitListener {
    private val viewPool = RecyclerView.RecycledViewPool()
    private var mTTs: TextToSpeech? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.phrases_parent, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return parents.size
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val parent = parents[position]

        holder.englishView.text = parent.english
        holder.russianView.text = parent.russian
        holder.transcView.text = parent.transc


        mTTs = TextToSpeech(holder.itemView.context, this)

        holder.listenButton.setOnClickListener {
            var textPronounce: String = parent.transc
            textPronounce = textPronounce.replace("[", "").replace("]", "")
            speakOut(textPronounce)
        }

        val childLayoutManager =
            LinearLayoutManager(holder.recyclerView.context, RecyclerView.VERTICAL, false)
        childLayoutManager.initialPrefetchItemCount = 4
        holder.recyclerView.apply {
            layoutManager = childLayoutManager
            adapter = PhrasesChildAdapter(parent.children)
            setRecycledViewPool(viewPool)
        }

        val isExpandable: Boolean = parents[position].isExpandable()
        holder.expandableLayout.visibility = if (isExpandable) View.VISIBLE else View.GONE

        holder.linearLayout.setOnClickListener {
            val parent = parents[position]
            if (!parent.expandable) {
                val mEnlargeAnimation0: Animation =
                    AnimationUtils.loadAnimation(holder.englishView.context, R.anim.enlarge_text)
                val mEnlargeAnimation1: Animation =
                    AnimationUtils.loadAnimation(holder.russianView.context, R.anim.enlarge_text)
                holder.englishView.startAnimation(mEnlargeAnimation0)
                holder.russianView.startAnimation(mEnlargeAnimation1)
            } else {
                val mEnlargeAnimation0: Animation =
                    AnimationUtils.loadAnimation(holder.englishView.context, R.anim.shrink_text)
                val mEnlargeAnimation1: Animation =
                    AnimationUtils.loadAnimation(holder.russianView.context, R.anim.shrink_text)
                holder.englishView.startAnimation(mEnlargeAnimation0)
                holder.russianView.startAnimation(mEnlargeAnimation1)
            }
            parent.expandable = !parent.isExpandable()
            notifyItemChanged(position) {
                if (!parent.expandable) {
                    val mEnlargeAnimation0: Animation = AnimationUtils.loadAnimation(
                        holder.englishView.context,
                        R.anim.enlarge_text
                    )
                    val mEnlargeAnimation1: Animation = AnimationUtils.loadAnimation(
                        holder.russianView.context,
                        R.anim.enlarge_text
                    )
                    holder.englishView.startAnimation(mEnlargeAnimation0)
                    holder.russianView.startAnimation(mEnlargeAnimation1)
                } else {
                    val mEnlargeAnimation0: Animation =
                        AnimationUtils.loadAnimation(holder.englishView.context, R.anim.shrink_text)
                    val mEnlargeAnimation1: Animation =
                        AnimationUtils.loadAnimation(holder.russianView.context, R.anim.shrink_text)
                    holder.englishView.startAnimation(mEnlargeAnimation0)
                    holder.russianView.startAnimation(mEnlargeAnimation1)
                }
            }
        }

        if (!parent.isFavorite) {
            holder.favoriteButton.setImageResource(R.drawable.favorite)
        } else {
            holder.favoriteButton.setImageResource(R.drawable.favorite_on)
        }

        holder.favoriteButton.setOnClickListener {
            if (!parent.isFavorite) {
                holder.favoriteButton.setImageResource(R.drawable.favorite_on)
                TopicsDataFactory.addToFavorites(parent)
                parent.isFavorite = true
            } else {
                holder.favoriteButton.setImageResource(R.drawable.favorite)
                TopicsDataFactory.removeFromFavorites(parent)
                parent.isFavorite = false
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.findViewById(R.id.phrases_examples_layout)

        var englishView: TextView = itemView.findViewById(R.id.phrases_english)
        var russianView: TextView = itemView.findViewById(R.id.phrases_russian)
        var transcView: TextView = itemView.findViewById(R.id.phrases_transcription)
        var listenButton: ImageButton = itemView.findViewById(R.id.ib_listen)
        var favoriteButton: ImageButton = itemView.findViewById(R.id.ib_favourite)

        var linearLayout: LinearLayout = itemView.findViewById(R.id.phrases_linear_layout)
        var expandableLayout: RelativeLayout = itemView.findViewById(R.id.phrases_expandable_layout)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = mTTs!!.isLanguageAvailable(Locale.US)
            Log.d("TTS", "ok");
        } else {
            Log.d("TTS", "error");
        }
    }

    private fun speakOut(text: String) {
        mTTs?.setSpeechRate(0.5f)
        mTTs!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")

    }
}