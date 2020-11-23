package com.example.innorussian.home_fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.innorussian.R
import com.example.innorussian.home_fragment.phrasebook.ParentDataFactory
import com.example.innorussian.home_fragment.phrasebook.PhrasebookParentAdapter
import kotlinx.android.synthetic.main.phrasebook_main.*
import kotlinx.android.synthetic.main.phrasebook_main.svSearchView

class HomeFragment : Fragment(R.layout.phrasebook_main) {
    lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        svSearchView.queryHint = "Search for topic"

        initRecycler()
    }


    private fun initRecycler() {
        recyclerView = phrasebook_rv!!

        recyclerView.apply {
            layoutManager = LinearLayoutManager(
                context,
                RecyclerView.VERTICAL, false
            )
            adapter = PhrasebookParentAdapter(
                ParentDataFactory.getParents(40)
            )
            setHasFixedSize(true)
        }

    }
}