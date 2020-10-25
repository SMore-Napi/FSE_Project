package com.example.innorussian

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.innorussian.phrases.PhrasesActivity
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : Fragment(R.layout.fragment_account) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        button_settings.setOnClickListener {
            val settingsIntent = Intent(activity, SettingsActivity::class.java)
            startActivity(settingsIntent)
        }

        button_favourites.setOnClickListener {
            val favouritesIntent = Intent(activity, PhrasesActivity()::class.java)
            startActivity(favouritesIntent)
        }

        btn_account_settings.setOnClickListener{
            val intent = Intent(activity, AccountSettingsActivity::class.java)
            startActivity(intent)

        }


        //Study reminder button functionality

        var set_reminder = false    //bool to check whether reimnder is set or not

        btn_study_reminder.setOnClickListener{  //function itself
            if(set_reminder){
                set_reminder = false
                btn_study_reminder.setText("Enable study reminder")
                Toast.makeText(activity, "Study reminder disabled", Toast.LENGTH_SHORT).show()  //showing toast, that reminder is disabled
            }
            else{
                set_reminder = true
                btn_study_reminder.setText("Disable study reminder")
                Toast.makeText(activity, "Study reminder enabled", Toast.LENGTH_SHORT).show()
            }


        }

        

    }
}