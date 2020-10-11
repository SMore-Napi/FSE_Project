package com.example.innorussian

import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_phrasebook.*

class PhrasebookFragment : Fragment(R.layout.fragment_phrasebook) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        ibShop.setOnClickListener{
            if(cvShop_hidden_view.visibility == View.VISIBLE){
                TransitionManager.beginDelayedTransition(cvShop, AutoTransition())
                cvShop_hidden_view.visibility = View.GONE
            }
            else{
                TransitionManager.beginDelayedTransition(cvShop, AutoTransition())
                cvShop_hidden_view.visibility = View.VISIBLE
            }

        }


        ibSportComplex.setOnClickListener{
            if(cvSportsComplex_hidden_view.visibility == View.VISIBLE){
                TransitionManager.beginDelayedTransition(cvSportsComplex, AutoTransition())
                cvSportsComplex_hidden_view.visibility = View.GONE
            }
            else{
                TransitionManager.beginDelayedTransition(cvSportsComplex, AutoTransition())
                cvSportsComplex_hidden_view.visibility = View.VISIBLE
            }

        }

        ibDorms.setOnClickListener{
            if(cvDorms_hidden_view.visibility == View.VISIBLE){
                TransitionManager.beginDelayedTransition(cvDorms, AutoTransition())
                cvDorms_hidden_view.visibility = View.GONE
            }
            else{
                TransitionManager.beginDelayedTransition(cvDorms, AutoTransition())
                cvDorms_hidden_view.visibility = View.VISIBLE
            }

        }

        ibUniversity.setOnClickListener{
            if(cvUniversity_hidden_view.visibility == View.VISIBLE){
                TransitionManager.beginDelayedTransition(cvUniversity, AutoTransition())
                cvUniversity_hidden_view.visibility = View.GONE
            }
            else{
                TransitionManager.beginDelayedTransition(cvUniversity, AutoTransition())
                cvUniversity_hidden_view.visibility = View.VISIBLE
            }

        }
    }

}