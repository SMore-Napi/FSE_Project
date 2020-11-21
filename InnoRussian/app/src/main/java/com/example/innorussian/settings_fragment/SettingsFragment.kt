package com.example.innorussian.settings_fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.innorussian.R
import com.example.innorussian.home_fragment.phrasebook.topic.phrases.PhrasesFragment
import com.example.innorussian.settings_fragment.account.LogInActivity
import kotlinx.android.synthetic.main.fragment_account.*


class SettingsFragment : Fragment(R.layout.fragment_account) {
    lateinit var phrasesFragment: PhrasesFragment

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        button_favourites.setOnClickListener {
            val nextFrag = PhrasesFragment()
            nextFrag.setTopic("Favorites")
            activity!!.supportFragmentManager.beginTransaction()
                .replace((getView()!!.parent as ViewGroup).id, nextFrag, "findThisFragment")
                .addToBackStack(null)
                .commit()
        }

        btn_account.setOnClickListener{
            val intent = Intent(activity, LogInActivity::class.java)
            startActivity(intent)

        }

        btn_feedback.setOnClickListener{
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSfJWcEzammW77Fve-Wf15OaaYY1T3k-i32d0XF-gcCVT9Uvzw/viewform")
            startActivity(openURL)
        }


        //Study reminder button functionality

        var setReminder = false    //bool to check whether reminder is set or not

        btn_study_reminder.setOnClickListener{  //function itself
            if(setReminder){
                setReminder = false
                btn_study_reminder.text = "Enable study reminder"
                Toast.makeText(activity, "Study reminder disabled", Toast.LENGTH_SHORT).show()  //showing toast, that reminder is disabled
            }
            else{
                setReminder = true
                btn_study_reminder.text = "Disable study reminder"
                Toast.makeText(activity, "Study reminder enabled", Toast.LENGTH_SHORT).show()
            }

        }

        

    }
}