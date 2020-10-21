package com.example.innorussian

import android.content.Intent
import android.os.Bundle
import android.view.View
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
            favouritesIntent.putExtra("topic", "Favorites")
            startActivity(favouritesIntent)
        }
    }
}