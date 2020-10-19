package com.example.innorussian

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.innorussian.phrasebook.ParentDataFactory
import com.example.innorussian.phrasebook.PhrasebookParentAdapter
import kotlinx.android.synthetic.main.phrasebook_main.*

class HomeFragment : Fragment(R.layout.phrasebook_main) {
    lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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